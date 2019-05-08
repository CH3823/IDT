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
 * @describe 关于我们窗口
 * 
 * @author guoqiang
 * 
 *         2019年4月25日
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
	 * 构造方法，初始化对话框
	 */
	public AboutUS() {
		/*
		 * 创建组件
		 */
		jpLeft = new JPanel();
		jpRight = new JPanel(new GridLayout(4, 1));
		jlLogo = new JLabel(ImageUtil.LZCU_LOGO);
		jlName = new JLabel("Internet download Kits v1.0 Bata");
		jlName.setFont(new Font("黑体", Font.PLAIN, 24));
		jlCommunity = new JLabel("<html><a href='https://ch3823.github.io/'>请访问我们的社区了解更多</a></html>");
		jl52PJ = new JLabel("<html><a href='https://www.52pojie.cn/'>吾爱破解论坛</a></html>");
		jlCopyright = new JLabel("(c) Copyright Genuitec, L.L.C. 2019-2020.");

		/*
		 * 向JPanel中添加组件
		 */
		jpLeft.add(jlLogo);

		jpRight.add(jlName);
		jpRight.add(jlCommunity);
		jpRight.add(jl52PJ);
		jpRight.add(jlCopyright);

		/*
		 * 当前对话框设定
		 */
		this.setLayout(new BorderLayout());
		this.add(jpLeft, BorderLayout.WEST);
		this.add(jpRight);

		/*
		 * 当前对话框设定
		 */
		this.setTitle("关于我们");
		this.setIconImage(ImageUtil.ABOUT.getImage());
		this.setModal(true);
		this.setSize(630, 250);

		// 获取屏幕大小
		Dimension screen = Toolkit.getDefaultToolkit().getScreenSize();

		this.setLocation((screen.width - 630) / 2, (screen.height - 250) / 2);
		this.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);

		// 初始化监听
		initLinsteners();
	}

	/**
	 * 初始化监听事件
	 */
	private void initLinsteners() {
		this.jlCommunity.addMouseListener(new MouseListener() {

			@Override
			public void mouseReleased(MouseEvent e) {
				// 只是用鼠标松开的
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
	 * 社区链接生效
	 */
	private void communityVisit() {
		// 判断是否支持Desktop扩展,如果支持则进行下一步
		if (Desktop.isDesktopSupported()) {
			try {
				URI uri = new URI("https://ch3823.github.io/");
				Desktop desktop = Desktop.getDesktop(); // 创建desktop对象
				// 调用默认浏览器打开指定URL
				desktop.browse(uri);

			} catch (URISyntaxException e) {
				e.printStackTrace();

			} catch (IOException e) {
				// 如果没有默认浏览器时，将引发下列异常
				e.printStackTrace();
			}

		}
	}

	/**
	 * 53pojie链接生效
	 */
	private void wuaipojieVisit() {
		// 判断是否支持Desktop扩展,如果支持则进行下一步
		if (Desktop.isDesktopSupported()) {
			try {
				URI uri = new URI("https://www.52pojie.cn/");
				Desktop desktop = Desktop.getDesktop(); // 创建desktop对象
				// 调用默认浏览器打开指定URL
				desktop.browse(uri);

			} catch (URISyntaxException e) {
				e.printStackTrace();

			} catch (IOException e) {
				// 如果没有默认浏览器时，将引发下列异常
				e.printStackTrace();
			}

		}
	}
}
