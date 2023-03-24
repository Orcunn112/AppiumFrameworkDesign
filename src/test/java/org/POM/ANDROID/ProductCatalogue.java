package org.POM.ANDROID;

import Utils.AndroidActions;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

//GrandParent(AppiumUtils) -> AndroidActions -> ProductCatalogue
public class ProductCatalogue extends AndroidActions {

    @AndroidFindBy(xpath = "//android.widget.TextView[@text='ADD TO CART']")
            private List<WebElement> addToCart;  // private yap
    //driver.findElements(By.xpath("//android.widget.TextView[@text='ADD TO CART']"))
    @AndroidFindBy(id = "com.androidsample.generalstore:id/appbar_btn_cart")
    private WebElement cart;
    AndroidDriver driver;
     public  ProductCatalogue(AndroidDriver driver)
    {
        super(driver);
        this.driver=driver;
        PageFactory.initElements(new AppiumFieldDecorator(driver),this); //


    }
    public void addItemToCartByIndex(int index)
    {
         addToCart.get(index).click();

    }
    public CartPage goToCartPage() throws InterruptedException {
         cart.click();
         Thread.sleep(2000);
         return new CartPage(driver);
    }

}
