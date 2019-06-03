package com.gemini.exam.testnote.dao;

import java.util.List;

import org.springframework.orm.hibernate5.support.HibernateDaoSupport;

import com.gemini.exam.testnote.entity.TestNote;

public class TestNoteDao extends HibernateDaoSupport{
	//��ÿ��Լ�¼����
	public TestNote getTestNote(Integer tnid) {
		String hql = "from TestNote where tnid = ?";
		List<TestNote> listtn = (List<TestNote>) this.getHibernateTemplate().find(hql, tnid);
		if(listtn != null && listtn.size() > 0){
			return listtn.get(0);
		}
		return null;
	}
	//���濼�Խ���ʱ��
	public void saveTestNote(TestNote tn) {
		this.getHibernateTemplate().save(tn);
	}

}
