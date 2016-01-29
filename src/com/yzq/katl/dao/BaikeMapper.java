package com.yzq.katl.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.yzq.katl.dto.BaikeDTO;
import com.yzq.katl.dto.DataGridModel;

public interface BaikeMapper {
	
	public abstract List<BaikeDTO> selectBaikeList(@Param("query")String query , @Param("dgm")DataGridModel dgm);

	public abstract Integer selectBaikeListTotalCount(@Param("query")String query);
	
	public abstract void insertBaike(@Param(value="dto")BaikeDTO dto);
	
	public abstract void updateBaike(@Param(value="dto")BaikeDTO dto);
	
	public abstract void deleteBaike(@Param(value="ids")List<Integer> ids);
}