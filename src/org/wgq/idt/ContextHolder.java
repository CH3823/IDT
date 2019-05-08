package org.wgq.idt;

import org.wgq.idt.thread.DownloadHandler;

/**
 * @describe 保证只有一个DownloadContext对象
 * 
 * @author guoqiang
 * 
 * 2019年5月6日
 */
public class ContextHolder {
	//下载工具上下文
	public static DownloadContext ctx = new DownloadContext();
	//下载处理类
	public static DownloadHandler dh = new DownloadHandler();
}
