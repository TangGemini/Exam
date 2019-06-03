package com.gemini.exam.testcontrol.dao;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import com.gemini.exam.question.entity.Question;
import com.gemini.exam.questionpaper.entity.QuestionPaper;
import com.gemini.exam.student.entity.Students;
import com.gemini.exam.testcontrol.entity.TestControl;
import org.springframework.orm.hibernate5.support.HibernateDaoSupport;

import com.gemini.exam.answerstate.entity.AnswerState;
import com.gemini.exam.qprelationq.entity.QpRelationq;
import com.gemini.exam.testnote.entity.TestNote;

public class TestControlDao extends HibernateDaoSupport {
	
	//��ѯ�����Ծ�
	public List<QuestionPaper> ckQuestionPaper() {
		String hql = "from QuestionPaper";
		List<QuestionPaper> list = (List<QuestionPaper>) this.getHibernateTemplate().find(hql, null);
		if(list != null && list.size() > 0 ){
			return list;
		}
		return null;
	}
	//��ӿ�����Ϣ
	public void addTestControl(TestControl testControl, Integer qpid) {
		String hql = "from QuestionPaper where qpid = ?";
		//�����Ծ�id��ѯ�Ծ���Ϣ
		List<QuestionPaper> list = (List<QuestionPaper>) this.getHibernateTemplate().find(hql, qpid);
		if(list != null && list.size() > 0){
			//�����ָ���Ծ��Է�ʽ���Ծ���Ϣ��ӵ��������ƶ�����
			testControl.setQuestionPaper(list.get(0));
		}
		//���濼�����ƶ���
		this.getHibernateTemplate().save(testControl);
	}
	//�򿪿���
	public void openTest() {
		String hql = "from TestControl tc order by tc.tdate desc";
		List<TestControl> list = (List<TestControl>) this.getHibernateTemplate().find(hql, null);
		if(list != null && list.size() > 0){
			TestControl tc = list.get(0);
			tc.setState(1);
			this.getHibernateTemplate().save(tc);
		}
	}
	//�رտ���
	public void closeTest() {
		String hql = "from TestControl tc order by tc.tdate desc";
		List<TestControl> list = (List<TestControl>) this.getHibernateTemplate().find(hql, null);
		if(list != null && list.size() > 0){
			TestControl tc = list.get(0);
			tc.setState(0);
			this.getHibernateTemplate().save(tc);
		}
	}
	//�鿴������Ϣ
	public TestControl ckTestControl() {
		String hql = "from TestControl tc order by tc.tdate desc";
		List<TestControl> list = (List<TestControl>) this.getHibernateTemplate().find(hql, null);
		if(list != null && list.size() > 0){
			return list.get(0);
		}
		return null;
	}
	//����ѧ�Ų�ѯ���Լ�¼
	public TestNote ckTestNote(Integer sid) {
		String hql = "from TestNote t where t.students.sid = ? order by t.tdate desc";
		List<TestNote> list = (List<TestNote>) this.getHibernateTemplate().find(hql, sid);
		if(list != null && list.size() >0){
			return list.get(0);
		}
		return null;
	}
	//�����ȡ�Ծ�
	public QuestionPaper cqQuestionPaper() {
		String hql = "from QuestionPaper";
		List<QuestionPaper> list = (List<QuestionPaper>) this.getHibernateTemplate().find(hql, null);
		if(list != null && list.size() > 0){
			Random rand = new Random();
			
			int randNum = rand.nextInt(list.size());
			System.out.println("�����������Ϊ==================================================="+randNum);
			return list.get(randNum);
		}
		return null;
	}
	//����ѧ�Ų�ѯѧ��
	public Students ckStudents(Integer sid) {
		String hql = "from Students where sid = ?";
		List<Students> list = (List<Students>) this.getHibernateTemplate().find(hql, sid);
		if(list != null && list.size() > 0){
			return list.get(0);
		}
		return null;
	}
	//���濼�Լ�¼
	public void saveTestNote(TestNote tn1) {
		this.getHibernateTemplate().save(tn1);
	}
	//�����Ծ�id��ѯ�Ծ���Ϣ
	public QuestionPaper hqQuestionPaper(Integer qpid) {
		String hql = "from QuestionPaper where qpid = ?";
		List<QuestionPaper> list = (List<QuestionPaper>) this.getHibernateTemplate().find(hql, qpid);
		if(list != null && list.size() > 0){
			return list.get(0);
		}
		return null;
	}
	//�����Ծ�id��ѯѡ����
	public List<QpRelationq> ckxzQpRelationq(Integer qpid) {
		String hql = "from QpRelationq  qpq where qpq.questionPaper.qpid = ? and qpq.question.questionType.qtid = ? order by qpq.num asc";
		List<QpRelationq> listqpq = (List<QpRelationq>) this.getHibernateTemplate().find(hql, qpid,1);
		List<QpRelationq> list = new ArrayList<QpRelationq>();
		String hql2 = null;
		for(int i=0; i<listqpq.size(); i++){
			QpRelationq qpq = listqpq.get(i);
			Question q = new Question();
			hql2 = "from Question where qid = ?";
			List<Question> listq = (List<Question>) this.getHibernateTemplate().find(hql2, listqpq.get(i).getQuestion().getQid());
			q = listq.get(0);
			qpq.setQuestion(q);
			list.add(qpq); 
		}
		return list;
	}
	//�����Ծ�id��ѯ�ж���
	public List<QpRelationq> ckpdQpRelationq(Integer qpid) {
		String hql = "from QpRelationq  qpq where qpq.questionPaper.qpid = ? and qpq.question.questionType.qtid = ? order by qpq.num asc";
		List<QpRelationq> listqpq = (List<QpRelationq>) this.getHibernateTemplate().find(hql, qpid,2);
		List<QpRelationq> list = new ArrayList<QpRelationq>();
		String hql2 = null;
		for(int i=0; i<listqpq.size(); i++){
			QpRelationq qpq = listqpq.get(i);
			Question q = new Question();
			hql2 = "from Question where qid = ?";
			List<Question> listq = (List<Question>) this.getHibernateTemplate().find(hql2, listqpq.get(i).getQuestion().getQid());
			q = listq.get(0);
			qpq.setQuestion(q);
			list.add(qpq); 
		}
		return list;
	}
	//�����Ծ�id��ѯ�����
	public List<QpRelationq> cktkQpRelationq(Integer qpid) {
		String hql = "from QpRelationq  qpq where qpq.questionPaper.qpid = ? and qpq.question.questionType.qtid = ? order by qpq.num asc";
		List<QpRelationq> listqpq = (List<QpRelationq>) this.getHibernateTemplate().find(hql, qpid,3);
		List<QpRelationq> list = new ArrayList<QpRelationq>();
		String hql2 = null;
		for(int i=0; i<listqpq.size(); i++){
			QpRelationq qpq = listqpq.get(i);
			Question q = new Question();
			hql2 = "from Question where qid = ?";
			List<Question> listq = (List<Question>) this.getHibernateTemplate().find(hql2, listqpq.get(i).getQuestion().getQid());
			q = listq.get(0);
			qpq.setQuestion(q);
			list.add(qpq); 
		}
		return list;
	}
	//�����Ծ�id��ѯ�������Ծ�Ķ�Ӧ��ϵ
	public List<QpRelationq> getQpq(Integer qpid) {
		String hql = "from QpRelationq qpq where qpq.questionPaper.qpid = ? order by qpq.num asc";
		List<QpRelationq> listqpq = (List<QpRelationq>) this.getHibernateTemplate().find(hql, qpid);
		return listqpq;
	}
	//��������id��ѯ�������
	public Question czQuestion(Integer qid){
		String hql = "from Question where qid = ?";
		List<Question> q = (List<Question>) this.getHibernateTemplate().find(hql, qid);
		if(q != null && q.size() > 0){
			return q.get(0);
		}
		return null;
	}
	//�������뿼�Լ�¼���浽answerState��
	public void saveAnswerState(AnswerState a) {
		this.getHibernateTemplate().save(a);
	}
	
	

}
