package com.yzq.katl.dto;

import com.yzq.katl.model.Baike;

@SuppressWarnings("serial")
public class BaikeDTO extends Baike {

	private String htmlText;

	public String getHtmlText() {
		return htmlText;
	}

	public void setHtmlText(String htmlText) {
		this.htmlText = htmlText;
	}

}
