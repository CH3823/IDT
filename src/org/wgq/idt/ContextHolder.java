package org.wgq.idt;

import org.wgq.idt.thread.DownloadHandler;

/**
 * @describe ��ֻ֤��һ��DownloadContext����
 * 
 * @author guoqiang
 * 
 * 2019��5��6��
 */
public class ContextHolder {
	//���ع���������
	public static DownloadContext ctx = new DownloadContext();
	//���ش�����
	public static DownloadHandler dh = new DownloadHandler();
}
