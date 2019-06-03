package com.gemini.exam.testnote.service;

import java.util.Date;

import com.gemini.exam.testnote.dao.TestNoteDao;
import com.gemini.exam.testnote.entity.TestNote;
import org.springframework.transaction.annotation.Transactional;

@Transactional
public class TestNoteService {
	private TestNoteDao tnDao;

	public void setTnDao(TestNoteDao tnDao) {
		this.tnDao = tnDao;
	}
	//���뿼�Խ���ʱ��
	public void upEndTime(Integer tnid) {
		TestNote tn = tnDao.getTestNote(tnid);
		tn.setEtime(new Date());
		tnDao.saveTestNote(tn);
	}
}
