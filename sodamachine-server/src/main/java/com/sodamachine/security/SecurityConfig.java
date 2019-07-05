package com.sodamachine.security;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.Environment;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
@EnableWebSecurity
@Configuration
public class SecurityConfig extends WebSecurityConfigurerAdapter {
	private static final Logger logger = LoggerFactory.getLogger(SecurityConfig.class);
   
	@Autowired
	private Environment env;
	
	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		logger.info("configure()::AuthenticationManagerBuilder::"+env.getProperty("auth.user")+" "+env.getProperty("auth.password"));
		auth.inMemoryAuthentication().withUser(env.getProperty("auth.user")).password(env.getProperty("auth.password")).roles("USER");
	}
	
	@Override
    protected void configure(HttpSecurity http) throws Exception {
		logger.info("configure()::HttpSecurity");
    	http.csrf().disable();
        http.authorizeRequests().antMatchers("/").permitAll();
        //http.httpBasic().and().authorizeRequests().antMatchers("/**").hasRole("USER").and().csrf().disable().headers().frameOptions().disable();
    }
}
