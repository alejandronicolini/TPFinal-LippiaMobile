package com.crowdar.examples.services;

import com.crowdar.core.actions.MobileActionManager;
import com.crowdar.examples.constants.LoginConstants;
import org.testng.Assert;


public class LoginService extends MobileActionManager {


    public static void hacerLogin(String email, String pass) {
        inputLoginEmail(email);
        inputLoginPass(pass);
        clicBtnLogin();
    }

    public static void hacerLogOut(){
        TpUtils.sleep(1000);
        HomeService.clicMenuOpciones();
        HomeService.clicOpcionLogOut();
        HomeService.clicConfirmacion();
        checkSeccionLogin();
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

    public static void checkSeccionLogin() {
        waitVisibility(LoginConstants.SIGN_IN_BTN_CLOCKIFY);
        Assert.assertTrue(isVisible(LoginConstants.EMAIL_INPUT_CLOCKIFY), "no se pudo cargar: Login Page");
        waitVisibility(LoginConstants.SIGN_IN_BTN_CLOCKIFY);
        Assert.assertTrue(isVisible(LoginConstants.SIGN_IN_BTN_CLOCKIFY), "El Boton de Login no se encuentra");
    }

}
