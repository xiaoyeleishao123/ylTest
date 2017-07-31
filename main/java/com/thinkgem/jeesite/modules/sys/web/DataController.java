package com.thinkgem.jeesite.modules.sys.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.SessionAttributes;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.thinkgem.jeesite.modules.sys.entity.Data;
import com.thinkgem.jeesite.modules.sys.entity.Relation;
import com.thinkgem.jeesite.modules.sys.entity.Sys;
import com.thinkgem.jeesite.modules.sys.service.DataService;
import com.thinkgem.jeesite.modules.sys.service.SysService;
import com.thinkgem.jeesite.modules.sys.service.TRelationService;

@Controller
@RequestMapping(value="${adminPath}/sys/data")
@SessionAttributes({"rels","syss"})

public class DataController {
	
	@Autowired
	protected DataService dataservice;
	@Autowired
	protected TRelationService tRelationService;
	@Autowired
	protected SysService sysService;
	
	ObjectMapper objectMapper = new ObjectMapper();
	
	@RequestMapping(value ={"", "findAllData"})
	public String findAllData(Model model, Data data){
		model.addAttribute("syss", sysService.findAllList(new Sys()));
		model.addAttribute("rels", tRelationService.findAllRel(new Relation()));
		model.addAttribute("datas",dataservice.findAllData(data));
		return "modules/doctr/dataList";
	}
	
	@RequestMapping(value ={"findData"})
	public String findData(Model model, Relation relation){
		model.addAttribute("datas",dataservice.findData(relation));
		return "modules/doctr/dataList";
	}
	
	@RequestMapping(value ={"findDataBySys"})
	public String findDataBySys(Model model, Relation relation){
		model.addAttribute("datas",dataservice.findDataBySys(relation));
		return "modules/doctr/dataList";
	}
	
	@RequestMapping(value={"findRelByRel"})
	@ResponseBody
	public String findRelByRel(Model model, @RequestBody Relation relation) throws JsonProcessingException{
		return dataservice.findRelByRel(relation);
	}

	@RequestMapping(value={"goAdd"})
	public String goAdd(){
		return "modules/doctr/dataForm";
	}

	@RequestMapping(value={"add"})
	public String add(Model model, Data data){
		dataservice.save(data);
		model.addAttribute("datas",dataservice.findAllData(new Data()));
		return "modules/doctr/dataList";
	}
	
	@RequestMapping(value={"goUpdate"})
	public String goUpdate(Model model, String dataId){
		model.addAttribute("data",dataservice.findDataById(dataId));
		return "modules/doctr/dataForm";
	}
	
	@RequestMapping(value={"update"})
	public String update(Model model, Data data){
		dataservice.update(data);
		model.addAttribute("datas",dataservice.findAllData(new Data()));
		return "modules/doctr/dataList";
	}
	
	@RequestMapping(value={"delete"})
	public String delete(Model model, Data data){
		dataservice.delete(data);
		model.addAttribute("datas",dataservice.findAllData(new Data()));
		return "modules/doctr/dataList";
	}
}