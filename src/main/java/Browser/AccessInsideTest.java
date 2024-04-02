LoginInsideTestpackage Browser;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.time.Duration;
import java.util.Arrays;

public class AccessBin {
    public static WebDriver loginInsideTest (String url) throws InterruptedException{
        WebDriver driver;
        System.out.println("Launching Chrome browser ...");
//        selenium-java ver < 4.5 sử dụng command
//        System.setProperty("webdriver.chrome.driver", "src/main/resources/drivers/chromedriver.exe");
//        SELENIUM-JAVA VER MINIMUM 4.5 USE COMMAND
//        System.setProperty("webdriver.http.factory", "jdk-http-client");
        //tạo đối tượng cho chrome options
//        WebDriverManager.chromedriver().clearDriverCache().setup();
//        WebDriverManager.chromiumdriver().clearDriverCache().setup();
        DesiredCapabilities caps = new DesiredCapabilities();
        ChromeOptions options = new ChromeOptions();
        //Set chrome headless
//        options.setHeadless(true);
//        options.addArguments("--headless=chrome"); //ver < ver 96: headless -- Between versions 96 to 108 it was --headless=chrome, after version 109 --headless=new.
        options.addArguments("--disable-extensions");
        //Disable all pop-ups in Chrome
        options.setExperimentalOption("excludeSwitches", Arrays.asList("disable-popup-blocking"));
        options.addArguments("--disable-gpu");
        options.addArguments("--no-sandbox");
//        options.addArguments("--disable-print-preview");
        options.addArguments("--remote-allow-origins=*");// Chrome ver 111
        options.addArguments("--window-size=1920,1080");
        options.addArguments("--start-maximized");
        caps.setCapability(ChromeOptions.CAPABILITY, options);
        //khởi tạo chrome với options trên
        driver = new ChromeDriver(options);
//        driver =new ChromeDriver();
        driver.manage().window().maximize();
        //driver.navigate().to(https://inside.hasaki.vn);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
        driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(30));
        //open link & login
        //driver.get("https://inside.hasaki.vn:sbd4Jnws7l@inshasaki.com");
        driver.get(url);

        return driver;
    }
}
