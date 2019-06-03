package com.gemini.exam.answerstate.service;

import com.gemini.exam.question.entity.Question;
import org.springframework.transaction.annotation.Transactional;

import com.gemini.exam.answerstate.dao.AnswerStateDao;
import com.gemini.exam.answerstate.entity.AnswerState;
import com.gemini.exam.testnote.entity.TestNote;

@Transactional
public class AnswerStateService {
	private AnswerStateDao asDao;

	public void setAsDao(AnswerStateDao asDao) {
		this.asDao = asDao;
	}
	//���������
	public void saveAnswerState(Integer tnid, Integer qid, String qas) {
		AnswerState a = asDao.hqAnswerState(tnid,qid);
		Question q = asDao.hqQuestion(qid);
		TestNote tn = asDao.hqTestNote(tnid);
		if(qas.equals(q.getQanswer())){
			a.setState(1);
		}else{
			a.setState(2);
		}
		a.setQuestion(q);
		a.setTestNote(tn);
		asDao.saveAnswerState(a);
	}
}
