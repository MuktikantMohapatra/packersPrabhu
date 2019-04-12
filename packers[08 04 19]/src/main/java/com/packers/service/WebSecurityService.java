package com.packers.service;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@Configuration
@EnableWebSecurity
public class WebSecurityService extends WebSecurityConfigurerAdapter {
	
	/*  @Autowired DataSource dataSource;
	  
	  @Autowired
	  private UserDetailsService userDetailsService;*/
	/* @Autowired public void configAuthentication(AuthenticationManagerBuilder
	  auth) throws Exception { auth.jdbcAuthentication().dataSource(dataSource);
	  
	 }*/
	 
	/*  @Override public void configure(WebSecurity web) throws Exception {
	 web.ignoring().antMatchers("/resources/**"); }*/
	

	@Bean(name = "encoder")
	public BCryptPasswordEncoder bcryptPasswordEncoder() {
		return new BCryptPasswordEncoder();
	}

	@Override
	protected void configure(HttpSecurity http) throws Exception {
		// http.authorizeRequests().anyRequest().authenticated().and().formLogin().loginPage("/login").loginProcessingUrl("/login").permitAll().and().logout().permitAll();
		// http.authorizeRequests().anyRequest().authenticated().antMatchers("/","/showRegister").permitAll();
		/*
		 * http.authorizeRequests().antMatchers("/","/packers/","/login","/login/*",
		 * "/index", "/registerUser","/showRegister")
		 * .permitAll().anyRequest().authenticated().and().csrf().disable();
		 * 
		 * http.authorizeRequests().antMatchers("/admin/dashBoard",
		 * "/admin/dashBoard/*").hasAnyAuthority("ADMIN")
		 * .anyRequest().authenticated().and().csrf().disable();
		 */

		http.authorizeRequests()
				.antMatchers("/", "/packers/", "/login", "/login/**", "/index", "/registerUser", "/showRegister","/index.html","/css/**", "/js/**", "/img/**","/quotation.html")
				.permitAll().antMatchers("/admin/dashBoard", "/admin/dashBoard/*").hasAnyAuthority("ADMIN").anyRequest()
				.authenticated().and().csrf().disable();
	}

	@Bean
	@Override
	public AuthenticationManager authenticationManagerBean() throws Exception {
		return super.authenticationManagerBean();
	}
	/*@Autowired
	public void configAuthentication(AuthenticationManagerBuilder auth)
	        throws Exception {
	    auth.userDetailsService(userDetailsService);

	}*/
}
