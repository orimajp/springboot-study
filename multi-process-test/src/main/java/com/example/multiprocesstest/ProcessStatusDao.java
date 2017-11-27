package com.example.multiprocesstest;

import org.seasar.doma.Dao;
import org.seasar.doma.Delete;
import org.seasar.doma.Insert;
import org.seasar.doma.Select;
import org.seasar.doma.Update;
import org.seasar.doma.boot.ConfigAutowireable;

import java.util.List;

@Dao
@ConfigAutowireable
public interface ProcessStatusDao {

	@Select
	ProcessStatus selectById(Integer id);

	@Select
	List<ProcessStatus> selectAll();

	@Insert
	int insert(ProcessStatus processStatus);

	@Update
	int update(ProcessStatus processStatus);

	@Delete
	int delete(ProcessStatus processStatus);

}
