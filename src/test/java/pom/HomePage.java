package pom;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import static java.sql.DriverManager.getDriver;

public class HomePage extends BasePage{
    public HomePage(WebDriver givenDriver){
        super(givenDriver);
    }

    By userAvatorIcon= By.cssSelector("img.avator");

    /*public WebElement getUserAvator(){
        return findElement(userAvatorIcon);
    }*/

    public String currentUrl(){
        return driver.getCurrentUrl();
    }
}
