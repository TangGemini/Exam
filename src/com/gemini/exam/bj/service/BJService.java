package com.gemini.exam.bj.service;

import java.util.List;

import com.gemini.exam.bj.entity.BJ;
import com.gemini.exam.student.entity.Students;
import org.springframework.transaction.annotation.Transactional;

import com.gemini.exam.bj.dao.BJDao;

@Transactional
public class BJService {
	private BJDao bjDao;

	public void setBjDao(BJDao bjDao) {
		this.bjDao = bjDao;
	}

	public List<BJ> ckbj(Integer tid) {
		List<BJ> list = bjDao.ckbj(tid);
		return list;
	}
	public List<BJ> ckbjAdmin() {
		List<BJ> list = bjDao.ckbjAdmin();
		return list;
	}
	//���༶����ѯ�༶�ķ���
	public BJ findByName(String bjname){
		return bjDao.findByName(bjname);
	}
	//��Ӱ༶��Ϣ
	public void addbjsx(BJ bj, Integer tid) {
		bjDao.addbjsx(bj,tid);
	}
	
	//���ݰ༶idɾ���༶
	public void deleteBJ(Integer bjid) {
		bjDao.deleteBJ(bjid);
	}
	//���ݰ༶id��ѯ�ð༶�����е�ѧ��
	public List<Students> ckBJStudents(Integer bjid) {
		return bjDao.ckBJStudents(bjid);
	}
	//����ѧ��ɾ��ѧ����Ϣ
	public void deleteBJStudent(Integer sid) {
		bjDao.deleteBJStudent(sid);
	}

	
	
}
