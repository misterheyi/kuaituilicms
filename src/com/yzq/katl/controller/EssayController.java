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
import com.yzq.katl.dto.EssayDTO;
import com.yzq.katl.service.EssayService;

@Controller
@RequestMapping(value="/essay/")
public class EssayController {
	
	@Autowired
	private EssayService essayService;
	
	@RequestMapping(value="addOrUpdate")
	@ResponseBody
	public Map<String,Object> addOrUpdate(@ModelAttribute EssayDTO moiveInfo){
	     return this.essayService.insertOrUpdate(moiveInfo);
	}
	
	@RequestMapping(value="delete")
	@ResponseBody
	public Map<String,String> deleteEssay(@RequestParam("ids[]") List<Integer> ids){
	     return this.essayService.deleteEssay(ids);
	}
	
	@RequestMapping(value="toListEssay")
	public ModelAndView toListMoiveUI(){
        ModelAndView mv = new ModelAndView("listessay");
        return mv;
	}
	
	@RequestMapping(value="popEssayWindow")
	public ModelAndView popEssayWindow(){
        ModelAndView mv = new ModelAndView("popEssayWindow");
        return mv;
	}
	
	@RequestMapping(value="selectEssayList")
	@ResponseBody
	public Map<String, Object> toListMoive(String query , DataGridModel dgm){
		Map<String, Object> moiveLists = this.essayService.selectEssayList(query , dgm);
        return moiveLists;
	}
}
