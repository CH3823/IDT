package org.wgq.idt.state;

import java.util.Timer;

import javax.swing.ImageIcon;

import org.wgq.idt.ContextHolder;
import org.wgq.idt.object.Resource;
import org.wgq.idt.util.FileUtil;
import org.wgq.idt.util.ImageUtil;

public class Finished extends AbstractState {

	@Override
	public ImageIcon getIcon() {
		return ImageUtil.FINISHED_IMAGE;
	}

	public String getState() {
		return "finished";
	}

	public void init(Resource resource) {
		//删除临时文件
		FileUtil.deletePartFiles(resource);
		//资源下载完成后取消任务
		ContextHolder.dh.stopTimer(resource);
	}
	
	
}
