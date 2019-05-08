package org.wgq.idt.ui;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Insets;
import java.awt.MenuItem;
import java.awt.PopupMenu;
import java.awt.SystemTray;
import java.awt.Toolkit;
import java.awt.TrayIcon;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import javax.swing.AbstractAction;
import javax.swing.Action;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JSplitPane;
import javax.swing.JTable;
import javax.swing.JToolBar;
import javax.swing.Timer;
import javax.swing.tree.DefaultMutableTreeNode;
import javax.swing.tree.TreePath;

import org.wgq.idt.ContextHolder;
import org.wgq.idt.DownloadContext;
import org.wgq.idt.info.DownloadInfo;
import org.wgq.idt.navigation.DownloadNode;
import org.wgq.idt.navigation.DownloadingNode;
import org.wgq.idt.navigation.FailNode;
import org.wgq.idt.navigation.FinishNode;
import org.wgq.idt.navigation.TaskNode;
import org.wgq.idt.object.Resource;
import org.wgq.idt.state.Downloading;
import org.wgq.idt.state.Failed;
import org.wgq.idt.state.Finished;
import org.wgq.idt.state.Pause;
import org.wgq.idt.util.ConfigurationFileUtil;
import org.wgq.idt.util.DateUtil;
import org.wgq.idt.util.FileUtil;
import org.wgq.idt.util.ImageUtil;
import org.wgq.idt.util.LookandFeelUtil;

/**
 * ������
 * 
 * @author guoqiang
 * @version 1.0 <br/>
 *          ��վ: <a href="http://www.lzcu.edu.cn">���ݳ���ѧԺ</a> <br>
 */
public class MainFrame extends JFrame {

	// ������
	private NavigationTree navTree;
	// �����б�
	private DownloadTable downloadTable;
	// ��Ϣ�б�
	private JList infoJList;
	// ������
	private JToolBar toolBar = new JToolBar();
	// ���������
	private NewTaskFrame taskFrame;
	// ��������ڵ�
	private TaskNode taskNode = new TaskNode();
	// �������ؽڵ�
	private DownloadingNode downloadingNode = new DownloadingNode();
	// ����ʧ�ܽڵ�
	private FailNode failNode = new FailNode();
	// ������ɽڵ�
	private FinishNode finishNode = new FinishNode();
	// ��ǰ�û�����Ľڵ�
	private DownloadNode currentNode = taskNode;

	// ��Ϣ�б�Ķ���
	private final static String FILE_SIZE_TEXT = "�ļ���С: ";
	private final static String FILE_PATH_TEXT = "�ļ�·��: ";
	private final static String DOWNLOAD_DATE_TEXT = "����ʱ��: ";
	private final static String RESOURCE_INFO_TEXT = "��Դ��Ϣ: ";

	private List<DownloadInfo> infoList = new ArrayList<DownloadInfo>();
	private DownloadInfo fileSize = new DownloadInfo(FILE_SIZE_TEXT);
	private DownloadInfo filePath = new DownloadInfo(FILE_PATH_TEXT);
	private DownloadInfo downloadDate = new DownloadInfo(DOWNLOAD_DATE_TEXT);
	private DownloadInfo info = new DownloadInfo(RESOURCE_INFO_TEXT);

	private Action newTask = new AbstractAction("������",
			new ImageIcon(System.getProperty("user.dir") + File.separator + "images/tool/new-download.gif")) {
		public void actionPerformed(ActionEvent e) {
			newTask();
		}
	};

	private Action start = new AbstractAction("��ʼ",
			new ImageIcon(System.getProperty("user.dir") + File.separator + "images/tool/do-download.gif")) {
		public void actionPerformed(ActionEvent e) {
			start();
		}
	};

	private Action pause = new AbstractAction("��ͣ",
			new ImageIcon(System.getProperty("user.dir") + File.separator + "images/tool/pause.gif")) {
		public void actionPerformed(ActionEvent e) {
			pause();
		}
	};

	private Action delete = new AbstractAction("ɾ������",
			new ImageIcon(System.getProperty("user.dir") + File.separator + "images/tool/delete.gif")) {
		public void actionPerformed(ActionEvent e) {
			delete();
		}
	};

	private Action deleteFinished = new AbstractAction("ɾ������",
			new ImageIcon(System.getProperty("user.dir") + File.separator + "images/tool/remove-finished.gif")) {
		public void actionPerformed(ActionEvent e) {
			deleteFinished();
		}
	};

