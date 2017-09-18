package com.geek.spring.boot.blog.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

/**
 * 安全配置类
 * @author zhuyangyong
 * @date 2017年9月18日 下午4:32:12
 */
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {

	/**
	 * 自定义配置
	 * @param http
	 * @throws Exception
	 */
	public void config(HttpSecurity http) throws Exception{
		http.authorizeRequests()
			.antMatchers("/css/**","/js/**","/fonts/**","/index").permitAll()	//放行
			.antMatchers("/users/**").hasRole("ADMIN")	//需要相应的角色才能访问
			.and()
			.formLogin()	//基于Form表单登录验证
			.loginPage("/login").failureUrl("/login-error");	//自定义登录界面
	}
	
	/**
	 * 认证信息管理
	 * @param auth
	 * @throws Exception
	 */
	@Autowired
	public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {
		auth.inMemoryAuthentication()	//认证信息存储于内存中
			.withUser("zhuyangyong").password("123456").roles("ADMIN");
	}
}
