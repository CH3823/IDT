package org.wgq.idt.ui;

import java.util.List;

import javax.swing.table.DefaultTableModel;

import org.wgq.idt.ContextHolder;
import org.wgq.idt.object.Resource;

public class DownloadTableModel extends DefaultTableModel {
	
	private List<Resource> resources;
	
	public final static String ID_COLUMN = "id";
	public final static String STATE_COLUMN = "״̬";
	public final static String FILE_NAME_COLUMN = "�ļ�����";
	public final static String FILE_SIZE_COLUMN = "�ļ���С";
//	public final static String DOWNLOAD_DATE_COLUMN = "��������";
	public final static String PLAN_COLUMN = "����";
	public final static String SPEED_COLUMN = "�����ٶ�";
	public final static String HAS_DOWN_COLUMN = "������";
	public final static String COST_TIME_COLUMN = "����ʱ��";
	public final static String SPARE_TIME_COLUMN = "ʣ��ʱ��";
	
	private static final String[] columnNames = {
		ID_COLUMN,
		STATE_COLUMN,
		FILE_NAME_COLUMN,
		FILE_SIZE_COLUMN,
//		DOWNLOAD_DATE_COLUMN,
		PLAN_COLUMN,
		SPEED_COLUMN,
		HAS_DOWN_COLUMN,
		COST_TIME_COLUMN,
		SPARE_TIME_COLUMN
	};

	public DownloadTableModel() {
		super();
		this.resources = ContextHolder.ctx.resources;
	}
	
	public int getRowCount() {
		if (this.resources != null) {
			return this.resources.size();
		} else {
			return 0;
		}
	}
	
	public String getColumnName(int col) {
		return columnNames[col];
	}
	
	public int getColumnCount() {
		return columnNames.length;
	}
	
	public void setResources(List<Resource> resources) {
		this.resources = resources;
	}
	
	public List<Resource> getResources() {
		return this.resources;
	}

	@Override
	public Object getValueAt(int row, int column) {
		Resource r = this.resources.get(row);
		if (r == null) return super.getValueAt(row, column);
		String columnName = this.getColumnName(column);
		if (columnName.equals(STATE_COLUMN)) {
			return r.getState().getIcon();
		} else if (columnName.equals(FILE_NAME_COLUMN)) {
			return r.getFileName();
		} else if (columnName.equals(FILE_SIZE_COLUMN)) {
			return r.getSize() / 1024 + " k";
		} else if (columnName.equals(PLAN_COLUMN)) {
			return r.getProgress();
		} else if (columnName.equals(SPEED_COLUMN)) {
			return r.getSpeed() + " k/s";
		} else if (columnName.equals(HAS_DOWN_COLUMN)) {
			return r.getCurrentLength() / 1024;
		} else if (columnName.equals(COST_TIME_COLUMN)) {
			return r.getCostTime() + " ��";
		} else if (columnName.equals(SPARE_TIME_COLUMN)) {
			return r.getSpareTime() + " ��";
		} else if (columnName.equals(ID_COLUMN)) {
			return r.getId();
		}
		return super.getValueAt(row, column);
	}

}
