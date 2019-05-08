package org.wgq.idt.util;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

import org.wgq.idt.info.DefaultConfigInfo;

/**
 * @describe 配置文件文件操作类
 * 主要用于读写配置文件操作
 * 
 * @author guoqiang
 * 
 * 2019年4月23日
 */
public class ConfigurationFileUtil {
	private static File configFile = new File(System.getProperty("user.dir") + File.separator + "data" + File.separator + "default_ui.ini");

	// 读取的配置对象，每次启动只读取一次
	public static List<String> SETTING_STRS = new ArrayList<String>();
	
	/**
	 * 读取配置信息
	 */
	public static void readConfig() {
		BufferedReader br = null;
		
		/*
		 * 判断配置文件是否存在
		 */
		if (!configFile.exists()) {
			// 恢复默认
			writeConfig(new DefaultConfigInfo().getDefaultConfigInfo());
		}
		
		try {
			String configString = "";
			br = new BufferedReader(new FileReader(configFile));
			
			/*
			 * 开始读文件
			 */
			while ((configString = br.readLine()) != null) {
				SETTING_STRS.add(configString);
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				br.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
	
	/**
	 * 写入配置信息
	 */
	public static void writeConfig(List<String> settingStrs) {
		BufferedWriter bw = null;
		
		/*
		 * 判断配置文件是否存在，不存在则创建
		 */
		if (!configFile.exists()) {
			try {
				configFile.createNewFile();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		
		/*
		 * 开始写文件
		 */
		try {
			bw = new BufferedWriter(new FileWriter(configFile));
			
			for (String str : settingStrs) {
				bw.write(str + "\r\n");
			}
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				bw.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
	
	/**
	 * 配置文件恢复默认
	 */
	public static void setDefault() {
		writeConfig(new DefaultConfigInfo().getDefaultConfigInfo());
	}
}




















