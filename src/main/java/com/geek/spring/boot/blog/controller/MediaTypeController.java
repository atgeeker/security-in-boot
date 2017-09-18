package com.geek.spring.boot.blog.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.geek.spring.boot.blog.domain.User;

/**
 * Media Type 控制器.
 * 
 * @author zhuyangyong
 * @date 2017年2月24日
 */
@RestController
public class MediaTypeController {

	/**
	 * 根据客户端请求的 Content-Type，响应相应的 UserVO 类型.
	 * 
	 * @return
	 */
	@RequestMapping("/user")
	public User getUser() {
		return new User("geek", 30);
	}

}
