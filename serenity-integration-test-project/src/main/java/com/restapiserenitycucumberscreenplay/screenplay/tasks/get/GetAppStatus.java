package com.restapiserenitycucumberscreenplay.screenplay.tasks.get;

import com.restapiserenitycucumberscreenplay.screenplay.model.AppStatus;
import net.serenitybdd.rest.SerenityRest;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.rest.interactions.Get;

import static net.serenitybdd.screenplay.Tasks.instrumented;


public class GetAppStatus implements Task {

    private static AppStatus appStatus;

    public static GetAppStatus fromAPI() {
        return instrumented(GetAppStatus.class);
    }

    public static Question<String> getStatus(){
        return actor -> appStatus.status;
    }

    @Override
    public <T extends Actor> void performAs(T theActor) {
        theActor.attemptsTo(Get.resource("/actuator/health"));
        appStatus = SerenityRest.lastResponse().jsonPath().getObject("", AppStatus.class);
    }
}
