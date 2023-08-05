package spring4.testproject;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.AbstractApplicationContext;
import spring4.testproject.Configuration.BeanTestctx;

@SpringBootApplication
public class TestprojectApplication {

	// private static TranspotationWalk transpotationWalk;

	// @Autowired
	// public TestprojectApplication(TranspotationWalk transpotationWalk) {
	// this.transpotationWalk = transpotationWalk;
	// }

	// @Autowired
	// public void setTranspotationWalk(TranspotationWalk transpotationWalk) {
	// this.transpotationWalk = transpotationWalk;
	// }

	public static void main(String[] args) throws Exception {
		SpringApplication.run(TestprojectApplication.class, args);

		// transpotationWalk.move();
		System.out.println("ctx 객체 생성");
		AbstractApplicationContext ctx = new AnnotationConfigApplicationContext(BeanTestctx.class);
	}
}