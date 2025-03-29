package pom;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.util.List;

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
        searchField.clear();
        searchField.sendKeys(search);
        searchField.sendKeys(Keys.ENTER);
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

    @FindBy(css=".item-container .song-item")
    public List<WebElement> songsList;
    @FindBy(css=".item-container .song-item")
    public List<WebElement> artistList;
    @FindBy(css=".item-container .song-item")
    public List<WebElement> albumList;
    @FindBy(css=".results .songs p")
    public WebElement noneFoundText;
    @FindBy(css="#searchForm .dirty")
    public WebElement clearSearchBtn;

    // Method to check if results are Displayed when searched
    public boolean areResultsDisplayed(){
        return findElement(viewAllBtn).isDisplayed();
    }
    // Method to check if songDetails are Displayed
    public boolean songDetails(){
        viewAllBtn.click();
        // Check the song details by looping through the lists
        System.out.println("Number of songs found: " + songsList.size());
        for (int i = 0; i < songsList.size(); i++) {
            WebElement song = songsList.get(i);
            WebElement artist = artistList.get(i);
            WebElement album = albumList.get(i);

            // Print the song details (Title, Artist, Album)
            System.out.println("Song Title: " + song.getText());
            System.out.println("Artist: " + artist.getText());
            System.out.println("Album: " + album.getText());

            // Check if the song is visible
            System.out.println("Song visible: " + song.isDisplayed());
        }
        return !songsList.isEmpty() || !artistList.isEmpty() || !albumList.isEmpty();
    }

    // Method to check for no results are displayed when searched for song
    public String isNoResultsDisplayed() {
        return findElement(noneFoundText).getText();
    }

    // Method to clear search input field using 'x' button
    public void clearSearchUsingXButton(){
        findElement(clearSearchBtn).click();
    }

    // Method to clear search using keyboard (Backspace)
    public void clearSearchUsingKeyboard() {
        findElement(clearSearchBtn).sendKeys(Keys.chord(Keys.CONTROL+"A",Keys.BACK_SPACE));
    }
}
