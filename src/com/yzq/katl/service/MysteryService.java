package com.yzq.katl.service;

import java.util.List;
import java.util.Map;

import com.yzq.katl.dto.DataGridModel;
import com.yzq.katl.dto.MysteryDTO;

public interface MysteryService {

	public abstract Map<String, Object> selectMysteryList(String query , DataGridModel dgm);
	
	public abstract Map<String,Object> insertOrUpdate(MysteryDTO mysteryDto);

	public abstract Map<String,String> deleteMystery(List<Integer> ids);
	
}
