import org.testng.Assert;
import org.testng.annotations.Test;

public class Homework17 extends BaseTest{
    @Test
    public void addSongsToPlaylist() {
        String expectedSongAddedMsg="Added 1 song into \"apple.\"";

        navigateToPage();
        provideEmail("kavya.ilapavuluri@testpro.io");
        providePassword("student#67");
        clickSubmit();
        searchSong("Pluto");
        clickViewAllBtn();
        selectFirstSongResult();
        clickAddToBtn();
        choosePlaylist();
        String successMsg=getAddToPlaylistSuccessMsg();
        Assert.assertEquals(successMsg,expectedSongAddedMsg);
    }
}
