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
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.*;



import java.net.MalformedURLException;
import java.net.URI;
import java.net.URL;
import java.time.Duration;
import java.util.HashMap;

public class BaseTest {
    public WebDriver driver=null;
    public WebDriverWait wait=null;
    String url=null;
    Actions action=null;
    // ThreadLocal for WebDriver to support parallel execution
    private static final ThreadLocal<WebDriver> threadDriver=new ThreadLocal<>();
//    @BeforeSuite
//    static void setupClass() {
//        WebDriverManager.chromedriver().setup();
//    }

    @BeforeMethod
    @Parameters({"BaseURL"})
    public void launchBrowser(String BaseURL) throws MalformedURLException {
        // Set WebDriver based on system property (in build.gradle)
        threadDriver.set(pickBrowser(System.getProperty("browser")));
         getDriver().manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        getDriver().manage().window().maximize();
        wait=new WebDriverWait(getDriver(),Duration.ofSeconds(10));
        action=new Actions(getDriver());
        url=BaseURL;
        navigateToPage();
    }

    // It returns current instance of webDriver associated with the current thread.(Parallel testing)
    public WebDriver getDriver() {
        return threadDriver.get();
    }

    @AfterMethod(alwaysRun=true)
    public void closeDriver() {
        threadDriver.get().quit(); // Clean up WebDriver instance after each test
    }

    public void navigateToPage() {
         threadDriver.get().get(url);
    }
//    @AfterMethod
//    public void closeBrowser() {
//        driver.quit();
//    }

    public WebDriver pickBrowser(String browser) throws MalformedURLException {
        String gridUrl = "http://192.168.1.149:4444"; // replace with our grid url
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
            case "cloud":
                return getLambdaDriver();
            default:
                WebDriverManager.chromedriver().setup();
                options = new ChromeOptions();
                options.addArguments("--remote-allow-origins=*");
                options.addArguments("--disable-notifications");
                driver = new ChromeDriver(options);
                return driver;
        }
    }

    public WebDriver getLambdaDriver() throws MalformedURLException {
        String userName = "kavya.new24";
        String authKey = "LT_pr7pusiWCpCtmMPWmQBXnJS7jDx18PaBQPxmmTrRze2UrX8";
        String hubURL = "https://hub.lambdatest.com/wd/hub";

        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setCapability("browserName", "Chrome");
        capabilities.setCapability("browserVersion", "130.0");
        HashMap<String, Object> ltOptions = new HashMap<>();
        ltOptions.put("username", userName);
        ltOptions.put("accessKey", authKey);
        ltOptions.put("project", "Koel");
        ltOptions.put("w3c", true);
        ltOptions.put("plugin", "java-testNG");
        ltOptions.put("platformName", "Windows 10");
        capabilities.setCapability("LT:Options", ltOptions);

        return new RemoteWebDriver(new URL(hubURL), capabilities);
    }

    public void overlay(){
        boolean isInvisible=wait.until(ExpectedConditions.invisibilityOfElementLocated(By.id("overlay")));
    }

    public String generateRandomName(){
        Faker faker = new Faker();
        String newName = faker.name().firstName();
        return newName;
    }
}