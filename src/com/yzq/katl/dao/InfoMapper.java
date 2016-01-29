package com.yzq.katl.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.yzq.katl.dto.DataGridModel;
import com.yzq.katl.dto.InfoDTO;

public interface InfoMapper {
	
	public abstract List<InfoDTO> selectInfoList(@Param("query")String query , @Param("dgm")DataGridModel dgm);

	public abstract Integer selectInfoListTotalCount(@Param("query")String query);
	
	public abstract void insertInfo(@Param(value="dto")InfoDTO dto);
	
	public abstract void updateInfo(@Param(value="dto")InfoDTO dto);
	
	public abstract void deleteInfo(@Param(value="ids")List<Integer> ids);
}