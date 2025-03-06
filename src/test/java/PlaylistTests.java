import org.testng.Assert;
import org.testng.annotations.Test;
import pom.LoginPage;
import pom.PlaylistPage;
import pom.SongsPage;

public class PlaylistTests extends BaseTest{
    @Test  (dataProvider = "validCredentialsAndPlaylistNames", dataProviderClass = DataProviderClass.class)
    public void createPlaylist(String email,String password,String playlistName){
        String expectedCreatedPlaylistMsg="Created playlist \"" + playlistName +"."+ "\"";
        LoginPage loginPage= new LoginPage(getDriver());
        SongsPage songsPage = new SongsPage(getDriver());
        PlaylistPage playlistPage = new PlaylistPage(getDriver());

        loginPage.login(email,password);
        playlistPage.clickPlusToCreate();
        playlistPage.clickNewPlaylistToCreate();
        playlistPage.inputNewPlaylistName(playlistName);
        Assert.assertEquals(playlistPage.getCreateSuccessMsg(),expectedCreatedPlaylistMsg);
    }

    @Test  (dataProvider = "validCredentialsAndPlaylistNames", dataProviderClass = DataProviderClass.class)
    public void deletePlaylist(String email,String password,String playlistName){
        String expectedDeletedPlaylistMsg="Deleted playlist \"" + playlistName +"."+ "\"";

        LoginPage loginPage= new LoginPage(getDriver());
        SongsPage songsPage = new SongsPage(getDriver());
        PlaylistPage playlistPage = new PlaylistPage(getDriver());

        loginPage.login(email,password);
        playlistPage.choosePlaylistToDelete(playlistName);
        playlistPage.clickRedPlaylistBtn();
        //  clickOkDialogBtn();
        Assert.assertEquals(playlistPage.getDeleteSuccessMsg(),expectedDeletedPlaylistMsg);
    }

    @Test(dataProvider = "ValidCredentials", dataProviderClass = DataProviderClass.class)
    public void renamePlaylist(String email,String password){
        String name=generateRandomName();
        String expectedSuccessMsg="Updated playlist \"" + name +"."+ "\"";

        LoginPage loginPage= new LoginPage(getDriver());
        SongsPage songsPage = new SongsPage(getDriver());
        PlaylistPage playlistPage = new PlaylistPage(getDriver());

        loginPage.login(email,password);
        playlistPage.doubleClickPlaylist();
        //rightClickPlaylistToRename();
        //clickEditToRename();
        playlistPage.enterNewPlaylistName(name);
        Assert.assertEquals(playlistPage.getUpdateSuccessMsg(),expectedSuccessMsg);
    }

    @Test(dataProvider = "ValidCredentials", dataProviderClass = DataProviderClass.class)
    public void addSongsToPlaylist(String email,String password) {
        String expectedSongAddedMsg="Added 1 song into \"first playlist.\"";
        LoginPage loginPage= new LoginPage(getDriver());
        SongsPage songsPage = new SongsPage(getDriver());
        PlaylistPage playlistPage = new PlaylistPage(getDriver());

        loginPage.login(email,password);
        songsPage.searchSong("Pluto");
        songsPage.clickViewAllBtn();
        songsPage.selectFirstSongResult();
        songsPage.clickAddToBtn();
        playlistPage.choosePlaylistToAdd();
        String successMsg=playlistPage.getAddToPlaylistSuccessMsg();
        Assert.assertEquals(successMsg,expectedSongAddedMsg);
    }
}
