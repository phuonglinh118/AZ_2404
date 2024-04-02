package BaseSetup;

import org.openqa.selenium.WebDriver;

// class chứa phần khởi tạo và đóng browser
public class LocalDriverManager {
    //khai báo biến driver loại - kiểu dữ liệu của biến - tên biến
    // Thread local
    //private static ChromeDriver driver = new ThreadLocal<>();
    private static ThreadLocal<WebDriver> webDriver = new ThreadLocal<WebDriver>();
   // private static String driverPath = "src/main/resources/drivers/chromedriver_old.exe";
    public static WebDriver getDriver (){

        return webDriver.get();
    }
    //tuỳ chọn Browser, chạy trước khi gọi clas này (before class)
    public static void setWebDriver( WebDriver driver){

        webDriver.set(driver);
    }
    /*
    public void setDriver(String browserType, String url){
        switch (browserType){
            case "chrome":
                driver = initChromeDriver(url);
                break;
            case "firefox":
                System.out.println("khởi tạo firefox browser");
                break;
            default:
                System.out.println("Browser: " + browserType + "is invalid, Launch chrome browser");
                driver = initChromeDriver(url);

        }
    }
     */


    //chạy hàm initializeTestBaseSetup trước hết khi class này được gọi
   // @Parameters ({"url"})
   /*
    @BeforeClass
    public void initializeTestBaseSetup ( String url){
        try {
            // Khởi tạo driver và browser
            setDriver( url);
        } catch (Exception e){
            System.out.println("Error..." + e.getStackTrace());
        }

    }
*/
    //@AfterTest
    public static void tearDown() throws Exception {
        Thread.sleep(2000);
        webDriver.get().quit();
        webDriver.remove();
    }

}
