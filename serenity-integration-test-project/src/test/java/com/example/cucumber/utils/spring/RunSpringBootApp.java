package com.example.cucumber.utils.spring;

import com.example.springboot.MyApplication;
import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.context.annotation.Profile;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component
@Scope(value = ConfigurableBeanFactory.SCOPE_SINGLETON)
@Profile(value="local-it")
public class RunSpringBootApp {

    public RunSpringBootApp(){
        SpringApplication springApplication = new SpringApplication(MyApplication.class);
        springApplication.setAdditionalProfiles("stg");
        springApplication.run();
    }

}
