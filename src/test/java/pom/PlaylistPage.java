package pom;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.util.List;

public class PlaylistPage extends BasePage {
    public PlaylistPage(WebDriver givenDriver) {
        super(givenDriver);
    }

    @FindBy(css = ".playlist.favorites")
    WebElement favoritesPlaylist;
    @FindBy(css = ".favorites .virtual-scroller .title")
    WebElement favoriteSongTitle;
    @FindBy(css = ".favorites [draggable='true'] .text-maroon")
    List<WebElement> likedSongs;
   // @FindBy(xpath ="(//section[@id='songResultsWrapper']//li[@class='playlist'])[3]" )
   @FindBy(xpath ="(//section[@id='songResultsWrapper']//li[contains(text(),'first playlist')])")
    public WebElement choosePlaylistName;
    @FindBy(css = "div.success.show")
    public WebElement notification;
    @FindBy(css = "div.success.show")
    public WebElement notificationCreatedPlaylist;
    @FindBy(css ="[data-testid=\"sidebar-create-playlist-btn\"]" )
    public  WebElement createPlaylistBtn;
    @FindBy(xpath = "//*[@id=\"playlists\"]/nav/ul/li[1]")
    public  WebElement newPlaylist1;

    public void goToFavorites(){
        favoritesPlaylist.click();
    }

    public String getFirstFavoritesTitle(){
        return favoriteSongTitle.getText();
    }

    public void unselectAllFavorites() {
//        for (WebElement song : likedSongs) {// song.click(); }
        int size = likedSongs.size();
        for (int i = size-1; i >= 0; i--) {
            likedSongs.get(i).click();
            //Thread.sleep(1000);
//            WebElement song = likedSongs.get(i);
//            wait.until(ExpectedConditions.invisibilityOfElementLocated(By.className("panes")));
//            // Wait until the element is clickable
//            wait.until(ExpectedConditions.elementToBeClickable(song));
           // song.click();
        }
    }

    public void choosePlaylistToAdd(){
        //findElement(choosePlaylistName);
        choosePlaylistName.click();
    }

    public String getAddToPlaylistSuccessMsg() {
       // findElement(notification);
        return notification.getText();
    }

    public void clickPlusToCreate() {
        findElement(createPlaylistBtn);
        createPlaylistBtn.click();
    }

    public void clickNewPlaylistToCreate() {
        findElement(newPlaylist1);
        newPlaylist1.click();
    }
    @FindBy(xpath = "//form[@class='create']//input[@name='name']")
    public WebElement newPlaylistName;
    public void inputNewPlaylistName(String name){
        newPlaylistName.clear();
        newPlaylistName.sendKeys(name);
        newPlaylistName.sendKeys(Keys.ENTER);
    }


    public String getCreateSuccessMsg() {
        return notificationCreatedPlaylist.getText();
    }
//    @FindBy(xpath = "//nav[@id=\"sidebar\"]//section[@id=\"playlists\"]//ul/li//*[text()='" + playlistName + "']")
//    public WebElement playlistNameToDelete;
    public void choosePlaylistToDelete(String playlistName) {
        WebElement playlistNameToDelete= driver.findElement(By.xpath("//nav[@id=\"sidebar\"]//section[@id=\"playlists\"]//ul/li//*[text()='" + playlistName + "']"));
        playlistNameToDelete.click();
    }
    @FindBy(css ="button[class='del btn-delete-playlist']" )
    public WebElement redPlaylistBtn;
    public void clickRedPlaylistBtn(){
        redPlaylistBtn.click();
    }

    @FindBy(css ="div.success.show" )
    public WebElement notificationDeletedPlaylist;
    public String getDeleteSuccessMsg() {
        findElement(notificationDeletedPlaylist);
        return notificationDeletedPlaylist.getText();
    }
    @FindBy(css = ".playlist.playlist:nth-of-type(3)")
    public WebElement playlistToRename;
    public  void doubleClickPlaylist(){
        actions.doubleClick(playlistToRename).perform();
        System.out.println("double click performed.");
    }

    @FindBy(css = "[data-testid='inline-playlist-name-input']")
    public  WebElement playlistInputField;
    public void enterNewPlaylistName(String name) {
        playlistInputField.sendKeys(Keys.chord(Keys.CONTROL+"A",Keys.BACK_SPACE));
        playlistInputField.sendKeys(name);
        playlistInputField.sendKeys(Keys.ENTER);
    }

    public String getUpdateSuccessMsg() {
        findElement(notification);
        return notification.getText();
    }

    /*public void clickEditToRename() {
        WebElement edit= wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("li[data-testid=\"playlist-context-menu-edit-102592\"]")));
        edit.click();
    }

    public void rightClickPlaylistToRename() {
        WebElement playlistToRename= wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//section[@id='playlists']//li//a[text()='apple']")));
        System.out.println("Element found: " + playlistToRename.getText());
        action.contextClick(playlistToRename).perform();
        System.out.println("Right-click performed on the 'apple' playlist.");
        //WebElement contextMenu = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("nav[class=\"menu playlist-item-menu\"]")));
        //System.out.println("Context menu is visible: " + contextMenu.isDisplayed());
    }*/
}
