package Global;



import org.testng.Reporter;

import java.util.logging.Logger;

/**
 *
 */

public class Log {

    private static Logger Log = Logger.getLogger(Log.class.getName());

    // This is to print log for the beginning of the test case, as we usually run so many test cases as a test suite

    public static void startTestCase(String sTestCaseName, String Description){

        Log.info("::: S.T.A.R.T. :::"+ sTestCaseName + ":::");
        Log.info("Description: " + Description);
        Reporter.log("::: S.T.A.R.T. :::"+ sTestCaseName + ":::");
        Reporter.log("Description:" + Description);
    }

    //This is to print log for the ending of the test case

    public static void endTestCase(String sTestCaseName){

        Log.info("::: E.N.D. :::"+" :::"+ sTestCaseName + ":::");
        Reporter.log("::: E.N.D :::"+" :::" + sTestCaseName + ":::");

    }

    // Need to create these methods, so that they can be called

    public static void info(String message) {

        Log.info(message);
        Reporter.log(message);
    }



}
