package com.lienptt.KiemTra2.testcases;

import com.lienptt.KiemTra2.pages.LoginPage;
import com.lienptt.common.BaseTest;
import com.lienptt.dataproviders.DataProviderFactory;
import org.testng.annotations.Test;

import java.util.Hashtable;

public class LoginTest extends BaseTest {

    LoginPage loginPage;

    @Test(priority = 1, dataProvider = "data_provider_login", dataProviderClass = DataProviderFactory.class)
    public void testLoginSuccess(String email, String password){
        loginPage = new LoginPage();
        loginPage.loginCRM(email, password);
        loginPage.verifyLoginSuccess();
        loginPage.logout();
        loginPage.verifyRedirectToLoginPage();
    }
}
