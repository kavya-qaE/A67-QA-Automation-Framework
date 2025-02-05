import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.time.Duration;

public class LoginTests extends BaseTest {
    @Test
    public void loginEmptyEmailPassword() {
        navigateToPage();
        provideEmail("kavya.ilapavuluri@testpro.io");
        providePassword("student#67");
        clickSubmit();
        Assert.assertEquals(driver.getCurrentUrl(), url);
        closeBrowser();
    }
}
