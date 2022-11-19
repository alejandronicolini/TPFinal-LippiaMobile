package com.crowdar.examples.steps;

import com.crowdar.core.PageSteps;
import com.crowdar.examples.services.HomeService;
import com.crowdar.examples.services.LoginService;
import io.cucumber.java.en.And;
import io.cucumber.java.en.When;
import io.cucumber.java.en.Then;

public class HomeSteps extends PageSteps {


    @Then("Page Entry Time is displayed")
    public void pageEntryTimeIsDisplayed() {
        HomeService.isTimeListPresent();
        LoginService.doLogOut();
    }


    @When("Click en la opcion Settings")
    public void clickEnLaOpcionSettings() {
        HomeService.clickOpcionSettings();
    }

    @And("Clic en el boton DarkMode")
    public void clicEnElBotonDarkMode() {
        HomeService.clickDarkMode();
    }

    @Then("La App cambia su color")
    public void laAppCambiaSuColor() {
        HomeService.checkAppColor();
        HomeService.clickDarkMode();
        LoginService.doLogOut();
    }

}
