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

import com.yzq.katl.dto.BaikeDTO;
import com.yzq.katl.dto.DataGridModel;
import com.yzq.katl.service.BaikeService;

@Controller
@RequestMapping(value="/baike/")
public class BaikeController {
	
	@Autowired
	private BaikeService baikeService;
	
	@RequestMapping(value="addOrUpdate")
	@ResponseBody
	public Map<String,Object> addOrUpdate(@ModelAttribute BaikeDTO baike){
	     return this.baikeService.insertOrUpdate(baike);
	}
	
	@RequestMapping(value="delete")
	@ResponseBody
	public Map<String,String> deleteMystery(@RequestParam("ids[]") List<Integer> ids){
	     return this.baikeService.deleteBaike(ids);
	}
	
	@RequestMapping(value="toListBaike")
	public ModelAndView toListMysteryUI(){
        ModelAndView mv = new ModelAndView("listbaike");
        return mv;
	}
	
	@RequestMapping(value="popBaikeWindow")
	public ModelAndView popMysteryWindow(){
        ModelAndView mv = new ModelAndView("popBaikeWindow");
        return mv;
	}
	
	@RequestMapping(value="selectBaikeList")
	@ResponseBody
	public Map<String, Object> toListMystery(String query , DataGridModel dgm){
		Map<String, Object> moiveLists = this.baikeService.selectBaikeList(query , dgm);
        return moiveLists;
	}
}
