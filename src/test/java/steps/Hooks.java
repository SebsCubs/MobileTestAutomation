package steps;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.net.MalformedURLException;
import java.net.URL;

public class Hooks {
    private AppiumDriver<MobileElement> driver;

    @Before
    public void setup(Scenario scenario) throws MalformedURLException {
        boolean isLocal = Boolean.parseBoolean(System.getenv("AppiumTestisLocal"));

        if(isLocal){
            URL appiumServerURL = new URL("http://127.0.0.1:4723/wd/hub");
            DesiredCapabilities caps = new DesiredCapabilities();
            caps.setCapability("deviceName","Mi A1");
            caps.setCapability("udid","00fe43dc0904");
            caps.setCapability("platformName","Android");
            caps.setCapability("platformVersion","9");
            caps.setCapability("automationName", "UiAutomator1");

            caps.setCapability("appPackage","com.thetrainline");
            caps.setCapability("appActivity","com.thetrainline.activities.home_screen.SplashScreenActivity");

            driver = new AppiumDriver<>(appiumServerURL,caps);
        }else{
            URL sauceLabsServer = new URL("http://ondemand.saucelabs.com:80/wd/hub");

            DesiredCapabilities caps = DesiredCapabilities.android();
            caps.setCapability("appiumVersion", "1.15.0");
            caps.setCapability("deviceName","Google Pixel 3 GoogleAPI Emulator");
            caps.setCapability("deviceOrientation", "portrait");
            caps.setCapability("browserName", "");
            caps.setCapability("platformVersion","9.0");
            caps.setCapability("platformName","Android");
            caps.setCapability("app","sauce-storage:thetrainline.apk");
            caps.setCapability("autoGrantPermissions", true);

            caps.setCapability("username", System.getenv("SauceLabsUser"));
            caps.setCapability("accesskey", System.getenv("SauceLabsKey"));
            caps.setCapability("build", "Trainline Suite");
            caps.setCapability("name", scenario.getName());
            driver = new AppiumDriver<>(sauceLabsServer, caps);
        }

    }
    @After
    public void teardown(Scenario scenario){
        boolean isLocal = Boolean.parseBoolean(System.getenv("AppiumTestisLocal"));
        if (scenario.isFailed()) {
            if(!isLocal){driver.executeScript("sauce:job-result=failed");}

            try {
                byte[] screenshot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES);
                String testName = scenario.getName();
                scenario.embed(screenshot, "image/png", "photo");
                scenario.write(testName);
            } catch (WebDriverException wde) {
                System.err.println(wde.getMessage());
            } catch (ClassCastException cce) {
                cce.printStackTrace();
            }

        }else if (!isLocal){
            driver.executeScript("sauce:job-result=passed");
        }
        driver.quit();
    }

    public AppiumDriver<MobileElement> getWebDriver(){
        return driver;
    }
}
