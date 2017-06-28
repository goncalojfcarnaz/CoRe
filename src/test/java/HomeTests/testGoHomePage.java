package HomeTests;


import Global.BrowserEnvironment;
import Global.Log;
import PageObjects.HomePage;
import junit.framework.Assert;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.testng.Reporter;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.io.IOException;


/**
 * Created by gcarnaz on 17/01/2017.
 *
 *
 *
 */
public class testGoHomePage {
    public static WebDriver driver;
    @BeforeMethod
    public void beforeValidateProfilePage() throws IOException {
            this.driver = new BrowserEnvironment().setup("chrome");
    }

    @Test(groups = "SmokeTestSuite")
    public void testGoHomePage() throws IOException {
        HomePage obj = new HomePage(driver);
        Log.startTestCase("testGoHomePage", "Aceder à página do GOOGLE");
        Log.info("Pesquisar");
        // obj.pesquisadados("Batman" + Keys.ENTER);
        // obj.setBtnpesquisa();
        // obj.setLblImagens();
        obj.setIniciar();
        Log.endTestCase("testGoHomePage");
    }



    @AfterMethod
    public void afterValidateProfilePage(){


    }


}
