import org.testng.Assert;
import org.testng.annotations.Test;

public class Homework20 extends BaseTest{
    @Test  (dataProvider = "playlistNames")
    public void createPlaylist(String playlistName){
        String expectedCreatedPlaylistMsg="Created playlist \"" + playlistName +"."+ "\"";

        provideEmail("kavya.ilapavuluri@testpro.io");
        providePassword("student#67");
        clickSubmit();
        clickPlusToCreate();
        clickNewPlaylistToCreate();
        inputNewPlaylistName(playlistName);
        Assert.assertEquals(getCreateSuccessMsg(),expectedCreatedPlaylistMsg);
    }

    @Test  (dataProvider = "playlistNames")
    public void deletePlaylist(String playlistName){
        String expectedDeletedPlaylistMsg="Deleted playlist \"" + playlistName +"."+ "\"";

        provideEmail("kavya.ilapavuluri@testpro.io");
        providePassword("student#67");
        clickSubmit();
        choosePlaylistToDelete(playlistName);
        clickRedPlaylistBtn();
        //  clickOkDialogBtn();
        Assert.assertEquals(getDeleteSuccessMsg(),expectedDeletedPlaylistMsg);

    }

}
