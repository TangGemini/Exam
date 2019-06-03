package com.gemini.exam.questionpaper.entity;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import com.gemini.exam.qprelationq.entity.QpRelationq;
import com.gemini.exam.teacheruser.entity.Teacher;
import com.gemini.exam.testcontrol.entity.TestControl;
import com.gemini.exam.testnote.entity.TestNote;

public class QuestionPaper {
	private Integer qpid;	//�Ծ�id
	private Date qpdate;	//����ʱ��
	private Integer time;	//����ʱ��
	private Teacher teacher; 
	//�����Ծ��������ϵ�ļ���
	private Set<QpRelationq> qpRelationq = new HashSet<QpRelationq> ();
	private Set<TestControl> testControl = new HashSet<TestControl>();
	private Set<TestNote> testNote = new HashSet<TestNote>();
	
	public Set<TestNote> getTestNote() {
		return testNote;
	}
	public void setTestNote(Set<TestNote> testNote) {
		this.testNote = testNote;
	}
	public Set<TestControl> getTestControl() {
		return testControl;
	}
	public void setTestControl(Set<TestControl> testControl) {
		this.testControl = testControl;
	}
	public Teacher getTeacher() {
		return teacher;
	}
	public void setTeacher(Teacher teacher) {
		this.teacher = teacher;
	}
	
	public Integer getQpid() {
		return qpid;
	}
	public void setQpid(Integer qpid) {
		this.qpid = qpid;
	}
	public Date getQpdate() {
		return qpdate;
	}
	public void setQpdate(Date qpdate) {
		this.qpdate = qpdate;
	}
	public Integer getTime() {
		return time;
	}
	public void setTime(Integer time) {
		this.time = time;
	}
	
	public Set<QpRelationq> getQpRelationq() {
		return qpRelationq;
	}
	public void setQpRelationq(Set<QpRelationq> qpRelationq) {
		this.qpRelationq = qpRelationq;
	}
	
}
