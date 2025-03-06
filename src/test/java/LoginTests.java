import org.testng.Assert;
import org.testng.annotations.Test;
import pom.HomePage;
import pom.LoginPage;

public class LoginTests extends BaseTest {
    @Test(dataProvider = "ValidCredentials", dataProviderClass = DataProviderClass.class)
    public void loginWithValidCredentials(String email,String password) {
        LoginPage loginPageFactory=new LoginPage(getDriver());
        HomePage homePage=new HomePage(getDriver());
        loginPageFactory.login(email,password);
        Assert.assertEquals("https://qa.koel.app/",homePage.currentUrl());
    }

    @Test(dataProvider = "InvalidCredentials", dataProviderClass = DataProviderClass.class)
    public void loginWithInvalidCredentials(String email,String password) {
        LoginPage loginPageFactory=new LoginPage(getDriver());
        HomePage homePage=new HomePage(getDriver());
        loginPageFactory.login(email,password);
        Assert.assertTrue(loginPageFactory.clickLoginBtn.isDisplayed());
    }
}
