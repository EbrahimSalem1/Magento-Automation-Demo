package utils;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class PropertyReader {
    Properties properties;


    public PropertyReader(String pathFile){

        properties = new Properties();
        try {
            FileInputStream stream2 = new FileInputStream(pathFile);
            properties.load(stream2);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }


    public String getProperty(String key){
        return  properties.getProperty(key);
    }











//    public PropertyReader (String relativeFilePath){
//        properties = new Properties();
//        try {
//            FileInputStream stream = new FileInputStream(relativeFilePath);
//            properties.load(stream);
//
//        } catch (IOException e) {
//            throw new RuntimeException(e);
//        }
//    }
//
//
//    public String getProperty(String key){
//        return  properties.getProperty(key);
//
//    }


//    public String getProperty(String relativeFilePath , String key){
//        try {
//            FileReader fileReader = new FileReader(System.getProperty("user-dir", relativeFilePath));
//            properties = new Properties();
//            properties.load(fileReader);
//            return properties.getProperty(key) != null ? properties.getProperty(key) : null;
//
//        } catch (IOException e) {
//            throw new RuntimeException(e);
//        }
//
//
//    }
}
