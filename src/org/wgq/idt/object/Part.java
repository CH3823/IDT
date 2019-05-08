package org.wgq.idt.object;

import java.io.Serializable;
import java.util.UUID;

/**
 * �����
 */
public class Part implements Serializable {

	//���صĿ�ʼλ��
	private int begin;
	//���part�ļ��ĳ���
	private int length;
	//�Ѿ����ص��ļ�����
	private int currentLength;
	//ÿ��Part��Ӧ���ļ�
	private String partName;

	public Part(int begin, int length, int currentLength) {
		this.begin = begin;
		this.length = length;
		this.currentLength = currentLength;
		this.partName = UUID.randomUUID() + ".part";
	}
	
	public int getBegin() {
		return begin;
	}

	public void setBegin(int begin) {
		this.begin = begin;
	}

	public int getLength() {
		return length;
	}

	public void setLength(int length) {
		this.length = length;
	}

	public int getCurrentLength() {
		return currentLength;
	}

	public void setCurrentLength(int currentLength) {
		this.currentLength = currentLength;
	}

	public String getPartName() {
		return partName;
	}

	public void setPartName(String partName) {
		this.partName = partName;
	}

	
	
}
