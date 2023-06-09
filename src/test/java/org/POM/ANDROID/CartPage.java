package org.POM.ANDROID;


import Utils.AndroidActions;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class CartPage extends AndroidActions {
    AndroidDriver driver;

    public CartPage(io.appium.java_client.android.AndroidDriver driver) {
        super(driver);
        this.driver = driver;
        PageFactory.initElements(new AppiumFieldDecorator(driver), this); //
    }

    @AndroidFindBy(id = "com.androidsample.generalstore:id/productPrice")
    public List<WebElement> productList;
    @AndroidFindBy(id = "com.androidsample.generalstore:id/totalAmountLbl")
    public WebElement totalAmount;

    @AndroidFindBy(id = "com.androidsample.generalstore:id/termsButton")
    public WebElement terms;

    @AndroidFindBy(id = "android:id/button1")
    public WebElement acceptButton;
    @AndroidFindBy(id = "com.androidsample.generalstore:id/btnProceed")
    public WebElement proceed;
    @AndroidFindBy(className = "android.widget.CheckBox")
    public WebElement checkbox;

    public List<WebElement> getProductList() {

        return productList;
    }

    public double getProductsSum() {
        int count = productList.size();
        double totalSum = 0;
        for (int i = 0; i < count; i++) {

            String amountString = productList.get(i).getText();
            Double price = getFormattedAmount(amountString);
            totalSum += price;

        }
        return totalSum;
    }

    public Double getTotalAmountDisplayed() {
        return getFormattedAmount(totalAmount.getText());

    }

    public void acceptedConditions() {
        LongpressAction(terms);
        acceptButton.click();

    }



    public void submitOrder() {
        checkbox.click();
        proceed.click();


    }

}
