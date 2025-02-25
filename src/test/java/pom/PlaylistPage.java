package pom;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

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
        for (WebElement song : likedSongs) {
            song.click();
        }
    }
}
