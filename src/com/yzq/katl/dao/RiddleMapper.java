package com.yzq.katl.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.yzq.katl.dto.DataGridModel;
import com.yzq.katl.model.Riddle;

public interface RiddleMapper {
	
	public abstract List<Riddle> selectRiddleList(@Param("query")String query , @Param("dgm")DataGridModel dgm);

	public abstract Integer selectRiddleListTotalCount(@Param("query")String query);
	
	public abstract void insertRiddle(@Param(value="dto")Riddle dto);
	
	public abstract void updateRiddle(@Param(value="dto")Riddle dto);
	
	public abstract void deleteRiddle(@Param(value="ids")List<Integer> ids);
}