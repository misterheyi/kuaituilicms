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
import com.yzq.katl.dto.MysteryDTO;
import com.yzq.katl.service.MysteryService;

@Controller
@RequestMapping(value="/mystery/")
public class MysteryController {
	
	@Autowired
	private MysteryService mysteryService;
	
	@RequestMapping(value="addOrUpdate")
	@ResponseBody
	public Map<String,Object> addOrUpdate(@ModelAttribute MysteryDTO mystery){
	     return this.mysteryService.insertOrUpdate(mystery);
	}
	
	@RequestMapping(value="delete")
	@ResponseBody
	public Map<String,String> deleteMystery(@RequestParam("ids[]") List<Integer> ids){
	     return this.mysteryService.deleteMystery(ids);
	}
	
	@RequestMapping(value="toListMystery")
	public ModelAndView toListMysteryUI(){
        ModelAndView mv = new ModelAndView("listmystery");
        return mv;
	}
	
	@RequestMapping(value="popMysteryWindow")
	public ModelAndView popMysteryWindow(){
        ModelAndView mv = new ModelAndView("popMysteryWindow");
        return mv;
	}
	
	@RequestMapping(value="selectMysteryList")
	@ResponseBody
	public Map<String, Object> toListMystery(String query , DataGridModel dgm){
		Map<String, Object> moiveLists = this.mysteryService.selectMysteryList(query , dgm);
        return moiveLists;
	}
}
