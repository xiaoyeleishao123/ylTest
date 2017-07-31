/**
 * Copyright &copy; 2012-2016 <a href="https://github.com/thinkgem/jeesite">JeeSite</a> All rights reserved.
 */
package com.thinkgem.jeesite.modules.sys.web;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;

import com.thinkgem.jeesite.modules.sys.entity.Relation;
import com.thinkgem.jeesite.modules.sys.entity.Sys;
import com.thinkgem.jeesite.modules.sys.service.SysService;
import com.thinkgem.jeesite.modules.sys.service.TRelationService;

@Controller
@RequestMapping(value="${adminPath}/sys/relation")
@SessionAttributes("syss")
public class RelationController{
	@Autowired
	protected TRelationService tRelationService;
	@Autowired
	protected SysService sysService;
	
	@RequestMapping(value ={"", "findAllRel"})
	public String findAllRel(Model model, Relation relation){
		model.addAttribute("syss", sysService.findAllList(new Sys()));
		model.addAttribute("rels", tRelationService.findAllRel(relation));
		return "modules/doctr/relationList";
	}

	@RequestMapping(value ={"findRel"})
	public String findRel(Model model, Relation relation){
		model.addAttribute("rels", tRelationService.findRel(relation));
		return "modules/doctr/relationList";
	}
	@RequestMapping(value={"goAdd"})
	public String goAdd(){
		return "modules/doctr/relForm";
	}
	@RequestMapping(value={"goUpdate"})
	public String goUpdate(Model model, int relId){
		model.addAttribute("rel",tRelationService.findRelById(relId));
		return "modules/doctr/relForm";
	}
	@RequestMapping(value={"update"})
	public String update(Model model, Relation relation){
		tRelationService.update(relation);
		model.addAttribute("rels", tRelationService.findAllRel(relation));
		return "modules/doctr/relationList";
	}
	@RequestMapping(value={"add"}, method=RequestMethod.POST)
	public String add(Model model, Relation relation){
		tRelationService.save(relation);
		model.addAttribute("rels", tRelationService.findAllRel(relation));
		return "modules/doctr/relationList";
	}
	@RequestMapping(value={"delete"})
	public String delete(Model model, Relation relation){
		tRelationService.delete(relation);
		model.addAttribute("rels", tRelationService.findAllRel(relation));
		return "modules/doctr/relationList";
	}
}
