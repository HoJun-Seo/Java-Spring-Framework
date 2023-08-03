package spring4.testproject.Bean;

import jakarta.annotation.PostConstruct;
import jakarta.annotation.PreDestroy;

public class BeanTest {

    @PostConstruct
    public void initMethod() {
        System.out.println("init-method 실행");
    }

    @PreDestroy
    public void destroyMethod() {
        System.out.println("destroy-method 실행");
    }
}