package spring4.testproject.Configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import spring4.testproject.Form.LoginForm;
import spring4.testproject.Model.Member;

@Configuration
public class BeanConfiguration {

    @Bean
    public LoginForm loginForm() {
        return new LoginForm();
    }
}