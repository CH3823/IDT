package org.wgq.idt.navigation;

import javax.swing.ImageIcon;

import org.wgq.idt.util.ImageUtil;

/**
 * �������صĵ����ڵ�
 * @author guoqiang wangguoqiangsh@163.com
 * @version  1.0
 * <br/>��վ: <a href="http://www.lzcu.edu.cn">���ݳ���ѧԺ</a>
 * <br>Copyright (C), 2019-2020, guoqiang
 * <br>This program is protected by copyright laws.
 */
public class DownloadingNode implements DownloadNode {

	public ImageIcon getImageIcon() {
		return ImageUtil.DOWNLOADING_NODE_IMAGE;
	}

	public String getText() {
		return "��������";
	}

}
