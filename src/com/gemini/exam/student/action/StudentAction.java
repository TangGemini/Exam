package com.gemini.exam.student.action;

import java.io.IOException;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletResponse;

import com.gemini.exam.student.service.StudentService;
import org.apache.struts2.ServletActionContext;
import org.apache.struts2.interceptor.SessionAware;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;

import com.gemini.exam.answerstate.entity.AnswerState;
import com.gemini.exam.bj.entity.BJ;
import com.gemini.exam.student.entity.Students;
import com.gemini.exam.testnote.entity.TestNote;
import com.gemini.exam.utils.PageBean;

public class StudentAction extends ActionSupport implements ModelDriven<Students>,SessionAware{
	
	private Students student = new Students();
	
	public Students getModel() {
		return student;
	}
	
	private StudentService studentService;

	public void setStudentService(StudentService studentService) {
		this.studentService = studentService;
	}
	
	//���յ�ǰҳ��
	private int page;
	
	public void setPage(int page) {
		this.page = page;
	}
	//���հ༶���
	private Integer bjid;
	
	public void setStudent(Students student) {
		this.student = student;
	}

	public void setBjid(Integer bjid) {
		this.bjid = bjid;
	}
	private Integer tnid;

	public void setTnid(Integer tnid) {
		this.tnid = tnid;
	}

	//���ս�ʦ���
	private Integer tid;

	public void setTid(Integer tid) {
		this.tid = tid;
	}
	private String npw;
	
	public void setNpw(String npw) {
		this.npw = npw;
	}

	public String slogin(){
		return "loginStudent";
	}
	//��֤ѧ�ź������Ƿ���ȷ
	public String login(){
		Students existStudent = studentService.login(student);
		//�ж��û��Ƿ����
		if(existStudent == null){
			this.addActionError("ѧ�Ż��������");
			return "loginFailStudent";
		}else{
			ServletActionContext.getRequest().getSession().setAttribute("existStudent", existStudent);
				return "loginSuccessStudent";	
		}		
	}
	//��ȫ�˳����session
	public String sessionDestory(){
		ServletActionContext.getRequest().getSession().invalidate();
		return "sessionDestory";
	}
	//�޸�����
	public String upw(){
		return "upwStudent";
	}
	//�޸�����ʵ��
	public String updatePW(){
		studentService.updatePW(student.getSid(),npw);
		return "updatePWStudent";
	}
	//��ѯ����ѧ����Ϣ
	public String ckAllStudent(){
		PageBean<Students> pageBean = studentService.ckStudent(tid,page);
		//��PageBean����ֵջ��
		ActionContext.getContext().getValueStack().set("pageBean", pageBean);		
		return "ckAllStudent";
	}
	public String ckAllStudentAdmin(){
		PageBean<Students> pageBean = studentService.ckStudentAdmin(page);
		//��PageBean����ֵջ��
		ActionContext.getContext().getValueStack().set("pageBean", pageBean);
		return "ckAllStudentAdmin";
	}
	//����ѧ��ɾ��ѧ����Ϣ
	public String deleteStudent(){
		studentService.deleteStudent(student.getSid());
		PageBean<Students> pageBean = studentService.ckStudent(tid,page);
		//��PageBean����ֵջ��
		ActionContext.getContext().getValueStack().set("pageBean", pageBean);		
		return "ckAllStudent";
	}
	public String deleteStudentAdmin(){
		studentService.deleteStudent(student.getSid());
		PageBean<Students> pageBean = studentService.ckStudentAdmin(page);
		//��PageBean����ֵջ��
		ActionContext.getContext().getValueStack().set("pageBean", pageBean);	
		return "ckAllStudentAdmin";
	}
	//���ѧ����Ϣ
	public String addStudent(){
		List<BJ> list =studentService.ckbj(tid);
		//ͨ��ֵջ���淵�ص�list����
		ActionContext.getContext().getValueStack().set("listbj", list);
		return "addStudent";
	}
	public String addStudentAdmin(){
		List<BJ> list =studentService.ckbjAdmin();
		//ͨ��ֵջ���淵�ص�list����
		ActionContext.getContext().getValueStack().set("listbj", list);
		return "addStudentAdmint";
	}
	//����ѧ����Ϣ
	public String wsStudent(){
		Students stu = studentService.cxStudent(student.getSid());
		ActionContext.getContext().getValueStack().set("stu", stu);
		return "wsStudent";
	}
	//����ѧ����Ϣ
	public String wsStudentSX(){
		studentService.wsStudentSX(student);
		return "wsStudentSX";
	}
	//��ѯѧ����Ϣ
	public String myBJ(){
		BJ bj = studentService.myBJ(student.getSid());
		ActionContext.getContext().getValueStack().set("bj", bj);
		return "myBJ";
	}

	/**
	 * AJAX�����첽У��༶����ִ�з���
	 * @return
	 * @throws IOException 
	 */
	public String findBySid() throws IOException{
		Students existStudent = studentService.findBySid(student.getSid());
		//���response������ҳ�����
		HttpServletResponse response = ServletActionContext.getResponse();
		response.setContentType("text/html;charset=UTF-8");
		//�ж�
		if(existStudent != null){
			//��ѯ���༶���༶������
			response.getWriter().print("t");
		}else{
			//û�в鵽�ð༶���༶�������ڣ�����ʹ��
			response.getWriter().print("f");
		}
		return NONE;
	}
	//���ѧ����Ϣʵ��
	public String addStudentSX(){
		studentService.addStudentSX(student,bjid);
		return "addStudentSX";
	}
	//�鿴���Լ�¼
	public String ckTestNote(){
		List<TestNote> testNotes = studentService.ckTestNote(student.getSid());
		ActionContext.getContext().getValueStack().set("testNotes", testNotes);
		return "ckTestNote";
	}
	//�鿴�Ծ�������
	public String ckAnswerState(){
		//�鿴ѡ����
		List<AnswerState> answerStatesxz = studentService.ckAnswerStatexz(tnid);
		//�鿴�ж���
		List<AnswerState> answerStatespd = studentService.ckAnswerStatepd(tnid);
		//�鿴�����
		List<AnswerState> answerStatestk = studentService.ckAnswerStatetk(tnid);
		ActionContext.getContext().getValueStack().set("answerStatesxz", answerStatesxz);
		ActionContext.getContext().getValueStack().set("answerStatespd", answerStatespd);
		ActionContext.getContext().getValueStack().set("answerStatestk", answerStatestk);
		return "ckAnswerState";
	}
	//�鿴ѧ����Ϣ
	public String ckStudentXX(){
		Students stu = studentService.ckStudentXX(student.getSid());
		ActionContext.getContext().getValueStack().set("stu", stu);
		return "ckStudentXX";
	}
	public void setSession(Map<String, Object> arg0) {
	
	}
}
