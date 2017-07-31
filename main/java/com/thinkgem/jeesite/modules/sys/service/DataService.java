/**
 * Copyright &copy; 2012-2013 <a href="httparamMap://github.com/thinkgem/jeesite">JeeSite</a> All rights reserved.
 */
package com.thinkgem.jeesite.modules.sys.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.thinkgem.jeesite.common.service.CrudService;
import com.thinkgem.jeesite.modules.sys.dao.DataDao;
import com.thinkgem.jeesite.modules.sys.entity.Data;
import com.thinkgem.jeesite.modules.sys.entity.Relation;


@Service
@Transactional(readOnly = true)
public class DataService extends CrudService<DataDao, Data> {
	@Autowired
	protected DataDao dataDao;
	ObjectMapper objectMapper = new ObjectMapper();
	
//	数据一览 全查询
	public List<Data> findAllData(Data data) {
		return super.findAllList(data);
	}
//	根据数据名称查询
	public List<Data> findData(Relation relation) {
		relation.setRelDataName("%"+relation.getRelDataName()+"%");
		return dataDao.findData(relation);
	}
//	根据系统的关系查询
	public List<Data> findDataBySys(Relation relation) {
		relation.setRelFrom("%"+relation.getRelFrom()+"%");
		relation.setRelTo("%"+relation.getRelTo()+"%");
		return dataDao.findDataBySys(relation);
	}
//	通过数据的ID查询
	public Data findDataById(String dataId) {
		return dataDao.findDataById(dataId);
	}
//	通过关系查询数据之间关系	
	public String findRelByRel(Relation relation) throws JsonProcessingException {
		return objectMapper.writeValueAsString(dataDao.findRelByRel(relation));
	}
}
