package com.qacollaboration.utils;

import com.qacollaboration.exceptions.FrameworkExceptions;
import com.qacollaboration.exceptions.InvalidPathForExcelException;
import com.qacollaboration.frameworkconstants.FrameworkConstants;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.*;

public class ExcelUtils {
    //try with resource
    private ExcelUtils() {
    }
    public static List<Map<String,String>> getTestDetails(String sheetName) {
        List<Map<String,String>> list = new ArrayList<>();
        try(FileInputStream file = new FileInputStream(FrameworkConstants.getExcelPath())){
            XSSFWorkbook xssfWorkbook = new XSSFWorkbook(file);
            XSSFSheet xssfSheet = xssfWorkbook.getSheet(sheetName);
            Map<String,String> map = null;
            int lastRowNumber = xssfSheet.getLastRowNum();
            int lastColumnNumber =  xssfSheet.getRow(0).getLastCellNum();
            for(int i =1;i<=lastRowNumber;i++)
            {
                map = new HashMap<>();
                String value="";
                for(int j =0;j<lastColumnNumber;j++)
                {
                    String key = xssfSheet.getRow(0).getCell(j).getStringCellValue();
                    if((xssfSheet.getRow(i).getCell(j).getCellType()!= CellType.BLANK))
                    {
                        if(xssfSheet.getRow(i).getCell(j).getCellType()== CellType.STRING)
                        {
                            value = xssfSheet.getRow(i).getCell(j).getStringCellValue();
                        }
                        if(xssfSheet.getRow(i).getCell(j).getCellType()== CellType.NUMERIC)
                        {
                            Double numericValue = xssfSheet.getRow(i).getCell(j).getNumericCellValue();
                            String[] stringValue = numericValue.toString().split("\\.");
                            value = stringValue[0];
                        }
                    }
                    map.put(key,value);
                }
                list.add(map);
            }
        }
        catch (FileNotFoundException e)
        {
            //StackTraceElement[] stackTraceElements = e.getStackTrace();
            //stackTraceElements[0] = new StackTraceElement("com.qacollaboration.ExcelUtils","getTestDetails","ExcelUtils.java",19);
            //e.setStackTrace(stackTraceElements);
            //throw new RuntimeException("Excel file you trying to read not found",e);

            throw new InvalidPathForExcelException("Excel file you trying to read not found");
        }
        catch(IOException e)
        {
            throw new FrameworkExceptions("Some IO exception happen while reading file");
        }
        return list;
    }


}
