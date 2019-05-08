package org.wgq.idt.util;

import javax.swing.JOptionPane;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

import org.jb2011.lnf.beautyeye.BeautyEyeLNFHelper;

/**
 * @describe java∆§∑Ùø‚º”‘ÿ
 * 
 * @author guoqiang
 * 
 * 2019ƒÍ3‘¬9»’
 */
public class LookandFeelUtil {
	// ƒ¨»œ∆§∑Ùø‚
	public static final int OPTION_LOOK_DEFAULT = 0;
	
	// Motif∑Á∏Ò
	public static final int OPTION_LOOK_MOTIF = 1;
	
	// beautyeye∆§∑Ùø‚
	public static final int OPTION_LOOK_BEAUTYEYE_INF = 2;
	
	// quaqua∑Á∏Ò
	public static final int OPTION_LOOK_QUAQUA = 3;
	
	/**
	 * º”‘ÿ≈‰÷√—°œÓ÷–µƒ∆§∑Ùø‚
	 * @param option ∆§∑Ùø‚—°œÓ
	 */
	public static void selectLookAndFeel(int option) {
		switch (option) {
		// ƒ¨»œ∆§∑Ù
		case OPTION_LOOK_DEFAULT:
			try {
				String lookAndFeel = UIManager.getSystemLookAndFeelClassName(); 
				UIManager.setLookAndFeel(lookAndFeel);
			} catch (ClassNotFoundException | InstantiationException | IllegalAccessException | UnsupportedLookAndFeelException e1) {
				JOptionPane.showMessageDialog(null, "ƒ¨»œ∆§∑Ùø‚º”‘ÿ ß∞‹£°", "¥ÌŒÛ", JOptionPane.ERROR_MESSAGE);			}
			break;
		
		// Motif∑Á∏Ò
		case OPTION_LOOK_MOTIF:
			try {
				String lookAndFeel = "com.sun.java.swing.plaf.motif.MotifLookAndFeel"; 
				UIManager.setLookAndFeel(lookAndFeel);
			} catch (ClassNotFoundException | InstantiationException | IllegalAccessException | UnsupportedLookAndFeelException e1) {
				JOptionPane.showMessageDialog(null, "Motif∆§∑Ùø‚º”‘ÿ ß∞‹£°", "¥ÌŒÛ", JOptionPane.ERROR_MESSAGE);
			}
			break;
		
		// beautyeye∆§∑Ù
		case OPTION_LOOK_BEAUTYEYE_INF:
			try {
				BeautyEyeLNFHelper.launchBeautyEyeLNF();
				UIManager.put("RootPane.setupButtonVisible", false);
			} catch (Exception e) {
				JOptionPane.showMessageDialog(null, "BeautyEye∆§∑Ùø‚º”‘ÿ ß∞‹£°", "¥ÌŒÛ", JOptionPane.ERROR_MESSAGE);
			}
			break;
			
		// quaqua∑Á∏Ò
		case OPTION_LOOK_QUAQUA:
			 try { 
	              UIManager.setLookAndFeel(
	                  ch.randelshofer.quaqua.QuaquaManager.getLookAndFeel()
	              );
	         } catch (Exception e) {
	        	 JOptionPane.showMessageDialog(null, "quaqua∆§∑Ùø‚º”‘ÿ ß∞‹£°", "¥ÌŒÛ", JOptionPane.ERROR_MESSAGE);
	         }
			break;
		}
	}
}




















