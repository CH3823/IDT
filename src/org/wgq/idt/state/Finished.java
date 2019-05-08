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
		//ɾ����ʱ�ļ�
		FileUtil.deletePartFiles(resource);
		//��Դ������ɺ�ȡ������
		ContextHolder.dh.stopTimer(resource);
	}
	
	
}
