package pom;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPage extends BasePage {

    public LoginPage(WebDriver givenDriver){
        super(givenDriver);
    }

    @FindBy(css="input[type='email']")
    public WebElement emailField;

    @FindBy(css="input[type='password']")
    public WebElement passwordField;

    @FindBy(css="button[type='submit']")
    public WebElement clickLoginBtn;

    public LoginPage provideEmail(String email){
        findElement(emailField).sendKeys(email);
        return this;
    }

    public LoginPage providePassword(String password){
        findElement(passwordField).sendKeys(password);
        return this;
    }

    public void clickLoginBtn(){
        findElement(clickLoginBtn).click();
    }

    public void login(String email,String password){
        provideEmail(email);
        providePassword(password);
        clickLoginBtn();
    }

    public void login(){
        provideEmail("kavya.ilapavuluri@testpro.io");
        providePassword("student#67");
        clickLoginBtn();
    }

}
