package com.gemini.exam.answerstate.action;

import java.io.IOException;

import com.gemini.exam.answerstate.service.AnswerStateService;

import com.gemini.exam.answerstate.entity.AnswerState;

import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;

public class AnswerStateAction extends ActionSupport implements ModelDriven<AnswerState>{
	private AnswerState answerState = new AnswerState();
	public AnswerState getModel() {
		return answerState;
	}
	private AnswerStateService asService;
	public void setAsService(AnswerStateService asService) {
		this.asService = asService;
	}
	private Integer qid;
	
	public void setQid(Integer qid) {
		this.qid = qid;
	}
	private Integer tnid;

	public void setTnid(Integer tnid) {
		this.tnid = tnid;
	}
	private String qanswer;

	public void setQanswer(String qanswer) {
		this.qanswer = qanswer;
	}
	//���������ţ���¼��� ���н�����𰸱���
	public String saveAnswerState() throws IOException{
		String qas = java.net.URLDecoder.decode(qanswer, "UTF-8");
		asService.saveAnswerState(tnid,qid,qas);
		return NONE;
	}

}
