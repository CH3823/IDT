package org.wgq.idt.util;

import javax.swing.JOptionPane;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

import org.jb2011.lnf.beautyeye.BeautyEyeLNFHelper;

/**
 * @describe javaƤ�������
 * 
 * @author guoqiang
 * 
 * 2019��3��9��
 */
public class LookandFeelUtil {
	// Ĭ��Ƥ����
	public static final int OPTION_LOOK_DEFAULT = 0;
	
	// Motif���
	public static final int OPTION_LOOK_MOTIF = 1;
	
	// beautyeyeƤ����
	public static final int OPTION_LOOK_BEAUTYEYE_INF = 2;
	
	// quaqua���
	public static final int OPTION_LOOK_QUAQUA = 3;
	
	/**
	 * ��������ѡ���е�Ƥ����
	 * @param option Ƥ����ѡ��
	 */
	public static void selectLookAndFeel(int option) {
		switch (option) {
		// Ĭ��Ƥ��
		case OPTION_LOOK_DEFAULT:
			try {
				String lookAndFeel = UIManager.getSystemLookAndFeelClassName(); 
				UIManager.setLookAndFeel(lookAndFeel);
			} catch (ClassNotFoundException | InstantiationException | IllegalAccessException | UnsupportedLookAndFeelException e1) {
				JOptionPane.showMessageDialog(null, "Ĭ��Ƥ�������ʧ�ܣ�", "����", JOptionPane.ERROR_MESSAGE);			}
			break;
		
		// Motif���
		case OPTION_LOOK_MOTIF:
			try {
				String lookAndFeel = "com.sun.java.swing.plaf.motif.MotifLookAndFeel"; 
				UIManager.setLookAndFeel(lookAndFeel);
			} catch (ClassNotFoundException | InstantiationException | IllegalAccessException | UnsupportedLookAndFeelException e1) {
				JOptionPane.showMessageDialog(null, "MotifƤ�������ʧ�ܣ�", "����", JOptionPane.ERROR_MESSAGE);
			}
			break;
		
		// beautyeyeƤ��
		case OPTION_LOOK_BEAUTYEYE_INF:
			try {
				BeautyEyeLNFHelper.launchBeautyEyeLNF();
				UIManager.put("RootPane.setupButtonVisible", false);
			} catch (Exception e) {
				JOptionPane.showMessageDialog(null, "BeautyEyeƤ�������ʧ�ܣ�", "����", JOptionPane.ERROR_MESSAGE);
			}
			break;
			
		// quaqua���
		case OPTION_LOOK_QUAQUA:
			 try { 
	              UIManager.setLookAndFeel(
	                  ch.randelshofer.quaqua.QuaquaManager.getLookAndFeel()
	              );
	         } catch (Exception e) {
	        	 JOptionPane.showMessageDialog(null, "quaquaƤ�������ʧ�ܣ�", "����", JOptionPane.ERROR_MESSAGE);
	         }
			break;
		}
	}
}




















