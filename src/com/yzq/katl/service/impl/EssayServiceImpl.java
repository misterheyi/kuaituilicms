package com.yzq.katl.service.impl;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.yzq.katl.dao.ContentMapper;
import com.yzq.katl.dao.EssayMapper;
import com.yzq.katl.dto.DataGridModel;
import com.yzq.katl.dto.EssayDTO;
import com.yzq.katl.model.Content;
import com.yzq.katl.service.EssayService;

@Service("essayService")
public class EssayServiceImpl implements EssayService {

	@Autowired
	private EssayMapper essayMapper;
	@Autowired
	private ContentMapper contentMapper;

	public Map<String, Object> selectEssayList(String query, DataGridModel dgm) {
		Map<String, Object> obj = new HashMap<String, Object>();
		Integer total = this.essayMapper.selectEssayListTotalCount(query);
		List<EssayDTO> list = essayMapper.selectEssayList(query, dgm);
		obj.put("total", total);
		obj.put("rows", list);
		return obj;
	}

	public Map<String,Object> insertOrUpdate(EssayDTO essay) {
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
				this.essayMapper.insertEssay(essay);
				map.put("code", "000000");
				map.put("mes", "添加成功");
				
			}
			//插入
			if(essay.getId() != null){
				Content content = new Content();
				content.setHtmlText(essay.getHtmlText());
				content.setId(essay.getContentId());;
				this.contentMapper.updateContent(content);
				essay.setUpdateTime(new Date());
				this.essayMapper.updateEssay(essay);
				map.put("code", "000000");
				map.put("mes", "更新成功");
			}
		} catch (Exception e) {
			map.put("code", "000000");
			map.put("mes", "失败");
			e.printStackTrace();
		}
		return map;
	}

	public Map<String, String> deleteEssay(List<Integer> ids) {
		Map<String, String> map = new HashMap<String, String>();
		try{
			this.essayMapper.deleteEssay(ids);
			map.put("code", "000000");
			map.put("mes", "成功");
		}catch(Exception e){
			map.put("code", "111111");
			map.put("mes", "失败");
		}
		
		return map;
	}

}
