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
 * @describe �����ļ��ļ�������
 * ��Ҫ���ڶ�д�����ļ�����
 * 
 * @author guoqiang
 * 
 * 2019��4��23��
 */
public class ConfigurationFileUtil {
	private static File configFile = new File(System.getProperty("user.dir") + File.separator + "data" + File.separator + "default_ui.ini");

	// ��ȡ�����ö���ÿ������ֻ��ȡһ��
	public static List<String> SETTING_STRS = new ArrayList<String>();
	
	/**
	 * ��ȡ������Ϣ
	 */
	public static void readConfig() {
		BufferedReader br = null;
		
		/*
		 * �ж������ļ��Ƿ����
		 */
		if (!configFile.exists()) {
			// �ָ�Ĭ��
			writeConfig(new DefaultConfigInfo().getDefaultConfigInfo());
		}
		
		try {
			String configString = "";
			br = new BufferedReader(new FileReader(configFile));
			
			/*
			 * ��ʼ���ļ�
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
	 * д��������Ϣ
	 */
	public static void writeConfig(List<String> settingStrs) {
		BufferedWriter bw = null;
		
		/*
		 * �ж������ļ��Ƿ���ڣ��������򴴽�
		 */
		if (!configFile.exists()) {
			try {
				configFile.createNewFile();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		
		/*
		 * ��ʼд�ļ�
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
	 * �����ļ��ָ�Ĭ��
	 */
	public static void setDefault() {
		writeConfig(new DefaultConfigInfo().getDefaultConfigInfo());
	}
}




















