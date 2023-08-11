package spring4.testproject.Configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import spring4.testproject.Form.DeleteForm;
import spring4.testproject.Form.LoginForm;
import spring4.testproject.Form.RegisterForm;
import spring4.testproject.Form.UpdateForm;

@Configuration
public class BeanConfiguration {

    @Bean
    public LoginForm loginForm() {
        return new LoginForm();
    }

    @Bean
    public RegisterForm registerForm() {
        return new RegisterForm();
    }

    @Bean
    public UpdateForm updateForm() {
        return new UpdateForm();
    }

    @Bean
    public DeleteForm deleteForm() {
        return new DeleteForm();
    }
}