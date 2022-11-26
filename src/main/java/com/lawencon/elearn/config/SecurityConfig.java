package com.lawencon.elearn.config;

import java.util.ArrayList;
import java.util.List;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityCustomizer;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;
import org.springframework.security.web.util.matcher.RequestMatcher;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import com.lawencon.elearn.filter.AuthorizationFilter;
import com.lawencon.elearn.service.impl.UserServiceImpl;

@Configuration
public class SecurityConfig {
	
	@Bean
	public AuthenticationManager authManager(HttpSecurity http, PasswordEncoder pwd, UserServiceImpl userService) throws Exception{
		return http.getSharedObject(AuthenticationManagerBuilder.class).userDetailsService(userService).passwordEncoder(pwd).and().build();
	}
	
	@Bean
	public List<RequestMatcher> matchers(){
		final List<RequestMatcher> matchers = new ArrayList<>();
		matchers.add(new AntPathRequestMatcher("/swagger-ui/**", HttpMethod.GET.name()));
		matchers.add(new AntPathRequestMatcher("/v3/**", HttpMethod.GET.name()));
		matchers.add(new AntPathRequestMatcher("/login/**", HttpMethod.POST.name()));
		matchers.add(new AntPathRequestMatcher("/files/download/**", HttpMethod.GET.name()));
//		matchers.add(new AntPathRequestMatcher("/**", HttpMethod.POST.name()));
//		matchers.add(new AntPathRequestMatcher("/users/**", HttpMethod.POST.name()));
//		matchers.add(new AntPathRequestMatcher("/users/**", HttpMethod.PUT.name()));
		return matchers;
	}
	
	@Bean
	public WebSecurityCustomizer customizer() {
		return web -> matchers().forEach(r -> web.ignoring().requestMatchers(r));
	}
	
	@Bean
	public SecurityFilterChain filterChain(HttpSecurity http, AuthorizationFilter auth) throws Exception{
		http.cors();
		http.csrf().disable();
		http.addFilterAt(auth, UsernamePasswordAuthenticationFilter.class);
		return http.build();
	}
	
	@Bean
	public WebMvcConfigurer webMvcConfigurer() {
		return new WebMvcConfigurer() {
			public void addCorsMappings(CorsRegistry registry) {
				registry.addMapping("/**").allowedOrigins("http://localhost:4200").allowedMethods(HttpMethod.GET.toString(),HttpMethod.POST.toString(),HttpMethod.PUT.toString(),HttpMethod.DELETE.toString());
				WebMvcConfigurer.super.addCorsMappings(registry);
			}
		};
	}
}
