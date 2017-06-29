package com.happy.controller.exception;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.servlet.HandlerExceptionResolver;
import org.springframework.web.servlet.ModelAndView;

import com.alibaba.fastjson.support.spring.FastJsonJsonView;
import com.happy.business.common.exception.BusinessException;


/**
 * 异常处理
 * 
 * @author：zyl
 * @since：2017年6月29日 下 午10:37:52
 * @version:
 */
public class DefaultExceptionHandler implements HandlerExceptionResolver {

	/**
	 * 日志工具类
	 */
	private static final Logger LOGGER = LoggerFactory.getLogger(DefaultExceptionHandler.class);

	@Override
	public ModelAndView resolveException(HttpServletRequest arg0, HttpServletResponse arg1,
			Object arg2, Exception ex) {
		Map<String, Object> attributes = new HashMap<String, Object>();
		if (ex instanceof BusinessException) {
			BusinessException jex = (BusinessException) ex;
			attributes.put("code", jex.getCode());
			attributes.put("msg", jex.getMessage());
			LOGGER.error("异常:" + jex.getMessage());
		} else if (ex.getCause() instanceof BusinessException) {
			BusinessException jex = (BusinessException) ex.getCause();
			attributes.put("code", jex.getCode());
			attributes.put("msg", jex.getMessage());
			LOGGER.error("异常:" + jex.getMessage());
		} else {
			attributes.put("code", "9999");
			attributes.put("msg", "系统异常:" + ex.getMessage());
			LOGGER.error("异常:", ex);
		}
		ModelAndView mv = new ModelAndView();
		/* 使用FastJson提供的FastJsonJsonView视图返回，不需要捕获异常 */
		FastJsonJsonView view = new FastJsonJsonView();
		view.setAttributesMap(attributes);
		mv.setView(view);
		return mv;
	}

}
