package Global;

// IMPORT'S

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.internal.WrapsDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.Reporter;

import java.util.List;
import java.util.Set;

import static Global.BrowserEnvironment.driver;
/**
 * Created by Carnaz on 03/01/2016.
 * Description: Methods to DEAL with SELENIUM Components
 */
public class SeleniumVault {

    public Select select;

    /**
     * Descrição: ON/OFF para component's switch's
     */
    public void setSwitchElements(int flag, WebElement ObjCheck) {
        switch (flag) {
            case 0: // OFF
            {
                boolean isChecked = "true".equals(ObjCheck.getText());
                if (isChecked) {
                    System.out.print("True");
                    ObjCheck.click();
                } else {
                    System.out.print("False");

                }
            }
            case 1: // ON
            {
                boolean isChecked = "true".equals(ObjCheck.getText());
                if (isChecked) {
                    System.out.print("True");
                } else {
                    System.out.print("False");
                    ObjCheck.click();
                }
            }
        }

    }

    /**
     * CLICK and WAIT in WebElements
     *
     * @param element
     * @param driver
     */
    public void WaitAnClickElements(WebElement element, WebDriver driver) {
        WebDriverWait wait = new WebDriverWait(driver, 100);
        wait.until(ExpectedConditions.elementToBeClickable(element));
        if (driver instanceof JavascriptExecutor) {
            ((JavascriptExecutor)driver).executeScript("arguments[0].style.border='3px solid red'", element);
        }
        new Actions(driver).moveToElement(element).click().perform();
    }

    /**
     * CLICK and WAIT and SENDKEYS in WebElements
     *
     * @param element
     * @param driver
     * @param Texto
     */
    public void WaitAnSendKeysElements(WebElement element, WebDriver driver, String Texto) {
        WebDriverWait wait = new WebDriverWait(driver, 100);
        wait.until(ExpectedConditions.elementToBeClickable(element));
        if (driver instanceof JavascriptExecutor) {
            ((JavascriptExecutor)driver).executeScript("arguments[0].style.border='3px solid red'", element);
        }
        new Actions(driver).moveToElement(element).sendKeys(Texto).perform();

    }

    /**
     * RETURN TEXT from SELECTED WEBELEMENT
     *
     * @param element
     * @param driver
     * @return
     */
    public String returnTextfromComponent(WebElement element, WebDriver driver) {
        WebDriverWait wait = new WebDriverWait(driver, 100);
        wait.until(ExpectedConditions.elementToBeClickable(element));
        return element.getText();
    }

