package com.crowdar.examples.steps;

import com.crowdar.core.PageSteps;
import com.crowdar.examples.services.TimeEntryService;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;


public class TimeEntrySteps extends PageSteps {


    @When("agrega una entrada")
    public void addAnEntry() {
        TimeEntryService.addEntry();
    }

    @And("ingresa a Time Range")
    public void inToTimeRange() {
        TimeEntryService.clicOnLabelStart();
    }

    @And("selecciona el dia {string} de {string} de {string}")
    public void seleccionaElDiaDeDe(String dia, String mes, String anio) {
        TimeEntryService.clicOnSomeDay(dia, mes, anio);
    }

    @And("ingresa un horario de inicio: {string} : {string}")
    public void setHorarioInicio(String hora, String min) {
        TimeEntryService.setHorarioInicio(hora, min);
    }

    @And("de finalizacion: {string} : {string}")
    public void setHorarioFinalizacion(String hora, String min) {
        TimeEntryService.setHorarioFin(hora, min);
    }

    @And("clic en boton save")
    public void clicEnBotonSave() {
        TimeEntryService.clicOnBtnSave();
    }

    @And("ingresa un nombre de tarea: {string}")
    public void ingresaUnNombreDeTarea(String tarea) {
        TimeEntryService.setNombreTarea(tarea);
    }

    @And("selecciona el primer proyecto")
    public void seleccionaPrimerProyecto() {
        TimeEntryService.selectProject();
    }

    @And("confirma la tarea")
    public void confirmaLaTarea() {
        TimeEntryService.clicOnBtnSave();
    }

    @Then("redirige a la seccion time entry")
    public void redirigeALaSeccionTimeEntry() {
        TimeEntryService.verifyViewSectionTimeEntry();
    }

    @And("aparece la entrada creada: {string}")
    public void apareceLaEntradaCreada(String nombre) {
        TimeEntryService.verifyNewEntry(nombre);
    }


}
