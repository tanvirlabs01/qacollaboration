package com.qacollaboration.frameworkconstants;

import com.qacollaboration.enums.ConfigProperties;
import com.qacollaboration.utils.PropertiesUtil;

public final class FrameworkConstants {
    private static final String RESOURCESPATH = System.getProperty("user.dir")+"/src/test/resources";
    private static final String CHROMEDRIVERPATH = RESOURCESPATH+"/executable/chromedriver.exe";
    private static final String GECKODRIVERPATH = RESOURCESPATH+"/executable/geckodriver.exe";
    private static final String CONFIGFILEPATH = RESOURCESPATH+"/config/config.properties";
    private static final String EXCELPATH = RESOURCESPATH+"/excel/testData.xlsx";
    private static final int EXPLICITWAIT  = 10;
    private static final String EXTENTREPORTFOLDERPATH = System.getProperty("user.dir")+"/extent-test-output";
    private static String EXTENTREPORTFILEPATH = "";
    private static final String RUNMANAGERSHEET = "RUNMANAGER";
    private static final String ITERATIONDATASHEET = "TestData";
    private FrameworkConstants()
    {

    }
    public static String getChromeDriverPath()
    {
        return CHROMEDRIVERPATH;
    }
    public static String getConfigFilePath()
    {
        return CONFIGFILEPATH;
    }
    public static int getExplicitWait()
    {
        return EXPLICITWAIT;
    }
    public static String getExtentReportFilePath(){
        if(EXTENTREPORTFILEPATH.isEmpty()){
            EXTENTREPORTFILEPATH = createReportPath();
        }
        return EXTENTREPORTFILEPATH;
    }
    private static String createReportPath() {
        if(PropertiesUtil.get(ConfigProperties.OVERRIDEREPORTS).equalsIgnoreCase("no"))
        {
            return EXTENTREPORTFOLDERPATH+"/"+System.currentTimeMillis()+"/index.html";
        }
        else {
            return EXTENTREPORTFOLDERPATH+"/index.html";
        }

    }

    public static String getExcelPath()
    {
        return EXCELPATH;
    }
    public static String getRunManagerSheet()
    {
        return RUNMANAGERSHEET;
    }
    public static String getIterationdatasheet()
    {
        return ITERATIONDATASHEET;
    }
    public static String getGeckoDriverPath()
    {
        return GECKODRIVERPATH;
    }



}
