package com.example.jackson;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.converter.json.Jackson2ObjectMapperBuilder;

@Configuration
public class JacksonConfig {

	@Bean
	public Jackson2ObjectMapperBuilder objectMapperBuilder() {
		final Jackson2ObjectMapperBuilder objectMapperBuilder = new Jackson2ObjectMapperBuilder() {

			@Override
			public void configure(ObjectMapper objectMapper) {
				super.configure(objectMapper);
				objectMapper.configure(SerializationFeature.WRITE_DATES_AS_TIMESTAMPS, false);
			}
		};

		// TODO ここにJackson2ObjectMapperBuilderの設定が必要であれば追加

		return objectMapperBuilder;
	}

	/*
	 * 以下のページにあるシリアライザ/デシリアライザの指定によるデフォルト書式設定は効かなくなっている？
	 * https://qiita.com/tag1216/items/25a64bba2bde98ea88d3
	 * application.propertiesかJavaConfigでWRITE_DATES_AS_TIMESTAMPSをfalseにするとLocalDateTimeなどが配列表現になることは防げる模様。
	 */

}
