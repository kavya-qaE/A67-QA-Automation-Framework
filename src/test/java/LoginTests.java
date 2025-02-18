import org.testng.Assert;
import org.testng.annotations.Test;
import pom.HomePage;
import pom.LoginPage;

public class LoginTests extends BaseTest {
    @Test

    public void loginEmptyEmailPassword() {
        LoginPage loginPage=new LoginPage(driver);
        HomePage homePage=new HomePage(driver);

        loginPage.provideEmail("kavya.ilapavuluri@testpro.io");
        loginPage.providePassword("student#67");
        loginPage.clickSubmit();

        Assert.assertEquals("https://qa.koel.app/",homePage.currentUrl());
    }
}
