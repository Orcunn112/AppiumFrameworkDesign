package TestUtils;

import Utils.AppiumUtils;
import com.google.common.collect.ImmutableMap;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;
import io.appium.java_client.service.local.AppiumDriverLocalService;
import io.appium.java_client.service.local.AppiumServiceBuilder;
import org.POM.ANDROID.FormPage;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebElement;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;
import java.util.Properties;

public class BaseTest extends AppiumUtils {

    public AndroidDriver driver;
    public AppiumDriverLocalService service;
    public FormPage formPage;

///
    @BeforeClass
    public void ConfigureAppium() throws IOException {

        Properties prop = new Properties();
        FileInputStream fis = new FileInputStream(System.getProperty("user.dir") + "//src//test//java//resources//data.properties");
        prop.load(fis);
        String ipAddress = prop.getProperty("ipAddress");
        String port = prop.getProperty("port");
        service = startAppiumServer(ipAddress, Integer.parseInt(port));

        UiAutomator2Options options = new UiAutomator2Options();
        options.setDeviceName(prop.getProperty("AndroidDeviceName"));
        options.setChromedriverExecutable("C://Users//Orcun//IdeaProjects//New_Android1_//src//test//java//resources//chromedriver.exe");

        //PREFERENS PATH APP
//        options.setApp("C:/Users/Orcun/IdeaProjects/New_Android1_/src/test/java/resources/ApiDemos-debug.apk"); // path giriş application
//        uygulama adı path li
        options.setApp(System.getProperty("user.dir") + "//src//test//java//resources//General-Store.apk");

        driver = new AndroidDriver(service.getUrl(), options);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
        formPage = new FormPage(driver);

    }


    @AfterClass
    public void tearDown() {
        driver.quit();
        service.stop();

    }
}
