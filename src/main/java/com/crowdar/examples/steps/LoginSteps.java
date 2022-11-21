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

    @Given("El usuario esta en la pagina LogIn")
    public void usuarioEnSignUp() {
        LoginService.checkSeccionLogin();
    }

    @And("La App muestra la pagina de Login")
    public void verPaginaLogin() {
        LoginService.checkSeccionLogin();
    }

    @Given("El usuario logueado esta en la seccion time entry")
    public void usuarioHaceLogin() {
        LoginService.hacerLogin(mail, password);
    }

    @When("Ingresa un email valido")
    public void ingresoEmailValido() {
        LoginService.inputLoginEmail(mail);
    }

    @And("Ingresa un password valido en la aplicacion")
    public void ingresoPasswordValido() {
        LoginService.inputLoginPass(password);
    }

    @And("Click en button login")
    public void clicBtnLogin() {
        LoginService.clicBtnLogin();
    }

    @And("Elige el menu opciones")
    public void eligeElMenuOpciones() {
        HomeService.clicMenuOpciones();
    }

    @When("Click en la opcion Log-Out")
    public void clicOpcionLogOut() {
        HomeService.clicOpcionLogOut();
    }

    @Then("Confirma la accion")
    public void confirmaLaAccion() {
        HomeService.clicConfirmacion();
    }

    @And("AFTER TEST: logout")
    public void afterTESTLogout() {
        LoginService.hacerLogOut();
    }

}
