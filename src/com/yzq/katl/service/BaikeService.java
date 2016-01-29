package com.yzq.katl.service;

import java.util.List;
import java.util.Map;

import com.yzq.katl.dto.BaikeDTO;
import com.yzq.katl.dto.DataGridModel;

public interface BaikeService {

	public abstract Map<String, Object> selectBaikeList(String query , DataGridModel dgm);
	
	public abstract Map<String,Object> insertOrUpdate(BaikeDTO mysteryDto);

	public abstract Map<String,String> deleteBaike(List<Integer> ids);
	
}