	private Action sysSetting = new AbstractAction("ϵͳ����",
			new ImageIcon(System.getProperty("user.dir") + File.separator + "images/tool/setting.png")) {
		public void actionPerformed(ActionEvent e) {
			sysSetting();
		}
	};
	
	private Action aboutWindow = new AbstractAction("��������", ImageUtil.ABOUT) {
		
		@Override
		public void actionPerformed(ActionEvent e) {
			aboutWindow();
		}
	};

	ActionListener refreshTable = new ActionListener() {
		public void actionPerformed(ActionEvent e) {
			// ˢ���б�
			downloadTable.updateUI();
		}
	};

	// ��������
	private SuspendWindow suspendWindow;
	// ������ͼ��
	private TrayIcon trayIcon;
	// ������ͼ��˵�
	private PopupMenu popupMenu = new PopupMenu();
	private MenuItem openItem = new MenuItem("��/�ر�");
	private MenuItem newItem = new MenuItem("�½���������");
	private MenuItem startItem = new MenuItem("��ʼȫ������");
	private MenuItem pauseItem = new MenuItem("��ͣȫ������");
	private MenuItem removeItem = new MenuItem("ɾ���������");
	private MenuItem quitItem = new MenuItem("�˳�");

	private BufferedImage trayIconImage = ImageUtil.getImage(ImageUtil.TRAY_ICON_PATH);

	public MainFrame() {
		// ����������
		createTree();
		createDownloadTable();
		// ������Ϣ�б�
		createList();
		this.taskFrame = new NewTaskFrame();
		// ������������
		this.suspendWindow = new SuspendWindow(this);
		// ����������ͼ��
		createTrayIcon();
		// ����������
		createToolBar();
		// �õ���Ļ��С
		Dimension screen = Toolkit.getDefaultToolkit().getScreenSize();
		// ��������
		JScrollPane navPane = new JScrollPane(this.navTree);
		JScrollPane downloadPane = new JScrollPane(this.downloadTable);
		int downloadPaneHeight = (int) (screen.height / 1.5);
		int downloadPaneWidth = (int) (screen.width / 0.8);
		downloadPane.setPreferredSize(new Dimension(downloadPaneWidth, downloadPaneHeight));
		JScrollPane infoPane = new JScrollPane(this.infoJList);
		// �������ұߵķָ�Pane
		JSplitPane rightPane = new JSplitPane(JSplitPane.VERTICAL_SPLIT, downloadPane, infoPane);
		rightPane.setDividerLocation(500);
		rightPane.setDividerSize(3);
		// ������ķָ�Pane
		JSplitPane mainPane = new JSplitPane(JSplitPane.HORIZONTAL_SPLIT, navPane, rightPane);
		mainPane.setDividerSize(3);
		mainPane.setDividerLocation((int) (screen.width / 5.5));

		this.add(mainPane);
		// this.setPreferredSize(new Dimension(screen.width, screen.height -
		// 30));
		// ����ߴ磺1330*0.618=822 1330-822=508 850*0.618=525 850-525=325
		// ��͸�
		int width = 0;
		int height = 0;
		
		try {
			List<String> settingStrs = ConfigurationFileUtil.SETTING_STRS;
			// ��ȡUI����
			String[] windowsSizeWidthSettingInfo = settingStrs.get(1).split("=");
			String[] windowsSizeHeighSettingInfo = settingStrs.get(2).split("=");
			
			// �ж�������Ϣ�Ƿ���ȷ
			width = Integer.parseInt(windowsSizeWidthSettingInfo[1]);
			height = Integer.parseInt(windowsSizeHeighSettingInfo[1]);
			
			this.setPreferredSize(new Dimension(width, height));
		} catch (Exception e) {
			ConfigurationFileUtil.setDefault();
			JOptionPane.showMessageDialog(null, "�����ļ�����ʧ�ܣ���Ϊ���ָ�Ĭ�����ã�", "����", JOptionPane.ERROR_MESSAGE);
			System.exit(1);
		}
		
		/*
		 * ���ó�ʼλ�� (screen.width - 1330) / 2 (screen.high - 850) / 2
		 */
		this.setLocation((screen.width - width) / 2, (screen.height - height) / 2);
		this.setVisible(true);
		this.setTitle("Internet Download Kits�����׼� v1.0 Bata");
		this.setIconImage(ImageUtil.ICON_MAIN.getImage());
		this.pack();
		initlisteners();
		// ������ʱ��
		Timer timer = new Timer(1000, refreshTable);
		timer.start();
		// ��ȡ���л��ļ�
		reverseSer();
	}

	public NewTaskFrame getNewTaskFrame() {
		return this.taskFrame;
	}

