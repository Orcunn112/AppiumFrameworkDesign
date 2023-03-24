package org.POM.ANDROID;

import TestUtils.BaseTest;
import com.aventstack.extentreports.ExtentTest;
import org.testng.AssertJUnit;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;

public class eCOMMERCE_TC_4_Hyrid extends BaseTest {

    @Test(dataProvider = "getData")
    public void FillForm(HashMap<String,String>input) throws InterruptedException {


        formPage.setNameField(input.get("name"));
        formPage.setGender(input.get("gender"));
        formPage.setCountrySelection(input.get("country"));

        ProductCatalogue productCatalogue = formPage.submitForm();
        productCatalogue.addItemToCartByIndex(0);
        productCatalogue.addItemToCartByIndex(0);
        CartPage cartPage = productCatalogue.goToCartPage();


//        Thread.sleep(3000);
//        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(7));
//        wait.until(ExpectedConditions.attributeContains(driver.findElement(By.id("com.androidsample.generalstore:id/toolbar_title")), "text", "Cart"));
        double totalSum = cartPage.getProductsSum();
        double displayFormattedSum = cartPage.getTotalAmountDisplayed();
        AssertJUnit.assertEquals(totalSum, displayFormattedSum);
        cartPage.acceptedConditions();
        cartPage.submitOrder();
    }

        @BeforeMethod
                public void preSetup(){
           formPage.setActivity();
           
    }
    @DataProvider
    public Object[][] getData() throws IOException
    {
      List<HashMap<String, String>>data=getJsonData(System.getProperty("user.dir")+"//src//test//java//testData//eCommerce.json");
       return  new  Object[][]{  {data.get(0)},{data.get(1)}  };
    }



}
