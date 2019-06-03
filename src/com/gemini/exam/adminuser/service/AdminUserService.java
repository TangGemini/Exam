package com.gemini.exam.adminuser.service;

import com.gemini.exam.adminuser.entity.AdminUser;
import org.springframework.transaction.annotation.Transactional;

import com.gemini.exam.adminuser.dao.AdminUserDao;

@Transactional
public class AdminUserService {
	
	private AdminUserDao adminUserDao;

	public void setAdminUserDao(AdminUserDao adminUserDao) {
		this.adminUserDao = adminUserDao;
	}
	
	//����Ա��¼��֤
	public AdminUser login(AdminUser admin) {
		return adminUserDao.login(admin);
	}

	public void updatePW(Integer uid, String npw) {
		adminUserDao.updatePW(uid,npw);
	}

}
