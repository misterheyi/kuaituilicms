package com.yzq.katl.service;

import java.util.List;
import java.util.Map;

import com.yzq.katl.dto.DataGridModel;
import com.yzq.katl.dto.InfoDTO;

public interface InfoService {

	public abstract Map<String, Object> selectInfoList(String query , DataGridModel dgm);
	
	public abstract Map<String,Object> insertOrUpdate(InfoDTO mysteryDto);

	public abstract Map<String,String> deleteInfo(List<Integer> ids);
	
}
