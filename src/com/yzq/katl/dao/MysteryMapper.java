package com.yzq.katl.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.yzq.katl.dto.DataGridModel;
import com.yzq.katl.dto.MysteryDTO;

public interface MysteryMapper {
	
	public abstract List<MysteryDTO> selectMysteryList(@Param("query")String query , @Param("dgm")DataGridModel dgm);

	public abstract Integer selectMysteryListTotalCount(@Param("query")String query);
	
	public abstract void insertMystery(@Param(value="dto")MysteryDTO dto);
	
	public abstract void updateMystery(@Param(value="dto")MysteryDTO dto);
	
	public abstract void deleteMystery(@Param(value="ids")List<Integer> ids);
}