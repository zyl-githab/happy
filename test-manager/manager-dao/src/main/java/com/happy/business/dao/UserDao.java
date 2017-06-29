package com.happy.business.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.happy.business.User;

/**
 * 
 * @author Administrator
 *
 */
@Repository
public interface UserDao {

	public List<User> selectAll();
}
