import org.testng.Assert;
import org.testng.annotations.Test;
import pom.LoginPageFactory;
import pom.PlaylistPage;
import pom.SongsPage;

public class SongTests extends BaseTest{
    @Test
    public void addSongToFavorites() {
        LoginPageFactory loginPageFactory = new LoginPageFactory(getDriver());
        SongsPage songsPage = new SongsPage(getDriver());
        PlaylistPage playlistPage = new PlaylistPage(getDriver());

        loginPageFactory.provideEmail("kavya.ilapavuluri@testpro.io");
        loginPageFactory.providePassword("student#67");
        loginPageFactory.clickSubmit();

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
}
