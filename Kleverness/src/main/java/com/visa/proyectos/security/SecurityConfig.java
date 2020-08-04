package com.visa.proyectos.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import com.visa.proyectos.security.service.UsuarioService;


@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter{
	@Autowired
	private UsuarioService userDetailsService;
	@Autowired
	private BCryptPasswordEncoder bcryp;

	@Bean
	public BCryptPasswordEncoder paswordEncoder() {

		BCryptPasswordEncoder bcry = new BCryptPasswordEncoder();
		return bcry;
	}
	
	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		auth.userDetailsService(userDetailsService).passwordEncoder(bcryp);
		
	}
	@Override
	protected void configure(HttpSecurity http) throws Exception {
		
		http.httpBasic().and().authorizeRequests().antMatchers(HttpMethod.GET, "/hubs","/divices")
		.hasRole("ADMIN").antMatchers(HttpMethod.POST, "/hubs","/divices").hasRole("ADMIN").anyRequest()
		.authenticated().and().csrf().disable();
		
	}

}
