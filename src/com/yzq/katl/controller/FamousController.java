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
import com.yzq.katl.dto.FamousDTO;
import com.yzq.katl.service.FamousService;
import com.yzq.katl.util.ImageUtil;
import com.yzq.katl.util.ResourceLoader;

@Controller
@RequestMapping(value="/famous/")
public class FamousController {
	
	@Autowired
	private FamousService famousService;
	
	@RequestMapping(value="addOrUpdate")
	@ResponseBody
	public Map<String,Object> addOrUpdate(@ModelAttribute FamousDTO moiveInfo){
	     return this.famousService.insertOrUpdate(moiveInfo);
	}
	
	@RequestMapping(value="delete")
	@ResponseBody
	public Map<String,String> deleteFamous(@RequestParam("ids[]") List<Integer> ids){
	     return this.famousService.deleteFamous(ids);
	}
	
	@RequestMapping(value="toListFamous")
	public ModelAndView toListFamousUI(){
        ModelAndView mv = new ModelAndView("listfamous");
        return mv;
	}
	
	@RequestMapping(value="popFamousWindow")
	public ModelAndView popFamousWindow(){
        ModelAndView mv = new ModelAndView("popFamousWindow");
        return mv;
	}
	
	@RequestMapping(value="loadFamousImage")
	@ResponseBody
	public String loadImage(String url){
		String savePath = ResourceLoader.loadResource("file.path");
		String basePath = ImageUtil.download(url , savePath);
		return basePath;
	}
	
	@RequestMapping(value="selectFamousList")
	@ResponseBody
	public Map<String, Object> toListFamous(String query , DataGridModel dgm){
		Map<String, Object> moiveLists = this.famousService.selectFamousList(query , dgm);
        return moiveLists;
	}
}
