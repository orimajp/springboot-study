package com.example.restjsonstatustest;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.AccessDeniedException;
import org.springframework.web.bind.MissingServletRequestParameterException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.method.annotation.MethodArgumentTypeMismatchException;

import java.util.HashMap;
import java.util.Map;
import java.util.logging.Logger;

@ControllerAdvice(annotations = {RestController.class})
public class RestExceptionHandler {

	private final Logger logger = Logger.getLogger(getClass().getName());

	@ResponseStatus(HttpStatus.BAD_REQUEST)
	@ExceptionHandler({MethodArgumentTypeMismatchException.class})
	@ResponseBody
	public Map<String, Object> methodArgumentTypeMismatchExceptionErrorHandler(MethodArgumentTypeMismatchException e) {
		logger.warning("エラー：" + e.getMessage());
		final Map<String, Object> errorMap = new HashMap<>();
		errorMap.put("message", "パラメータのデータ型が正しくありません");
		errorMap.put("status", HttpStatus.BAD_REQUEST);
		return errorMap;
	}

	@ResponseStatus(HttpStatus.BAD_REQUEST)
	@ExceptionHandler({MissingServletRequestParameterException.class})
	@ResponseBody
	public Map<String, Object> issingServletRequestParameterExceptionErrorHandler(MissingServletRequestParameterException e) {
		logger.warning("エラー：" + e.getMessage());
		final Map<String, Object> errorMap = new HashMap<>();
		errorMap.put("message", "必須パラメータが指定されていません");
		errorMap.put("status", HttpStatus.BAD_REQUEST);
		return errorMap;
	}

	@ResponseStatus(HttpStatus.FORBIDDEN)
	@ExceptionHandler({AccessDeniedException.class})
	@ResponseBody
	public Map<String, Object> accessDeniedExceptionErrorHandler(AccessDeniedException e) {
		logger.warning("エラー：" + e.getMessage());
		final Map<String, Object> errorMap = new HashMap<>();
		errorMap.put("message", "認可されないアクセスです");
		errorMap.put("status", HttpStatus.FORBIDDEN);
		return errorMap;
	}


	@ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
	@ExceptionHandler({Exception.class})
	@ResponseBody
	public Map<String, Object> exceptionErrorHandler(Exception e) {
		logger.warning("エラー：" + e.getMessage());
		final Map<String, Object> errorMap = new HashMap<>();
		errorMap.put("message", "サーバエラーです");
		errorMap.put("status", HttpStatus.INTERNAL_SERVER_ERROR);
		return errorMap;
	}

/*	@ExceptionHandler({Exception.class})
	@ResponseBody
	public ResponseEntity exceptionErrorHandler(Exception e) {
		if (e.getCause() instanceof AccessDeniedException) {
			logger.warning("エラー：" + e.getMessage());
			final Map<String, Object> errorMap = new HashMap<>();
			errorMap.put("message", "認可エラーです");
			errorMap.put("status", HttpStatus.FORBIDDEN);
			return ResponseEntity.status(HttpStatus.FORBIDDEN).body(errorMap);
		}
		logger.warning("エラー：" + e.getMessage());
		final Map<String, Object> errorMap = new HashMap<>();
		errorMap.put("message", "サーバエラーです");
		errorMap.put("status", HttpStatus.INTERNAL_SERVER_ERROR);
		return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(errorMap);
	}*/

}
