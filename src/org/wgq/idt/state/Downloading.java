package org.wgq.idt.state;

import javax.swing.ImageIcon;

import org.wgq.idt.object.Resource;
import org.wgq.idt.util.ImageUtil;

public class Downloading extends AbstractState {

	@Override
	public ImageIcon getIcon() {
		return ImageUtil.DOWNLOADING_IMAGE;
	}
	public String getState() {
		return "downloading";
	}
}
