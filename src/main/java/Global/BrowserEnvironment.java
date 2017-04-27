package Global;// IMPORTS
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.testng.annotations.Parameters;

import java.io.File;
import java.io.IOException;

/**
 * This class supports WEBDRIVER links
 *
 *
 * @author Gonçalo Carnaz
 */
public class BrowserEnvironment {

    public static WebDriver driver; // Global Variable - WebDriver

    /**
     * With BROWSER selection, and OS SYSTEM
     * @param browser
     * @throws IOException
     */
    @Parameters("browser")
    public WebDriver setup(String browser) throws IOException {

        String osName = System.getProperty("os.name");
        String osNameMatch = osName.toLowerCase();

        if(osNameMatch.contains("linux"))
        {

        }
        else if(osNameMatch.contains("windows"))
        {
            //** BROWSER: IExplore *********************************************
            if(browser.equalsIgnoreCase("iexplore")){
                File file = new File(new IPropertiesDealer().ReturnPath("iexplorer"));
                System.setProperty("webdriver.ie.driver", file.getAbsolutePath());
                driver = new InternetExplorerDriver();
            }
            // **********************************************
            //** BROWSER: Firefox ********************************************************
            if(browser.equalsIgnoreCase("firefox")){
                driver = new FirefoxDriver();
            }
            // *******************************************************************
            //** BROWSER: Chrome ****************************************************************
            if(browser.equalsIgnoreCase("chrome")){
                File file = new File(new IPropertiesDealer().ReturnPath("chromedriverW"));
                System.setProperty("webdriver.chrome.driver", file.getAbsolutePath());
                driver = new ChromeDriver();
            }

            // *********************************************************************
            // NOW WE ARE READY - GO HOME
            new goHome().SetupHome(driver);
        }
        return driver;
    }
    /**
     * TEARDOWN
     */
    public void Teardown()
    {
        // CLOSE DRIVER
        driver.close();
    }
} // THE END

