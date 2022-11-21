package com.crowdar.examples.services;

import com.crowdar.core.actions.MobileActionManager;
import com.crowdar.driver.DriverManager;
import com.crowdar.examples.constants.LoginConstants;
import io.appium.java_client.MobileBy;
import org.openqa.selenium.WebElement;
import org.testng.Assert;


public class TpUtils extends MobileActionManager {


    public static void sleep(int milisegundos){
        try {
            Thread.sleep(milisegundos);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public static int randomNum() {
        double random = Math.random();
        int num = (int) (Math.random() * (1000));
        return num;
    }

    public static WebElement scrollElement(String locatorType, String locatorValue, int index) {
        String locator = String.format("new UiScrollable(new UiSelector().scrollable(true).instance(3)).scrollIntoView(new UiSelector().%s(\"%s\").instance(0).index(%d))", locatorType, locatorValue, index);
        return DriverManager.getDriverInstance().findElement(MobileBy.AndroidUIAutomator(locator));
    }



}
