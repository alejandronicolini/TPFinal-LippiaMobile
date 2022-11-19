package com.crowdar.examples.services;

import com.crowdar.core.actions.MobileActionManager;
import com.crowdar.examples.constants.HomeConstants;
import org.testng.Assert;
import org.testng.asserts.SoftAssert;


public class HomeService extends MobileActionManager{


    public static void isTimeListPresent() {
        waitVisibility(HomeConstants.LAYOUT_TIME_LIST);
        String tituloEsperado = "Time entries";
        String tituloRecibido = getText(HomeConstants.LAYOUT_TITLE);

        SoftAssert assertsSoft = new SoftAssert();
        assertsSoft.assertTrue(isVisible(HomeConstants.LAYOUT_TIME_LIST), "el Frame, Time List no esta presente");
        assertsSoft.assertEquals(tituloEsperado, tituloRecibido, "no coincide el txt recibido");
        assertsSoft.assertAll();
    }

    public static void clickMenuOpciones() {
        click(HomeConstants.BTN_OPCIONES);
    }

    public static void clickOpcionLogOut() {
        click(HomeConstants.BTN_LOG_OUT);
    }

    public static void clickConfirmacion() {
        click(HomeConstants.BTN_CONFIRM_LOG_OUT);
    }

    public static void clickOpcionSettings() {
        click(HomeConstants.BTN_SETTINGS);
    }

    public static void clickDarkMode() {
        click(HomeConstants.BTN_DARKMODE);
    }

    public static void checkAppColor() {
        String estadoBtn = getAttribute(HomeConstants.BTN_DARKMODE, "active");
        //Falta hacer un assert con el estado Active
        String attrText = getAttribute(HomeConstants.BTN_DARKMODE, "text");
        Assert.assertEquals(attrText, "ON");
    }

}
