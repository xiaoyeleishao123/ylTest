/**
 * Copyright &copy; 2012-2016 <a href="https://github.com/thinkgem/jeesite">JeeSite</a> All rights reserved.
 */
package com.thinkgem.jeesite.modules.sys.entity;

import com.thinkgem.jeesite.common.persistence.DataEntity;

/**
 * 系统Entity
 * @author ThinkGem
 * @version 2014-8-19
 */
public class Sys extends DataEntity<Sys> {
	private static final long serialVersionUID = 1L;
	private String sysId;
	private String sysyName;
	private String sysFun;
	private String sysNode;
	public Sys(String sysId, String sysyName, String sysFun, String sysNode) {
		super();
		this.sysId = sysId;
		this.sysyName = sysyName;
		this.sysFun = sysFun;
		this.sysNode = sysNode;
	}
	public Sys() {
		super();
	}
	public Sys(String id) {
		super(id);
	}
	@Override
	public String toString() {
		return "Sys [sysId=" + sysId + ", sysyName=" + sysyName + ", sysFun=" + sysFun + ", sysNode=" + sysNode + "]";
	}
	public String getSysId() {
		return sysId;
	}
	public void setSysId(String sysId) {
		this.sysId = sysId;
	}
	public String getSysyName() {
		return sysyName;
	}
	public void setSysyName(String sysyName) {
		this.sysyName = sysyName;
	}
	public String getSysFun() {
		return sysFun;
	}
	public void setSysFun(String sysFun) {
		this.sysFun = sysFun;
	}
	public String getSysNode() {
		return sysNode;
	}
	public void setSysNode(String sysNode) {
		this.sysNode = sysNode;
	}
}
