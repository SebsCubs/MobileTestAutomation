package pageObjects;

        import io.appium.java_client.AppiumDriver;
        import io.appium.java_client.MobileElement;
        import org.openqa.selenium.support.PageFactory;

public class PageFather {
    public PageFather(AppiumDriver<MobileElement> driver) {
        PageFactory.initElements(driver,this);
    }

}
