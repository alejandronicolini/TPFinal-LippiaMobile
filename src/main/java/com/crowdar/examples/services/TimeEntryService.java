package com.crowdar.examples.services;

import com.crowdar.core.actions.MobileActionManager;
import com.crowdar.examples.constants.TimesEntryConstants;
import org.testng.Assert;


public class TimeEntryService {

    public static void addEntry() {
        MobileActionManager.click(TimesEntryConstants.BTN_ADD_ENTRY);
        MobileActionManager.waitVisibility(TimesEntryConstants.DIV_SECTION_HORARIO);
    }

    public static void clicOnLabelStart() {
        MobileActionManager.click(TimesEntryConstants.LABEL_START);
    }

    public static void clicOnSomeDay() {
        MobileActionManager.click(TimesEntryConstants.PICKER_DAY);
    }

    public static void setHorarioInicio(String hora, String min) {
        MobileActionManager.click(TimesEntryConstants.BTN_START);
        inputHorario(hora, min);
    }

    public static void setHorarioFin(String hora, String min) {
        MobileActionManager.click(TimesEntryConstants.BTN_END);
        inputHorario(hora, min);
    }

    private static void inputHorario(String hora, String min) {
        MobileActionManager.click(TimesEntryConstants.INPUT_HORA);
        for (int i = 0; i < 2; i++) {   //es necesario repetir el input para que tome el valor
            MobileActionManager.setInput(TimesEntryConstants.INPUT_HORA, hora);
        }
        MobileActionManager.click(TimesEntryConstants.INPUT_MIN);
        for (int i = 0; i < 2; i++) {   //es necesario repetir el input para que tome el valor
            MobileActionManager.setInput(TimesEntryConstants.INPUT_MIN, min);
        }
    }

    public static void setNombreTarea(String tarea) {
        MobileActionManager.waitVisibility(TimesEntryConstants.INPUT_WORKING_ON);
        MobileActionManager.setInput(TimesEntryConstants.INPUT_WORKING_ON, tarea, true, false);
    }

    public static void selectProject() {
        MobileActionManager.click(TimesEntryConstants.SECTION_PROJECT);
        MobileActionManager.click(TimesEntryConstants.PROJECT);
    }

    public static void verifyViewSectionTimeEntry() {
        MobileActionManager.waitVisibility(TimesEntryConstants.TITLE_TIME_ENTRY);
        Assert.assertTrue(MobileActionManager.isVisible(TimesEntryConstants.TITLE_TIME_ENTRY), "la seccion Time Entry no esta visible");
    }

    public static void verifyNewEntry(String nombre) {
        String contenido = MobileActionManager.getText(TimesEntryConstants.TITLE_TASK);
        Assert.assertTrue(contenido.contains(nombre), "el proyecto no esta presente en el listado");
    }

    public static void clicOnBtnSave() {
        MobileActionManager.click(TimesEntryConstants.BTN_SAVE);
    }

}
