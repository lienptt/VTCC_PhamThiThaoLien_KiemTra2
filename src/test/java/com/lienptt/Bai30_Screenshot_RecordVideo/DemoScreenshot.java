package com.lienptt.Bai30_Screenshot_RecordVideo;

import com.lienptt.KiemTra2.pages.LoginPage;
import com.lienptt.common.BaseTest;
import com.lienptt.dataproviders.DataProviderFactory;
import com.lienptt.drivers.DriverManager;
import com.lienptt.keywords.WebUI;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.io.FileHandler;
import org.testng.annotations.Test;

import java.io.File;
import java.io.IOException;

public class DemoScreenshot extends BaseTest {
    LoginPage loginPage;
    @Test(priority = 1, dataProvider = "data_provider_login", dataProviderClass = DataProviderFactory.class)
    public void testLoginSuccess(String email, String password){
        loginPage = new LoginPage();

        loginPage.loginCRM(email, password);
        loginPage.verifyLoginSuccess();
    }
}
