package com.crowdar.examples.services;

import com.crowdar.core.actions.MobileActionManager;
import com.crowdar.examples.constants.HomeConstants;
import org.testng.asserts.SoftAssert;


public class HomeService {


    public static void isTimeListPresent() {
        MobileActionManager.waitVisibility(HomeConstants.LAYOUT_TIME_LIST);
        String strEsperado = "Time entries";
        String strRecibido = MobileActionManager.getText(HomeConstants.LAYOUT_TITLE);

        SoftAssert assertsSoft = new SoftAssert();
        assertsSoft.assertTrue(MobileActionManager.isVisible(HomeConstants.LAYOUT_TIME_LIST), "el Frame, Time List no esta presente");
        assertsSoft.assertEquals(strEsperado, strRecibido, "no coincide el txt recibido");
        assertsSoft.assertAll();
    }

}
