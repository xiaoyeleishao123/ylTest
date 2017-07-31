package com.thinkgem.jeesite.modules.sys.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import com.thinkgem.jeesite.common.service.CrudService;
import com.thinkgem.jeesite.modules.sys.dao.SysDao;
import com.thinkgem.jeesite.modules.sys.entity.Sys;

@Service("sysService")
@Transactional(readOnly = true)
public class SysService extends CrudService<SysDao, Sys> {
	@Autowired
	protected SysDao sysDao;
	
	public List<Sys> findSys(Sys sys) {
		sys.setSysId("%"+sys.getSysId()+"%");
		return super.findList(sys);
	}
	public String selectSysById(String sysId){
		Sys sys = new Sys();
		sys.setSysId(sysId);
		if (sysDao.selectSysById(sys) == null) {
			return "{\"result\":\"*\"}";
		}else {
			return "{\"result\":\"已存在该编号\"}";
		}
	}
}
