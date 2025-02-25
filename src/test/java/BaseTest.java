import com.github.javafaker.Faker;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.*;



import java.net.MalformedURLException;
import java.net.URI;
import java.time.Duration;

public class BaseTest {
    public WebDriver driver=null;
    public WebDriverWait wait=null;
    String url=null;
    Actions action=null;

    @DataProvider(name = "playlistNames")
    public Object[][] playlistNames(){
        return new Object[][]{
                {"banana playlist"}
        };
    }

    @BeforeSuite
    static void setupClass() {
        WebDriverManager.chromedriver().setup();
    }

    @BeforeMethod
    @Parameters({"BaseURL"})
    public void launchBrowser(String BaseURL) throws MalformedURLException {
        //      Added ChromeOptions argument below to fix websocket error
       // ChromeOptions options = new ChromeOptions();
       // options.addArguments("--remote-allow-origins=*");
        // driver = new ChromeDriver(options);
        driver = pickBrowser(System.getProperty("browser"));
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.manage().window().maximize();
        wait=new WebDriverWait(driver,Duration.ofSeconds(10));
        action=new Actions(driver);
        url=BaseURL;
        navigateToPage();
    }

    public void navigateToPage() {
         driver.get(url);
    }
    @AfterMethod
    public void closeBrowser() {
        driver.quit();
    }

    public WebDriver pickBrowser(String browser) throws MalformedURLException {
        String gridUrl = "http://192.168.0.159:4444"; // replace with our grid url
        DesiredCapabilities desiredCapabilities = new DesiredCapabilities();
        switch (browser) {
            case "firefox":
                WebDriverManager.firefoxdriver().setup();
                driver = new FirefoxDriver();
                return driver;
            case "chrome":
                WebDriverManager.chromedriver().setup();
                ChromeOptions options = new ChromeOptions();
                options.addArguments("--remote-allow-origins=*");
                options.addArguments("--disable-notifications");
                driver = new ChromeDriver(options);
                return driver;
            case "grid-chrome":
                desiredCapabilities.setBrowserName("chrome");
                driver = new RemoteWebDriver(URI.create(gridUrl).toURL(), desiredCapabilities);
                return driver;
            case "grid-firefox":
                desiredCapabilities.setCapability("browserName", "firefox");
                driver = new RemoteWebDriver(URI.create(gridUrl).toURL(), desiredCapabilities);
                return driver;
            default:
                WebDriverManager.firefoxdriver().setup();
                driver = new FirefoxDriver();
                return driver;
        }
    }

    public void overlay(){
        boolean isInvisible=wait.until(ExpectedConditions.invisibilityOfElementLocated(By.id("overlay")));
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

    public void clickViewAllBtn() {
        WebElement viewAllBtn=wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("button[data-test='view-all-songs-btn']")));
        viewAllBtn.click();
    }

    public void selectFirstSongResult() {
        WebElement firstSong=wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//section[@id='songResultsWrapper']//tr[@class='song-item']")));
        firstSong.click();
    }

    public void clickAddToBtn() {
        WebElement addToBtn=driver.findElement(By.cssSelector("button[class='btn-add-to']"));
        addToBtn.click();
    }

    public void choosePlaylist(){
        WebElement playlistName=wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//section[@id='songResultsWrapper']//li[@class='playlist'])[1]")));
        playlistName.click();
    }

    public String getAddToPlaylistSuccessMsg() {
        WebElement notification=wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("div.success.show")));
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

    public void choosePlaylistToDelete(String playlistName) {
        WebElement playlistNameToDelete= driver.findElement(By.xpath("//nav[@id=\"sidebar\"]//section[@id=\"playlists\"]//ul/li//*[text()='" + playlistName + "']"));
        playlistNameToDelete.click();
    }

    public void clickRedPlaylistBtn(){
        WebElement redPlaylistBtn=wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("button[class='del btn-delete-playlist']")));
        redPlaylistBtn.click();
    }

  /*  public void clickOkDialogBtn() {
        WebElement okBtn= driver.findElement(By.cssSelector("button.ok"));
        okBtn.click();
    }*/

    public String getDeleteSuccessMsg() {
        WebElement deleteMsg= wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("div.success.show")));
        return deleteMsg.getText();
    }

    public void clickPlusToCreate() {
        WebElement createPlaylistBtn=driver.findElement(By.cssSelector("[data-testid=\"sidebar-create-playlist-btn\"]"));
        createPlaylistBtn.click();
    }

    public void clickNewPlaylistToCreate() {
        WebElement newPlaylist1= wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id=\"playlists\"]/nav/ul/li[1]")));
        newPlaylist1.click();
    }

    public void inputNewPlaylistName(String name){
        WebElement newPlaylistName=wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//form[@class='create']//input[@name='name']")));
        newPlaylistName.clear();
        newPlaylistName.sendKeys(name);
        newPlaylistName.sendKeys(Keys.ENTER);
    }

    protected String getCreateSuccessMsg() {
        WebElement createMsg= wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("div.success.show")));
        return createMsg.getText();
    }

    public String getUpdateSuccessMsg() {
        WebElement successMsg= driver.findElement(By.cssSelector("div.success.show"));
        return successMsg.getText();
    }

    public String generateRandomName(){
        Faker faker = new Faker();
        String newName = faker.name().firstName();
        return newName;
    }

    public void enterNewPlaylistName(String name) {
        WebElement playlistInputField=wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("[data-testid='inline-playlist-name-input']")));
        playlistInputField.sendKeys(Keys.chord(Keys.CONTROL+"A",Keys.BACK_SPACE));

        playlistInputField.sendKeys(name);
        playlistInputField.sendKeys(Keys.ENTER);
    }

    public  void doubleClickPlaylist(){
        WebElement playlistToRename= wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".playlist.playlist:nth-of-type(3)")));
        action.doubleClick(playlistToRename).perform();
        System.out.println("double click performed.");
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