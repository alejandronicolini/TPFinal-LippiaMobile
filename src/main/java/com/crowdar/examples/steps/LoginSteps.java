package com.crowdar.examples.steps;

import com.crowdar.core.PageSteps;
import com.crowdar.examples.services.LoginService;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;


public class LoginSteps extends PageSteps {


    @io.cucumber.java.en.Given("The user is in the sign up page")
    public void theUserIsInTheSignUpPage() {
        LoginService.isViewLoadedClockify();
    }

//    @io.cucumber.java.en.When("The user input email {string}")
//    public void theUserInputEmail(String email) {
//        LoginService.inputLoginEmail(email);
//    }
//
//    @And("input password {string} in the application")
//    public void inputPasswordInTheApplication(String pass) {
//        LoginService.inputLoginPass(pass);
//    }
//
//    @And("clic in button login")
//    public void clicInButtonLogin() {
//        LoginService.clicBtnLogin();
//    }

    @Given("el usuario logueado esta en la seccion time entry")
    public void elUsuarioLogueadoEstaEnLaSeccionTimeEntry() {
        LoginService.inputLoginData("nicolinialejandro@gmail.com", "ale130985");
    }

    @When("The user input email {string} and password {string} in the application")
    public void inputEmailAndPassword(String email, String pass) {
        LoginService.inputLoginData(email, pass);
    }
}
