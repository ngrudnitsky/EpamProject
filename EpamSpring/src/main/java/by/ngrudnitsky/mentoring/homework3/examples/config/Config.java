package by.ngrudnitsky.mentoring.homework3.examples.config;

import by.ngrudnitsky.mentoring.homework3.examples.bean.Head;
import by.ngrudnitsky.mentoring.homework3.examples.bean.Human;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;

@Configuration
public class Config {
    @Bean
    @Scope("prototype")
    public Human human(){
        return new Human();
    }

    @Bean
    @Scope("prototype")
    public Head head(){
        return new Head();
    }
}
