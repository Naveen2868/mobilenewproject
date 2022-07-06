package utils;

import org.testng.Assert;

import java.io.*;
import java.util.Properties;

public class PropertiesUtils {
    static FileInputStream fis;
    static Properties properties;
    static  File file = new File(System.getProperty("user.dir") +
            File.separator + "src" + File.separator +"test"+ File.separator + "resources"+ File.separator + "ccdata.properties");

    static {
        try {
            fis = new FileInputStream(file);
            properties = new Properties();
            properties.load(fis);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
            System.exit(0);
        } catch (IOException e) {
            e.printStackTrace();
            System.exit(0);
        }
    }

    public void setProperty(String key, String value) throws IOException {
        FileOutputStream fos = new FileOutputStream(file);
        properties.setProperty(key, value);
        properties.store(fos, null);
        fos.close();
    }

    public static String getProperty(String key) {
        String value = properties.getProperty(key);
        if (value != null) {
            System.out.println("Value for the property " + key + " == " + value);
        } else {
            Assert.assertTrue(false, "Corresponding key value not present.");
        }
        return value;
    }
}
