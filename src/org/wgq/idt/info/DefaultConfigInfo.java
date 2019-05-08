package org.wgq.idt.info;

import java.util.ArrayList;
import java.util.List;

import org.wgq.idt.util.LookandFeelUtil;

/**
 * @describe 默认的配置信息
 * 
 * @author guoqiang
 * 
 * 2019年4月23日
 */
public class DefaultConfigInfo {
	private List<String> settingStrs = new ArrayList<>();
	
	public List<String> getDefaultConfigInfo() {
		settingStrs.add("ui=" + LookandFeelUtil.OPTION_LOOK_BEAUTYEYE_INF);
		settingStrs.add("width=1330");
		settingStrs.add("height=850");
		
		return settingStrs;
	}
}
