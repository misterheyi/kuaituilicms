package com.yzq.katl.service.impl;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.yzq.katl.dao.RiddleMapper;
import com.yzq.katl.dto.DataGridModel;
import com.yzq.katl.model.Riddle;
import com.yzq.katl.service.RiddleService;

@Service("riddleService")
public class RiddleServiceImpl implements RiddleService {

	@Autowired
	private RiddleMapper riddleMapper;

	public Map<String, Object> selectRiddleList(String query, DataGridModel dgm) {
		Map<String, Object> obj = new HashMap<String, Object>();
		Integer total = this.riddleMapper.selectRiddleListTotalCount(query);
		List<Riddle> list = riddleMapper.selectRiddleList(query, dgm);
		obj.put("total", total);
		obj.put("rows", list);
		return obj;
	}

	public Map<String,Object> insertOrUpdate(Riddle riddle) {
		Map<String,Object> map = new HashMap<String,Object>();
		try {
			//添加
			if (riddle.getId() == null) {
				riddle.setCreateTime(new Date());
				this.riddleMapper.insertRiddle(riddle);
				map.put("code", "000000");
				map.put("mes", "成功");
			}
			//插入
			if(riddle.getId() != null){
				riddle.setUpdateTime(new Date());
				this.riddleMapper.updateRiddle(riddle);
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

	public Map<String, String> deleteRiddle(List<Integer> ids) {
		Map<String, String> map = new HashMap<String, String>();
		try{
			this.riddleMapper.deleteRiddle(ids);
			map.put("code", "000000");
			map.put("mes", "成功");
		}catch(Exception e){
			map.put("code", "111111");
			map.put("mes", "失败");
		}
		
		return map;
	}

}
