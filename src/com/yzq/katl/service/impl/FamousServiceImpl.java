package com.yzq.katl.service.impl;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.yzq.katl.dao.ContentMapper;
import com.yzq.katl.dao.FamousMapper;
import com.yzq.katl.dto.DataGridModel;
import com.yzq.katl.dto.FamousDTO;
import com.yzq.katl.model.Content;
import com.yzq.katl.service.FamousService;

@Service("famousService")
public class FamousServiceImpl implements FamousService {

	@Autowired
	private FamousMapper famousMapper;
	@Autowired
	private ContentMapper contentMapper;

	public Map<String, Object> selectFamousList(String query, DataGridModel dgm) {
		Map<String, Object> obj = new HashMap<String, Object>();
		Integer total = this.famousMapper.selectFamousListTotalCount(query);
		List<FamousDTO> list = famousMapper.selectFamousList(query, dgm);
		obj.put("total", total);
		obj.put("rows", list);
		return obj;
	}

	public Map<String,Object> insertOrUpdate(FamousDTO famous) {
		Map<String,Object> map = new HashMap<String,Object>();
		try {
			//添加
			if (famous.getId() == null) {
				//先插入html内容
				Content brief = new Content();
				brief.setHtmlText(famous.getBrief());
				this.contentMapper.insertContent(brief);
				//先插入html内容
				Content basic = new Content();
				basic.setHtmlText(famous.getBasic());
				this.contentMapper.insertContent(basic);
				famous.setSeoId(0);
				famous.setClickTimes(0);
				famous.setBriefId(brief.getId());
				famous.setBasicId(basic.getId());
				famous.setStatus(0);
				famous.setSort(0);
				famous.setIsDeleted(0);
				famous.setCreateTime(new Date());
				this.famousMapper.insertFamous(famous);
				map.put("code", "000000");
				map.put("mes", "成功");
				
			}
			//更新
			if(famous.getId() != null){
				Content brief = new Content();
				brief.setHtmlText(famous.getBrief());
				brief.setId(famous.getBriefId());
				this.contentMapper.updateContent(brief);
				Content basic = new Content();
				basic.setHtmlText(famous.getBasic());
				basic.setId(famous.getBasicId());
				this.contentMapper.updateContent(basic);
				famous.setUpdateTime(new Date());
				this.famousMapper.updateFamous(famous);
				map.put("code", "000000");
				map.put("mes", "成功");
			}
		} catch (Exception e) {
			map.put("code", "000000");
			map.put("mes", "失败");
			e.printStackTrace();
		}
		return map;
	}

	public Map<String, String> deleteFamous(List<Integer> ids) {
		Map<String, String> map = new HashMap<String, String>();
		try{
			this.famousMapper.deleteFamous(ids);
			map.put("code", "000000");
			map.put("mes", "成功");
		}catch(Exception e){
			map.put("code", "111111");
			map.put("mes", "失败");
		}
		
		return map;
	}

}
