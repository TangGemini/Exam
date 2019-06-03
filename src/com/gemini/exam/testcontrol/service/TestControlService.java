package com.gemini.exam.testcontrol.service;

import java.util.List;

import com.gemini.exam.question.entity.Question;
import com.gemini.exam.questionpaper.entity.QuestionPaper;
import com.gemini.exam.student.entity.Students;
import com.gemini.exam.testcontrol.entity.TestControl;
import org.springframework.transaction.annotation.Transactional;

import com.gemini.exam.answerstate.entity.AnswerState;
import com.gemini.exam.qprelationq.entity.QpRelationq;
import com.gemini.exam.testcontrol.dao.TestControlDao;
import com.gemini.exam.testnote.entity.TestNote;

@Transactional
public class TestControlService {
	private TestControlDao tcDao;

	public void setTcDao(TestControlDao tcDao) {
		this.tcDao = tcDao;
	}
	//�鿴�Ծ�
	public List<QuestionPaper> ckQuestionPaper() {
		return tcDao.ckQuestionPaper();
	}
	//��ӿ�����Ϣ
	public void addTestControl(TestControl testControl, Integer qpid) {
		tcDao.addTestControl(testControl,qpid);
	}
	//�򿪿���
	public void openTest() {
		tcDao.openTest();
	}
	//�رտ���
	public void closeTest() {
		tcDao.closeTest();
	}
	//�鿴������Ϣ
	public TestControl ckTestControl() {
		return tcDao.ckTestControl();
	}
	//��ѯ���Լ�¼
	public TestNote ckTestNote(Integer sid) {
		return tcDao.ckTestNote(sid);
	}
	//�����ȡ�Ծ�
	public QuestionPaper cqQuestionPaper() {
		
		return tcDao.cqQuestionPaper();
	}
	//����ѧ�Ų�ѯѧ��
	public Students ckStudents(Integer sid) {
		return tcDao.ckStudents(sid);
	}
	//���濼�Լ�¼
	public void saveTestNote(TestNote tn1) {
		tcDao.saveTestNote(tn1);
	}
	
	//�����Ծ�id��ȡ�Ծ���Ϣ
	public QuestionPaper hqQuestionPaper(Integer qpid) {
		return tcDao.hqQuestionPaper(qpid);
	}
	//�����Ծ�id��ѯѡ����
	public List<QpRelationq> ckxzQpRelationq(Integer qpid) {
		return tcDao.ckxzQpRelationq(qpid);
	}
	//�����Ծ�id��ѯ�ж���
	public List<QpRelationq> ckpdQpRelationq(Integer qpid) {
		return tcDao.ckpdQpRelationq(qpid);
	}
	//�����Ծ�id��ѯ�����
	public List<QpRelationq> cktkQpRelationq(Integer qpid) {
		return tcDao.cktkQpRelationq(qpid);
	}
	//������id��testnote���浽answerState��
	public void saveQuestionTN(QuestionPaper qp, TestNote tn2) {
		List<QpRelationq> listqpq = tcDao.getQpq(qp.getQpid());
		Question q = null;
		for(int i=0; i<listqpq.size(); i++){
			AnswerState a = new AnswerState();
			a.setTestNote(tn2);
			a.setState(3);
			q = tcDao.czQuestion(listqpq.get(i).getQuestion().getQid());
			a.setQuestion(q);
			tcDao.saveAnswerState(a);
		}
	}
}
