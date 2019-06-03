package com.gemini.exam.student.service;

import java.util.List;

import org.springframework.transaction.annotation.Transactional;

import com.gemini.exam.answerstate.entity.AnswerState;
import com.gemini.exam.bj.entity.BJ;
import com.gemini.exam.student.dao.StudentDao;
import com.gemini.exam.student.entity.Students;
import com.gemini.exam.testnote.entity.TestNote;
import com.gemini.exam.utils.PageBean;

@Transactional
public class StudentService {
	private StudentDao studentDao;

	public void setStudentDao(StudentDao studentDao) {
		this.studentDao = studentDao;
	}
	
	//���ݽ�ʦ��Ų�ѯ���ڸý�ʦ��ѧ��
	public PageBean<Students> ckStudent(Integer tid, int page) {
		PageBean<Students> pageBean = new PageBean<Students>();
		//���õ�ǰҳ��
		pageBean.setPage(page);
		//����ÿҳ��ʾ�ļ�¼��
		int limit = 3;
		pageBean.setLimit(limit);
		//�����ܵļ�¼��
		int totalCount = 0;
		totalCount = studentDao.findCountTid(tid);
		pageBean.setTotalCount(totalCount);
		//�����ܵ�ҳ��
		int totalPage = 0;
		if(totalCount % limit == 0 ){
			totalPage = totalCount / limit;
		}else{
			totalPage = totalCount / limit +1;
		}
		pageBean.setTotalPage(totalPage);
		//ÿҳ��ʾ�����ݼ���
		//��������¼��ʼ
		int begin = (page - 1) * limit;
		List<Students> list = studentDao.findByPageTid(tid,begin,limit);
		pageBean.setList(list);
		return pageBean;
	}
	public PageBean<Students> ckStudentAdmin(int page) {
		PageBean<Students> pageBean = new PageBean<Students>();
		//���õ�ǰҳ��
		pageBean.setPage(page);
		//����ÿҳ��ʾ�ļ�¼��
		int limit = 3;
		pageBean.setLimit(limit);
		//�����ܵļ�¼��
		int totalCount = 0;
		totalCount = studentDao.findCountAdmin();
		pageBean.setTotalCount(totalCount);
		//�����ܵ�ҳ��
		int totalPage = 0;
		if(totalCount % limit == 0 ){
			totalPage = totalCount / limit;
		}else{
			totalPage = totalCount / limit +1;
		}
		pageBean.setTotalPage(totalPage);
		//ÿҳ��ʾ�����ݼ���
		//��������¼��ʼ
		int begin = (page - 1) * limit;
		List<Students> list = studentDao.findByPageAdmin(begin,limit);
		pageBean.setList(list);
		return pageBean;
	}
	public List<BJ> ckbj(Integer tid) {
		
		return studentDao.ckbj(tid);
	}
	public List<BJ> ckbjAdmin() {
		return studentDao.ckbjAdmin();
	}
	//����ѧ�Ų�ѯѧ���Ƿ����
	public Students findBySid(Integer sid) {
		return studentDao.finBySid(sid);
	}
	//���ѧ����Ϣʵ��
	public void addStudentSX(Students student, Integer bjid) {
		studentDao.addStudentSX(student,bjid);	
	}
	//�޸�����ʵ��
	public void updatePW(Integer sid, String npw) {
		studentDao.updatePW(sid,npw);
	}
	//����ѧ��ɾ��ѧ����Ϣ
	public void deleteStudent(Integer sid) {
		studentDao.deleteStudent(sid);
	}
	
	//����ѧ�Ų�ѯ���Լ�¼
	public List<TestNote> ckTestNote(Integer sid) {
		return studentDao.ckTestNote(sid);
	}
	//���ݿ��Լ�¼id��ѯѡ����������
	public List<AnswerState> ckAnswerStatexz(Integer tnid) {
		return studentDao.ckAnserStatexz(tnid);
	}
	//���ݿ��Լ�¼id��ѯ�ж���������
	public List<AnswerState> ckAnswerStatepd(Integer tnid) {
		return studentDao.ckAnserStatepd(tnid);
	}
	//���ݿ��Լ�¼id��ѯ�����������
	public List<AnswerState> ckAnswerStatetk(Integer tnid) {
		return studentDao.ckAnserStatetk(tnid);
	}

	public Students login(Students student) {
		return studentDao.login(student);
	}
	//����ѧ�Ų�ѯѧ����Ϣ
	public Students cxStudent(Integer sid) {
		return studentDao.ckStudent(sid);
	}
	
	//����ѧ����Ϣʵ��
	public void wsStudentSX(Students student) {
		studentDao.wsStudentSX(student);
	}
	//��ѯѧ����Ϣ
	public BJ myBJ(Integer sid) {
		return studentDao.myBJ(sid);
	}
	//����ѧ�Ų�ѯѧ����Ϣ
	public Students ckStudentXX(Integer sid) {
		return studentDao.ckStudentXX(sid);
	}
	
}
