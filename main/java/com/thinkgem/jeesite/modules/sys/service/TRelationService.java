/**
 * Copyright &copy; 2012-2013 <a href="httparamMap://github.com/thinkgem/jeesite">JeeSite</a> All rights reserved.
 */
package com.thinkgem.jeesite.modules.sys.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.thinkgem.jeesite.common.service.CrudService;
import com.thinkgem.jeesite.modules.sys.dao.TRelationDao;
import com.thinkgem.jeesite.modules.sys.entity.Relation;


@Service
@Transactional(readOnly = true)
public class TRelationService extends CrudService<TRelationDao, Relation> {
	
	@Autowired
	protected TRelationDao tRelationDao;
	
	public List<Relation> findAllRel(Relation relation) {
		return super.findAllList(relation);
	} 
	public List<Relation> findRel(Relation relation) {
		relation.setRelFrom("%"+relation.getRelFrom()+"%");
		relation.setRelTo("%"+relation.getRelTo()+"%");
		return tRelationDao.findRel(relation);
	}
	public Relation findRelById(int relId) {
		return tRelationDao.findRelById(relId);
	}
}
