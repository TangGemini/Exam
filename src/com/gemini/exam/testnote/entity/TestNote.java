package com.gemini.exam.testnote.entity;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import com.gemini.exam.answerstate.entity.AnswerState;
import com.gemini.exam.questionpaper.entity.QuestionPaper;
import com.gemini.exam.student.entity.Students;

public class TestNote {
	private Integer tnid;	//���Լ�¼id
	private String tname;	//��������
	private Date tdate;		//��������
	private Date stime;		//��ʼ����ʱ��
	private Date etime;		//����ʱ��
	private Integer score;	//���Գɼ�
	private Students students;
	private QuestionPaper questionPaper;
	private Set<AnswerState> answerState = new HashSet<AnswerState>();
	
	public Set<AnswerState> getAnswerState() {
		return answerState;
	}
	public void setAnswerState(Set<AnswerState> answerState) {
		this.answerState = answerState;
	}
	public Integer getTnid() {
		return tnid;
	}
	public void setTnid(Integer tnid) {
		this.tnid = tnid;
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
	public Date getStime() {
		return stime;
	}
	public void setStime(Date stime) {
		this.stime = stime;
	}
	public Date getEtime() {
		return etime;
	}
	public void setEtime(Date etime) {
		this.etime = etime;
	}
	public Integer getScore() {
		return score;
	}
	public void setScore(Integer score) {
		this.score = score;
	}
	public Students getStudents() {
		return students;
	}
	public void setStudents(Students students) {
		this.students = students;
	}
	public QuestionPaper getQuestionPaper() {
		return questionPaper;
	}
	public void setQuestionPaper(QuestionPaper questionPaper) {
		this.questionPaper = questionPaper;
	}
}
