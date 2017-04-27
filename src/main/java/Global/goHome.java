package Global;

import PageObjects.HomePage;
import org.openqa.selenium.WebDriver;

import java.io.IOException;
import java.util.concurrent.TimeUnit;


/**
 * Created by gcarnaz on 22/03/2017.
 */
public class goHome {
    public static WebDriver driver;

    public void SetupHome(WebDriver driver) throws IOException {

        this.driver = driver;

        // NAVEGAR PARA A PLATAFORMA A TESTAR
        driver.navigate().to(new IPropertiesDealer().ReturnPath("plataformurl"));
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.manage().window().maximize();
        // EFECTUAR O LOGIN | PASSWORD






    }

}
