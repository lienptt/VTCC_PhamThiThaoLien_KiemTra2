package com.lienptt.KiemTra2.testcases;

import com.lienptt.KiemTra2.pages.LoginPage;
import com.lienptt.KiemTra2.pages.ProductPage;
import com.lienptt.common.BaseTest;
import com.lienptt.dataproviders.DataProviderFactory;
import com.lienptt.helpers.CaptureHelper;
import com.lienptt.keywords.WebUI;
import org.testng.annotations.Test;

public class AddNewProductTest extends BaseTest {

    LoginPage loginPage;
    ProductPage productPage;
    @Test(dataProvider = "data_provider_login", dataProviderClass = DataProviderFactory.class)
    public void addNewProduct(String email, String password) {
        loginPage = new LoginPage();
        loginPage.login(email, password);
        loginPage.verifyLoginSuccess();

        productPage = new ProductPage();
        productPage.redirectToAddNewProductTab();
        productPage.verifyRedirectToAddNewProductTabSuccess();
        productPage.inputProductName();
        productPage.chooseCategory();

        productPage.inputUnit();
        productPage.inputMinQty();
        productPage.inputTag();
        productPage.inputUnitPrice();
        productPage.inputQuantity();
        productPage.clickSavePublishButton();
        productPage.verifyAddNewProductSuccess();
        CaptureHelper.captureScreenshot("Add New Product");
    }
}
