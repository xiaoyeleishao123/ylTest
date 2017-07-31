/**
 * Copyright &copy; 2012-2016 <a href="https://github.com/thinkgem/jeesite">JeeSite</a> All rights reserved.
 */
package com.thinkgem.jeesite.modules.sys.entity;


import com.thinkgem.jeesite.common.persistence.DataEntity;

/**
 * 关系Entity
 * @author ThinkGem
 * @version 2013-05-15
 */
public class Relation extends DataEntity<Relation> {
	
	private static final long serialVersionUID = 1L;
	private int relId;  
	private String relFrom;
	private String relTo;
	private int relType;
	private String relDataName;
	public Relation(int relId, String relFrom, String relTo, int relType, String relDataName) {
		super();
		this.relId = relId;
		this.relFrom = relFrom;
		this.relTo = relTo;
		this.relType = relType;
		this.relDataName = relDataName;
	}
	public Relation() {
		super();
	
	}
	public Relation(String id) {
		super(id);
		
	}
	@Override
	public String toString() {
		return "Relation [relId=" + relId + ", relFrom=" + relFrom + ", relTo=" + relTo + ", relType=" + relType
				+ ", relDataName=" + relDataName + "]";
	}
	public int getRelId() {
		return relId;
	}
	public void setRelId(int relId) {
		this.relId = relId;
	}
	public String getRelFrom() {
		return relFrom;
	}
	public void setRelFrom(String relFrom) {
		this.relFrom = relFrom;
	} 
	public String getRelTo() {
		return relTo;
	}
	public void setRelTo(String relTo) {
		this.relTo = relTo;
	}
	public int getRelType() {
		return relType;
	}
	public void setRelType(int relType) {
		this.relType = relType;
	}
	public String getRelDataName() {
		return relDataName;
	}
	public void setRelDataName(String relDataName) {
		this.relDataName = relDataName;
	}
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	
}