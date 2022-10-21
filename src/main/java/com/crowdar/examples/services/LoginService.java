package com.crowdar.examples.services;

import com.crowdar.core.actions.MobileActionManager;
import com.crowdar.examples.constants.LoginConstants;
import org.testng.Assert;


public class LoginService {


    public static void isViewLoadedClockify() {
        MobileActionManager.waitVisibility(LoginConstants.SIGN_IN_BTN_CLOCKIFY);
        Assert.assertTrue(MobileActionManager.isVisible(LoginConstants.EMAIL_INPUT_CLOCKIFY), "no se pudo cargar: Login Page");
    }

    public static void inputLoginData(String email, String pass) {
        inputLoginEmail(email);
        inputLoginPass(pass);
        clicBtnLogin();
    }

    public static void inputLoginEmail(String email) {
        MobileActionManager.setInput(LoginConstants.EMAIL_INPUT_CLOCKIFY, email, true,false);
    }

    public static void inputLoginPass(String pass) {
        MobileActionManager.setInput(LoginConstants.PASSWORD_INPUT_CLOCKIFY, pass, true,false);
    }

    public static void clicBtnLogin() {
        MobileActionManager.click(LoginConstants.SIGN_IN_BTN_CLOCKIFY);
    }
}
