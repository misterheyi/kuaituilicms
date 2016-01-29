package com.yzq.katl.service;

import java.util.List;
import java.util.Map;

import com.yzq.katl.dto.DataGridModel;
import com.yzq.katl.dto.FamousDTO;

public interface FamousService {

	public abstract Map<String, Object> selectFamousList(String query , DataGridModel dgm);
	
	public abstract Map<String,Object> insertOrUpdate(FamousDTO moiveInfo);

	public abstract Map<String,String> deleteFamous(List<Integer> ids);
	
}
