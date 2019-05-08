package org.wgq.idt.ui;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;
import java.util.Vector;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

import org.wgq.idt.util.ConfigurationFileUtil;
import org.wgq.idt.util.ImageUtil;

/**
 * @describe 系统设置界面
 * 
 * @author guoqiang
 * 
 * 2019年4月24日
 */
public class SettingWindow extends JDialog {
	private JLabel jlImageIcon = null;
	private JLabel jlBeautyView = null;
	private JLabel jlWindowSize = null;
	private JPanel jpLeft = null;
	private JPanel jpRight = null;
	private JPanel jpRightL1 = null;
	private JPanel jpRightL2 = null;
	private JPanel jpRightL3 = null;
	private JButton jbOK = null;
	private JButton jbDefault = null;
	private JComboBox<String> jcbChoiceBeautyView = null;
	private JComboBox<String> jcbChoiceWindowSize = null;
	
	// JComboBox中的条目组件
	Vector<String> beautyItemStrs = null;
	Vector<String> windowSizeItemStrs = null;
	
	/**
	 * 构造方法初始化
	 */
	public SettingWindow() {
		beautyItemStrs = new Vector<String>();
		beautyItemStrs.add("系统风格");
		beautyItemStrs.add("Motif风格");
		beautyItemStrs.add("BeautyEye风格");
		beautyItemStrs.add("Quaqua风格");
		
		windowSizeItemStrs = new Vector<String>();
		windowSizeItemStrs.add("1024x655");
		windowSizeItemStrs.add("1330x850");
		windowSizeItemStrs.add("1400x895");
		windowSizeItemStrs.add("1600x1023");
		
		// 左侧图标
		jlImageIcon = new JLabel(ImageUtil.SYSTEM_SETTING_BIG);
		// 皮肤选择提示
		jlBeautyView = new JLabel("皮肤选项：");
		// 窗口尺寸
		jlWindowSize = new JLabel("窗口尺寸：");
		// 左侧panel
		jpLeft = new JPanel();
		// 右侧panel, 3 rows, 1 cols
		jpRight = new JPanel(new GridLayout(3, 1, 5, 5));
		// jpRightL1 jpRight的第一行
		jpRightL1 = new JPanel(new BorderLayout());
		// jpRightL2 jpRight的第二行
		jpRightL2 = new JPanel(new BorderLayout());
		// jpRightL3 jpRight的第三行
		jpRightL3 = new JPanel(new GridLayout(1, 2, 10, 5));
		// 确认按钮
		jbOK = new JButton("确  认");
		// 取消
		jbDefault = new JButton("默  认");
		// 皮肤库选择
		jcbChoiceBeautyView = new JComboBox<String>(beautyItemStrs);
		// 分辨率选择
		jcbChoiceWindowSize = new JComboBox<String>(windowSizeItemStrs);
		
		// 向panel中添加组件
		jpLeft.add(jlImageIcon);
		
		jpRightL1.add(jlBeautyView, BorderLayout.WEST);
		jpRightL1.add(jcbChoiceBeautyView);
		jpRightL2.add(jlWindowSize, BorderLayout.WEST);
		jpRightL2.add(jcbChoiceWindowSize);
		jpRightL3.add(jbOK);
		jpRightL3.add(jbDefault);
		
		jpRight.add(jpRightL1);
		jpRight.add(jpRightL2);
		jpRight.add(jpRightL3);
		
		// 向对=对话框中添加组件
		this.setLayout(new BorderLayout());
		this.add(jpLeft, BorderLayout.WEST);
		this.add(jpRight);
		
		//得到屏幕大小
		Dimension screen = Toolkit.getDefaultToolkit().getScreenSize();
		
		// 相关设置
		this.setModal(true);
		this.setTitle("设置");
		this.setSize(500, 150);
		this.setLocation((screen.width - 500) / 2, (screen.height - 150) / 2);
		this.setIconImage(ImageUtil.SYSTEM_SETTING_BIG.getImage());
		this.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
		this.pack();
		
		// 初始化监听
		initLinsteners();
	}
	
	/**
	 * 初始化监听事件
	 */
	private void initLinsteners(){
		
		/*
		 * 确定按钮监听事件
		 */
		this.jbOK.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				jbOKListener();
			}
		});
		
		/*
		 * 还原默认监听
		 */
		this.jbDefault.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				jbDefaultListener();
			}
		});
	}
	
	/**
	 * 确认按钮监听事件处理
	 */
	private void jbOKListener() {
		List<String> settingStrs = new ArrayList<>();
		
		// 选择皮肤风格
		String ui = "ui=" + this.jcbChoiceBeautyView.getSelectedIndex();
		
		// 选择宽高
		String[] strs = windowSizeItemStrs.get(this.jcbChoiceWindowSize.getSelectedIndex()).split("x");
		String width = "width=" + strs[0];
		String height = "height=" + strs[1];
		
		// 加入集合
		settingStrs.add(ui);
		settingStrs.add(width);
		settingStrs.add(height);
		
		// 将配置写入文件
		ConfigurationFileUtil.writeConfig(settingStrs);
		
		JOptionPane.showMessageDialog(null, "保存成功！\n请重启生效！", "成功", JOptionPane.INFORMATION_MESSAGE);
		
		// 关闭当前窗口
		this.setVisible(false);
	}
	
	/**
	 * 恢复默认默认按钮监听事件处理
	 */
	private void jbDefaultListener() {
		ConfigurationFileUtil.setDefault();
		JOptionPane.showMessageDialog(null, "已为您恢复默认设置！\n请重启生效！", "成功", JOptionPane.INFORMATION_MESSAGE);
		
		// 关闭当前窗口
		this.setVisible(false);
	}
}

























