package com.gemini.exam.teacheruser.service;

import java.util.List;

import com.gemini.exam.teacheruser.entity.Teacher;
import org.springframework.transaction.annotation.Transactional;

import com.gemini.exam.teacheruser.dao.TeacherDao;

@Transactional
public class TeacherService {
	//ע��TeacherDao
	private TeacherDao teacherDao;

	public void setTeacherDao(TeacherDao teacherDao) {
		this.teacherDao = teacherDao;
	}

	public Teacher login(Teacher teacher) {
		
		return teacherDao.login(teacher);
	}

	public void updatePW(Integer tid, String npw) {
		teacherDao.updatePW(tid,npw);
	}
	//��ѯ���н�ʦ��Ϣ
	public List<Teacher> ckAllTeacher() {
		return teacherDao.ckAllTeacher();
	}
	//���ݽ�ʦ��Ų�ѯ��ʦ��Ϣ
	public Teacher ckTeacherXX(Integer tid) {
		return teacherDao.ckTeacherXX(tid);
	}
	//���ݽ�ʦ���ɾ����ʦ
	public void deleteTeacherAdmin(Integer tid) {
		teacherDao.deleteTeacherAdmin(tid);
	}
	//��ӽ�ʦ
	public void addTeacherSX(Teacher teacher) {
		teacherDao.addTeacherSX(teacher);
	}
}
