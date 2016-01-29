package com.yzq.katl.dao;

import org.apache.ibatis.annotations.Param;

import com.yzq.katl.model.Content;

public interface ContentMapper {
	
	public abstract Integer insertContent(@Param(value="content") Content content);

	public abstract void updateContent(@Param(value="content") Content content);
	
}
