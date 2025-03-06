package pom;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class SongsPage extends BasePage {

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
    @FindBy(css = "[data-testid=\"play-next-btn\"]")
    public WebElement playNextSongBtn;
    @FindBy(css = "[data-testid='play-btn']")
    public WebElement playOrResumeBtn;
    @FindBy(css = "[data-testid=\"sound-bar-play\"]")
    public WebElement soundBar;
    @FindBy(css ="input[type='search']" )
    public WebElement searchField;
    @FindBy(css ="button[data-test='view-all-songs-btn']")
    public WebElement viewAllBtn;
    @FindBy(xpath ="//section[@id='songResultsWrapper']//tr[@class='song-item']" )
    public WebElement firstSongResult;
    @FindBy(css = "button[class='btn-add-to']")
    public  WebElement addToBtn;

    public void clickFirstSong() {
        actions.contextClick(firstSong).perform();
        playBtn.click();
    }
    public String getSongTitle () {
        return songTitle.getText();
    }
    public void addSongToFav () {

        wait.until(ExpectedConditions.elementToBeClickable(unlikedSong)).click();
    }
    public void clickAllSongs () {
        allSongs.click();
    }

    public void clickPlayNextSongBtn() {
        playNextSongBtn.click();
    }

    public void clickPlayOrResumeBtn() {
        playOrResumeBtn.click();
    }

    public boolean getSoundBar() {
        return soundBar.isDisplayed();
    }

    public void searchSong(String search) {
        searchField.sendKeys(search);
    }

    public void clickViewAllBtn() {
        viewAllBtn.click();
    }

    public void selectFirstSongResult() {
        firstSongResult.click();
    }

    public void clickAddToBtn() {
        findElement(addToBtn);
        addToBtn.click();
    }
}
