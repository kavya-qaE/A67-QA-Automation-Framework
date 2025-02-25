import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.annotations.Test;

public class Homework18 extends BaseTest{
    @Test
    public void playSong(){

        provideEmail("kavya.ilapavuluri@testpro.io");
        providePassword("student#67");
        clickSubmit();
        // Wait until the overlay is not visible
        overlay();
        clickPlayNextSongBtn();
        clickPlayOrResumeBtn();
        boolean result=getSoundBar();
        Assert.assertTrue(result);
    }

}
