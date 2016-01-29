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
import com.yzq.katl.model.Riddle;
import com.yzq.katl.service.RiddleService;

@Controller
@RequestMapping(value="/riddle/")
public class RiddleController {
	
	@Autowired
	private RiddleService riddleService;
	
	@RequestMapping(value="addOrUpdate")
	@ResponseBody
	public Map<String,Object> addOrUpdate(@ModelAttribute Riddle riddle){
	     return this.riddleService.insertOrUpdate(riddle);
	}
	
	@RequestMapping(value="delete")
	@ResponseBody
	public Map<String,String> deleteRiddle(@RequestParam("ids[]") List<Integer> ids){
	     return this.riddleService.deleteRiddle(ids);
	}
	
	@RequestMapping(value="toListRiddle")
	public ModelAndView toListMoiveUI(){
        ModelAndView mv = new ModelAndView("listriddle");
        return mv;
	}
	
	@RequestMapping(value="popRiddleWindow")
	public ModelAndView popEssayWindow(){
        ModelAndView mv = new ModelAndView("popRiddleWindow");
        return mv;
	}
	
	@RequestMapping(value="selectRiddleList")
	@ResponseBody
	public Map<String, Object> toListMoive(String query , DataGridModel dgm){
		Map<String, Object> moiveLists = this.riddleService.selectRiddleList(query , dgm);
        return moiveLists;
	}
}
