package com.example.flywayh2dbmysqlmodetrouble;

import org.seasar.doma.Dao;
import org.seasar.doma.Select;
import org.seasar.doma.boot.ConfigAutowireable;

import java.util.List;

@Dao
@ConfigAutowireable
public interface GreetingDao {

	@Select
	Greeting selectById(Integer id);

	@Select
	List<Greeting> selectAll();

}
