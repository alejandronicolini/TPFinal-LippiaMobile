package com.crowdar.examples.services;

import com.crowdar.core.actions.MobileActionManager;
import com.crowdar.examples.constants.LoginConstants;
import org.testng.Assert;


public class LoginService extends MobileActionManager {


    public static void isViewLoadedClockify() {
        waitVisibility(LoginConstants.SIGN_IN_BTN_CLOCKIFY);
        Assert.assertTrue(isVisible(LoginConstants.EMAIL_INPUT_CLOCKIFY), "no se pudo cargar: Login Page");
    }

    public static void doLogin(String email, String pass) {
        inputLoginEmail(email);
        inputLoginPass(pass);
        clicBtnLogin();
    }

    public static void doLogOut(){
        HomeService.clickMenuOpciones();
        HomeService.clickOpcionLogOut();
        HomeService.clickConfirmacion();
        verificacionBtnLogin();
    }

    public static void inputLoginEmail(String email) {
        setInput(LoginConstants.EMAIL_INPUT_CLOCKIFY, email, true,false);
    }

    public static void inputLoginPass(String pass) {
        setInput(LoginConstants.PASSWORD_INPUT_CLOCKIFY, pass, true,false);
    }

    public static void clicBtnLogin() {
        click(LoginConstants.SIGN_IN_BTN_CLOCKIFY);
    }

    public static void verificacionBtnLogin() {
        waitVisibility(LoginConstants.SIGN_IN_BTN_CLOCKIFY);
        Assert.assertTrue(isVisible(LoginConstants.SIGN_IN_BTN_CLOCKIFY), "El Boton de Login no se encuentra");
    }

}
