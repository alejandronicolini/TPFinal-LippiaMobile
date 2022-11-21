package com.crowdar.examples.services;

import com.crowdar.core.actions.MobileActionManager;
import com.crowdar.driver.DriverManager;
import com.crowdar.examples.constants.HomeConstants;
import com.crowdar.examples.constants.TimesEntryConstants;
import io.appium.java_client.MobileBy;
import org.testng.Assert;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.HashMap;
import java.util.Map;


public class TimeEntryService extends MobileActionManager {


    public static void clicBtnAgregarEntrada() {
        click(TimesEntryConstants.BTN_ADD_ENTRY);
        waitVisibility(TimesEntryConstants.DIV_SECCION_HORARIO);
    }

    public static void clicTagStart() {
        click(TimesEntryConstants.LABEL_START);
    }

    public static void elegirDia(String dia, String mes, String anio) {   //Formato ingreso  28-11-2022
        String fecha = dia + "-" + mes + "-" + anio;
        Assert.assertTrue(validarFecha(fecha), "Fecha ingresada invalida");
        String strMes = strMesIngresado(mes);

        int anioIngresado = Integer.parseInt(anio);
        int diferenciaAnios = anioIngresado - anioActual();
        if (diferenciaAnios != 0) {
            if (diferenciaAnios > 0) {
                for (int i = 0; i < (diferenciaAnios * 12); i++) {
                    TpUtils.sleep(500);
                    click(TimesEntryConstants.BTN_NEXT_MONTH);
                }
            } else {
                for (int i = 0; i > (diferenciaAnios * 12); i--) {
                    TpUtils.sleep(1000);
                    click(TimesEntryConstants.BTN_PREVIOUS_MONTH);
                }
            }
        }

        int mesIngresado = Integer.parseInt(mes);
        int diferenciaMeses = mesIngresado - mesActual();
        if (diferenciaMeses != 0) {
            if (diferenciaMeses > 0) {
                for (int i = 0; i < diferenciaMeses; i++) {
                    TpUtils.sleep(1000);
                    click(TimesEntryConstants.BTN_NEXT_MONTH);
                }
            } else {
                for (int i = 0; i > diferenciaMeses; i--) {
                    TpUtils.sleep(1000);
                    click(TimesEntryConstants.BTN_PREVIOUS_MONTH);
                }
            }
        }

        String fechaElegida = String.format("ACCESSIBILITY_ID:%s %s %s", dia, strMes, anio);
        click(fechaElegida);
    }

    public static boolean validarFecha(String date) {
        String DATE_FORMAT = "dd-MM-yyyy";
        try {
            DateFormat df = new SimpleDateFormat(DATE_FORMAT);
            df.setLenient(false);
            df.parse(date);
            return true;
        } catch (ParseException e) {
            return false;
        }
    }

    public static String strMesIngresado(String mes) {
        Map<String, String> listaMeses = new HashMap<String, String>();
        listaMeses.put("01", "January");
        listaMeses.put("02", "February");
        listaMeses.put("03", "March");
        listaMeses.put("04", "April");
        listaMeses.put("05", "May");
        listaMeses.put("06", "June");
        listaMeses.put("07", "July");
        listaMeses.put("08", "August");
        listaMeses.put("09", "September");
        listaMeses.put("10", "October");
        listaMeses.put("11", "November");
        listaMeses.put("12", "December");
        return listaMeses.get(mes);
    }

    public static int anioActual() {
        LocalDate localDate = LocalDate.now();
        return localDate.getYear();
    }

    public static int mesActual() {
        LocalDate localDate = LocalDate.now();
        return localDate.getMonthValue();
    }

    public static void setHorarioInicio(String hora, String min) {
        click(TimesEntryConstants.BTN_START);
        inputHorario(hora, min);
    }

    public static void setHorarioFin(String hora, String min) {
        click(TimesEntryConstants.BTN_END);
        inputHorario(hora, min);
    }

    public static void setHorasTrabajadas(String hora, String min) {
        inputHorario(hora, min);
    }

    private static void inputHorario(String hora, String min) {
        click(TimesEntryConstants.INPUT_HORA);
        setInput(TimesEntryConstants.INPUT_HORA, hora); //es necesario repetir el input para que tome el valor
        setInput(TimesEntryConstants.INPUT_HORA, hora);

        click(TimesEntryConstants.INPUT_MIN);
        setInput(TimesEntryConstants.INPUT_MIN, min); //es necesario repetir el input para que tome el valor
        setInput(TimesEntryConstants.INPUT_MIN, min);
    }

    public static String nombreTarea;
    public static void setNombreTarea(String tarea) {
        nombreTarea = tarea + TpUtils.randomNum();
        waitVisibility(TimesEntryConstants.INPUT_WORKING_ON);
        setInput(TimesEntryConstants.INPUT_WORKING_ON, nombreTarea, true, false);
    }

    public static void elegirPrimerProyecto() {
        click(TimesEntryConstants.SECTION_PROJECT);
        click(TimesEntryConstants.PROJECT);
    }

    public static void checkVistaSeccionTimeEntry() {
        TpUtils.sleep(1500);
        waitVisibility(TimesEntryConstants.TITLE_TIME_ENTRY);
        Assert.assertTrue(isVisible(TimesEntryConstants.TITLE_TIME_ENTRY), "la seccion Time Entry no esta visible");
    }

    public static void checkNuevaEntrada() {
        TpUtils.sleep(1500);
        String locatorEntrada ="xpath://*[@text='"+nombreTarea+"']";

        scrollATexto(nombreTarea);
        TpUtils.sleep(2000);
        Assert.assertTrue(isPresent(locatorEntrada), "Error: la entrada no se encuentra en la lista");
    }

    public static void scrollATexto(String texto) {
        DriverManager.getDriverInstance().findElement(MobileBy.AndroidUIAutomator("new UiScrollable(new UiSelector().scrollable(true).instance(0)).scrollIntoView(new UiSelector().text(\""+texto+"\").instance(0))"));
    }

    public static void clicBtnSave() {
        click(TimesEntryConstants.BTN_SAVE);
    }

    public static void eliminarTarea() {
        TpUtils.sleep(1500);
        String locatorEntrada ="xpath://*[@text='"+nombreTarea+"']";
        click(locatorEntrada);
        TpUtils.sleep(1500);
        click(HomeConstants.BTN_TASK_EDIT);
        click(HomeConstants.BTN_TASK_DELETE);
    }

    public static void cancelarEntrada() {
        click(TimesEntryConstants.TOOLBAR_DISCARD_BTN);
        click(TimesEntryConstants.BTN_DISCARD); //anulacion del titulo de la entrada
        TpUtils.sleep(1000);
        click(TimesEntryConstants.TOOLBAR_DISCARD_BTN); //anulacion de la entrada
        click(TimesEntryConstants.BTN_DISCARD);
    }

    public static void clickBtnVolverATimeEntry() {
        TpUtils.sleep(1000);
        click(TimesEntryConstants.BTN_VOLVER);
    }

    public static void checkAnulacion() {
        TpUtils.sleep(1500);
        String locatorEntrada ="xpath://*[@text='"+nombreTarea+"']";
        Assert.assertFalse(isPresent(locatorEntrada), "Error: la entrada no se ha eliminado");
    }


}
