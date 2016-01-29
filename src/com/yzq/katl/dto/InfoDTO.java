package com.yzq.katl.dto;

import com.yzq.katl.model.Info;

@SuppressWarnings("serial")
public class InfoDTO extends Info {

	private String htmlText;

	public String getHtmlText() {
		return htmlText;
	}

	public void setHtmlText(String htmlText) {
		this.htmlText = htmlText;
	}

}
