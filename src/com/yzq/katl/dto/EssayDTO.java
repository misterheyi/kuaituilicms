package com.yzq.katl.dto;

import com.yzq.katl.model.Essay;

@SuppressWarnings("serial")
public class EssayDTO extends Essay {

	private String htmlText;

	public String getHtmlText() {
		return htmlText;
	}

	public void setHtmlText(String htmlText) {
		this.htmlText = htmlText;
	}

}
