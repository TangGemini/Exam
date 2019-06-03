package com.gemini.exam.questionpaper.action;

import java.util.Date;
import java.util.List;

import com.gemini.exam.question.entity.Question;
import com.gemini.exam.questionpaper.service.QuestionPaperService;
import com.gemini.exam.utils.PageBean;
import com.gemini.exam.qprelationq.entity.QpRelationq;
import com.gemini.exam.questionpaper.entity.QuestionPaper;
import com.gemini.exam.questiontype.entity.QuestionType;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;

public class QuestionPaperAction extends ActionSupport implements ModelDriven<QuestionPaper>{
	
	private QuestionPaper questionPaper = new QuestionPaper();
	public QuestionPaper getModel() {
		return questionPaper;
	}
	private QuestionPaperService qpService;
	
	public void setQpService(QuestionPaperService qpService) {
		this.qpService = qpService;
	}
	public Question question;
	public Question getQuestion() {
		return question;
	}
	public void setQuestion(Question question) {
		this.question = question;
	}
	private Integer tid;
	
	public void setTid(Integer tid) {
		this.tid = tid;
	}
	private Integer qtid;
	public void setQtid(Integer qtid) {
		this.qtid = qtid;
	}
	private Integer qid;
	public Integer getQid() {
		return qid;
	}
	public void setQid(Integer qid) {
		this.qid = qid;
	}
	private int page;
	public void setPage(int page) {
		this.page = page;
	}
	private Integer num;
	public void setNum(Integer num) {
		this.num = num;
	}
	//�����Ծ�
	public String szQuestionPaper(){	
		return "szQuestionPaper";
	}
	public String szAdminQuestionPaper(){
		return "szAdminQuestionPaper";
	}
	//����Ծ�
	public String tjQuestionPaper(){
		Date qpdate = new Date();
		questionPaper.setQpdate(qpdate);
		qpService.szQuestionPaper(questionPaper,tid);
		List<QuestionType> listqt = qpService.allQT();
		questionPaper = qpService.getQuestionPaper();  //��ѯ�Ծ��ȡ�Ծ�id
		ActionContext.getContext().getValueStack().set("listqt", listqt);
		ActionContext.getContext().getValueStack().set("questionPaper", questionPaper);
		return "tjQuestionPaper";
	}
	public String tjAdminQuestionPaper(){
		Date qpdate = new Date();
		questionPaper.setQpdate(qpdate);
		qpService.szAdminQuestionPaper(questionPaper);
		List<QuestionType> listqt = qpService.allQT();
		questionPaper = qpService.getQuestionPaper();  //��ѯ�Ծ��ȡ�Ծ�id
		ActionContext.getContext().getValueStack().set("listqt", listqt);
		ActionContext.getContext().getValueStack().set("questionPaper", questionPaper);
		return "tjAdminQuestionPaper";
	}
	//Ϊ�Ծ��������
	public String tjQuestion(){
		if(qid!=null){
			question = qpService.selectQuestion(qid);
		}
		
		PageBean<Question> pageBean = qpService.ckQuestion(question,tid,qtid,page);
		ActionContext.getContext().getValueStack().set("pageBean", pageBean);
		List<QpRelationq> listqpq = qpService.qpQuestion(questionPaper.getQpid()); //�����Ծ������е�����
		List<QuestionType> listqt = qpService.allQT();
		ActionContext.getContext().getValueStack().set("questionPaper", questionPaper);
		ActionContext.getContext().getValueStack().set("listqt", listqt);
		ActionContext.getContext().getValueStack().set("pageqtid", qtid);
		ActionContext.getContext().getValueStack().set("listqpq", listqpq);
		
		return "tjQuestion";
	}
	public String tjAdminQuestion(){
		if(qid!=null){
			question = qpService.selectQuestion(qid);
		}
		
		PageBean<Question> pageBean = qpService.ckAdminQuestion(question,qtid,page);
		ActionContext.getContext().getValueStack().set("pageBean", pageBean);
		List<QpRelationq> listqpq = qpService.qpQuestion(questionPaper.getQpid()); //�����Ծ������е�����
		List<QuestionType> listqt = qpService.allQT();
		ActionContext.getContext().getValueStack().set("questionPaper", questionPaper);
		ActionContext.getContext().getValueStack().set("listqt", listqt);
		ActionContext.getContext().getValueStack().set("pageqtid", qtid);
		ActionContext.getContext().getValueStack().set("listqpq", listqpq);
		return "tjAdminQuestion";
	}
	//Ϊ�Ծ��������ʵ��
	public String tjQuestionSX(){
		qpService.tiQuestionSX(questionPaper.getQpid(),qid,num);
		List<QpRelationq> listqpq = qpService.qpQuestion(questionPaper.getQpid()); //�����Ծ������е�����
		List<QuestionType> listqt = qpService.allQT();
		ActionContext.getContext().getValueStack().set("listqt", listqt);
		ActionContext.getContext().getValueStack().set("questionPaper", questionPaper);
		ActionContext.getContext().getValueStack().set("listqpq", listqpq);
		return "tjQuestionSX";
	}
	public String tjAdminQuestionSX(){
		qpService.tiQuestionSX(questionPaper.getQpid(),qid,num);
		List<QpRelationq> listqpq = qpService.qpQuestion(questionPaper.getQpid()); //�����Ծ������е�����
		List<QuestionType> listqt = qpService.allQT();
		ActionContext.getContext().getValueStack().set("listqt", listqt);
		ActionContext.getContext().getValueStack().set("questionPaper", questionPaper);
		ActionContext.getContext().getValueStack().set("listqpq", listqpq);
		return "tjAdminQuestionSX";
	}
	//�鿴�Ծ�
	public String ckQuestionPaper(){
		List<QuestionPaper> list = qpService.ckQuestionPaper(tid);
		ActionContext.getContext().getValueStack().set("list", list);
		return "ckQuestionPaper";
	}
	public String ckAdminQuestionPaper(){
		List<QuestionPaper> list = qpService.ckAdminQuestionPaper();
		ActionContext.getContext().getValueStack().set("list", list);
		return "ckAdminQuestionPaper";
	}
	//�鿴�Ծ��е�����
	public String ckQPQuestion(){
		//�鿴�Ծ��е�����
		List<QpRelationq> listqpq = qpService.qpQuestion(questionPaper.getQpid()); 
		ActionContext.getContext().getValueStack().set("listqpq", listqpq);
		return "ckQPQuestion";
	}

}
