package com.yzq.katl.dto;

import com.yzq.katl.model.Mystery;

@SuppressWarnings("serial")
public class MysteryDTO extends Mystery {

	private String htmlText;

	public String getHtmlText() {
		return htmlText;
	}

	public void setHtmlText(String htmlText) {
		this.htmlText = htmlText;
	}

}
