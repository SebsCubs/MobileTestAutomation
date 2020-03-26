package steps;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.net.MalformedURLException;
import java.net.URL;

public class Hooks {
    private AppiumDriver<MobileElement> driver;

    @Before
    public void setup() throws MalformedURLException {
        // TO DO: setup a driver factory if necessary
        URL appiumServerURL = new URL("http://127.0.0.1:4723/wd/hub");

        DesiredCapabilities caps = new DesiredCapabilities();
        caps.setCapability("deviceName","Mi A1");
        caps.setCapability("udid","00fe43dc0904");
        caps.setCapability("platformName","Android");
        caps.setCapability("platformVersion","9");
        caps.setCapability("automationName", "UiAutomator1");


        caps.setCapability("appPackage","com.thetrainline");
        caps.setCapability("appActivity","com.thetrainline.activities.home_screen.SplashScreenActivity");

        driver = new AppiumDriver<MobileElement>(appiumServerURL,caps);
    }
    @After
    public void teardown(){
        driver.quit();
    }
    public AppiumDriver<MobileElement> getWebDriver(){
        return driver;
    }
}
