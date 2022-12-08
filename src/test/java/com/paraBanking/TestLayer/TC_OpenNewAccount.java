package com.paraBanking.TestLayer;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.paraBanking.BasePackage.basePBClass;
import com.paraBanking.PomLayer.pom_Open_New_Account;
import com.paraBanking.PomLayer.pom_PB_Login;

public class TC_OpenNewAccount extends basePBClass {
		pom_Open_New_Account pona;
		
		
		public TC_OpenNewAccount() {
			super();
		}
		
		
		@BeforeClass
		public void initSetup() {
			initiation(); 
			getLoginUrl();
			
			pona = new pom_Open_New_Account();
			
		}
		
		
		 @Test public void OpenAccount() throws InterruptedException {
			  
			  //String User= prop.getProperty("username"); 
			  //String Pass=prop.getProperty("password");
			 
			  pom_PB_Login PL = new pom_PB_Login();
			  PL.typeUsername("ram420"); 
			  PL.typePassword("demo"); PL.clickLoginBtn();
			  Thread.sleep(3000);
			  pona.clickOpenAccount();
			  
			  
			  }
}
