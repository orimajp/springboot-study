package com.example.restjsonstatustest;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class TestController {

	// 正常系(POST/GET共用)
	@RequestMapping(value = "/okrequest")
	public String okRequest() {
		return "result";
	}

	// パラメータエラー
	@RequestMapping(value = "/paramcheck", method = RequestMethod.GET)
	public String missMatchParameter(@RequestParam Integer value) {
		return "result";
	}

	// Internal Server Error
	@RequestMapping(value = "/internalservererror", method = RequestMethod.GET)
	public String internalServerError(Model model) {
		if (model != null) {
			throw new IllegalArgumentException("テストエラー");
		}
		return "result";
	}

	// 権限チェック用
	@PreAuthorize("hasRole('ADMIN')")
	@RequestMapping(value = "/adminonly", method = RequestMethod.GET)
	public String adminOnly() {
		return "result";
	}

}
