import org.testng.Assert;
import org.testng.annotations.Test;
import pom.LoginPage;
import pom.PlaylistPage;
import pom.SongsPage;

public class Internship extends BaseTest {

    @Test(dataProvider = "validCredentialsAndPlaylistNames", dataProviderClass = DataProviderClass.class)
    public void DuplicatePlaylistNameTest(String email, String password, String playlistName) {
        String expectedCreatedPlaylistMsg = "Created playlist \"" + playlistName + "." + "\"";
        LoginPage loginPage = new LoginPage(getDriver());
        PlaylistPage playlistPage = new PlaylistPage(getDriver());

        loginPage.login(email, password);
        // Method to Check if playlist name already exists
        if (playlistPage.isPlaylistExists(playlistName)) {
            System.out.println("Playlist with name \"" + playlistName + "\" already exists.");
        }
    }

    @Test(dataProvider = "validCredentialsAndPlaylistNames", dataProviderClass = DataProviderClass.class)
    public void PlaylistNameLengthTest(String email, String password, String playlistName) {
        String expectedCreatedPlaylistMsg = "Created playlist \"" + playlistName + "." + "\"";
        LoginPage loginPage = new LoginPage(getDriver());
        PlaylistPage playlistPage = new PlaylistPage(getDriver());

        loginPage.login(email, password);
        // Method to Check if playlist name already exists
        if (playlistPage.isPlaylistExists(playlistName)) {
            System.out.println("Playlist with name \"" + playlistName + "\" already exists.");
        } else {
            playlistPage.clickPlusToCreate();
            playlistPage.clickNewPlaylistToCreate();
            boolean value=playlistPage.checkPlaylistLength(playlistName);
            Assert.assertTrue(value);
        }
    }

    @Test(dataProvider = "validCredentialsAndPlaylistNames", dataProviderClass = DataProviderClass.class)
    public void createPlaylistTest(String email, String password, String playlistName) {
        String expectedCreatedPlaylistMsg = "Created playlist \"" + playlistName + "." + "\"";
        LoginPage loginPage = new LoginPage(getDriver());
        PlaylistPage playlistPage = new PlaylistPage(getDriver());

        loginPage.login(email, password);
        playlistPage.clickPlusToCreate();
        playlistPage.clickNewPlaylistToCreate();
        playlistPage.inputNewPlaylistName(playlistName);

        Assert.assertEquals(playlistPage.getCreateSuccessMsg(), expectedCreatedPlaylistMsg);
        //User’s playlist should displays correctly DB
        boolean playlistCreated = playlistPage.isPlaylistDisplayed(playlistName);
        Assert.assertTrue(playlistCreated);
        //Delete Playlist
        playlistPage.choosePlaylistToDelete(playlistName);
        playlistPage.clickRedPlaylistBtn();
    }

}