    /**
     * SELECT a OPTION from a OPTION WEBCOMPONENT
     *
     * @param selector
     * @param value
     */
    public void selectOption(By selector, Object value) {
        WebElement element = getElement(selector);
        List<WebElement> options = element.findElements(getTagName("option"));
        select = new Select(element);
        try {
            for (WebElement option : options) {
                if (option.isDisplayed()) {
                    if (value instanceof String) {
                        select.selectByValue((String) value);
                        break;
                    } else if (value instanceof Integer) {
                        select.selectByIndex((Integer) value);
                        break;
                    }
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * VERIFY IF A WEBELEMENT EXIST'S
     *
     * @param selector
     * @return
     */
    public WebElement getElement(By selector) {
        try {
            return driver.findElement(selector);
        } catch (Exception e) {
            System.out.println(String.format("Element %s does not exist - proceeding", selector));
        }
        return null;
    }

    /**
     * GET TAG NAME
     *
     * @param Selector
     * @return
     */
    public By getTagName(String Selector) {
        return By.tagName(Selector);
    }

    /**
     * Switch Windows
     */

    /**
     * Switch to Another Window
     *
     * @param driver  - Current Driver
     * @param sString - Name of the current window
     * @return
     */
    public static boolean switchToWindow(WebDriver driver, String sString) {
        String currentHandle = driver.getWindowHandle();
        Set<String> handles = driver.getWindowHandles();
        if (!handles.isEmpty()) {
            for (String handle : handles) {
                Reporter.log("Switching to other window");
                driver.switchTo().window(handle);
                if (sString.equals(driver.getTitle())) {
                    Reporter.log("switched to window with title:" + sString);
                    return true;
                }
            }
            driver.switchTo().window(currentHandle);

            Reporter.log("Window with title:" + sString
                    + " Not present,Not able to switch");
            return false;
        } else {
            Reporter.log("There is only one window handle :" + currentHandle);
            return false;
        }
    }

    // ** Click Element - XPATH -  by JAVASCRIPT
    public static void clickElement(String xpath)
    {
        WebElement element = driver.findElement(By.xpath(xpath));
        JavascriptExecutor executor = (JavascriptExecutor)driver;
        executor.executeScript("arguments[0].click();", element);
    }

    // ** Click Element - CLASS - by JAVASCRIPT
    public static void clickElementbyClass(String Classe)
    {
        WebElement element = driver.findElement(By.className(Classe));
        JavascriptExecutor executor = (JavascriptExecutor)driver;
        executor.executeScript("arguments[0].click();", element);
    }
    public static void clickElementbyXpath(String xpath)
    {
        WebElement element = driver.findElement(By.className(xpath));
        JavascriptExecutor executor = (JavascriptExecutor)driver;
        executor.executeScript("arguments[0].click();", element);
    }


    public static void setAttribute(WebElement element, String attName, String attValue) {
        WrapsDriver wd = (WrapsDriver) element;
        JavascriptExecutor dr = (JavascriptExecutor) wd.getWrappedDriver();
        dr.executeScript("arguments[0].setAttribute(arguments[1],arguments[2])", element, attName, attValue);
    }

    public static void moveUpDown(String Move, WebDriver driver) {
        JavascriptExecutor jse = (JavascriptExecutor) driver;
        if (Move == "UP") {
            ((JavascriptExecutor) driver).executeScript("window.scrollBy(0,-500)");
            // jse.executeScript("window.scrollBy(0,500)", "");
        } else if (Move == "DOWN") {
            jse.executeScript("window.scrollBy(0,-250)", "");
        }

    }


    public static void clickJS( WebDriver driver) {
        JavascriptExecutor jse = (JavascriptExecutor) driver;

            jse.executeScript("a[href=\"/fs/modules/_tickets/manager/ticket-manager/manager-ticket.html\"]').click()", "");


    }

    // ** INPUT TEXT - TEXTBOX
    public static void inputTXTbox(String Texto, String id)
    {
       JavascriptExecutor jse = (JavascriptExecutor) driver;
       jse.executeScript("document.getElementById('"+ id +"').value = ' " + Texto + "';");
    }

    public static void innerText(String Class, String Texto)
    {
        WebElement e = driver.findElement(By.className(Class));
        ((JavascriptExecutor) driver).executeScript("arguments[0].innerHTML='"+ Texto +"'", e);

     }

    public static int LoadTableReturnNumberOfRows(String ElementID) {
        WebElement table_element = driver.findElement(By.id(ElementID));
        List<WebElement> tr_collection = table_element.findElements(By.xpath("id('" + ElementID + "')/tbody/tr"));

        System.out.println("Numero de linhas na tabela = " + tr_collection.size());
        int row_num, col_num;
        row_num = 1;
        for (WebElement trElement : tr_collection) {
            List<WebElement> td_collection = trElement.findElements(By.xpath("td"));
            System.out.println("Numero de colunas=" + td_collection.size());
            col_num = 1;
            for (WebElement tdElement : td_collection) {
                System.out.println("linha # " + row_num + ", coluna # " + col_num + "texto=" + tdElement.getText());
                col_num++;
            }
            row_num++;
        }
        return row_num;


    }

    public static boolean LoadTableReturnIfElementIsPresent(String ElementID, String Elemento) {
        WebElement table_element = driver.findElement(By.id(ElementID));
        List<WebElement> tr_collection = table_element.findElements(By.xpath("id('" + ElementID + "')/tbody/tr"));
        boolean result = false;
        System.out.println("Numero de linhas na tabela = " + tr_collection.size());
        int row_num, col_num;
        row_num = 1;
        for (WebElement trElement : tr_collection) {
            List<WebElement> td_collection = trElement.findElements(By.xpath("td"));
            System.out.println("Numero de colunas=" + td_collection.size());
            col_num = 1;
            for (WebElement tdElement : td_collection) {
                System.out.println("linha # " + row_num + ", coluna # " + col_num + "texto=" + tdElement.getText());
                //System.out.println("Elemento Encontrado="+ Elemento);
                System.out.println("Elemento Encontrado=" + tdElement.getText());
                if (tdElement.getText() == Elemento) {
                    System.out.println("Elemento Encontrado=" + Elemento);
                    result = true;

                }
                col_num++;
            }
            row_num++;
        }
        return result;
    }

    public static WebElement LoadTableReturnElement(String ElementID, String Elemento) {
        WebElement table_element = driver.findElement(By.id(ElementID));
        List<WebElement> tr_collection = table_element.findElements(By.xpath("id('" + ElementID + "')/tbody/tr"));
        WebElement result= table_element;
        System.out.println("Numero de linhas na tabela = " + tr_collection.size());
        int row_num, col_num;
        row_num = 1;
        for (WebElement trElement : tr_collection) {
            List<WebElement> td_collection = trElement.findElements(By.xpath("td"));
            System.out.println("Numero de colunas=" + td_collection.size());
            col_num = 1;
            for (WebElement tdElement : td_collection) {
                System.out.println("linha # " + row_num + ", coluna # " + col_num + "texto=" + tdElement.getText());
                if (tdElement.getText() == Elemento) {
                    System.out.println("Elemento Encontrado=" + Elemento);
                    result = tdElement;
                    return result;
                }
                col_num++;
            }
            row_num++;
        }
        return result;
    }
    /**
     *
     * @param classLocator
     * @param text
     * @return
     */
    public static  WebElement getElementBasedOnClassAndText(String classLocator, String text) {
        List<WebElement> elements = driver.findElements(By.className(classLocator));
        for (WebElement element : elements) {
            if (element.getText().contentEquals(text)) {
                return element;
            }
        }
        Assert.fail("Unable to find any element with the said Text");
        return null;
    }

    public static void getElementComboBox(String dropXpath)
    {
        List <WebElement> allSuggestions = driver.findElements(By.xpath(dropXpath));
        for (WebElement suggestion : allSuggestions)
        {
            System.out.println(suggestion.getText());

        }
    }

    // ###########################################################################
    /**
     * RETURN Number of Element if have items - HTML ul
     *
     */
    // ###########################################################################
    public static void returnItemUlHtml(String Id)
    {
        List<WebElement> elems = driver.findElements(By.id(Id));
        System.out.print(elems.size());
    }






} // THE END
