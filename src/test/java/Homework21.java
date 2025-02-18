import org.testng.Assert;
import org.testng.annotations.Test;

public class Homework21 extends BaseTest{
    @Test
    public void renamePlaylist(){
        String expectedSuccessMsg="Updated playlist\"apple.\"";

        provideEmail("kavya.ilapavuluri@testpro.io");
        providePassword("student#67");
        clickSubmit();
        doubleClickPlaylist();
        //rightClickPlaylistToRename();
       //clickEditToRename();
      enterNewPlaylistName();
      Assert.assertEquals(getUpdateSuccessMsg(),expectedSuccessMsg);
    }
}


