package com.example.multiprocesstest;

import lombok.Data;
import org.seasar.doma.Entity;
import org.seasar.doma.Id;

@Data
@Entity
public class ProcessStatus {

	@Id
	private Integer id;

	private Boolean complate;

}
