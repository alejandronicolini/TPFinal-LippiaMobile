package com.crowdar.examples.steps;

import com.crowdar.core.PageSteps;
import com.crowdar.examples.constants.HomeConstants;
import com.crowdar.examples.services.HomeService;
import com.crowdar.examples.services.LoginService;
import io.cucumber.java.en.And;
import io.cucumber.java.en.When;
import io.cucumber.java.en.Then;

public class HomeSteps extends PageSteps {


    @Then("La Seccion Entry Time es visualizada")
    public void seccionEntryTime() {
        HomeService.checkVistaListaDeEntradas();
    }

    @When("Clic en la opcion Settings")
    public void clicEnLaOpcionSettings() {
        HomeService.clicOpcionSettings();
    }

    @And("Clic en el boton DarkMode")
    public void clicBtnDarkMode() {
        HomeService.AtributosInicial(HomeConstants.BTN_DARKMODE);
        HomeService.clicBtnDarkMode();
    }

    @Then("La App cambia su color")
    public void laAppCambiaSuColor() {
        HomeService.checkCambioConfiguracion(HomeConstants.BTN_DARKMODE);
    }

    @And("Clic en el boton Show Notifications")
    public void clicEnElBotonShowNotifications() {
        HomeService.AtributosInicial(HomeConstants.BTN_SHOW_NOTIFICATIONS);
        HomeService.clicBtnShowNotifications();
    }

    @Then("La App muestra u oculta las notificaciones")
    public void laAppMuestraUOcultaLasNotificaciones() {
        HomeService.checkCambioConfiguracion(HomeConstants.BTN_SHOW_NOTIFICATIONS);
    }

    @And("AFTER TEST: restaurar color - logout")
    public void afterTESTRestaurarColorLogout() {
        HomeService.clicBtnDarkMode();
        LoginService.hacerLogOut();
    }

    @And("AFTER TEST: restaurar notificaciones - logout")
    public void afterTESTRestaurarNotificacionesLogout() {
        HomeService.clicBtnShowNotifications();
        LoginService.hacerLogOut();
    }

}
