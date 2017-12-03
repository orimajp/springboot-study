package com.example.restjsonstatustest;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.access.AccessDeniedException;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.web.AuthenticationEntryPoint;
import org.springframework.security.web.access.AccessDeniedHandler;
import org.springframework.security.web.access.AccessDeniedHandlerImpl;
import org.springframework.security.web.csrf.MissingCsrfTokenException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.logging.Logger;

/*
 * https://www.slideshare.net/navekazu/spring-bootweb-55470364
 * http://progmemo.wp.xdomain.jp/archives/858
 */
@Configuration
@EnableWebSecurity
@EnableGlobalMethodSecurity(prePostEnabled = true, securedEnabled = true)
public class SecurityConfig extends WebSecurityConfigurerAdapter {

	private final Logger logger = Logger.getLogger(getClass().getName());

	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http.authorizeRequests()
				.anyRequest().authenticated();

		http.formLogin()
				.loginPage("/login")
				.usernameParameter("username")
				.passwordParameter("password")
				.permitAll();

		http.exceptionHandling()
				.authenticationEntryPoint(authenticationEntryPoint())
				.accessDeniedHandler(accessDeniedHandler());
	}

	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		auth.inMemoryAuthentication()
				.withUser("user").password("pass").roles("USER").and()
				.withUser("admin").password("pass").roles("USER", "ADMIN");
	}

	@Bean
	AuthenticationEntryPoint authenticationEntryPoint() {
		return new SessionExpiredDetectingLoginUrlAuthenticationEntryPoint("/login");
	}

	/**
	 * タイムアウト如ルCSRFトークン消失対応
	 *
	 * @return AccessDeniedHandler
	 */
	@Bean
	AccessDeniedHandler accessDeniedHandler() {
		return new AccessDeniedHandler() {
			@Override
			public void handle(HttpServletRequest request, HttpServletResponse response, AccessDeniedException accessDeniedException)
					throws IOException, ServletException {
				if (accessDeniedException instanceof MissingCsrfTokenException) {
					logger.warning("CSRFトークンが無効");
					authenticationEntryPoint().commence(request, response, null);
				} else {
					new AccessDeniedHandlerImpl().handle(request, response, accessDeniedException);
				}
			}
		};
	}

}
