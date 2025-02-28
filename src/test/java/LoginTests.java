import org.testng.Assert;
import org.testng.annotations.Test;
import pom.HomePage;
import pom.LoginPage;
import pom.LoginPageFactory;

public class LoginTests extends BaseTest {
    @Test

    public void loginEmptyEmailPassword() {
        //LoginPage loginPage=new LoginPage(getDriver());
        HomePage homePage=new HomePage(getDriver());
        //loginPage.provideEmail("kavya.ilapavuluri@testpro.io");
        //loginPage.providePassword("student#67");
        //loginPage.clickSubmit();

        LoginPageFactory loginPageFactory=new LoginPageFactory(getDriver());
        loginPageFactory.provideEmail("kavya.ilapavuluri@testpro.io");
        loginPageFactory.providePassword("student#67");
        loginPageFactory.clickSubmit();


        Assert.assertEquals("https://qa.koel.app/",homePage.currentUrl());
    }
}
