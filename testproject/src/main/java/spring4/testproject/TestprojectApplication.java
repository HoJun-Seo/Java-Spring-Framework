package spring4.testproject;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class TestprojectApplication {
	public static void main(String[] args) throws Exception {
		SpringApplication.run(TestprojectApplication.class, args);
		String version = org.springframework.core.SpringVersion.getVersion();
		System.out.println("version : " + version);
	}
}