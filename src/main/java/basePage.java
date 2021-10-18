import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

public class basePage {
    AndroidDriver driver;
    WebDriverWait wait;

    public basePage() {
        URL remoteUrl = null;
        try {
            remoteUrl = new URL("http://127.0.0.1:4723/wd/hub");
        } catch (MalformedURLException e) {
            e.printStackTrace();
            System.exit(1);
        }
        DesiredCapabilities desiredCapabilities = new DesiredCapabilities();
        desiredCapabilities.setCapability("platformName", "android");
        desiredCapabilities.setCapability("deviceName", "hogwarts");
        desiredCapabilities.setCapability("appPackage", "com.tencent.wework");
        desiredCapabilities.setCapability("appActivity", ".launch.WwMainActivity");
        desiredCapabilities.setCapability("noReset", "true");
        desiredCapabilities.setCapability("udid", "");

        this.driver = new AndroidDriver(remoteUrl, desiredCapabilities);
        this.driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        wait = new WebDriverWait(this.driver, 20);
    }


    public basePage(AndroidDriver driver) {
        this.driver = driver;
        wait = new WebDriverWait(this.driver, 20);
    }

    public WebElement byText(String text) {
        return driver.findElement(By.xpath("//*[@text=" + text + "]"));
    }

    public void click(String text) {
        byText(text).click();
    }

    public void sendKeys(String text, CharSequence keyword) {
        byText(text).sendKeys(keyword);
    }

    public void quit() {
        driver.quit();
    }
}
