package org.POM.ANDROID;

import TestUtils.BaseTest;
import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.Activity;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.AssertJUnit;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class eCOMMERCE_TC_1 extends BaseTest {


    @BeforeMethod
    public void preSetup(){

        Activity activity = new Activity("com.androidsample.generalstore","com.androidsample.generalstore.MainActivity");
        driver.startActivity(activity);
    }
    @Test
    public void FillForm_ErrorValidation() throws InterruptedException {
//        driver.findElement(By.id("com.androidsample.generalstore:id/nameField")).sendKeys("orcun112");
        driver.hideKeyboard();
        driver.findElement(By.xpath("//android.widget.RadioButton[@text='Female']")).click();
        driver.findElement(By.id("android:id/text1")).click();
        driver.findElement(AppiumBy.androidUIAutomator("new UiScrollable(new UiSelector()).scrollIntoView(text(\"Bolivia\"));"));
        driver.findElement(By.xpath("//android.widget.TextView[@text='Bolivia']")).click();
        driver.findElement(By.id("com.androidsample.generalstore:id/btnLetsShop")).click();

        String toastMessage = driver.findElement(By.xpath("(//android.widget.Toast)[1]")).getAttribute("name");
        AssertJUnit.assertEquals(toastMessage, "Please enter your name");

    }

    @Test
    public void FillForm_PositiveFlow() throws InterruptedException {
        driver.findElement(By.id("com.androidsample.generalstore:id/nameField")).sendKeys("orcun112");
        driver.hideKeyboard();
        driver.findElement(By.xpath("//android.widget.RadioButton[@text='Female']")).click();
        driver.findElement(By.id("android:id/text1")).click();
        driver.findElement(AppiumBy.androidUIAutomator("new UiScrollable(new UiSelector()).scrollIntoView(text(\"Bolivia\"));"));
        driver.findElement(By.xpath("//android.widget.TextView[@text='Bolivia']")).click();
        driver.findElement(By.id("com.androidsample.generalstore:id/btnLetsShop")).click();
        Thread.sleep(3000);

        Assert.assertTrue(driver.findElements(By.xpath("(//android.widget.Toast)[1]")).size()<1);

    }
}