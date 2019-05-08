package org.wgq.idt.navigation;

import javax.swing.ImageIcon;

import org.wgq.idt.util.ImageUtil;

/**
 * 全部下载资源(任务)节点
 * @author guoqiang wangguoqiangsh@163.com
 * @version  1.0
 * <br/>网站: <a href="http://www.lzcu.edu.cn">兰州城市学院</a>
 * <br>Copyright (C), 2019-2020, guoqiang
 * <br>This program is protected by copyright laws.
 */
public class TaskNode implements DownloadNode {

	public ImageIcon getImageIcon() {
		return ImageUtil.TASK_NODE_IMAGE;
	}

	public String getText() {
		return "任务";
	}

}
