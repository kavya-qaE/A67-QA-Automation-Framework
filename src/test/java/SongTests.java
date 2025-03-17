import org.testng.Assert;
import org.testng.annotations.Test;
import pom.LoginPage;
import pom.PlaylistPage;
import pom.SongsPage;

public class SongTests extends BaseTest{
    @Test(dataProvider = "ValidCredentials", dataProviderClass = DataProviderClass.class)
    public void addSongToFavorites(String email,String password) {
        LoginPage loginPage= new LoginPage(getDriver());
        SongsPage songsPage = new SongsPage(getDriver());
        PlaylistPage playlistPage = new PlaylistPage(getDriver());

        loginPage.login(email,password);
        // Wait until the overlay is not visible
        overlay();
        //click favorites
        playlistPage.goToFavorites();
        playlistPage.unselectAllFavorites();
        songsPage.clickAllSongs();
        String title = songsPage.getSongTitle();
        songsPage.addSongToFav();
        playlistPage.goToFavorites();
        String songName = playlistPage.getFirstFavoritesTitle();
        Assert.assertEquals(title, songName);
    }

    @Test(dataProvider = "ValidCredentials", dataProviderClass = DataProviderClass.class)
    public void playSong(String email,String password){
        LoginPage loginPage= new LoginPage(getDriver());
        SongsPage songsPage = new SongsPage(getDriver());
        PlaylistPage playlistPage = new PlaylistPage(getDriver());

        loginPage.login(email,password);
        // Wait until the overlay is not visible
        overlay();
        songsPage.clickPlayNextSongBtn();
        songsPage.clickPlayOrResumeBtn();
        boolean result=songsPage.getSoundBar();
        Assert.assertTrue(result);
    }
}
