package com.thinkgem.jeesite.modules.sys.dao;

import com.thinkgem.jeesite.common.persistence.CrudDao;
import com.thinkgem.jeesite.common.persistence.annotation.MyBatisDao;
import com.thinkgem.jeesite.modules.sys.entity.Sys;

@MyBatisDao
public interface SysDao extends CrudDao<Sys> {
	public String selectSysById(Sys sys);
}
