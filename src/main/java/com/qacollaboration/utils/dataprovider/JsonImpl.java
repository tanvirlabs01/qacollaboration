package com.qacollaboration.utils.dataprovider;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;

public class JsonImpl implements DataProviderUtil {
    private String fileName;
    private String testName;
    private List<Map<String,Object>> dataList = new ArrayList<>();

    public static void main(String[] args) {
        String dir = System.getProperty("user.dir");
        String testFile = System.getProperty("user.dir")+"\\src\\test\\resources\\json\\DashBoardData.json";
        String testName = "verifyFuelEfficiencyMatchBetweenPopUpAndGrid";
        JsonImpl test = new JsonImpl(testFile,testName);
        List<Map<String,Object>>list = test.getData();
    }
    protected JsonImpl(String fileName, String testName) {
        this.fileName = fileName;
        this.testName = testName;
    }

    public List<Map<String,Object>> getData()
    {
        JSONParser parser = new JSONParser();
        JSONObject jsonObject = null;
        Object obj = null;
        try {
            obj = parser.parse(new FileReader(fileName));
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        } catch (ParseException e) {
            throw new RuntimeException(e);
        }
        jsonObject = (JSONObject) obj;
        if(Objects.nonNull(jsonObject))
        {
            JSONArray testData = (JSONArray) jsonObject.get(testName);
            JSONObject rowData;
            for(int i =0;i<testData.size();i++)
            {
                HashMap<String,Object> dataMap = new HashMap<>();
                rowData = (JSONObject) testData.get(i);
                Set<String> keys = rowData.keySet();
                for(String key:keys)
                {
                    dataMap.put(key,rowData.get(key));
                }
                dataList.add(dataMap);
            }
        }
        return dataList;
    }
}
