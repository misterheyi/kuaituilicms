package com.yzq.katl.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.yzq.katl.dto.DataGridModel;
import com.yzq.katl.dto.FamousDTO;

public interface FamousMapper {
	
	public abstract List<FamousDTO> selectFamousList(@Param("query")String query , @Param("dgm")DataGridModel dgm);

	public abstract Integer selectFamousListTotalCount(@Param("query")String query);
	
	public abstract void insertFamous(@Param(value="dto")FamousDTO dto);
	
	public abstract void updateFamous(@Param(value="dto")FamousDTO dto);
	
	public abstract void deleteFamous(@Param(value="ids")List<Integer> ids);
}