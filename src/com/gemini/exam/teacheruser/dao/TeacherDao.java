package com.gemini.exam.teacheruser.dao;

import java.util.List;

import com.gemini.exam.teacheruser.entity.Teacher;
import org.springframework.orm.hibernate5.support.HibernateDaoSupport;

public class TeacherDao extends HibernateDaoSupport{

	public Teacher login(Teacher teacher) {

		String hql = "from Teacher where tid = ? and password = ?";
		List<Teacher> list = (List<Teacher>) this.getHibernateTemplate().find(hql, teacher.getTid(),teacher.getPassword());
		if(list != null && list.size() > 0){
			return list.get(0);
		}
		return null;
	}

	public void updatePW(Integer tid, String npw) {
		String hql = "from Teacher where tid =? ";
		Teacher teacher = null;
		List<Teacher> list = (List<Teacher>) this.getHibernateTemplate().find(hql, tid);
		if(list != null && list.size()>0){
			teacher = (Teacher)list.get(0);
		}
		teacher.setPassword(npw);
		this.getHibernateTemplate().save(teacher);
	}

	public List<Teacher> ckAllTeacher() {
		String hql = "from Teacher";
		List<Teacher> list = (List<Teacher>) this.getHibernateTemplate().find(hql, null);
		return list;
	}
	//����
	public Teacher ckTeacherXX(Integer tid) {
		String hql = "from Teacher where tid = ?";
		List<Teacher> list = (List<Teacher>) this.getHibernateTemplate().find(hql, tid);
		if(list != null && list.size() > 0){
			return list.get(0);
		}
		return null;
	}
	//���ݽ�ʦ���ɾ����ʦ
	public void deleteTeacherAdmin(Integer tid) {
		String hql = "from Teacher where tid = ?";
		List<Teacher> list = (List<Teacher>) this.getHibernateTemplate().find(hql, tid);
		if(list != null && list.size() > 0){
			this.getHibernateTemplate().delete(list.get(0));
		}
	}

	public void addTeacherSX(Teacher teacher) {
		this.getHibernateTemplate().save(teacher);
	}

	




}
