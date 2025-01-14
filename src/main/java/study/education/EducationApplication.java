package study.education;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@EnableAutoConfiguration
@SpringBootApplication
public class EducationApplication {
	public static void main(String[] args) {
		SpringApplication.run(EducationApplication.class, args);
	}
}