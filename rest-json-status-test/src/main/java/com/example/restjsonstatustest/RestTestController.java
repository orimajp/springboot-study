package com.example.restjsonstatustest;

import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class RestTestController {

	// OKパターン
	@RequestMapping(value = "/ok", method = RequestMethod.POST)
	public ResponseEntity ok() {
		return ResponseEntity.ok("ok");
	}

	// GET バリデートエラー用
	@RequestMapping(value = "/valid", method = RequestMethod.GET)
	public ResponseEntity valid(@RequestParam Integer value) {
		return ResponseEntity.ok("ok");
	}

	// Internal Server Error
	@RequestMapping(value = "/servererrorrest", method = RequestMethod.GET)
	public ResponseEntity internalServerErrorRest(Model model) {
		if (model != null) {
			throw new IllegalArgumentException("テストエラー");
		}
		return ResponseEntity.ok("ok");
	}

	// 権限テスト
	@PreAuthorize("hasRole('ADMIN')")
	@RequestMapping(value = "/adminrest", method = RequestMethod.GET)
	public ResponseEntity adminOnlyRest() {
		return ResponseEntity.ok("ok");
	}

}
