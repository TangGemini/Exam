package com.gemini.exam.qprelationq.service;

import org.springframework.transaction.annotation.Transactional;

import com.gemini.exam.qprelationq.dao.QpRelationqDao;

@Transactional
public class QpRelationqService {
	private QpRelationqDao qprqDao;

	public void setQprqDao(QpRelationqDao qprqDao) {
		this.qprqDao = qprqDao;
	}
}
