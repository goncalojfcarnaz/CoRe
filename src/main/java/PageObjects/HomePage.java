package PageObjects;

// IMPORT'S
import Global.SeleniumVault;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.AjaxElementLocatorFactory;
// **************************************************************************************

/**
 * Created by mazevedo on 09/01/2017.
 */
public class HomePage {
    public static WebDriver driver;

    @FindBy(xpath = "//*[@id=\"lst-ib\"]")
    WebElement caixapesquisa;

    @FindBy(xpath = "//*[@id=\"_fZl\"]/span/svg/path")
    WebElement btnpesquisa;

    @FindBy(xpath = "//*[@id=\"hdtb-msb-vis\"]/div[2]/a")
    WebElement lblImagens;

    @FindBy(xpath = "//*[@id=\"tsf\"]/div[2]/div[3]/center/input[1]")
    WebElement iniciar;

    // BOOT - PAGE FACTORY #############################################################################
    public HomePage(WebDriver driver)
    {
        this.driver = driver;
        AjaxElementLocatorFactory factory=new AjaxElementLocatorFactory(driver,100);
        PageFactory.initElements(factory, this);
    }
    // ################################################################################################


    public void pesquisadados(String dados)
    {
        new SeleniumVault().WaitAnSendKeysElements(caixapesquisa,driver,dados);

    }


    public void setBtnpesquisa()
    {
        new SeleniumVault().WaitAnClickElements(btnpesquisa,driver);
    }

    public void setLblImagens()
    {
        new SeleniumVault().WaitAnClickElements(lblImagens,driver);
    }

    public void setIniciar()
    {
        new SeleniumVault().WaitAnClickElements(iniciar,driver);
    }

} // THE END
