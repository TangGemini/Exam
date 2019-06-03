package com.gemini.exam.testcontrol.action;

import java.util.Date;
import java.util.List;

import com.gemini.exam.questionpaper.entity.QuestionPaper;
import com.gemini.exam.student.entity.Students;
import com.gemini.exam.qprelationq.entity.QpRelationq;
import com.gemini.exam.testcontrol.entity.TestControl;
import com.gemini.exam.testcontrol.service.TestControlService;
import com.gemini.exam.testnote.entity.TestNote;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;

public class TestControlAction extends ActionSupport implements ModelDriven<TestControl>{
	private TestControl testControl = new TestControl();
	public TestControl getModel() {
		return testControl;
	}
	private TestControlService tcService;
	public void setTcService(TestControlService tcService) {
		this.tcService = tcService;
	}
	private Integer qpid;
	public void setQpid(Integer qpid) {
		this.qpid = qpid;
	}
	private Integer sid;
	
	public void setSid(Integer sid) {
		this.sid = sid;
	}
	//�������ÿ�����Ϣҳ��
	public String szTest(){
		List<QuestionPaper> list = tcService.ckQuestionPaper();
		ActionContext.getContext().getValueStack().set("list", list);
		return "szTest";
	}
	//��ӿ�����Ϣ
	public String addTestControl(){
		Date date = new Date();
		testControl.setTdate(date);
		tcService.addTestControl(testControl,qpid);
		return "addTestControl";
	}
	//�鿴������Ϣ
	public String ckTestControl(){
		TestControl tc = tcService.ckTestControl();
		if(tc.getState()==0){
			return "closeTestControl";
		}else{
			ActionContext.getContext().getValueStack().set("tc", tc);
			return "openTestControl";
		}
	}
	//�򿪿���
	public String openTest(){
		tcService.openTest();
		return "openTest";
	}
	//�رտ���
	public String closeTest(){
		tcService.closeTest();
		return "closeTest";
	}
	//��ѯ���Է�ʽ
	public String ckTestControlMode(){
		TestControl tc = tcService.ckTestControl();
		TestNote tn = tcService.ckTestNote(sid);
		Students stu = tcService.ckStudents(sid);
		ActionContext.getContext().getValueStack().set("stu", stu);
		TestNote tn1 = new TestNote();
		tn1.setStudents(stu);
		tn1.setTdate(tc.getTdate());
		tn1.setTname(tc.getTname());
		if(tn != null && tn.getTname().equals(tc.getTname()) && tn.getTdate().equals(tc.getTdate())){
			return "testend";
		}else{
			//tc.getMode() == 2 ��ʾ�����ȡ�Ծ�
			if(tc.getMode() == 2){					
				//�����ȡ�Ծ�
				QuestionPaper qp = tcService.cqQuestionPaper();
				ActionContext.getContext().getValueStack().set("qp", qp);
				Date stime = new Date();
				tn1.setQuestionPaper(qp);
				tn1.setStime(stime);
				//���濼�Լ�¼
				tcService.saveTestNote(tn1);
				TestNote tn2 = tcService.ckTestNote(sid);
				//������Ϳ��Լ�¼id���浽AnswerState����
				tcService.saveQuestionTN(qp,tn2); 
				List<QpRelationq> listxzqpq = tcService.ckxzQpRelationq(qp.getQpid());
				List<QpRelationq> listpdqpq = tcService.ckpdQpRelationq(qp.getQpid());
				List<QpRelationq> listtkqpq = tcService.cktkQpRelationq(qp.getQpid());
				ActionContext.getContext().getValueStack().set("listxzqpq", listxzqpq);
				ActionContext.getContext().getValueStack().set("listpdqpq", listpdqpq);
				ActionContext.getContext().getValueStack().set("listtkqpq", listtkqpq);
				ActionContext.getContext().getValueStack().set("tn", tn2);
				return "StartTest";
			}else{	
				//ָ���Ծ���п���
				QuestionPaper qp = tcService.hqQuestionPaper(tc.getQuestionPaper().getQpid());
				ActionContext.getContext().getValueStack().set("qp", qp);
				Date stime = new Date();
				tn1.setQuestionPaper(qp);
				tn1.setStime(stime);
				//���濼�Լ�¼
				tcService.saveTestNote(tn1);
				TestNote tn2 = tcService.ckTestNote(sid);
				//������Ϳ��Լ�¼id���浽AnswerState����
				tcService.saveQuestionTN(qp,tn2); 
				List<QpRelationq> listxzqpq = tcService.ckxzQpRelationq(qp.getQpid());
				List<QpRelationq> listpdqpq = tcService.ckpdQpRelationq(qp.getQpid());
				List<QpRelationq> listtkqpq = tcService.cktkQpRelationq(qp.getQpid());
				ActionContext.getContext().getValueStack().set("listxzqpq", listxzqpq);
				ActionContext.getContext().getValueStack().set("listpdqpq", listpdqpq);
				ActionContext.getContext().getValueStack().set("listtkqpq", listtkqpq);
				ActionContext.getContext().getValueStack().set("tn", tn2);
				return "StartTest";
			}
		}
	}
}
