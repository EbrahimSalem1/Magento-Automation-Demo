package utils;

import com.google.gson.*;
import com.jayway.jsonpath.JsonPath;
import org.apache.commons.io.FileUtils;

import java.io.File;
import java.io.FileWriter;
import java.util.List;

public class JsonManager {

    //Variables
    private String filePath;

    //Constructor
    public JsonManager(String filePath) {
        this.filePath = filePath;
    }

    //Method to Get JsonData as String using JsonPath Expression
    public String getData(String jsonPath) {
        try {
            String data;
        Object result = JsonPath.parse(new File(filePath)).read(jsonPath);
        if (result.toString().contains("{"))
            data = JsonPath.parse(result).jsonString();
        else
            data = result.toString();

        LogHelper.logInfoStep("Getting Test Data ["+data+"] by Json Path ["+jsonPath+"]");
        return data;

        }catch (Exception e){
            LogHelper.logErrorStep("Failed to Read Test Data by Json Path ["+jsonPath+"]",e);
            return null;
        }
    }




    //Method to Get JsonData as JsonArray using JsonPath Expression
    public JsonArray getDataAsJsonArray(String jsonPath) {
        try {
            List<Object> list = JsonPath.parse(new File(filePath)).read(jsonPath);
            JsonArray data;
            data = JsonParser.parseString(list.toString()).getAsJsonArray();
            LogHelper.logInfoStep("Getting Test Data ["+data+"] by Json Path ["+jsonPath+"]");
            return data;
        }catch (Exception e){
            LogHelper.logErrorStep("Failed to Get Test Data by Json Path ["+jsonPath+"]",e);
            return null;
        }
    }



    //Method to read JsonFile and convert it to JsonObject
    public static JsonObject readJsonFile(String filePath) {
        try {
            //pass the path of test data json file
            File filename = new File(filePath);
            //convert the json file to string
            String jsonString = FileUtils.readFileToString(filename, "UTF8");
            //parse the json string into Json Object (Deserialization)
            LogHelper.logInfoStep("Reading the Json File By filePath ["+filePath+"]");
            return JsonParser.parseString(jsonString).getAsJsonObject();
        }catch (Exception e){
            LogHelper.logErrorStep("Failed to Read the Json File By filePath ["+filePath+"]",e);
            return null;
        }
    }


    //Method to Create JsonFile from Object
    public static void createJsonFile(Object obj , String filePath) {
        try{
            FileWriter file = new FileWriter(filePath);
            Gson gson = new GsonBuilder().setPrettyPrinting().create();
            String formattedJson = gson.toJson(obj);
            file.write(formattedJson);
            file.close();
            LogHelper.logInfoStep("Writing Into Json File By filePath ["+filePath+"]");
        }catch (Exception e){
            LogHelper.logErrorStep("Failed to Write Data Into Json File By filePath ["+filePath+"]",e);
        }
    }



}


