package org.wgq.idt.util;

import java.io.File;
import java.util.List;

import javax.swing.JOptionPane;

import org.wgq.idt.object.Part;
import org.wgq.idt.object.Resource;

/**
 * 文件工具类
 * 
 * @author guoqiang
 * @version 1.0 <br/>
 *          网站: <a href="http://www.lzcu.edu.cn">兰州城市学院</a> <br>
 *          Copyright (C), 2009-2010, guoqiang <br>
 *          This program is protected by copyright laws.
 */
public class FileUtil {

	public final static File SERIALIZABLE_FILE = new File(
			System.getProperty("user.dir") + File.separator + "data" + File.separator + "history.dat")
					.getAbsoluteFile();

	/**
	 * 删除该下载文件的.part文件,
	 * 
	 * @param file
	 */
	public static void deletePartFiles(Resource resource) {
		List<Part> parts = resource.getParts();

		for (Part part : parts) {
			File partFile = new File(getPartFilePath(resource, part));
			if (!partFile.exists())
				continue;
			// 只要有一份文件删除失败, 再递归删除, 直到可以删除为止
			if (!(partFile.delete())) {
				// 此处异常暂时无法修复，但已捕获
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
	 * 得到.part文件的绝对路径
	 * 
	 * @param resource
	 * @param part
	 * @return
	 */
	public static String getPartFilePath(Resource resource, Part part) {
		return resource.getFilePath() + File.separator + part.getPartName();
	}
}
