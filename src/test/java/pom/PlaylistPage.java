package pom;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.util.List;

public class PlaylistPage extends BasePageFactory{
    public PlaylistPage(WebDriver givenDriver) {
        super(givenDriver);
    }

    @FindBy(css = ".playlist.favorites")
    WebElement favoritesPlaylist;

    @FindBy(css = ".favorites .virtual-scroller .title")
    WebElement favoriteSongTitle;

    @FindBy(css = ".favorites [draggable='true'] .text-maroon")
    List<WebElement> likedSongs;

    public void goToFavorites(){
        favoritesPlaylist.click();
    }

    public String getFirstFavoritesTitle(){
        return favoriteSongTitle.getText();
    }

    public void unselectAllFavorites() {
//        for (WebElement song : likedSongs) {
//            song.click();
//        }
        int size = likedSongs.size();
        for (int i = size-1; i >= 0; i--) {
            //likedSongs.get(i).click();
            //Thread.sleep(1000);
            WebElement song = likedSongs.get(i);
            
            wait.until(ExpectedConditions.invisibilityOfElementLocated(By.className("panes")));
            // Wait until the element is clickable
            wait.until(ExpectedConditions.elementToBeClickable(song));
            song.click();
        }
    }
}
