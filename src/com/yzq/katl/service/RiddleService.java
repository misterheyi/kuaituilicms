package com.yzq.katl.service;

import java.util.List;
import java.util.Map;

import com.yzq.katl.dto.DataGridModel;
import com.yzq.katl.model.Riddle;

public interface RiddleService {

	public abstract Map<String, Object> selectRiddleList(String query , DataGridModel dgm);
	
	public abstract Map<String,Object> insertOrUpdate(Riddle moiveInfo);

	public abstract Map<String,String> deleteRiddle(List<Integer> ids);
	
}
