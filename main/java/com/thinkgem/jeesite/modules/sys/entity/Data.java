/**
 * Copyright &copy; 2012-2016 <a href="https://github.com/thinkgem/jeesite">JeeSite</a> All rights reserved.
 */
package com.thinkgem.jeesite.modules.sys.entity;



import com.thinkgem.jeesite.common.persistence.DataEntity;

/**
 * 数据Entity
 * @author ThinkGem
 * @version 2014-8-19
 */
public class Data extends DataEntity<Data> {

	private static final long serialVersionUID = 1L;
	private int dataId;
	private int dataRelId;
	private String dataType;
	private int dataLength;
	public Data(int dataId, int dataRelId, String dataType, int dataLength) {
		super();
		this.dataId = dataId;
		this.dataRelId = dataRelId;
		this.dataType = dataType;
		this.dataLength = dataLength;
	}
	public Data() {
		super();
	}
	public Data(String id) {
		super(id);
	}
	@Override
	public String toString() {
		return "Data [dataId=" + dataId + ", dataRelId=" + dataRelId + ", dataType=" + dataType + ", dataLength="
				+ dataLength + "]";
	}
	public int getDataId() {
		return dataId;
	}
	public void setDataId(int dataId) {
		this.dataId = dataId;
	}
	public int getDataRelId() {
		return dataRelId;
	}
	public void setDataRelId(int dataRelId) {
		this.dataRelId = dataRelId;
	}
	public String getDataType() {
		return dataType;
	}
	public void setDataType(String dataType) {
		this.dataType = dataType;
	}
	public int getDataLength() {
		return dataLength;
	}
	public void setDataLength(int dataLength) {
		this.dataLength = dataLength;
	}
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
}