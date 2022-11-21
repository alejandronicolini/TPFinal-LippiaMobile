package com.crowdar.examples.steps;

import com.crowdar.core.PageSteps;
import com.crowdar.examples.services.LoginService;
import com.crowdar.examples.services.TimeEntryService;
import com.crowdar.examples.services.TpUtils;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;


public class TimeEntrySteps extends PageSteps {


    @When("Agrega una entrada")
    public void agregaEntrada() {
        TimeEntryService.clicBtnAgregarEntrada();
    }

    @And("ingresa a Time Range")
    public void inToTimeRange() {
        TimeEntryService.clicTagStart();
    }

    @And("selecciona el dia {string}-{string}-{string}")
    public void seleccionaElDia(String dia, String mes, String anio) {
        TimeEntryService.elegirDia(dia, mes, anio);
    }

    @And("ingresa un horario de inicio: {string} : {string}")
    public void setHorarioInicio(String hora, String min) {
        TimeEntryService.setHorarioInicio(hora, min);
    }

    @And("de finalizacion: {string} : {string}")
    public void setHorarioFinalizacion(String hora, String min) {
        TimeEntryService.setHorarioFin(hora, min);
    }

    @And("ingresa las horas trabajadas: {string}:{string}")
    public void ingresaLasHorasTrabajadas(String hora, String min) {
        TimeEntryService.setHorasTrabajadas(hora, min);
    }

    @And("clic en boton save")
    public void clicEnBotonSave() {
        TimeEntryService.clicBtnSave();
    }

    @And("ingresa un nombre de tarea: {string}")
    public void ingresaUnNombreDeTarea(String tarea) {
        TimeEntryService.setNombreTarea(tarea);
    }

    @And("selecciona el primer proyecto")
    public void seleccionaPrimerProyecto() {
        TimeEntryService.elegirPrimerProyecto();
    }

    @And("confirma la tarea")
    public void confirmaLaTarea() {
        TimeEntryService.clicBtnSave();
    }

    @Then("redirige a la seccion time entry")
    public void redirigeALaSeccionTimeEntry() {
        TimeEntryService.checkVistaSeccionTimeEntry();
    }

    @And("aparece la entrada creada")
    public void apareceLaEntradaCreada() {
        TimeEntryService.checkNuevaEntrada();
    }

    @And("cancela la tarea y vuelve a la seccion time entry")
    public void cancelaLaTareaYVuelveALaSeccionTimeEntry() {
        TimeEntryService.cancelarEntrada();
        TimeEntryService.clickBtnVolverATimeEntry();
    }

    @Then("la entrada no queda registrada")
    public void laEntradaNoQuedaRegistrada() {
        TimeEntryService.checkAnulacion();
    }

    @And("AFTER TEST: eliminar tarea - logout")
    public void afterTESTEliminarTareaLogout() {
        TimeEntryService.eliminarTarea();
        LoginService.hacerLogOut();
    }



}
