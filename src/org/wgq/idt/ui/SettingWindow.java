package org.wgq.idt.ui;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;
import java.util.Vector;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

import org.wgq.idt.util.ConfigurationFileUtil;
import org.wgq.idt.util.ImageUtil;

/**
 * @describe ϵͳ���ý���
 * 
 * @author guoqiang
 * 
 * 2019��4��24��
 */
public class SettingWindow extends JDialog {
	private JLabel jlImageIcon = null;
	private JLabel jlBeautyView = null;
	private JLabel jlWindowSize = null;
	private JPanel jpLeft = null;
	private JPanel jpRight = null;
	private JPanel jpRightL1 = null;
	private JPanel jpRightL2 = null;
	private JPanel jpRightL3 = null;
	private JButton jbOK = null;
	private JButton jbDefault = null;
	private JComboBox<String> jcbChoiceBeautyView = null;
	private JComboBox<String> jcbChoiceWindowSize = null;
	
	// JComboBox�е���Ŀ���
	Vector<String> beautyItemStrs = null;
	Vector<String> windowSizeItemStrs = null;
	
	/**
	 * ���췽����ʼ��
	 */
	public SettingWindow() {
		beautyItemStrs = new Vector<String>();
		beautyItemStrs.add("ϵͳ���");
		beautyItemStrs.add("Motif���");
		beautyItemStrs.add("BeautyEye���");
		beautyItemStrs.add("Quaqua���");
		
		windowSizeItemStrs = new Vector<String>();
		windowSizeItemStrs.add("1024x655");
		windowSizeItemStrs.add("1330x850");
		windowSizeItemStrs.add("1400x895");
		windowSizeItemStrs.add("1600x1023");
		
		// ���ͼ��
		jlImageIcon = new JLabel(ImageUtil.SYSTEM_SETTING_BIG);
		// Ƥ��ѡ����ʾ
		jlBeautyView = new JLabel("Ƥ��ѡ�");
		// ���ڳߴ�
		jlWindowSize = new JLabel("���ڳߴ磺");
		// ���panel
		jpLeft = new JPanel();
		// �Ҳ�panel, 3 rows, 1 cols
		jpRight = new JPanel(new GridLayout(3, 1, 5, 5));
		// jpRightL1 jpRight�ĵ�һ��
		jpRightL1 = new JPanel(new BorderLayout());
		// jpRightL2 jpRight�ĵڶ���
		jpRightL2 = new JPanel(new BorderLayout());
		// jpRightL3 jpRight�ĵ�����
		jpRightL3 = new JPanel(new GridLayout(1, 2, 10, 5));
		// ȷ�ϰ�ť
		jbOK = new JButton("ȷ  ��");
		// ȡ��
		jbDefault = new JButton("Ĭ  ��");
		// Ƥ����ѡ��
		jcbChoiceBeautyView = new JComboBox<String>(beautyItemStrs);
		// �ֱ���ѡ��
		jcbChoiceWindowSize = new JComboBox<String>(windowSizeItemStrs);
		
		// ��panel��������
		jpLeft.add(jlImageIcon);
		
		jpRightL1.add(jlBeautyView, BorderLayout.WEST);
		jpRightL1.add(jcbChoiceBeautyView);
		jpRightL2.add(jlWindowSize, BorderLayout.WEST);
		jpRightL2.add(jcbChoiceWindowSize);
		jpRightL3.add(jbOK);
		jpRightL3.add(jbDefault);
		
		jpRight.add(jpRightL1);
		jpRight.add(jpRightL2);
		jpRight.add(jpRightL3);
		
		// ���=�Ի�����������
		this.setLayout(new BorderLayout());
		this.add(jpLeft, BorderLayout.WEST);
		this.add(jpRight);
		
		//�õ���Ļ��С
		Dimension screen = Toolkit.getDefaultToolkit().getScreenSize();
		
		// �������
		this.setModal(true);
		this.setTitle("����");
		this.setSize(500, 150);
		this.setLocation((screen.width - 500) / 2, (screen.height - 150) / 2);
		this.setIconImage(ImageUtil.SYSTEM_SETTING_BIG.getImage());
		this.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
		this.pack();
		
		// ��ʼ������
		initLinsteners();
	}
	
	/**
	 * ��ʼ�������¼�
	 */
	private void initLinsteners(){
		
		/*
		 * ȷ����ť�����¼�
		 */
		this.jbOK.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				jbOKListener();
			}
		});
		
		/*
		 * ��ԭĬ�ϼ���
		 */
		this.jbDefault.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				jbDefaultListener();
			}
		});
	}
	
	/**
	 * ȷ�ϰ�ť�����¼�����
	 */
	private void jbOKListener() {
		List<String> settingStrs = new ArrayList<>();
		
		// ѡ��Ƥ�����
		String ui = "ui=" + this.jcbChoiceBeautyView.getSelectedIndex();
		
		// ѡ����
		String[] strs = windowSizeItemStrs.get(this.jcbChoiceWindowSize.getSelectedIndex()).split("x");
		String width = "width=" + strs[0];
		String height = "height=" + strs[1];
		
		// ���뼯��
		settingStrs.add(ui);
		settingStrs.add(width);
		settingStrs.add(height);
		
		// ������д���ļ�
		ConfigurationFileUtil.writeConfig(settingStrs);
		
		JOptionPane.showMessageDialog(null, "����ɹ���\n��������Ч��", "�ɹ�", JOptionPane.INFORMATION_MESSAGE);
		
		// �رյ�ǰ����
		this.setVisible(false);
	}
	
	/**
	 * �ָ�Ĭ��Ĭ�ϰ�ť�����¼�����
	 */
	private void jbDefaultListener() {
		ConfigurationFileUtil.setDefault();
		JOptionPane.showMessageDialog(null, "��Ϊ���ָ�Ĭ�����ã�\n��������Ч��", "�ɹ�", JOptionPane.INFORMATION_MESSAGE);
		
		// �رյ�ǰ����
		this.setVisible(false);
	}
}

























