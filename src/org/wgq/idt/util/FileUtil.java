package org.wgq.idt.util;

import java.io.File;
import java.util.List;

import javax.swing.JOptionPane;

import org.wgq.idt.object.Part;
import org.wgq.idt.object.Resource;

/**
 * �ļ�������
 * 
 * @author guoqiang
 * @version 1.0 <br/>
 *          ��վ: <a href="http://www.lzcu.edu.cn">���ݳ���ѧԺ</a> <br>
 *          Copyright (C), 2009-2010, guoqiang <br>
 *          This program is protected by copyright laws.
 */
public class FileUtil {

	public final static File SERIALIZABLE_FILE = new File(
			System.getProperty("user.dir") + File.separator + "data" + File.separator + "history.dat")
					.getAbsoluteFile();

	/**
	 * ɾ���������ļ���.part�ļ�,
	 * 
	 * @param file
	 */
	public static void deletePartFiles(Resource resource) {
		List<Part> parts = resource.getParts();

		for (Part part : parts) {
			File partFile = new File(getPartFilePath(resource, part));
			if (!partFile.exists())
				continue;
			// ֻҪ��һ���ļ�ɾ��ʧ��, �ٵݹ�ɾ��, ֱ������ɾ��Ϊֹ
			if (!(partFile.delete())) {
				// �˴��쳣��ʱ�޷��޸������Ѳ���
				deletePartFiles(resource);
			}
		}
	}

	public static String getFileName(String address) {
		if (address.indexOf("/") != -1) {
			return address.substring(address.lastIndexOf("/") + 1, address.length());
		}
		return null;
	}

	/**
	 * �õ�.part�ļ��ľ���·��
	 * 
	 * @param resource
	 * @param part
	 * @return
	 */
	public static String getPartFilePath(Resource resource, Part part) {
		return resource.getFilePath() + File.separator + part.getPartName();
	}
}
