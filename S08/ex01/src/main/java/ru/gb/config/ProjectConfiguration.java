package ru.gb.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import ru.gb.aspect.LoggingAspect;

@Configuration
@ComponentScan(basePackages = "ru.gb")
@EnableAspectJAutoProxy // turns on aspects
public class ProjectConfiguration {
    @Bean
    public LoggingAspect aspectMethod(){
        return new LoggingAspect();
    }
}
