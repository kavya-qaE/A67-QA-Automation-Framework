import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;

import java.time.Duration;

public class BaseTest {
    public WebDriver driver=null;
    String url = "https://qa.koel.app/";
    @BeforeSuite
    static void setupClass() {
        WebDriverManager.chromedriver().setup();
    }

    @BeforeMethod
    public void launchBrowser() {
        //      Added ChromeOptions argument below to fix websocket error
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--remote-allow-origins=*");
         driver = new ChromeDriver(options);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.manage().window().maximize();
    }

    public void navigateToPage() {
         driver.get(url);
    }
    @AfterMethod
    public void closeBrowser() {
        driver.quit();
    }

    public void provideEmail(String email){
        WebElement emailField=driver.findElement(By.cssSelector("input[type='email']"));
        emailField.clear();
        emailField.sendKeys(email);
    }

    public void providePassword(String password){
        WebElement passwordField=driver.findElement(By.cssSelector("input[type='password']"));
        passwordField.clear();
        passwordField.sendKeys(password);
    }

    public void clickSubmit(){
        WebElement submitButton=driver.findElement(By.cssSelector("button[type='submit']"));
        submitButton.click();
    }

    public void searchSong(String search) {
        WebElement searchField =driver.findElement(By.cssSelector("input[type='search']"));
        searchField.sendKeys(search);
    }

    public void clickViewAllBtn() throws InterruptedException {
        WebElement viewAllBtn=driver.findElement(By.cssSelector("button[data-test='view-all-songs-btn']"));
        viewAllBtn.click();
        Thread.sleep(3000);
    }

    public void selectFirstSongResult() throws InterruptedException {
        WebElement firstSong=driver.findElement(By.xpath("//section[@id='songResultsWrapper']//tr[@class='song-item']"));
        firstSong.click();
        Thread.sleep(3000);
    }

    public void clickAddToBtn() throws InterruptedException {
        WebElement addToBtn=driver.findElement(By.cssSelector("button[class='btn-add-to']"));
        addToBtn.click();
        Thread.sleep(3000);
    }

    public void choosePlaylist() throws InterruptedException {
        WebElement playlistName=driver.findElement(By.xpath("(//section[@id='songResultsWrapper']//li[@class='playlist'])[1]"));
        playlistName.click();
        Thread.sleep(3000);
    }

    public String getAddToPlaylistSuccessMsg() {
        WebElement notification=driver.findElement(By.cssSelector("div.success.show"));
        return notification.getText();
    }

    public void clickPlayOrResumeBtn() {
        WebElement playBtn=driver.findElement(By.cssSelector("[data-testid='play-btn']"));
        playBtn.click();
    }

    public void clickPlayNextSongBtn() {
        WebElement playNextSongBtn= driver.findElement(By.cssSelector("[data-testid=\"play-next-btn\"]"));
        playNextSongBtn.click();
    }

    public boolean getSoundBar() {
        WebElement soundBar=driver.findElement(By.cssSelector("[data-testid=\"sound-bar-play\"]"));
        return soundBar.isDisplayed();
    }

}