package com.crowdar.examples.steps;

import com.crowdar.core.PageSteps;
import com.crowdar.core.PropertyManager;
import com.crowdar.examples.services.LoginService;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;


public class LoginSteps extends PageSteps {

    private final String mail = PropertyManager.getProperty("user_email");
    private final String password = PropertyManager.getProperty("user_pass");

    @io.cucumber.java.en.Given("The user is in the sign up page")
    public void theUserIsInTheSignUpPage() {
        LoginService.isViewLoadedClockify();
    }

    @io.cucumber.java.en.When("The user input email xxxx")
    public void theUserInputEmail() {
        LoginService.inputLoginEmail(mail);
    }

    @And("input password xxxx in the application")
    public void inputPasswordInTheApplication() {
        LoginService.inputLoginPass(password);
    }

    @And("clic in button login")
    public void clicInButtonLogin() {
        LoginService.clicBtnLogin();
    }

    @Given("el usuario logueado esta en la seccion time entry")
    public void userDoLogin() {
        LoginService.inputLoginData(mail, password);
    }


}
