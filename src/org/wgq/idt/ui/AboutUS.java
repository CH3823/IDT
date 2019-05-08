package org.wgq.idt.ui;

import java.awt.BorderLayout;
import java.awt.Desktop;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;

import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

import org.wgq.idt.util.ImageUtil;

/**
 * @describe �������Ǵ���
 * 
 * @author guoqiang
 * 
 *         2019��4��25��
 */
public class AboutUS extends JDialog {
	private JPanel jpLeft = null;
	private JPanel jpRight = null;
	private JLabel jlLogo = null;
	private JLabel jlName = null;
	private JLabel jlCommunity = null;
	private JLabel jl52PJ = null;
	private JLabel jlCopyright = null;

	/**
	 * ���췽������ʼ���Ի���
	 */
	public AboutUS() {
		/*
		 * �������
		 */
		jpLeft = new JPanel();
		jpRight = new JPanel(new GridLayout(4, 1));
		jlLogo = new JLabel(ImageUtil.LZCU_LOGO);
		jlName = new JLabel("Internet download Kits v1.0 Bata");
		jlName.setFont(new Font("����", Font.PLAIN, 24));
		jlCommunity = new JLabel("<html><a href='https://ch3823.github.io/'>��������ǵ������˽����</a></html>");
		jl52PJ = new JLabel("<html><a href='https://www.52pojie.cn/'>�ᰮ�ƽ���̳</a></html>");
		jlCopyright = new JLabel("(c) Copyright Genuitec, L.L.C. 2019-2020.");

		/*
		 * ��JPanel��������
		 */
		jpLeft.add(jlLogo);

		jpRight.add(jlName);
		jpRight.add(jlCommunity);
		jpRight.add(jl52PJ);
		jpRight.add(jlCopyright);

		/*
		 * ��ǰ�Ի����趨
		 */
		this.setLayout(new BorderLayout());
		this.add(jpLeft, BorderLayout.WEST);
		this.add(jpRight);

		/*
		 * ��ǰ�Ի����趨
		 */
		this.setTitle("��������");
		this.setIconImage(ImageUtil.ABOUT.getImage());
		this.setModal(true);
		this.setSize(630, 250);

		// ��ȡ��Ļ��С
		Dimension screen = Toolkit.getDefaultToolkit().getScreenSize();

		this.setLocation((screen.width - 630) / 2, (screen.height - 250) / 2);
		this.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);

		// ��ʼ������
		initLinsteners();
	}

	/**
	 * ��ʼ�������¼�
	 */
	private void initLinsteners() {
		this.jlCommunity.addMouseListener(new MouseListener() {

			@Override
			public void mouseReleased(MouseEvent e) {
				// ֻ��������ɿ���
				communityVisit();
			}

			@Override
			public void mousePressed(MouseEvent e) {
				// TODO Auto-generated method stub

			}

			@Override
			public void mouseExited(MouseEvent e) {
				// TODO Auto-generated method stub

			}

			@Override
			public void mouseEntered(MouseEvent e) {
				// TODO Auto-generated method stub

			}

			@Override
			public void mouseClicked(MouseEvent e) {
				// TODO Auto-generated method stub

			}
		});

		this.jl52PJ.addMouseListener(new MouseListener() {

			@Override
			public void mouseReleased(MouseEvent e) {
				wuaipojieVisit();
			}

			@Override
			public void mousePressed(MouseEvent e) {
				// TODO Auto-generated method stub

			}

			@Override
			public void mouseExited(MouseEvent e) {
				// TODO Auto-generated method stub

			}

			@Override
			public void mouseEntered(MouseEvent e) {
				// TODO Auto-generated method stub

			}

			@Override
			public void mouseClicked(MouseEvent e) {
				// TODO Auto-generated method stub

			}
		});
	}

	/**
	 * ����������Ч
	 */
	private void communityVisit() {
		// �ж��Ƿ�֧��Desktop��չ,���֧���������һ��
		if (Desktop.isDesktopSupported()) {
			try {
				URI uri = new URI("https://ch3823.github.io/");
				Desktop desktop = Desktop.getDesktop(); // ����desktop����
				// ����Ĭ���������ָ��URL
				desktop.browse(uri);

			} catch (URISyntaxException e) {
				e.printStackTrace();

			} catch (IOException e) {
				// ���û��Ĭ�������ʱ�������������쳣
				e.printStackTrace();
			}

		}
	}

	/**
	 * 53pojie������Ч
	 */
	private void wuaipojieVisit() {
		// �ж��Ƿ�֧��Desktop��չ,���֧���������һ��
		if (Desktop.isDesktopSupported()) {
			try {
				URI uri = new URI("https://www.52pojie.cn/");
				Desktop desktop = Desktop.getDesktop(); // ����desktop����
				// ����Ĭ���������ָ��URL
				desktop.browse(uri);

			} catch (URISyntaxException e) {
				e.printStackTrace();

			} catch (IOException e) {
				// ���û��Ĭ�������ʱ�������������쳣
				e.printStackTrace();
			}

		}
	}
}
