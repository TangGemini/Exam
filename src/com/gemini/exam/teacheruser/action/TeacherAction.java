package com.gemini.exam.teacheruser.action;

import java.io.IOException;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletResponse;

import com.gemini.exam.teacheruser.entity.Teacher;
import com.gemini.exam.teacheruser.service.TeacherService;
import org.apache.struts2.ServletActionContext;
import org.apache.struts2.interceptor.SessionAware;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;

public class TeacherAction extends ActionSupport implements ModelDriven<Teacher>,SessionAware{
	//ģ������ʹ�õĶ���
	private Teacher teacher = new Teacher();
	
	public Teacher getModel() {
		return teacher;
	}
	
	//ע��TeacherService
	private TeacherService teacherService;

	public void setTeacherService(TeacherService teacherService) {
		this.teacherService = teacherService;
	}
	//��ȡ������
	private String npw ;

	public void setTeacher(Teacher teacher) {
		this.teacher = teacher;
	}

	public void setNpw(String npw) {
		this.npw = npw;
	}

	public String tlogin(){
		return "login";
	}
	
	//��֤��ʦ��ź������Ƿ���ȷ
	public String login(){
		Teacher existTeacher = teacherService.login(teacher);
		//�ж��û��Ƿ����
		if(existTeacher == null){
			this.addActionError("��ʦ��Ż��������");
			return "loginFail";
		}else{
			ServletActionContext.getRequest().getSession().setAttribute("existTeacher", existTeacher);
				return "loginSuccess";	
		}		
	}
	//��ȫ�˳����session
	public String sessionDestory(){
		ServletActionContext.getRequest().getSession().invalidate();
		return "sessionDestoryteacher";
	}
	//�鿴��ʦ��Ϣ
	public String ckxx(){
		return "ckxx";
	}
	//�鿴���н�ʦ
	public String ckAllTeacherAdmin(){
		List<Teacher>  list = teacherService.ckAllTeacher();
		ActionContext.getContext().getValueStack().set("list", list);
		return "ckAllTeacherAdmin";
	}
	//���ݽ�ʦ��Ų�ѯ��ʦ��Ϣ
	public String ckTeacherXX(){
		Teacher t = teacherService.ckTeacherXX(teacher.getTid());
		ActionContext.getContext().getValueStack().set("t", t);
		return "ckTeacherXX";
	}
	//���ݽ�ʦ���ɾ����ʦ
	public String deleteTeacherAdmin(){
		teacherService.deleteTeacherAdmin(teacher.getTid());
		List<Teacher>  list = teacherService.ckAllTeacher();
		ActionContext.getContext().getValueStack().set("list", list);
		return "ckAllTeacherAdmin";
	}
	//У���ʦ����Ƿ�ʹ��
	public String findByTid() throws IOException{
		Teacher existTeacher = teacherService.ckTeacherXX(teacher.getTid());
		//���response������ҳ�����
		HttpServletResponse response = ServletActionContext.getResponse();
		response.setContentType("text/html;charset=UTF-8");
		//�ж�
		if(existTeacher != null){
			//��ѯ����ʦ������
			response.getWriter().print("t");
		}else{
			//û�в鵽�ý�ʦ����ʦ�����ڣ�����ʹ��
			response.getWriter().print("f");
		}
		return NONE;
	}
	//��ӽ�ʦ
	public String addTeacherAdmin(){
		return "addTeacherAdmin";
	}
	//��ӽ�ʦʵ��
	public String addTeacherSX(){
		teacherService.addTeacherSX(teacher);
		return "addTeacherSX";
	}
	//�޸�����
	public String upw(){
		return "upw";
	}
	//�޸�����ʵ��
	public String updatePW(){
		teacherService.updatePW(teacher.getTid(),npw);
		return "updatePW";
	}
	@Override
	public String execute() throws Exception {
		// TODO Auto-generated method stub
		return "NONE";
	}

	public void setSession(Map<String, Object> arg0) {
	}
}
