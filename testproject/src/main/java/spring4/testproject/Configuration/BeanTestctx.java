package spring4.testproject.Configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import spring4.testproject.Bean.BeanTest;

@Configuration
public class BeanTestctx {

    @Bean
    public BeanTest beanTest() {
        return new BeanTest();
    }
}