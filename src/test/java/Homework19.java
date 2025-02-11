import org.testng.Assert;
import org.testng.annotations.Test;

public class Homework19 extends BaseTest{
    @Test
    public void createPlaylist() throws InterruptedException{
        String expectedCreatedPlaylistMsg="Created playlist \"second playlist.\"";
        navigateToPage();
        provideEmail("kavya.ilapavuluri@testpro.io");
        providePassword("student#67");
        clickSubmit();
        clickPlusToCreate();
        clickNewPlaylistToCreate();
        inputNewPlaylistName("second playlist");
        Assert.assertEquals(getCreateSuccessMsg(),expectedCreatedPlaylistMsg);
    }

    @Test
    public void deletePlaylist() throws InterruptedException {
        String expectedDeletedPlaylistMsg="Deleted playlist \"second playlist.\"";
        navigateToPage();
        provideEmail("kavya.ilapavuluri@testpro.io");
        providePassword("student#67");
        clickSubmit();
        choosePlaylistToDelete();
        clickRedPlaylistBtn();
      //  clickOkDialogBtn();
        Assert.assertEquals(getDeleteSuccessMsg(),expectedDeletedPlaylistMsg);

    }

}
