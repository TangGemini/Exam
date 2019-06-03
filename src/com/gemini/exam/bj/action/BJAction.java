package com.gemini.exam.bj.action;

import java.io.IOException;
import java.util.List;

import javax.servlet.http.HttpServletResponse;

import com.gemini.exam.bj.entity.BJ;
import com.gemini.exam.bj.service.BJService;
import com.gemini.exam.student.entity.Students;
import org.apache.struts2.ServletActionContext;

import com.gemini.exam.teacheruser.entity.Teacher;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;

public class BJAction extends ActionSupport implements ModelDriven<BJ>{
	
	private BJ bj = new BJ();
	public BJ getModel() {
		return bj;
	}
	private Integer sid;
	public void setSid(Integer sid) {
		this.sid = sid;
	}
	private Integer tid;
	public void setTid(Integer tid) {
		this.tid = tid;
	}
	
	private BJService bjService;

	public void setBjService(BJService bjService) {
		this.bjService = bjService;
	}
	
	/**
	 * �鿴�༶
	 * @return
	 */
	public String ckbj(){
		Teacher teacher = (Teacher) ServletActionContext.getRequest().getSession().getAttribute("existTeacher");
		List<BJ> listbj = bjService.ckbj(teacher.getTid());
		//ͨ��ֵջ���淵�ص�list����
		ActionContext.getContext().getValueStack().set("listbj", listbj);
		return "ckbj";
	}
	public String ckbjAdmin(){
		List<BJ> listbj = bjService.ckbjAdmin();
		//ͨ��ֵջ���淵�ص�list����
		ActionContext.getContext().getValueStack().set("listbj", listbj);
		return "ckbjAdmin";
	}
	/**
	 * ��ת����Ӱ༶ҳ��
	 * @return
	 */
	public String addbj(){	
		return "addbj";
	}
	public String addbjAdmin(){
		return "addbjAdmin";
	}
	/**
	 * AJAX�����첽У���û�����ִ�з���
	 * @return
	 * @throws IOException 
	 */
	public String findByName() throws IOException{
		BJ existBJ = bjService.findByName(java.net.URLDecoder.decode(bj.getBjname(), "UTF-8"));
		//���response������ҳ�����
		HttpServletResponse response = ServletActionContext.getResponse();
		response.setContentType("text/html;charset=UTF-8");
		//�ж�
		if(existBJ != null){
			//��ѯ���༶���༶������
			response.getWriter().print("t");
		}else{
			//û�в鵽�ð༶���༶�������ڣ�����ʹ��
			response.getWriter().print("f");
		}
		return NONE;
	}
	/**
	 * ��Ӱ༶ʵ��
	 * @return
	 */
	public String addbjsx(){
		bjService.addbjsx(bj,tid);
		return "addbjsx";
	}
	
	public String deleteBJ(){
		bjService.deleteBJ(bj.getBjid());
		return "deleteBJ";
	}
	public String deleteBJAdmin(){
		bjService.deleteBJ(bj.getBjid());
		return "deleteBJAdmin";
	}
	//���ݰ༶id�鿴�༶��Ϣ
	public String ckBJStudents(){
		List<Students> liststu = bjService.ckBJStudents(bj.getBjid());
		ActionContext.getContext().getValueStack().set("liststu", liststu);
		ActionContext.getContext().getValueStack().set("bjid", bj.getBjid());
		return "ckBJStudents";
	}
	//����ѧ��ɾ��ѧ����Ϣ
	public String deleteBJStudent(){
		bjService.deleteBJStudent(sid);
		List<Students> liststu = bjService.ckBJStudents(bj.getBjid());
		ActionContext.getContext().getValueStack().set("liststu", liststu);
		ActionContext.getContext().getValueStack().set("bjid", bj.getBjid());
		return "ckBJStudents";
	}
	@Override
	public String execute() throws Exception {
		// TODO Auto-generated method stub
		return super.execute();
	}

}
