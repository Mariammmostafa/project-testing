package Utelities;

import java.io.FileInputStream;
import java.io.IOException;

import java.util.Properties;

public class LoadProperties {
 static   Properties environmentSetUp=loadProperties("src/main/resources/environmentSetUp.properties");
  static String URL = environmentSetUp.getProperty("URL");
  static String Browser=environmentSetUp.getProperty("Browser");
   //hstkhdm l url w l browser fl drive manger ashnn ayn kan l browser ydkhul

    public static Properties loadProperties(String path) {
        Properties props = new Properties();
        try {
            FileInputStream stream = new FileInputStream( path);
            props.load(stream);
            stream.close();
        } catch (IOException e) {
            System.out.println(" Error loading properties file: " + e.getMessage());
        }
        return props;
    }
}
