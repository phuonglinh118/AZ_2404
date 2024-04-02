package Setup;

import BaseSetup.LocalDriverManager;
import Browser.AccessInsideTest;
import Helper.Log;
import org.testng.ITestResult;
import org.testng.annotations.*;

import static BaseSetup.LocalDriverManager.setWebDriver;
import static Method.Methods.takeScreenShot;
import static Testcases.TcInsideTest.inputInfoAndPressLogin;

public class LoginInsideTest {

  //  public static WebDriver driver;
    @BeforeMethod
    public void loginPageInside () throws Exception{
        String url = "https://accounts.binance.com/en/login?loginChannel=&return_to=aHR0cHM6Ly93d3cuYmluYW5jZS5jb20vZW4vbXkvZGFzaGJvYXJk";
        String user = "linhntp@hasaki.vn"; //linhntp@hasaki.vn //admintest1@hsk.vn //shop176@hasaki.vn //shop555@hasaki.vn //dailtt@hasaki.vn //nhungdnh //ngocy // cashier71@hasaki.vn
        String pass = "hsk123"; //hsk123 // 123456
        setWebDriver(AccessInsideTest.loginInsideTest(url));
        Thread.sleep(2000);
        inputInfoAndPressLogin(user, pass);
    }
    @AfterMethod
    public void closeChromeBrowser (ITestResult result) throws Exception {
        Log.info(result.getName());
        if (ITestResult.FAILURE == result.getStatus()){
            try {
                takeScreenShot("src/main/resources/Screen Shot/FailScreen_Inside.jpg");
            }
            catch (Exception e){
                System.out.println("Error Message: " + e.getMessage());
            }
        }

        LocalDriverManager.tearDown();
    }
}
