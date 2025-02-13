/*public class Homework19 extends BaseTest{
    @Test
    public void createPlaylist(){
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
    public void deletePlaylist(){
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
*/