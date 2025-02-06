import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.time.Duration;


public class Homework16 extends BaseTest{
    @Test
    public void registrationNavigation(){
        //Added ChromeOptions argument below to fix websocket error
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--remote-allow-origins=*");

        WebDriver driver = new ChromeDriver(options);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        String url = "https://qa.koel.app/";
        driver.get(url);

        //Click on Registration link
        driver.findElement(By.cssSelector("a[href='registration']")).click();

        //Verify Registration page
        String url1 = "https://qa.koel.app/registration";
        driver.get(url1);
        Assert.assertEquals(driver.getCurrentUrl(), url1);
        driver.quit();
    }
}
