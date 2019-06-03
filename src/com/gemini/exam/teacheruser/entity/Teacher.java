package com.gemini.exam.teacheruser.entity;

import java.util.HashSet;
import java.util.Set;

import com.gemini.exam.bj.entity.BJ;
import com.gemini.exam.question.entity.Question;

/**
 * ��ʦʵ����
 * @author xxn
 *
 */
public class Teacher {
	private Integer tid;		//��ʦ���
	private String password;	//����
	private String tname;		//��ʦ����	
	private String phone;		//��ʦ�绰
	private String email;		//����
	private Set<BJ> bjs = new HashSet<BJ>();
	private Set<Question> questions = new HashSet<Question>();
	
	public Set<Question> getQuestions() {
		return questions;
	}
	public void setQuestions(Set<Question> questions) {
		this.questions = questions;
	}
	public Set<BJ> getBjs() {
		return bjs;
	}
	public void setBjs(Set<BJ> bjs) {
		this.bjs = bjs;
	}
	public Integer getTid() {
		return tid;
	}
	public void setTid(Integer tid) {
		this.tid = tid;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getTname() {
		return tname;
	}
	public void setTname(String tname) {
		this.tname = tname;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	
}
