package com.yzq.katl.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.yzq.katl.dto.DataGridModel;
import com.yzq.katl.dto.EssayDTO;

public interface EssayMapper {
	
	public abstract List<EssayDTO> selectEssayList(@Param("query")String query , @Param("dgm")DataGridModel dgm);

	public abstract Integer selectEssayListTotalCount(@Param("query")String query);
	
	public abstract void insertEssay(@Param(value="dto")EssayDTO dto);
	
	public abstract void updateEssay(@Param(value="dto")EssayDTO dto);
	
	public abstract void deleteEssay(@Param(value="ids")List<Integer> ids);
}