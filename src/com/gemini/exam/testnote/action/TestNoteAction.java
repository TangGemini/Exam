package com.gemini.exam.testnote.action;

import com.gemini.exam.testnote.entity.TestNote;
import com.gemini.exam.testnote.service.TestNoteService;

import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;

public class TestNoteAction extends ActionSupport implements ModelDriven<TestNote>{
	private TestNote testNote = new TestNote();
	public TestNote getModel() {
		return testNote;
	}
	private TestNoteService tnService;
	public void setTnService(TestNoteService tnService) {
		this.tnService = tnService;
	}
	//���Խ���
	public String closeTestNote(){
		System.out.println("���Լ�¼id"+testNote.getTnid());
		tnService.upEndTime(testNote.getTnid());
		return "closeTestNote";
	}
}
