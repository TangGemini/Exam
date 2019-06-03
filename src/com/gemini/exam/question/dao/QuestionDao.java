package com.gemini.exam.question.dao;

import java.util.List;

import com.gemini.exam.question.entity.Question;
import org.springframework.orm.hibernate5.support.HibernateDaoSupport;

import com.gemini.exam.questiontype.entity.QuestionType;
import com.gemini.exam.teacheruser.entity.Teacher;
import com.gemini.exam.utils.PageHibernateCallback;

public class QuestionDao extends HibernateDaoSupport{

	public List<QuestionType> ckQuestionAndXZQT() {
		String hql = "from QuestionType";
		List<QuestionType> listqt = (List<QuestionType>) this.getHibernateTemplate().find(hql, null);
		if(listqt!=null && listqt.size()>0){
			return listqt;
		}else{
			return null;
		}
		
	}
	//��ȡ������������������
	public int findCount(Question question, Integer tid, Integer qtid) {
		String hql = "select count(*) from Question q where q.teacher.tid = ? and q.questionType.qtid = ? and  q.qscope = ? and q.qdifficulty = ? ";
		List<Long> list = (List<Long>) this.getHibernateTemplate().find(hql, tid,qtid,question.getQscope(),question.getQdifficulty());
		if(list != null && list.size()>0){
			return list.get(0).intValue();
		}
		return 0;	
	}
	//��ȡ������������������
	public int findCountAdmin(Question question, Integer qtid) {
		String hql = "select count(*) from Question q where  q.questionType.qtid = ? and  q.qscope = ? and q.qdifficulty = ? ";
		List<Long> list = (List<Long>) this.getHibernateTemplate().find(hql,qtid,question.getQscope(),question.getQdifficulty());
		if(list != null && list.size()>0){
			return list.get(0).intValue();
		}
		return 0;	
	}
	//����������ȡ���⼯��
	public List<Question> findQuestion(Question question, Integer tid,
			Integer qtid, int begin, int limit) {
		//String hql = "select s from Students s join s.bj b join b.teacher t where t.tid = ? order by s.sid";
		String hql = "select q from Question q join q.teacher t join q.questionType qt where t.tid = ? and qt.qtid = ? and q.qscope = ? and q.qdifficulty = ? order by q.qid";
		//��ҳʵ��
		List<Question> list = this.getHibernateTemplate().execute(new PageHibernateCallback<Question>(hql, new Object[]{tid,qtid,question.getQscope(),question.getQdifficulty()}, begin, limit));
		if(list != null && list.size()>0){
			return list;
		}
		return null;
	}
	//����������ȡ���⼯��
	public List<Question> findQuestionAmin(Question question, Integer qtid,
			int begin, int limit) {
		String hql = "select q from Question q join q.questionType qt where qt.qtid = ? and q.qscope = ? and q.qdifficulty = ? order by q.qid";
		//��ҳʵ��
		List<Question> list = this.getHibernateTemplate().execute(new PageHibernateCallback<Question>(hql, new Object[]{qtid,question.getQscope(),question.getQdifficulty()}, begin, limit));
		if(list != null && list.size()>0){
			return list;
		}
		return null;
	}
	public Question selectQuestion(Integer qid) {
		String hql = "from Question where qid = ?";
		List<Question> list = (List<Question>) this.getHibernateTemplate().find(hql, qid);
		if(list != null && list.size()>0){
			return list.get(0);
		}
		return null;
	}
	//�ؼ��ؼ��ֲ�����������
	public List<Question> finByOword(String oword,String qscope,String qdifficulty,Integer qtid) {
		//String hql = "select q from Question q join q.questionType qt  where q.oword = ? and q.qscope = ? and q.qdifficulty = ? and qt.qtid = ?";
		String hql = "select q from Question q join q.questionType qt  where q.oword like ? and q.qscope = ? and q.qdifficulty = ? and qt.qtid = ?";
		List<Question> list = (List<Question>) this.getHibernateTemplate().find(hql, "%"+oword+"%",qscope,qdifficulty,qtid);
		return list;
	}
	public void addQuestionXZSX(Question question,Integer qtid,Integer tid) {
		String hql = "from QuestionType where qtid = ?";
		List<QuestionType> qt = (List<QuestionType>) this.getHibernateTemplate().find(hql, qtid);
		String hql2 = "from Teacher where tid = ?";
		List<Teacher> t = (List<Teacher>) this.getHibernateTemplate().find(hql2, tid);
		if(qt != null && qt.size()>0){
			question.setQuestionType(qt.get(0));
		}
		if(t != null && t.size()>0){
			question.setTeacher(t.get(0));
		}
		
		this.getHibernateTemplate().save(question);
		
	}
	public void addAdminQuestionXZSX(Question question, Integer qtid) {
		String hql = "from QuestionType where qtid = ?";
		//���������е���������id��ѯ����������Ϣ
		List<QuestionType> qt = (List<QuestionType>) this.getHibernateTemplate().find(hql, qtid);
		if(qt != null && qt.size()>0){
			//������������Ϣ���뵽���������
			question.setQuestionType(qt.get(0));
		}
		//����hibernate�е���ӷ���
		this.getHibernateTemplate().save(question);
	}
	//���������Ų鿴������Ϣ
	public Question ckQuestionXX(Integer qid) {
		String hql = "from Question where qid = ?";
		List<Question> listq = (List<Question>) this.getHibernateTemplate().find(hql, qid);
		Question question = null;
		if(listq != null && listq.size() > 0 ){
			question = listq.get(0);
			String hql2 = "from QuestionType where qtid = ?";
			List<QuestionType> listqt = (List<QuestionType>) this.getHibernateTemplate().find(hql2, listq.get(0).getQuestionType().getQtid());
			if(listqt != null && listqt.size() > 0 ){
				question.setQuestionType(listqt.get(0));
				return question;
			}
		}
		return null;
	}
	//����������ɾ������
	public void delQuestion(Integer qid) {
		//String hql2 = "from AnswerState a where a.question.qid = ?";
		String hql = "from Question where qid = ?";
		List<Question> listq = (List<Question>) this.getHibernateTemplate().find(hql, qid);
		/*List<AnswerState> listas = (List<AnswerState>) this.getHibernateTemplate().find(hql2, qid);
		for(int i=0; i<listas.size(); i++){
			
			this.getHibernateTemplate().delete(listas.get(i));
		}*/
		
		
		if(listq != null && listq.size() > 0){
			this.getHibernateTemplate().delete(listq.get(0));
		}
	}
	
	
	

}
