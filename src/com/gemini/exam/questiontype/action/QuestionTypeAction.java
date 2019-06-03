package com.gemini.exam.questiontype.action;

import com.gemini.exam.questiontype.service.QuestionTypeService;
import com.gemini.exam.questiontype.entity.QuestionType;

import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;

public class QuestionTypeAction extends ActionSupport implements ModelDriven<QuestionType>{
	
	private QuestionType questionType = new QuestionType();
	public QuestionType getModel() {
		return questionType;
	}
	
	private QuestionTypeService qtService;
	public void setQtService(QuestionTypeService qtService) {
		this.qtService = qtService;
	}

}
