package com.gemini.exam.bj.dao;

import java.util.ArrayList;
import java.util.List;

import com.gemini.exam.bj.entity.BJ;
import com.gemini.exam.student.entity.Students;
import org.springframework.orm.hibernate5.support.HibernateDaoSupport;

import com.gemini.exam.teacheruser.entity.Teacher;

public class BJDao extends HibernateDaoSupport{
	
	//����ʦ�Ų�ѯ�༶��Ϣ
	public List<BJ> ckbj(Integer tid) {
		String hql = "from BJ where tid = ?";
		List<BJ> list = (List<BJ>) this.getHibernateTemplate().find(hql, tid);
		return list;
	}
	public List<BJ> ckbjAdmin() {
		String hql = "from BJ ";
		String hql2 = null;
		Teacher teacher = null;
		List<BJ> list = (List<BJ>) this.getHibernateTemplate().find(hql, null);
		List<BJ> listbj = new ArrayList<BJ>();
		for(int i=0; i<list.size(); i++){
			hql2 = "from Teacher where tid = ?";
			List<Teacher> t = (List<Teacher>) this.getHibernateTemplate().find(hql2, list.get(i).getTeacher().getTid());
			if(t != null && t.size() >0){
				teacher = t.get(0);
			}
			BJ bj = list.get(i);
			bj.setTeacher(teacher);
			listbj.add(bj);
		}
		return listbj;
	}
	//��Ӱ༶ʱ��֤�༶�����Ƿ��ظ�
	public BJ findByName(String bjname){
		String hql = "from BJ where bjname = ?";
		List<BJ> list = (List<BJ>) this.getHibernateTemplate().find(hql, bjname);
		if(list != null && list.size()>0){
			return list.get(0);
		}
		return null;
	}
	//��Ӱ༶
	public void addbjsx(BJ bj, Integer tid) {
		String hql = "from Teacher where tid = ?";
		Teacher teacher = null;
		List<Teacher> list = (List<Teacher>) this.getHibernateTemplate().find(hql, tid); 
		if(list!=null && list.size()>0){
			teacher = list.get(0);
		}
		bj.setTeacher(teacher);
		this.getHibernateTemplate().save(bj);
	}

	public void deleteBJ(Integer bjid) {
		String hql = "from BJ where bjid = ?";
		BJ bj = null;
		List<BJ> list = (List<BJ>) this.getHibernateTemplate().find(hql, bjid);
		if(list!=null && list.size()>0){
			bj = list.get(0);
		}
		this.getHibernateTemplate().delete(bj);
	}
	//���ݰ༶id��ѯ�༶�����е�ѧ����Ϣ
	public List<Students> ckBJStudents(Integer bjid) {
		String hql = "from Students s where s.bj.bjid = ? order by s.sid desc";
		List<Students> liststu = (List<Students>) this.getHibernateTemplate().find(hql, bjid);
		if(liststu != null && liststu.size() > 0){
			return liststu;
		}
		return null;
	}
	//����ѧ��ɾ��ѧ����Ϣ
	public void deleteBJStudent(Integer sid) {
		String hql = "from Students where sid = ?";
		List<Students> liststu = (List<Students>) this.getHibernateTemplate().find(hql, sid);
		if(liststu != null && liststu.size() > 0 ){
			this.getHibernateTemplate().delete(liststu.get(0));
		}
		
	}


}
