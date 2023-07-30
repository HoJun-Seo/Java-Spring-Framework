package spring4.testproject;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;

// @Configuration
@Component
public class TranspotationWalk {

    // @Bean
    // public TranspotationWalk setTranspotationWalk() {
    // return new TranspotationWalk();
    // }

    public void move() {
        System.out.println("도보로 이동합니다.");
    }
}
