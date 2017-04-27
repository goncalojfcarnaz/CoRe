package Global;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

/**
 * Created by gcarnaz on 23/02/2017.
 */
public class IPropertiesDealer {

    public String ReturnPath(String Browser) throws IOException {
        String path="";
        InputStream inputStream;

        Properties prop = new Properties();
        String propFileName = "setup.properties";
        inputStream = getClass().getClassLoader().getResourceAsStream(propFileName);

        // Exceptions
        if (inputStream != null) {
            prop.load(inputStream);
        } else {
            throw new FileNotFoundException("property file '" + propFileName + "' not found in the classpath");
        }
        path = prop.getProperty(Browser);
        return  path;
    }


}
