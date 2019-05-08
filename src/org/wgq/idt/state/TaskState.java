package org.wgq.idt.state;

import java.io.Serializable;

import javax.swing.ImageIcon;

import org.wgq.idt.object.Resource;

/**
 * ���������״̬�ӿ� 
 * @author guoqiang wangguoqiangsh@163.com
 * @version  1.0
 * <br/>��վ: <a href="http://www.lzcu.edu.cn">���ݳ���ѧԺ</a>
 * <br>Copyright (C), 2019-2020, guoqiang
 * <br>This program is protected by copyright laws.
 */
public interface TaskState extends Serializable {

	/**
	 * ���ظ�״̬�µ�ͼƬ
	 * @return
	 */
	ImageIcon getIcon();
	
	/**
	 * ����״̬���ַ���
	 * @return
	 */
	String getState();
	
	/**
	 * ��״̬��ʼ��ִ�еķ���
	 */
	void init(Resource resource);
	
	/**
	 * ��״̬����ʱִ�еķ���
	 */
	void destory(Resource resouse);
}
