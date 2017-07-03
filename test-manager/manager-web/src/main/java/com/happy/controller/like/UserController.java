package com.happy.controller.like;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.happy.business.User;
import com.happy.business.service.UserService;
import com.wordnik.swagger.annotations.Api;
import com.wordnik.swagger.annotations.ApiOperation;

/**
 * 
 * @author Administrator
 *
 */
@Api(value="user-api",description="有关于用户的CURD操作")
@Controller
@RequestMapping("/user")
public class UserController {
	private final static Logger LOGGER = LoggerFactory.getLogger(UserController.class);
	@Autowired
	private UserService userService;
	
	@RequestMapping(value = "/all", method = RequestMethod.GET)
	@ApiOperation(value="获取所有用户",notes = "返回用户实体对象集合")
	@ResponseBody
	public Object getUserAll() throws ServletException, IOException {
		List<User> selectAll = userService.selectAll();
		for (User user : selectAll) {
			System.out.println(user.toString());
			 LOGGER.debug(user.toString());
		}
		return selectAll;
	}
	
	
}
