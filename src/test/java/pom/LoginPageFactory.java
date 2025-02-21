package pom;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPageFactory extends BasePageFactory{

    public LoginPageFactory(WebDriver givenDriver){
        super(givenDriver);
    }

    @FindBy(css="input[type='email']")
    public WebElement emailField;

    @FindBy(css="input[type='password']")
    public WebElement passwordField;

    @FindBy(css="button[type='submit']")
    public WebElement submitBtn;

    public LoginPageFactory provideEmail(String email){
        emailField.sendKeys(email);
        return this;
    }

    public LoginPageFactory providePassword(String password){
        passwordField.sendKeys(password);
        return this;
    }

    public void clickSubmit(){
        submitBtn.click();
    }


}
