package com.yzq.katl.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.yzq.katl.util.ImageUtil;
import com.yzq.katl.util.ResourceLoader;

@Controller
@RequestMapping(value="/common/")
public class CommonController {

	@RequestMapping(value="loadImage")
	@ResponseBody
	public String loadImage(String url){
		String savePath = ResourceLoader.loadResource("file.path");
		String basePath = ImageUtil.download(url , savePath);
		return basePath;
	}
	
}
