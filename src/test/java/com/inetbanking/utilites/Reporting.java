//Listener class used to generate Extent reports
package com.inetbanking.utilites;
import java.io.File;
import java.util.Date;

import org.openqa.selenium.WebDriver;
import org.testng.ITestContext;
import org.testng.ITestResult;
import org.testng.TestListenerAdapter;

 
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

 

public class Reporting extends TestListenerAdapter
{
     Date d=new Date();

     String newDate=d.toString();

    String modifyDate=newDate.replace(" ","_").replace(":","_")+".html";

     ExtentReports extent=new ExtentReports();
     ExtentSparkReporter spark=new ExtentSparkReporter("./ExtentReport/+"+modifyDate+"");

     public WebDriver driver;
     ExtentTest test;

     @Override
     public void onStart(ITestContext testContext)
     {
         extent.attachReporter(spark);
         test=extent.createTest("This is verify page").assignAuthor("Raj").assignCategory("smoke");
         test.info("Project name =>eBanking");
         test.info("This is Login test");

 

     }
         @Override
     public void onTestSuccess(ITestResult tr)
     {


         test.log(Status.PASS,"Sucessfully pass "+tr.getName());
 
     }
     @Override
     public void onTestFailure(ITestResult tr)
     {

 
        test.log(Status.FAIL," Test case "+ tr.getName()+" is failed ");
        
        String screenshotPath=System.getProperty("user.dir")+"\\Screenshots\\"+tr.getName()+".png";
        File f=new File(screenshotPath);
        if(f.exists()){
        	test.fail("Screenshot is below: "+test.addScreenCaptureFromPath(screenshotPath));
        }


     }
     @Override
     public void onTestSkipped(ITestResult tr)
     {


         test.log(Status.SKIP,"Test case "+tr.getName()+" is skip");
     }


     @Override
     public void onFinish(ITestContext testContext)
     {
         test.log(Status.INFO,"Test is finished");
         extent.flush();
     }
}