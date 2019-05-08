package org.wgq.idt.navigation;

import javax.swing.ImageIcon;

import org.wgq.idt.util.ImageUtil;

/**
 * 下载失败导航节点
 * @author guoqiang wangguoqiangsh@163.com
 * @version  1.0
 * <br/>网站: <a href="http://www.lzcu.edu.cn">兰州城市学院</a>
 * <br>Copyright (C), 2019-2020, guoqiang
 * <br>This program is protected by copyright laws.
 */
public class FailNode implements DownloadNode {

	public ImageIcon getImageIcon() {
		return ImageUtil.FAIL_NODE_IMAGE;
	}

	public String getText() {
		return "下载失败";
	}

}
