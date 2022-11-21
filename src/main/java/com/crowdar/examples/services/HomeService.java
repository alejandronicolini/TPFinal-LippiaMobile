package com.crowdar.examples.services;

import com.crowdar.core.actions.MobileActionManager;
import com.crowdar.examples.constants.HomeConstants;
import org.testng.Assert;
import org.testng.asserts.SoftAssert;


public class HomeService extends MobileActionManager {


    public static void checkVistaListaDeEntradas() {
        waitVisibility(HomeConstants.LAYOUT_TIME_LIST);
        String tituloEsperado = "Time entries";
        String tituloRecibido = getText(HomeConstants.LAYOUT_TITLE);

        SoftAssert assertsSoft = new SoftAssert();
        assertsSoft.assertTrue(isVisible(HomeConstants.LAYOUT_TIME_LIST), "el Frame, Time List no esta presente");
        assertsSoft.assertEquals(tituloEsperado, tituloRecibido, "no coincide el txt recibido");
        assertsSoft.assertAll();
    }

    public static void clicMenuOpciones() {
        click(HomeConstants.BTN_OPCIONES);
    }

    public static void clicOpcionLogOut() {
        waitPresence(HomeConstants.BTN_LOG_OUT);
        click(HomeConstants.BTN_LOG_OUT);
    }

    public static void clicConfirmacion() {
        waitPresence(HomeConstants.BTN_CONFIRM_LOG_OUT);
        click(HomeConstants.BTN_CONFIRM_LOG_OUT);
    }

    public static void clicOpcionSettings() {
        click(HomeConstants.BTN_SETTINGS);
    }

    public static String attrCheckedInicial;
    public static String attrModoInicial;
    public static void AtributosInicial(String LocatorBtn) {
        attrCheckedInicial = getAttribute(LocatorBtn, "checked");
        attrModoInicial = getAttribute(LocatorBtn, "text");
    }

    public static void clicBtnDarkMode() {
        click(HomeConstants.BTN_DARKMODE);
    }

    public static void checkCambioConfiguracion(String LocatorBtn) {
        String attrCheckedActual = getAttribute(LocatorBtn, "checked");
        String attrText = getAttribute(LocatorBtn, "text");
        Assert.assertNotEquals(attrCheckedInicial, attrCheckedActual, "Error: la App no cambio la configuracion requerida");
        Assert.assertNotEquals(attrModoInicial, attrText);
    }

    public static void clicBtnShowNotifications() {
        click(HomeConstants.BTN_SHOW_NOTIFICATIONS);
    }

}
