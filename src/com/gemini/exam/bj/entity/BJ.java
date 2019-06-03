package com.gemini.exam.bj.entity;
/**
 * �༶ʵ����
 */
import java.util.HashSet;
import java.util.Set;

import com.gemini.exam.student.entity.Students;
import com.gemini.exam.teacheruser.entity.Teacher;

public class BJ {

	private Integer bjid;
	private String bjname;
	private Teacher teacher;
	private Set<Students> students = new HashSet<Students>();
	
	public Set<Students> getStudents() {
		return students;
	}
	public void setStudents(Set<Students> students) {
		this.students = students;
	}
	public Integer getBjid() {
		return bjid;
	}
	public void setBjid(Integer bjid) {
		this.bjid = bjid;
	}
	public String getBjname() {
		return bjname;
	}
	public void setBjname(String bjname) {
		this.bjname = bjname;
	}
	public Teacher getTeacher() {
		return teacher;
	}
	public void setTeacher(Teacher teacher) {
		this.teacher = teacher;
	}
}
