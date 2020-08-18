package com.example.cucumber.hooks;

import com.example.cucumber.utils.spring.AppRunnerManager;
import io.cucumber.java.Before;
import net.serenitybdd.junit.spring.integration.SpringIntegrationMethodRule;
import net.serenitybdd.screenplay.actors.Cast;
import net.serenitybdd.screenplay.actors.OnStage;
import net.serenitybdd.screenplay.rest.abilities.CallAnApi;
import org.junit.ClassRule;
import org.junit.Rule;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Import;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.rules.SpringClassRule;

@ContextConfiguration
@Import(AppRunnerManager.class)
public class Hooks {

    @Rule
    public SpringIntegrationMethodRule springIntegrationMethodRule =
            new SpringIntegrationMethodRule();

    @ClassRule
    public static final SpringClassRule SPRING_CLASS_RULE = new SpringClassRule();

    @Autowired
    AppRunnerManager appRunnerManager;

    @Before
    public void setStage() {
        String theRestApiBaseUrl = "http://localhost";
        Cast cast = new Cast();
        cast.actorNamed("Javi",CallAnApi.at(theRestApiBaseUrl));
        OnStage.setTheStage(cast);
        OnStage.theActor("Javi").entersTheScene();
    }
}
