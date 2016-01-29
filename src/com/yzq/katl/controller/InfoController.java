package com.yzq.katl.controller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.yzq.katl.dto.DataGridModel;
import com.yzq.katl.dto.InfoDTO;
import com.yzq.katl.service.InfoService;

@Controller
@RequestMapping(value="/info/")
public class InfoController {
	
	@Autowired
	private InfoService infoService;
	
	@RequestMapping(value="addOrUpdate")
	@ResponseBody
	public Map<String,Object> addOrUpdate(@ModelAttribute InfoDTO info){
	     return this.infoService.insertOrUpdate(info);
	}
	
	@RequestMapping(value="delete")
	@ResponseBody
	public Map<String,String> deleteInfo(@RequestParam("ids[]") List<Integer> ids){
	     return this.infoService.deleteInfo(ids);
	}
	
	@RequestMapping(value="toListInfo")
	public ModelAndView toListInfoUI(){
        ModelAndView mv = new ModelAndView("listinfo");
        return mv;
	}
	
	@RequestMapping(value="popInfoWindow")
	public ModelAndView popInfoWindow(){
        ModelAndView mv = new ModelAndView("popInfoWindow");
        return mv;
	}
	
	@RequestMapping(value="selectInfoList")
	@ResponseBody
	public Map<String, Object> toListInfo(String query , DataGridModel dgm){
		Map<String, Object> moiveLists = this.infoService.selectInfoList(query , dgm);
        return moiveLists;
	}
}
