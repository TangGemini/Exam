package com.gemini.exam.questiontype.service;

import org.springframework.transaction.annotation.Transactional;

import com.gemini.exam.questiontype.dao.QuestionTypeDao;

@Transactional
public class QuestionTypeService {

	private QuestionTypeDao qtDao;

	public void setQtDao(QuestionTypeDao qtDao) {
		this.qtDao = qtDao;
	}
}
