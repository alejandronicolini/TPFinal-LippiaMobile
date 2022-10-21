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

    @And("ingresa a Time Range, selecciona un dia")
    public void ingresaATimeRangeSeleccionaUnDia() {
        TimeEntryService.clicOnLabelStart();
        TimeEntryService.clicOnSomeDay();
    }

    @And("ingresa un horario de inicio: {string} : {string} y de finalizacion: {string} : {string}")
    public void setHorarioInicioYFinalizacion(String hora1, String min1, String hora2, String min2) {
        TimeEntryService.setHorarioInicio(hora1, min1);
        TimeEntryService.setHorarioFin(hora2, min2);
        TimeEntryService.clicOnBtnSave();
    }

    @And("ingresa un nombre de tarea: {string}")
    public void ingresaUnNombreDeTarea(String tarea) {
        TimeEntryService.setNombreTarea(tarea);
    }

    @And("selecciona un proyecto y confirma la tarea")
    public void seleccionaUnProyectoYConfirmaLaTarea() {
        TimeEntryService.selectProject();
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
