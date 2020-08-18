package com.example.cucumber.utils.spring;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Import;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component
@Scope(value = ConfigurableBeanFactory.SCOPE_SINGLETON)
@Import(RunSpringBootApp.class)
public class AppRunnerManager {

    @Autowired(required=false)
    RunSpringBootApp runSpringBootApp;

    public AppRunnerManager(){
        System.out.println("Init AppRunnerControl");
    }
}
