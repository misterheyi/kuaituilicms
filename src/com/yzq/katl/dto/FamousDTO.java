package com.yzq.katl.dto;

import com.yzq.katl.model.Famous;

public class FamousDTO extends Famous {

	private String brief;

	private String basic;

	public String getBrief() {
		return brief;
	}

	public void setBrief(String brief) {
		this.brief = brief;
	}

	public String getBasic() {
		return basic;
	}

	public void setBasic(String basic) {
		this.basic = basic;
	}

}