	/**
	 * ����������ͼ��
	 */
	private void createTrayIcon() {
		this.popupMenu.add(openItem);
		this.popupMenu.add(newItem);
		this.popupMenu.add(startItem);
		this.popupMenu.add(pauseItem);
		this.popupMenu.add(removeItem);
		this.popupMenu.add(quitItem);
		try {
			SystemTray tray = SystemTray.getSystemTray();
			this.trayIcon = new TrayIcon(trayIconImage, "���߳����ع���", this.popupMenu);
			this.trayIcon.setToolTip("���߳����ع���");
			tray.add(this.trayIcon);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	private void initlisteners() {
		// ����б���������
		this.downloadTable.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {
				// �õ��������Դ
				Resource r = getResource();
				if (r == null)
					return;
				// ������Ϣ��ʾ�����ֵ
				fileSize.setValue(FILE_SIZE_TEXT + r.getSize());
				filePath.setValue(FILE_PATH_TEXT + r.getSaveFile().getAbsolutePath());
				downloadDate.setValue(DOWNLOAD_DATE_TEXT + DateUtil.formatDate(r.getDownloadDate()));
				info.setValue(RESOURCE_INFO_TEXT + r.getState().getState());
				// ��������JList����
				infoJList.setListData(infoList.toArray());
			}
		});
		// �����������������
		this.navTree.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {
				selectTree();
			}
		});
		this.addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent e) {
				setVisible(false);
			}
		});
		// ������ͼ�������
		this.trayIcon.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {
				if (e.getClickCount() == 2) {
					setVisible(true);
				}
			}
		});
		this.openItem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if (isVisible())
					setVisible(false);
				else
					setVisible(true);
			}
		});
		this.newItem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				taskFrame.setVisible(true);
			}
		});
		this.startItem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				startAllTask();
			}
		});
		this.pauseItem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				pauseAllTask();
			}
		});
		this.removeItem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				deleteFinished();
			}
		});
		this.quitItem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				serializable();
				System.exit(0);
			}
		});
	}

	/**
	 * ��������������ķ���
	 */
	private void selectTree() {
		DownloadNode selectNode = getSelectNode();
		this.currentNode = selectNode;
		refreshTable();
	}

	/**
	 * ˢ���б�
	 */
	private void refreshTable() {
		DownloadTableModel model = (DownloadTableModel) this.downloadTable.getModel();
		model.setResources(ContextHolder.ctx.getResources(currentNode));
	}

	private DownloadNode getSelectNode() {
		TreePath treePath = this.navTree.getSelectionPath();
		if (treePath == null)
			return null;
		// ���ѡ�е�TreeNode
		DefaultMutableTreeNode node = (DefaultMutableTreeNode) treePath.getLastPathComponent();
		return (DownloadNode) node.getUserObject();
	}

	private void addTableData() {
		DownloadTableModel model = (DownloadTableModel) this.downloadTable.getModel();
		// ���������Դ���õ��б���
		model.setResources(ContextHolder.ctx.resources);
		// ˢ���б�
		this.downloadTable.refresh();
	}

	/**
	 * �����л�
	 */
	public void reverseSer() {
		File serFile = FileUtil.SERIALIZABLE_FILE;
		if (!serFile.exists())
			return;
		try {
			// �õ��ļ�������
			FileInputStream fis = new FileInputStream(serFile);
			ObjectInputStream ois = new ObjectInputStream(fis);
			// ����ContextHolder��DownloadContext
			ContextHolder.ctx = (DownloadContext) ois.readObject();
			ois.close();
			fis.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		// �����б�
		addTableData();
	}

	/**
	 * ���л�(DownloadContext����)
	 */
	public void serializable() {
		try {
			// ���л�ǰ�Ƚ������������ص�����ֹͣ
			for (Resource r : ContextHolder.ctx.resources) {
				if (r.getState() instanceof Downloading) {
					r.setState(ContextHolder.ctx.PAUSE);
				}
			}
			File serFile = FileUtil.SERIALIZABLE_FILE;
			// �ж����л��ļ��Ƿ����, �������򴴽�
			if (!serFile.exists()) {
				serFile.createNewFile();
			}

			FileOutputStream fos = new FileOutputStream(serFile);
			ObjectOutputStream oos = new ObjectOutputStream(fos);
			// �������Ķ���д�����л��ļ���
			oos.writeObject(ContextHolder.ctx);
			oos.close();
			fos.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public JTable getDownloadTable() {
		return this.downloadTable;
	}

	private void createDownloadTable() {
		DownloadTableModel tableModel = new DownloadTableModel();
		this.downloadTable = new DownloadTable();
		this.downloadTable.setModel(tableModel);
		this.downloadTable.setTableFace();
	}

	/**
	 * ��������ͼ��
	 */
	private void createToolBar() {
		this.toolBar.setFloatable(false);
		this.toolBar.add(this.newTask).setToolTipText("����������");
		this.toolBar.add(this.start).setToolTipText("��ʼ����");
		this.toolBar.add(this.pause).setToolTipText("��ͣ");
		this.toolBar.add(this.delete).setToolTipText("ɾ��");
		this.toolBar.add(this.deleteFinished).setToolTipText("�Ƴ��Ѿ���ɵ�����");
		this.toolBar.add(this.sysSetting).setToolTipText("ϵͳ����");
		this.toolBar.add(this.aboutWindow).setToolTipText("��������");
		
		this.toolBar.setMargin(new Insets(5, 10, 5, 5));
		this.add(this.toolBar, BorderLayout.NORTH);
	}

	private void start() {
		Resource r = getResource();
		if (r == null)
			return;
		if (r.getState() instanceof Pause || r.getState() instanceof Failed) {
			ContextHolder.dh.resumeDownload(r);
		}
	}

	/**
	 * ��ʼȫ������
	 */
	public void startAllTask() {
		for (Resource r : ContextHolder.ctx.resources) {
			if (r.getState() instanceof Pause || r.getState() instanceof Failed) {
				ContextHolder.dh.resumeDownload(r);
			}
		}
	}

	/**
	 * ��ͣȫ������
	 */
	public void pauseAllTask() {
		for (Resource r : ContextHolder.ctx.resources) {
			if (r.getState() instanceof Downloading) {
				r.setState(ContextHolder.ctx.PAUSE);
			}
		}
	}

	private void newTask() {
		this.taskFrame.setVisible(true);
	}

	private void pause() {
		Resource r = getResource();
		if (r == null)
			return;
		// �ж�״̬
		if (!(r.getState() instanceof Downloading))
			return;
		r.setState(ContextHolder.ctx.PAUSE);
	}

	/**
	 * ɾ����Դ
	 */
	private void delete() {
		Resource r = getResource();
		if (r == null)
			return;
		// �Ƚ�����ֹͣ
		r.setState(ContextHolder.ctx.PAUSE);
		// ɾ�����е�.part�ļ�
		try {
			FileUtil.deletePartFiles(r);
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, "��Դ��ϵͳռ�ã���������������ԣ�", "����", JOptionPane.ERROR_MESSAGE);
		}
		// �������ļ�����ɾ����Դ
		ContextHolder.ctx.resources.remove(r);
	}

	/**
	 * ɾ����������ɵ���Դ
	 */
	public void deleteFinished() {
		for (Iterator it = ContextHolder.ctx.resources.iterator(); it.hasNext();) {
			Resource r = (Resource) it.next();
			if (r.getState() instanceof Finished) {
				it.remove();
			}
		}
	}

	/**
	 * ���ϵͳ����
	 */
	public void sysSetting() {
		new SettingWindow().setVisible(true);
	}
	
	/**
	 * ���ڽ���
	 */
	public void aboutWindow() {
		new AboutUS().setVisible(true);
	}

	/**
	 * �õ��û����б�����ѡ�����Դ
	 * 
	 * @return
	 */
	private Resource getResource() {
		int row = this.downloadTable.getSelectedRow();
		int column = this.downloadTable.getColumn(DownloadTableModel.ID_COLUMN).getModelIndex();
		if (row == -1)
			return null;
		String id = (String) this.downloadTable.getValueAt(row, column);
		return ContextHolder.ctx.getResource(id);
	}

	/**
	 * ������
	 */
	private void createTree() {
		DefaultMutableTreeNode root = new DefaultMutableTreeNode();
		DefaultMutableTreeNode tn = new DefaultMutableTreeNode(taskNode);
		root.add(tn);
		// ���������ڵ�
		tn.add(new DefaultMutableTreeNode(downloadingNode));
		tn.add(new DefaultMutableTreeNode(failNode));
		tn.add(new DefaultMutableTreeNode(finishNode));
		this.navTree = new NavigationTree(root);
	}

	private void createList() {
		this.infoJList = new JList();
		this.infoList.add(this.fileSize);
		this.infoList.add(this.filePath);
		this.infoList.add(this.downloadDate);
		this.infoList.add(this.info);
		this.infoJList.setListData(infoList.toArray());
	}

}
