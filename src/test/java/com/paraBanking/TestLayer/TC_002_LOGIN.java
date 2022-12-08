package com.paraBanking.TestLayer;

import java.util.Properties;

import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.paraBanking.BasePackage.basePBClass;
import com.paraBanking.PomLayer.pom_PB_Login;

import testDataPB.ExcelSheet;

public class TC_002_LOGIN extends basePBClass  {
		pom_PB_Login PL;
		
		public static Properties prop ;
		
		
		public TC_002_LOGIN() {
			super();
		}
		
		
		
		@BeforeClass
		public void initSetup() {
			initiation(); 
			getLoginUrl();
			
			PL = new pom_PB_Login();
			
		}
		
	
		@DataProvider
		public Object[][] Details(){
			Object result[][] = ExcelSheet.readData("Sheet1");
			return result;
			
		}
		
		@Test(priority = 1,dataProvider="Details")
		public void Login(String name,String Passwd) throws InterruptedException {
		  
		  PL.typeUsername(name); 
		  PL.typePassword(Passwd); 
		  PL.clickLoginBtn();
		  screenshot("InvalidUsernamePassword");
		  Thread.sleep(3000);
		  
		  
		  }
		 
		
			
			  @Test
			  
			  public void EmptyUsername() throws InterruptedException {
			  //PL.typeUsername(" "); 
			  PL.typePassword("Demo"); 
			  PL.clickLoginBtn();
			  screenshot("EmptyUsernameLogin"); Thread.sleep(3000);
			  
			  
			  }
			 
		
		
		
		@AfterClass
		public void Close() {
			driver.close();
		}
}
