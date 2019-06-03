package com.gemini.exam.questiontype.entity;

import java.util.HashSet;
import java.util.Set;

import com.gemini.exam.question.entity.Question;

public class QuestionType {
	private Integer qtid;    //��������id
	private String qtname;	 //������������
	private Integer score;	 //�������ͷ���
	private Set<Question> questions = new HashSet<Question>();
	
	public Set<Question> getQuestions() {
		return questions;
	}
	public void setQuestions(Set<Question> questions) {
		this.questions = questions;
	}
	public Integer getQtid() {
		return qtid;
	}
	public void setQtid(Integer qtid) {
		this.qtid = qtid;
	}
	public String getQtname() {
		return qtname;
	}
	public void setQtname(String qtname) {
		this.qtname = qtname;
	}
	public Integer getScore() {
		return score;
	}
	public void setScore(Integer score) {
		this.score = score;
	}
}
