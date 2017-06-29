package com.happy.business.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.happy.business.User;
import com.happy.business.dao.UserDao;
import com.happy.business.service.UserService;

/**
 * 
 * @author Administrator
 *
 */
@Service("userService")
public class UserServiceImpl implements UserService {

	@Autowired
	private UserDao userDao;

	@Override
	public List<User> selectAll() {
		return userDao.selectAll();
	}

}
