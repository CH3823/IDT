package org.wgq.idt.ui;

import javax.swing.JTable;
import javax.swing.ListSelectionModel;

/**
 * �����б� 
 * @author yangenxiong yangenxiong2009@gmail.com
 * @version  1.0
 * <br/>��վ: <a href="http://www.crazyit.org">���Java����</a>
 * <br>Copyright (C), 2009-2010, yangenxiong
 * <br>This program is protected by copyright laws.
 */
public class DownloadTable extends JTable {
		
	public DownloadTable() {
		super();
	}

	public void refresh() {
		DownloadTableModel tableModel = (DownloadTableModel)this.getModel();
		//֪ͨ������, �ڷ�Χ�ڼ�������
		tableModel.fireTableRowsInserted(getRowCount() - 1, getRowCount() - 1);
		setTableFace();
	}

	public void setTableFace() {
		this.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		this.setRowHeight(25);
		//�����п�
		this.getColumn(DownloadTableModel.ID_COLUMN).setMinWidth(0);
		this.getColumn(DownloadTableModel.ID_COLUMN).setMaxWidth(0);
		this.getColumn(DownloadTableModel.STATE_COLUMN).setMaxWidth(40);
		this.getColumn(DownloadTableModel.FILE_NAME_COLUMN).setMinWidth(200);
		this.getColumn(DownloadTableModel.FILE_SIZE_COLUMN).setMinWidth(60);
		this.getColumn(DownloadTableModel.PLAN_COLUMN).setMinWidth(180);
		this.getColumn(DownloadTableModel.SPEED_COLUMN).setMinWidth(50);
		this.getColumn(DownloadTableModel.HAS_DOWN_COLUMN).setMinWidth(50);
		this.getColumn(DownloadTableModel.COST_TIME_COLUMN).setMinWidth(50);
		this.getColumn(DownloadTableModel.SPARE_TIME_COLUMN).setMinWidth(50);
		//���õ�Ԫ����Ⱦ
		this.getColumn(DownloadTableModel.STATE_COLUMN).setCellRenderer(
				new DownloadTableCellRenderer());
		this.getColumn(DownloadTableModel.FILE_NAME_COLUMN).setCellRenderer(
				new DownloadTableCellRenderer());
		this.getColumn(DownloadTableModel.FILE_SIZE_COLUMN).setCellRenderer(
				new DownloadTableCellRenderer());
		this.getColumn(DownloadTableModel.PLAN_COLUMN).setCellRenderer(
				new DownloadProgressBar());
		this.getColumn(DownloadTableModel.SPEED_COLUMN).setCellRenderer(
				new DownloadTableCellRenderer());
		this.getColumn(DownloadTableModel.HAS_DOWN_COLUMN).setCellRenderer(
				new DownloadTableCellRenderer());
		this.getColumn(DownloadTableModel.COST_TIME_COLUMN).setCellRenderer(
				new DownloadTableCellRenderer());
		this.getColumn(DownloadTableModel.SPARE_TIME_COLUMN).setCellRenderer(
				new DownloadTableCellRenderer());
		//ȥ��������
		setShowVerticalLines(false);
	}
	
	public boolean isCellEditable(int row, int column) {
		return false;
	}

}
