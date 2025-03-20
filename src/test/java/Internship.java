import org.testng.Assert;
import org.testng.annotations.Test;
import pom.LoginPage;
import pom.PlaylistPage;
import pom.SongsPage;



public class Internship extends BaseTest {
    @Test(dataProvider = "validCredentialsAndPlaylistNames", dataProviderClass = DataProviderClass.class)
    public void createPlaylist(String email, String password, String playlistName) {
        String expectedCreatedPlaylistMsg = "Created playlist \"" + playlistName + "." + "\"";
        LoginPage loginPage = new LoginPage(getDriver());
        PlaylistPage playlistPage = new PlaylistPage(getDriver());

        loginPage.login(email, password);
        // Check if playlist name already exists
        if (playlistPage.isPlaylistExists(playlistName)) {
            System.out.println("Playlist with name \"" + playlistName + "\" already exists.");
        } else {
            playlistPage.clickPlusToCreate();
            playlistPage.clickNewPlaylistToCreate();
            playlistPage.inputNewPlaylistName(playlistName);
        }
        Assert.assertEquals(playlistPage.getCreateSuccessMsg(), expectedCreatedPlaylistMsg);
    }
}

