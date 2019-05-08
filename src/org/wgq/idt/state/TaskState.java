package org.wgq.idt.state;

import java.io.Serializable;

import javax.swing.ImageIcon;

import org.wgq.idt.object.Resource;

/**
 * 下载任务的状态接口 
 * @author guoqiang wangguoqiangsh@163.com
 * @version  1.0
 * <br/>网站: <a href="http://www.lzcu.edu.cn">兰州城市学院</a>
 * <br>Copyright (C), 2019-2020, guoqiang
 * <br>This program is protected by copyright laws.
 */
public interface TaskState extends Serializable {

	/**
	 * 返回该状态下的图片
	 * @return
	 */
	ImageIcon getIcon();
	
	/**
	 * 返回状态的字符串
	 * @return
	 */
	String getState();
	
	/**
	 * 该状态初始化执行的方法
	 */
	void init(Resource resource);
	
	/**
	 * 该状态结束时执行的方法
	 */
	void destory(Resource resouse);
}
