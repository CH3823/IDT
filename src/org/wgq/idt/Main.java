package org.wgq.idt;

import java.util.List;

import javax.swing.JOptionPane;

import org.wgq.idt.ui.MainFrame;
import org.wgq.idt.util.ConfigurationFileUtil;
import org.wgq.idt.util.LookandFeelUtil;

/**
 * ���������
 * 
 * @author guoqiang
 * @version  1.0
 * <br/>��վ: <a href="http://www.lzcu.edu.cn">���ݳ���ѧԺ</a>
 * <br>Copyright (C), 2009-2010, guoqiang
 * <br>This program is protected by copyright laws.
 */
public class Main {
	/**
	 * �޸�Ĭ�ϵ�Ƥ����
	 */
	static {
		try {
			ConfigurationFileUtil.readConfig();
			List<String> settingStrs = ConfigurationFileUtil.SETTING_STRS;
			// ��ȡUI����
			String[] uiSettingInfo = settingStrs.get(0).split("=");

			LookandFeelUtil.selectLookAndFeel(uiSettingInfo[1].charAt(0) - '0');
		} catch (Exception e) {
			ConfigurationFileUtil.setDefault();
			JOptionPane.showMessageDialog(null, "�����ļ�����ʧ�ܣ���Ϊ���ָ�Ĭ�����ã�", "����", JOptionPane.ERROR_MESSAGE);
			System.exit(1);
		}
	}
	
	/**
	 * ���������������
	 * @param args
	 */
	public static void main(String[] args) {
		/*
		 * ���д���
		 */
		MainFrame mf = new MainFrame();
	}

}























