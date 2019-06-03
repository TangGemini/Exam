package com.gemini.exam.question.service;

import java.util.List;

import com.gemini.exam.question.entity.Question;
import org.springframework.transaction.annotation.Transactional;

import com.gemini.exam.question.dao.QuestionDao;
import com.gemini.exam.questiontype.entity.QuestionType;
import com.gemini.exam.utils.PageBean;

@Transactional
public class QuestionService {
	private QuestionDao questionDao;

	public void setQuestionDao(QuestionDao questionDao) {
		this.questionDao = questionDao;
	}

	public List<QuestionType> ckQuestionAndXZQT() {
		return questionDao.ckQuestionAndXZQT();
	}
	//���ݽ�ʦ��š��������ͱ�š��Ȳ�ѯ����
	public PageBean<Question> ckQuestion(Question question, Integer tid,
                                         Integer qtid, int page) {
		PageBean<Question> pageBean = new PageBean<Question>();
		//���õ�ǰҳ��
		pageBean.setPage(page);
		//����ÿҳ��ʾ�ļ�¼��
		int limit = 3;
		pageBean.setLimit(limit);
		//�����ܵļ�¼��
		int totalCount = 0;
		totalCount = questionDao.findCount(question,tid,qtid);
		pageBean.setTotalCount(totalCount);
		//�����ܵ�ҳ��
		int totalPage = 0;
		if(totalCount % limit == 0){
			totalPage = totalCount /limit ;
		}else{
			totalPage = totalCount / limit +1;
		}
		pageBean.setTotalPage(totalPage);
		//ÿҳ��ʾ�����ݼ���
		//��������¼��ʼ
		int begin = (page - 1) * limit;
		List<Question> list = questionDao.findQuestion(question,tid,qtid,begin,limit);
		pageBean.setList(list);
		return pageBean;
	}
	//����Ա�����������ͱ�š��Ȳ�ѯ����
	public PageBean<Question> ckAdminQuestion(Question question, Integer qtid,
			int page) {
		PageBean<Question> pageBean = new PageBean<Question>();
		//���õ�ǰҳ��
		pageBean.setPage(page);
		//����ÿҳ��ʾ�ļ�¼��
		int limit = 3;
		pageBean.setLimit(limit);
		//�����ܵļ�¼��
		int totalCount = 0;
		totalCount = questionDao.findCountAdmin(question,qtid);
		pageBean.setTotalCount(totalCount);
		//�����ܵ�ҳ��
		int totalPage = 0;
		if(totalCount % limit == 0){
			totalPage = totalCount /limit ;
		}else{
			totalPage = totalCount / limit +1;
		}
		pageBean.setTotalPage(totalPage);
		//ÿҳ��ʾ�����ݼ���
		//��������¼��ʼ
		int begin = (page - 1) * limit;
		List<Question> list = questionDao.findQuestionAmin(question,qtid,begin,limit);
		pageBean.setList(list);
		return pageBean;
	}	
	public Question selectQuestion(Integer qid) {
		
		return questionDao.selectQuestion(qid);
	}
	
	//���ݹؼ��ֲ����Ƿ������Ƶ�����
	public List<Question> findByOword(String oword,String qscope,String qdifficulty,Integer qtid) {
		
		return questionDao.finByOword(oword,qscope,qdifficulty,qtid);
	}
	//�������ʵ��
	public void addQuestionXZSX(Question question,Integer qtid, Integer tid) {
		questionDao.addQuestionXZSX(question,qtid,tid);
	}
	public void addAdminQuestionXZSX(Question question, Integer qtid) {
		questionDao.addAdminQuestionXZSX(question,qtid);
	}
	//���������Ų鿴������Ϣ
	public Question ckQuestionXX(Integer qid) {
		return questionDao.ckQuestionXX(qid);
	}
	//����������ɾ������
	public void delQuestion(Integer qid) {
		questionDao.delQuestion(qid);
	}

	

	
}
