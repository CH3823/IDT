package org.wgq.idt;

import java.util.List;

import javax.swing.JOptionPane;

import org.wgq.idt.ui.MainFrame;
import org.wgq.idt.util.ConfigurationFileUtil;
import org.wgq.idt.util.LookandFeelUtil;

/**
 * 程序入口类
 * 
 * @author guoqiang
 * @version  1.0
 * <br/>网站: <a href="http://www.lzcu.edu.cn">兰州城市学院</a>
 * <br>Copyright (C), 2009-2010, guoqiang
 * <br>This program is protected by copyright laws.
 */
public class Main {
	/**
	 * 修改默认的皮肤库
	 */
	static {
		try {
			ConfigurationFileUtil.readConfig();
			List<String> settingStrs = ConfigurationFileUtil.SETTING_STRS;
			// 读取UI配置
			String[] uiSettingInfo = settingStrs.get(0).split("=");

			LookandFeelUtil.selectLookAndFeel(uiSettingInfo[1].charAt(0) - '0');
		} catch (Exception e) {
			ConfigurationFileUtil.setDefault();
			JOptionPane.showMessageDialog(null, "配置文件加载失败，已为您恢复默认设置！", "错误", JOptionPane.ERROR_MESSAGE);
			System.exit(1);
		}
	}
	
	/**
	 * 主函数，程序入口
	 * @param args
	 */
	public static void main(String[] args) {
		/*
		 * 运行窗口
		 */
		MainFrame mf = new MainFrame();
	}

}























