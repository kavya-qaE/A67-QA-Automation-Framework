import org.testng.Assert;
import org.testng.annotations.Test;
import pom.LoginPage;
import pom.SongsPage;

public class Internship2 extends BaseTest{
    SongsPage songsPage;
    LoginPage loginPage;

    @Test
    public void searchForExistingSongTest(){
        songsPage = new SongsPage(getDriver());
        loginPage = new LoginPage(getDriver());
        loginPage.login();
        songsPage.searchSong("pluto");
        Assert.assertTrue(songsPage.areResultsDisplayed(),"Song results are displayed");
    }

    @Test
    public void searchForNonExistingSongTest() {
        songsPage = new SongsPage(getDriver());
        loginPage = new LoginPage(getDriver());
        loginPage.login();
        songsPage.searchSong("pluto");
        Assert.assertEquals(songsPage.isNoResultsDisplayed(),"None found.");
    }

    @Test
    public void searchWithLeadingTrailingSpacesTest() {
        songsPage = new SongsPage(getDriver());
        loginPage = new LoginPage(getDriver());
        loginPage.login();
        songsPage.searchSong(" Dark days  ");
        Assert.assertTrue(songsPage.areResultsDisplayed(), "Search results are displayed.");
    }

    @Test
    public void searchCaseSensitivityTest() {
        songsPage = new SongsPage(getDriver());
        loginPage = new LoginPage(getDriver());
        loginPage.login();
        songsPage.searchSong("Pluto");
        Assert.assertTrue(songsPage.areResultsDisplayed(), "Search should return case-sensitive results.");
    }

    @Test
    public void clearSearchUsingXButtonTest() {
        songsPage = new SongsPage(getDriver());
        loginPage = new LoginPage(getDriver());
        loginPage.login();
        songsPage.searchSong("pluto");
        songsPage.clearSearchUsingXButton();
        Assert.assertTrue(songsPage.searchField.getText().isEmpty(), "Search field is cleared.");
    }

    @Test
    public void clearSearchUsingKeyboardTest() {
        songsPage = new SongsPage(getDriver());
        loginPage = new LoginPage(getDriver());
        loginPage.login();
        songsPage.searchSong("pluto");
        songsPage.clearSearchUsingKeyboard();
        Assert.assertTrue(songsPage.searchField.getText().isEmpty(), "Search field should be cleared.");
    }
}
