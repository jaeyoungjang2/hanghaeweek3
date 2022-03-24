package com.sparta.week01;

import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.util.Date;
import java.util.TimeZone;
import javax.annotation.PostConstruct;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@EnableJpaAuditing
@SpringBootApplication
public class Week01Application {
	@PostConstruct
	public void started() {
		System.setProperty("user.timezone", "Asia/Seoul");
		TimeZone tz = TimeZone.getTimeZone("Asia/Seoul");
		TimeZone.setDefault(tz);
	}

	public static void main(String[] args) {
		SpringApplication.run(Week01Application.class, args);
	}
}
