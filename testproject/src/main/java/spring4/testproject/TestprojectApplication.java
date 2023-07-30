package spring4.testproject;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class TestprojectApplication {

	private static TranspotationWalk transpotationWalk;

	@Autowired
	public TestprojectApplication(TranspotationWalk transpotationWalk) {
		this.transpotationWalk = transpotationWalk;
	}

	public static void main(String[] args) {
		SpringApplication.run(TestprojectApplication.class, args);

		transpotationWalk.move();
	}
}
