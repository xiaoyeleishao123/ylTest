/**
 * Copyright &copy; 2012-2016 <a href="https://github.com/thinkgem/jeesite">JeeSite</a> All rights reserved.
 */
package com.thinkgem.jeesite.modules.sys.dao;

import java.util.List;

import com.thinkgem.jeesite.common.persistence.CrudDao;
import com.thinkgem.jeesite.common.persistence.annotation.MyBatisDao;
import com.thinkgem.jeesite.modules.sys.entity.Relation;

/**
 * 关系DAO接口
 * @author ThinkGem
 * @version 2014-05-16
 */
@MyBatisDao
public interface TRelationDao extends CrudDao<Relation> {
	public List<Relation> findRel(Relation relation);
	public Relation findRelById(int relId);
}