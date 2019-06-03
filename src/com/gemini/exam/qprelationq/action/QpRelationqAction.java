package com.gemini.exam.qprelationq.action;

import com.gemini.exam.qprelationq.entity.QpRelationq;
import com.gemini.exam.qprelationq.service.QpRelationqService;

import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;

public class QpRelationqAction extends ActionSupport implements ModelDriven<QpRelationq>{
	
	private QpRelationq qpRelationq = new QpRelationq();
	public QpRelationq getModel() {
		return qpRelationq;
	}
	
	private QpRelationqService qprqService;
	public void setQprqService(QpRelationqService qprqService) {
		this.qprqService = qprqService;
	}
}
