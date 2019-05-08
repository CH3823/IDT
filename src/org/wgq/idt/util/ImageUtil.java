package org.wgq.idt.util;

import java.awt.image.BufferedImage;
import java.io.File;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;

public class ImageUtil {

	// 图标
	public static final ImageIcon ICON_MAIN = new ImageIcon(
			System.getProperty("user.dir") + File.separator + "images/icon.png");
	
	// 任务节点图片
	public static final ImageIcon TASK_NODE_IMAGE = new ImageIcon(
			System.getProperty("user.dir") + File.separator + "images/nav/flashget-trayicon.png");

	// 下载完成节点图片
	public static final ImageIcon FINISH_NODE_IMAGE = new ImageIcon(
			System.getProperty("user.dir") + File.separator + "images/nav/finish.gif");

	// 下载失败节点图片
	public static final ImageIcon FAIL_NODE_IMAGE = new ImageIcon(
			System.getProperty("user.dir") + File.separator + "images/nav/fail.gif");

	// 下载完成的节点
	public static final ImageIcon DOWNLOADING_NODE_IMAGE = new ImageIcon(
			System.getProperty("user.dir") + File.separator + "images/nav/downloading.gif");

	// 正在下载状态图片
	public static final ImageIcon DOWNLOADING_IMAGE = new ImageIcon(
			System.getProperty("user.dir") + File.separator + "images/state/downloading.gif");

	// 正在连接资源的图片
	public static final ImageIcon CONNECTING_IMAGE = new ImageIcon(
			System.getProperty("user.dir") + File.separator + "images/state/connecting.gif");

	// 下载完成的图片
	public static final ImageIcon FINISHED_IMAGE = new ImageIcon(
			System.getProperty("user.dir") + File.separator + "images/state/finished.gif");

	// 不能连接的图片
	public static final ImageIcon FAILED_IMAGE = new ImageIcon(
			System.getProperty("user.dir") + File.separator + "images/state/failed.gif");

	// 暂停下载的图片
	public static final ImageIcon PAUSE_IMAGE = new ImageIcon(
			System.getProperty("user.dir") + File.separator + "images/state/pause.gif");

	public static final String SUSPEND_IMAGE_PATH = System.getProperty("user.dir") + File.separator
			+ "images/flashget.gif";
	// 悬浮打开主窗体菜单
	public static final ImageIcon SUSPEND_OPEN_IAMGE = new ImageIcon(
			System.getProperty("user.dir") + File.separator + "images/suspend/open.gif");
	// 悬浮新任务菜单
	public static final ImageIcon SUSPEND_NEW_IAMGE = new ImageIcon(
			System.getProperty("user.dir") + File.separator + "images/suspend/add.gif");
	// 悬浮开始任务菜单
	public static final ImageIcon SUSPEND_START_IAMGE = new ImageIcon(
			System.getProperty("user.dir") + File.separator + "images/suspend/start.gif");
	// 悬浮暂停任务菜单
	public static final ImageIcon SUSPEND_PAUSE_IAMGE = new ImageIcon(
			System.getProperty("user.dir") + File.separator + "images/suspend/pause.gif");
	// 删除已完成任务
	public static final ImageIcon SUSPEND_REMOVE_IAMGE = new ImageIcon(
			System.getProperty("user.dir") + File.separator + "images/suspend/remove.gif");
	// 退出菜单
	public static final ImageIcon SUSPEND_QUIT_IAMGE = new ImageIcon(
			System.getProperty("user.dir") + File.separator + "images/suspend/quit.gif");
	// 工具栏图片
	public static final String TRAY_ICON_PATH = System.getProperty("user.dir") + File.separator
			+ "images/flashget-trayicon.png";
	// 系统设置界面的大的设置图标
	public static final ImageIcon SYSTEM_SETTING_BIG = new ImageIcon(
			System.getProperty("user.dir") + File.separator + "images/tool/setting_big.png");
	// 关于图标
	public static final ImageIcon ABOUT = new ImageIcon(
			System.getProperty("user.dir") + File.separator + "images/tool/about.png");
	// 兰州城市学院logo
	public static final ImageIcon LZCU_LOGO = new ImageIcon(
			System.getProperty("user.dir") + File.separator + "images/about/lzcu_logo.png");

	/**
	 * 返回悬浮图片
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
