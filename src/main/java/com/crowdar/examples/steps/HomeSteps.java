package com.crowdar.examples.steps;

import com.crowdar.core.PageSteps;
import com.crowdar.examples.services.HomeService;


public class HomeSteps extends PageSteps {


    @io.cucumber.java.en.Then("Page Entry Time is displayed")
    public void pageEntryTimeIsDisplayed() {
        HomeService.isTimeListPresent();
    }

}
