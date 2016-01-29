package com.yzq.katl.service.impl;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.yzq.katl.dao.ContentMapper;
import com.yzq.katl.dao.MysteryMapper;
import com.yzq.katl.dto.DataGridModel;
import com.yzq.katl.dto.MysteryDTO;
import com.yzq.katl.model.Content;
import com.yzq.katl.service.MysteryService;

@Service("mysteryService")
public class MysteryServiceImpl implements MysteryService {

	@Autowired
	private MysteryMapper mysteryMapper;
	@Autowired
	private ContentMapper contentMapper;

	public Map<String, Object> selectMysteryList(String query, DataGridModel dgm) {
		Map<String, Object> obj = new HashMap<String, Object>();
		Integer total = this.mysteryMapper.selectMysteryListTotalCount(query);
		List<MysteryDTO> list = mysteryMapper.selectMysteryList(query, dgm);
		obj.put("total", total);
		obj.put("rows", list);
		return obj;
	}

	public Map<String,Object> insertOrUpdate(MysteryDTO essay) {
		Map<String,Object> map = new HashMap<String,Object>();
		try {
			//添加
			if (essay.getId() == null) {
				//先插入html内容
				Content content = new Content();
				content.setHtmlText(essay.getHtmlText());
				this.contentMapper.insertContent(content);
				essay.setSeoId(0);
				essay.setClickTimes(0);
				essay.setContentId(content.getId());
				essay.setStatus(0);
				essay.setSort(0);
				essay.setIsDeleted(0);
				essay.setCreateTime(new Date());
				this.mysteryMapper.insertMystery(essay);
				map.put("code", "000000");
				map.put("mes", "成功");
				
			}
			//插入
			if(essay.getId() != null){
				Content content = new Content();
				content.setHtmlText(essay.getHtmlText());
				content.setId(essay.getContentId());;
				this.contentMapper.updateContent(content);
				essay.setUpdateTime(new Date());
				this.mysteryMapper.updateMystery(essay);
				map.put("code", "000000");
				map.put("mes", "成功");
			}
		} catch (Exception e) {
			e.printStackTrace();
			map.put("code", "000000");
			map.put("mes", "失败");
		}
		return map;
	}

	public Map<String, String> deleteMystery(List<Integer> ids) {
		Map<String, String> map = new HashMap<String, String>();
		try{
			this.mysteryMapper.deleteMystery(ids);
			map.put("code", "000000");
			map.put("mes", "成功");
		}catch(Exception e){
			map.put("code", "111111");
			map.put("mes", "失败");
		}
		
		return map;
	}

}
