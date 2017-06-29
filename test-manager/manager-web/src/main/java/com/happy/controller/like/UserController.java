package com.happy.controller.like;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.happy.business.User;
import com.happy.business.service.UserService;

/**
 * 
 * @author Administrator
 *
 */
@Controller
@RequestMapping("/user")
public class UserController {
	private final static Logger LOGGER = LoggerFactory.getLogger(UserController.class);
	@Autowired
	private UserService userService;

	@RequestMapping(value = "/all", method = RequestMethod.GET)
	public ModelAndView getUserAll(HttpServletRequest req,HttpServletResponse resp) throws ServletException, IOException {
		List<User> selectAll = userService.selectAll();
		for (User user : selectAll) {
			System.out.println(user.toString());
			LOGGER.debug(user.toString());
		}
		ModelAndView model = new ModelAndView("success");
		model.addObject("userAll", selectAll);
		return model;
	}
}
