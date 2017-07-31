package com.thinkgem.jeesite.modules.sys.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.SessionAttributes;

import com.thinkgem.jeesite.common.web.BaseController;
import com.thinkgem.jeesite.modules.sys.entity.Sys;
import com.thinkgem.jeesite.modules.sys.service.SysService;
@Controller
@RequestMapping(value = "${adminPath}/sys/system")
@SessionAttributes("syss")
public class SysController  extends BaseController {

	@Autowired
	protected SysService sysService;
	
	@RequestMapping(value ={"", "findAllSys"})
	public String findAllSys(Model model, Sys sys){
		model.addAttribute("syss", sysService.findAllList(sys));
		return "modules/doctr/systemList";
	}
	@RequestMapping(value={"findSys"})
	public String findSys(Model model, String sysId){
		Sys sys =new Sys();
		sys.setSysId(sysId);
		model.addAttribute("syss", sysService.findSys(sys));
		return "modules/doctr/systemList";
	}
//	ajax局部刷新
	@ResponseBody
	@RequestMapping(value={"selectSysById"})
	public String selectSysById(String sysId){
		return sysService.selectSysById(sysId);
	}
	@RequestMapping(value={"goAdd"})
	public String goAdd(){
		return "modules/doctr/systemForm";
	}
	@RequestMapping(value={"add"})
	public String save(Model model, Sys sys){
		sysService.save(sys);
		model.addAttribute("syss", sysService.findAllList(sys));
		return "modules/doctr/systemList";
	}
	@RequestMapping(value={"goUpdate"})
	public String goUpdate(Model model, String sysId){
		Sys sys = new Sys();
		sys.setSysId(sysId);
		model.addAttribute("sys",sysService.findSys(sys).get(0));
		return "modules/doctr/systemForm";
	}
	@RequestMapping(value={"update"})
	public String update(Model model, Sys sys){
		sysService.update(sys);
		model.addAttribute("syss",sysService.findAllList(sys));
		return "modules/doctr/systemList";
	}
	@RequestMapping(value={"delete"})
	public String delete(Model model, Sys sys){
		sysService.delete(sys);
		model.addAttribute("syss", sysService.findAllList(sys));
		return "modules/doctr/systemList"; 
	}
}
