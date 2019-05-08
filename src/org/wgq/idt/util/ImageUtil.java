package org.wgq.idt.util;

import java.awt.image.BufferedImage;
import java.io.File;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;

public class ImageUtil {

	// ͼ��
	public static final ImageIcon ICON_MAIN = new ImageIcon(
			System.getProperty("user.dir") + File.separator + "images/icon.png");
	
	// ����ڵ�ͼƬ
	public static final ImageIcon TASK_NODE_IMAGE = new ImageIcon(
			System.getProperty("user.dir") + File.separator + "images/nav/flashget-trayicon.png");

	// ������ɽڵ�ͼƬ
	public static final ImageIcon FINISH_NODE_IMAGE = new ImageIcon(
			System.getProperty("user.dir") + File.separator + "images/nav/finish.gif");

	// ����ʧ�ܽڵ�ͼƬ
	public static final ImageIcon FAIL_NODE_IMAGE = new ImageIcon(
			System.getProperty("user.dir") + File.separator + "images/nav/fail.gif");

	// ������ɵĽڵ�
	public static final ImageIcon DOWNLOADING_NODE_IMAGE = new ImageIcon(
			System.getProperty("user.dir") + File.separator + "images/nav/downloading.gif");

	// ��������״̬ͼƬ
	public static final ImageIcon DOWNLOADING_IMAGE = new ImageIcon(
			System.getProperty("user.dir") + File.separator + "images/state/downloading.gif");

	// ����������Դ��ͼƬ
	public static final ImageIcon CONNECTING_IMAGE = new ImageIcon(
			System.getProperty("user.dir") + File.separator + "images/state/connecting.gif");

	// ������ɵ�ͼƬ
	public static final ImageIcon FINISHED_IMAGE = new ImageIcon(
			System.getProperty("user.dir") + File.separator + "images/state/finished.gif");

	// �������ӵ�ͼƬ
	public static final ImageIcon FAILED_IMAGE = new ImageIcon(
			System.getProperty("user.dir") + File.separator + "images/state/failed.gif");

	// ��ͣ���ص�ͼƬ
	public static final ImageIcon PAUSE_IMAGE = new ImageIcon(
			System.getProperty("user.dir") + File.separator + "images/state/pause.gif");

	public static final String SUSPEND_IMAGE_PATH = System.getProperty("user.dir") + File.separator
			+ "images/flashget.gif";
	// ������������˵�
	public static final ImageIcon SUSPEND_OPEN_IAMGE = new ImageIcon(
			System.getProperty("user.dir") + File.separator + "images/suspend/open.gif");
	// ����������˵�
	public static final ImageIcon SUSPEND_NEW_IAMGE = new ImageIcon(
			System.getProperty("user.dir") + File.separator + "images/suspend/add.gif");
	// ������ʼ����˵�
	public static final ImageIcon SUSPEND_START_IAMGE = new ImageIcon(
			System.getProperty("user.dir") + File.separator + "images/suspend/start.gif");
	// ������ͣ����˵�
	public static final ImageIcon SUSPEND_PAUSE_IAMGE = new ImageIcon(
			System.getProperty("user.dir") + File.separator + "images/suspend/pause.gif");
	// ɾ�����������
	public static final ImageIcon SUSPEND_REMOVE_IAMGE = new ImageIcon(
			System.getProperty("user.dir") + File.separator + "images/suspend/remove.gif");
	// �˳��˵�
	public static final ImageIcon SUSPEND_QUIT_IAMGE = new ImageIcon(
			System.getProperty("user.dir") + File.separator + "images/suspend/quit.gif");
	// ������ͼƬ
	public static final String TRAY_ICON_PATH = System.getProperty("user.dir") + File.separator
			+ "images/flashget-trayicon.png";
	// ϵͳ���ý���Ĵ������ͼ��
	public static final ImageIcon SYSTEM_SETTING_BIG = new ImageIcon(
			System.getProperty("user.dir") + File.separator + "images/tool/setting_big.png");
	// ����ͼ��
	public static final ImageIcon ABOUT = new ImageIcon(
			System.getProperty("user.dir") + File.separator + "images/tool/about.png");
	// ���ݳ���ѧԺlogo
	public static final ImageIcon LZCU_LOGO = new ImageIcon(
			System.getProperty("user.dir") + File.separator + "images/about/lzcu_logo.png");

	/**
	 * ��������ͼƬ
	 * 
	 * @return
	 */
	public static BufferedImage getImage(String path) {
		try {
			return ImageIO.read(new File(path));
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}
}
