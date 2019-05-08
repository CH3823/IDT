package org.wgq.idt.state;

import javax.swing.ImageIcon;

import org.wgq.idt.util.ImageUtil;

public class Connecting extends AbstractState {

	@Override
	public ImageIcon getIcon() {
		return ImageUtil.CONNECTING_IMAGE;
	}
	
	public String getState() {
		return "connecting";
	}
}
