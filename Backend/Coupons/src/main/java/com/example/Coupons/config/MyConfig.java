package com.example.Coupons.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

@Configuration
@EnableWebSecurity
public class MyConfig extends WebSecurityConfigurerAdapter{

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.cors();
        http
        .csrf().disable()
        .authorizeRequests().antMatchers("/**").permitAll()
        .anyRequest()
        .authenticated()
        .and()
        .formLogin();
    }
	
//	  @Bean public WebMvcConfigurer corsConfigurer() { return new
//	  WebMvcConfigurerAdapter() {
//	  
//	  @Override public void addCorsMappings(CorsRegistry registry) {
//	  registry.addMapping("/**") .allowedMethods("HEAD", "GET", "PUT", "POST",
//	  "DELETE", "PATCH"); } }; }
	 

    
    
}