package com.lienptt.KiemTra2.testcases;

import com.lienptt.KiemTra2.pages.ProductPage;
import com.lienptt.KiemTra2.pages.LoginPage;
import com.lienptt.common.BaseTest;
import com.lienptt.keywords.WebUI;
import org.testng.annotations.Test;

public class ProductTest extends BaseTest {

    LoginPage loginPage;
    ProductPage dashboardPage;

    @Test
    public void testOpenPage(){
        loginPage = new LoginPage();
        dashboardPage = loginPage.loginCRM("admin@example.com", "123456");

        dashboardPage.openPage("Customers");
        WebUI.sleep(2);
        dashboardPage.openPage("Projects");
        WebUI.sleep(2);
        dashboardPage.openPage("Tasks");
        WebUI.sleep(2);
    }

    @Test
    public void testLogout(){
        loginPage = new LoginPage();
        loginPage.loginCRM("admin@example.com", "123456");

        loginPage.verifyRedirectToLoginPage();
    }

    @Test
    public void testTotalOfTasksNotFinished(){
        loginPage = new LoginPage();
        loginPage.loginCRM("admin@example.com", "123456");
        dashboardPage = new ProductPage();
        dashboardPage.verifyRedirectToDashboardPage();
        dashboardPage.verifyTotalOfTasksNotFinished("1 / 1");
    }
}
