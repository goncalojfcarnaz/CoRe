package Global;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;
import org.testng.Reporter;

import java.io.File;
import java.io.IOException;
import java.util.logging.FileHandler;
import java.util.logging.Logger;
import java.util.logging.SimpleFormatter;

import static Global.BrowserEnvironment.driver;

/**
 * Created by Carnaz on 19/10/2016.
 * Description
 */


public class Screenshot implements ITestListener {

        // SET UP PATH: FOLDER TO STORE SCREENSHOTS
        String filePath = "C:\\SCREENSHOTS\\";

        public void onTestFailure(ITestResult result) {

            Logger logger = Logger.getLogger("MyLog");
            FileHandler fh;
            try {
                // This block configure the logger with handler and formatter
                fh = new FileHandler(filePath + "TestResults.log");
                logger.addHandler(fh);
                SimpleFormatter formatter = new SimpleFormatter();
                fh.setFormatter(formatter);
                // LOG - MESSAGES
                logger.info("***** RESULTADO: "+result.getName()+" - O TESTE FALHOU  *****");
                String methodName=result.getName().toString().trim();
                // TAKE PHOTO
                takeScreenShot(methodName);
            } catch (SecurityException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        public void takeScreenShot(String methodName) {
          File scrFile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
            try {

                FileUtils.copyFile(scrFile, new File(filePath+methodName+".png"));
                System.out.println("***Placed screen shot in "+filePath+" ***");
                String reportDirectory = new File(System.getProperty("user.dir")).getAbsolutePath() + "\\target\\surefire-reports";
                File destFile = new File((String) reportDirectory+"\\failure_screenshots\\"+methodName+ ".png");
                FileUtils.copyFile(scrFile, destFile);
                //Reporter.log(String.format("<img src='"+ destFile.getAbsolutePath() + "' height='100' width='100'/> Imagem</a>"));
                Reporter.log("<a href="  + destFile.getAbsolutePath()	+ ">Detailed Report</a>");

            } catch (IOException e) {
                e.printStackTrace();
            }

        }

        public void onFinish(ITestContext context) {}

        public void onTestStart(ITestResult result) {
            Logger logger = Logger.getLogger("MyLog");
            FileHandler fh;
            try {
                // This block configure the logger with handler and formatter
                fh = new FileHandler(filePath + "TestResults.log");
                logger.addHandler(fh);
                SimpleFormatter formatter = new SimpleFormatter();
                fh.setFormatter(formatter);
                // the following statement is used to log any messages
                logger.info("***** TESTE INICIOU: "+result.getName()+" *****");
                String methodName=result.getName().toString().trim();
               // takeScreenShot(methodName);
            } catch (SecurityException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        public void onTestSuccess(ITestResult result) {
            Logger logger = Logger.getLogger("MyLog");
            FileHandler fh;
            try {
                // This block configure the logger with handler and formatter
                fh = new FileHandler(filePath + "TestResults.log");
                logger.addHandler(fh);
                SimpleFormatter formatter = new SimpleFormatter();
                fh.setFormatter(formatter);

                // the following statement is used to log any messages
                logger.info("***** RESULTADO: "+result.getName()+" O Teste PASSOU *****");
                String methodName=result.getName().toString().trim();
              //  takeScreenShot(methodName);
            } catch (SecurityException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        public void onTestSkipped(ITestResult result) {   }

        public void onTestFailedButWithinSuccessPercentage(ITestResult result) {   }

        public void onStart(ITestContext context) {   }

} // THE END

