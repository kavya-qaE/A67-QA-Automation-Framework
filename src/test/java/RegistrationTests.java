import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.Assert;
import org.testng.annotations.Test;
import pom.RegistrationPage;

import java.time.Duration;


public class RegistrationTests extends BaseTest{
    @Test
    public void registrationNavigation(){
        //Click on Registration link
        RegistrationPage registrationPage=new RegistrationPage(getDriver());
        //registrationPage.registrationBtn.click();
        driver.findElement(By.cssSelector("a[href='registration']")).click();

        //Verify Registration page
        String url1 = "https://qa.koel.app/registration";
        driver.get(url1);
        Assert.assertEquals(driver.getCurrentUrl(), url1);
        driver.quit();
    }
}
