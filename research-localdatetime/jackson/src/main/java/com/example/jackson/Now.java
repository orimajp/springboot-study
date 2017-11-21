package com.example.jackson;

import com.fasterxml.jackson.annotation.JsonFormat;

import java.time.LocalDateTime;

class Now {
	private LocalDateTime defaultTime;

	@JsonFormat(pattern = "yyyy/MM/dd HH:mm:dd.ss.SSS")
	private LocalDateTime formattedTime;

	Now(LocalDateTime defaultTime, LocalDateTime formattedTime) {
		this.defaultTime = defaultTime;
		this.formattedTime = formattedTime;
	}

	public LocalDateTime getDefaultTime() {
		return defaultTime;
	}

	public LocalDateTime getFormattedTime() {
		return formattedTime;
	}
}
