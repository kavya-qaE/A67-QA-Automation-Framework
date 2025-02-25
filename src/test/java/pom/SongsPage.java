package pom;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class SongsPage extends BasePageFactory{

    public SongsPage(WebDriver givenDriver) {
        super(givenDriver);
    }

    @FindBy(css = ".song-item:nth-child(1)")
    public WebElement firstSong;
    @FindBy(css = ".playback")
    public WebElement playBtn;
    @FindBy(css = ".items [draggable='true'] .fa-heart-o")
    public WebElement unlikedSong;
    @FindBy(css = ".items .song-item:nth-of-type(1) .title")
    public WebElement songTitle;
    @FindBy(css = ".songs")
    public WebElement allSongs;

    public void clickFirstSong() {
        actions.contextClick(firstSong).perform();
        playBtn.click();
    }
    public String getSongTitle () {
        return songTitle.getText();
    }
    public void addSongToFav () {
        unlikedSong.click();
    }
    public void clickAllSongs () {
        allSongs.click();
    }

}
