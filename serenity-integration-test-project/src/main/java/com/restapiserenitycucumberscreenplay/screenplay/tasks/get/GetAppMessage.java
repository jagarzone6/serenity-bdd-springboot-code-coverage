package com.restapiserenitycucumberscreenplay.screenplay.tasks.get;

import io.restassured.RestAssured;
import io.restassured.specification.RequestSpecification;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.rest.interactions.Get;
import net.serenitybdd.screenplay.rest.questions.RestQueryFunction;

import static net.serenitybdd.screenplay.Tasks.instrumented;


public class GetAppMessage implements Task {

    public static GetAppMessage fromAPI() {
        return instrumented(GetAppMessage.class);
    }

    @Override
    public <T extends Actor> void performAs(T theActor) {
        theActor.attemptsTo(Get.resource("/"));
    }
}
