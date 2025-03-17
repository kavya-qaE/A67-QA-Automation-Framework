package pom;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class RegistrationPage extends BasePage {
    public RegistrationPage(WebDriver givenDriver) {
        super(givenDriver);
    }

    @FindBy(css ="a[href='registration']")
    public WebElement registrationBtn;

    public void registrationLink(){
        registrationBtn.click();
    }
}
