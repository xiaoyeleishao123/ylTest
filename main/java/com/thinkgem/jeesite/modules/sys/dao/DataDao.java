/**
 * Copyright &copy; 2012-2016 <a href="https://github.com/thinkgem/jeesite">JeeSite</a> All rights reserved.
 */
package com.thinkgem.jeesite.modules.sys.dao;

import java.util.List;

import com.thinkgem.jeesite.common.persistence.CrudDao;
import com.thinkgem.jeesite.common.persistence.annotation.MyBatisDao;
import com.thinkgem.jeesite.modules.sys.entity.Data;
import com.thinkgem.jeesite.modules.sys.entity.Relation;

/**
 * 数据DAO接口
 * @author ThinkGem
 * @version 2014-05-16
 */
@MyBatisDao
public interface DataDao extends CrudDao<Data> {
	public List<Data> findData(Relation relation);
	public List<Data> findDataBySys(Relation relation);
	public Data findDataById(String dataId);
	public List<Relation> findRelByRel(Relation relation);
}
