package com.crowdar.examples.steps;

import com.crowdar.core.PageSteps;
import com.crowdar.core.PropertyManager;
import com.crowdar.examples.services.HomeService;
import com.crowdar.examples.services.LoginService;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;


public class LoginSteps extends PageSteps {

    private final String mail = PropertyManager.getProperty("user_email");
    private final String password = PropertyManager.getProperty("user_pass");

    @Given("The user is in the sign up page")
    public void theUserIsInTheSignUpPage() {
        LoginService.isViewLoadedClockify();
    }

    @When("The user input valid email")
    public void theUserInputEmail() {
        LoginService.inputLoginEmail(mail);
    }

    @And("input valid password in the application")
    public void inputPasswordInTheApplication() {
        LoginService.inputLoginPass(password);
    }

    @And("clic in button login")
    public void clicInButtonLogin() {
        LoginService.clicBtnLogin();
    }

    @Given("el usuario logueado esta en la seccion time entry")
    public void userDoLogin() {
        LoginService.doLogin(mail, password);
    }

    @Given("El usuario esta en la Home Page")
    public void elUsuarioEstaEnLaHomePage() {
        LoginService.doLogin(mail, password);
    }

    @And("Elige el menu opciones")
    public void eligeElMenuOpciones() {
        HomeService.clickMenuOpciones();
    }

    @When("Click en la opcion Log-Out")
    public void clickEnLaOpcionLogOut() {
        HomeService.clickOpcionLogOut();
    }

    @Then("Confirma la accion")
    public void confirmaLaAccion() {
        HomeService.clickConfirmacion();
    }

    @And("La App muestra la pagina de Login")
    public void laAppMuestraLaPaginaDeLogin() {
        LoginService.verificacionBtnLogin();
    }

}
