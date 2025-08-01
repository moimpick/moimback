package org.jpetto.moimback;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@EnableJpaAuditing
@RestController
public class MoimbackApplication {

	public static void main(String[] args) {
		SpringApplication.run(MoimbackApplication.class, args);
	}

	@GetMapping("/api/test")
	public String moimback() {
		return "Moimback api 테스트";
	}
}
