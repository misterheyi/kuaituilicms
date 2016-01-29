package com.yzq.katl.service;

import java.util.List;
import java.util.Map;

import com.yzq.katl.dto.DataGridModel;
import com.yzq.katl.dto.EssayDTO;

public interface EssayService {

	public abstract Map<String, Object> selectEssayList(String query , DataGridModel dgm);
	
	public abstract Map<String,Object> insertOrUpdate(EssayDTO moiveInfo);

	public abstract Map<String,String> deleteEssay(List<Integer> ids);
	
}
