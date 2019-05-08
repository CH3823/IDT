package org.wgq.idt.state;

import javax.swing.ImageIcon;

import org.wgq.idt.ContextHolder;
import org.wgq.idt.object.Resource;
import org.wgq.idt.util.ImageUtil;

public class Pause extends AbstractState {
	
	@Override
	public ImageIcon getIcon() {
		return ImageUtil.PAUSE_IMAGE;
	}

	@Override
	public String getState() {
		return "pause";
	}

	@Override
	public void init(Resource resource) {
		//��Դ��ͣ��ȡ������
		ContextHolder.dh.stopTimer(resource);
	}

}
