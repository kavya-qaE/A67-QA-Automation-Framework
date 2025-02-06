import org.testng.Assert;
import org.testng.annotations.Test;

public class Homework18 extends BaseTest{
    @Test
    public void playSong(){
        navigateToPage();
        provideEmail("kavya.ilapavuluri@testpro.io");
        providePassword("student#67");
        clickSubmit();
        clickPlayNextSongBtn();
        clickPlayOrResumeBtn();
        boolean result=getSoundBar();
        Assert.assertTrue(result);
    }

}
