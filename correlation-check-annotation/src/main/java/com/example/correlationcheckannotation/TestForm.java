package com.example.correlationcheckannotation;

import lombok.Data;

@Data
@DateCorrelationValid(startDateProperty = "startDate", endDateProperty = "endDate")
public class TestForm {

	private String startDate;

	private String endDate;

}
