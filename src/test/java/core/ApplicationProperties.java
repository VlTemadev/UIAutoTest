package core;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class ApplicationProperties {
    protected static FileInputStream fileInputStream;
    protected static Properties properties;

    static {
        try {

            fileInputStream = new FileInputStream("src/test/resources/applications.properties");
            properties = new Properties();
            properties.load(fileInputStream);

        } catch (IOException e) {

            e.printStackTrace();

        } finally {

            if (fileInputStream != null)
                try {
                    fileInputStream.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
        }
    }

    public static String getProperty(String key) {
        return properties.getProperty(key);
    }

}

