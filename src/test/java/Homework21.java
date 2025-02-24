import org.testng.Assert;
import org.testng.annotations.Test;

public class Homework21 extends BaseTest{
    @Test
    public void renamePlaylist(){
        String name=generateRandomName();
        String expectedSuccessMsg="Updated playlist \"" + name +"."+ "\"";

        provideEmail("kavya.ilapavuluri@testpro.io");
        providePassword("student#67");
        clickSubmit();
        doubleClickPlaylist();
        //rightClickPlaylistToRename();
       //clickEditToRename();
      enterNewPlaylistName(name);
      Assert.assertEquals(getUpdateSuccessMsg(),expectedSuccessMsg);
    }
}


