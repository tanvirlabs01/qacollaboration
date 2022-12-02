package com.qacollaboration.extentReports;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;
import com.qacollaboration.enums.CategoryType;
import com.qacollaboration.frameworkconstants.FrameworkConstants;

import java.awt.*;
import java.io.File;
import java.io.IOException;
import java.util.Objects;

public final class ExtentReport {
    private  ExtentReport()
    {

    }
    private static ExtentReports extentReports;
    public static void inItReport(){
        if(Objects.isNull(extentReports))
        {
            extentReports = new ExtentReports();
            ExtentSparkReporter extentSparkReporter = new ExtentSparkReporter(FrameworkConstants.getExtentReportFilePath()
            );
            extentReports.attachReporter(extentSparkReporter);
            extentSparkReporter.config().setTheme(Theme.STANDARD);
            extentSparkReporter.config().setDocumentTitle("QA Collaboration Report");
            extentSparkReporter.config().setReportName("Practice framework");
        }
    }
    public static void flushReport() {
        if(Objects.nonNull(extentReports))
        {
            extentReports.flush();
        }
        ExtentManager.unload();
        try
        {
            Desktop.getDesktop().browse(new File(FrameworkConstants.getExtentReportFilePath()).toURI());
        }
        catch (IOException e){
            e.printStackTrace();
        }

    }
    public static void createTest(String testCaseName)
    {
        ExtentManager.setExtentTest(extentReports.createTest(testCaseName));
    }
    public static void addAuthors(String[] authors)
    {
        for(String author:authors)
        {
            ExtentManager.getExtentTest().assignAuthor(author);
        }
    }
    public static void addCategory(CategoryType[] categories)
    {
        for(CategoryType category:categories)
        {
            ExtentManager.getExtentTest().assignCategory(category.toString());
        }
    }
}
