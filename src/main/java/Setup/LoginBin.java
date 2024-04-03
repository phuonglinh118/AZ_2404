package Setup;

import BaseSetup.LocalDriverManager;
import Browser.AccessBin;
import Browser.AccessBin.*;
import Helper.Log;
import org.testng.ITestResult;
import org.testng.annotations.*;

import static BaseSetup.LocalDriverManager.setWebDriver;
import static Method.Methods.takeScreenShot;
import static TestCases.TC_Bin.*;

public class LoginBin {

  //  public static WebDriver driver;
    @BeforeMethod
    public void loginPageBin() throws Exception{
        String url = "https://accounts.binance.com/en/login";
        setWebDriver(AccessBin.loginBin(url));
        Thread.sleep(2000);

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
