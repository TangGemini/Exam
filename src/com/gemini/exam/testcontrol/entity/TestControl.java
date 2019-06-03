package com.gemini.exam.testcontrol.entity;
/**
 * ��������
 */
import java.util.Date;

import com.gemini.exam.questionpaper.entity.QuestionPaper;

public class TestControl {
	private Integer tcid;	//��������id
	private Integer state;	//����״̬0(�����ر�)/1(������)
	private Integer mode;	//���Է�ʽ2(�����ȡ�Ծ�)/3(ָ���Ծ�)
	private String tname;	//��������
	private Date tdate;		//����ʱ��
	private QuestionPaper questionPaper;
	
	public QuestionPaper getQuestionPaper() {
		return questionPaper;
	}
	public void setQuestionPaper(QuestionPaper questionPaper) {
		this.questionPaper = questionPaper;
	}
	public Integer getTcid() {
		return tcid;
	}
	public void setTcid(Integer tcid) {
		this.tcid = tcid;
	}
	public Integer getState() {
		return state;
	}
	public void setState(Integer state) {
		this.state = state;
	}
	public Integer getMode() {
		return mode;
	}
	public void setMode(Integer mode) {
		this.mode = mode;
	}
	public String getTname() {
		return tname;
	}
	public void setTname(String tname) {
		this.tname = tname;
	}
	public Date getTdate() {
		return tdate;
	}
	public void setTdate(Date tdate) {
		this.tdate = tdate;
	}
	
}
