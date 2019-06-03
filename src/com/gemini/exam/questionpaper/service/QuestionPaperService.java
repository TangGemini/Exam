package com.gemini.exam.questionpaper.service;

import java.util.List;

import com.gemini.exam.question.entity.Question;
import com.gemini.exam.utils.PageBean;
import org.springframework.transaction.annotation.Transactional;

import com.gemini.exam.qprelationq.entity.QpRelationq;
import com.gemini.exam.questionpaper.dao.QuestionPaperDao;
import com.gemini.exam.questionpaper.entity.QuestionPaper;
import com.gemini.exam.questiontype.entity.QuestionType;

@Transactional
public class QuestionPaperService {
	private QuestionPaperDao qpDao;

	public void setQpDao(QuestionPaperDao qpDao) {
		this.qpDao = qpDao;
	}
	//�����Ծ������Ϣ
	public void szQuestionPaper(QuestionPaper questionPaper, Integer tid) {
		qpDao.szQuestionPaper(questionPaper,tid);
	}
	public void szAdminQuestionPaper(QuestionPaper questionPaper) {
		qpDao.szAdminQuestionPaper(questionPaper);
	}
	//��ѯ��������
	public List<QuestionType> allQT() {
		return qpDao.allQT();
	}
	public Question selectQuestion(Integer qid) {
		return qpDao.selectQuestion(qid);
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
		totalCount = qpDao.findCount(question,tid,qtid);
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
		List<Question> list = qpDao.findQuestion(question,tid,qtid,begin,limit);
		pageBean.setList(list);
		return pageBean;
	}
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
		totalCount = qpDao.findCountAdmin(question,qtid);
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
		List<Question> list = qpDao.findQuestionAdmin(question,qtid,begin,limit);
		pageBean.setList(list);
		return pageBean;
	}
	//��ѯ�Ծ�
	public QuestionPaper getQuestionPaper() {
		return qpDao.getQuestionPaper();
	}
	//Ϊ�Ծ���������ʵ��
	public void tiQuestionSX(Integer qpid, Integer qid, Integer num) {
		qpDao.tjQuestionSX(qpid,qid,num);
	}
	//��ѯ�Ծ����Ѿ����ڵ�����
	public List<QpRelationq> qpQuestion(Integer qpid) {
		return qpDao.qpQuestion(qpid);
	}
	
	//���ݽ�ʦ��Ų鿴�Ծ�
	public List<QuestionPaper> ckQuestionPaper(Integer tid) {
		return qpDao.ckQuestionPaper(tid);
	}
	public List<QuestionPaper> ckAdminQuestionPaper() {
		return qpDao.ckAdminQuestionPaper();
	}
	
	

}
