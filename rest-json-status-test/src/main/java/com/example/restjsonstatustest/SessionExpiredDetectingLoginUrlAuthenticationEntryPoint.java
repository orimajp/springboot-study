package com.example.restjsonstatustest;

import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.authentication.LoginUrlAuthenticationEntryPoint;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/*
 * http://progmemo.wp.xdomain.jp/archives/847
 */
public class SessionExpiredDetectingLoginUrlAuthenticationEntryPoint extends LoginUrlAuthenticationEntryPoint {

	public SessionExpiredDetectingLoginUrlAuthenticationEntryPoint(String loginFormUrl) {
		super(loginFormUrl);
	}

	/**
	 * Ajaxアクセス時対応
	 *
	 * @param request HttpServletRequest
	 * @param response HttpServletResponse
	 * @param authException AuthenticationException
	 * @throws IOException
	 * @throws ServletException
	 */
	@Override
	public void commence(HttpServletRequest request, HttpServletResponse response, AuthenticationException authException) throws IOException, ServletException {
		if ("XMLHttpRequest".equals(request.getHeader("X-Requested-With"))) {
			response.sendError(HttpServletResponse.SC_UNAUTHORIZED, "セッションは無効です");
			return;
		}
		super.commence(request, response, authException);
	}

}
