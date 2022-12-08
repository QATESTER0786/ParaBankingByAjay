package com.paraBanking.TestLayer;

import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.paraBanking.BasePackage.basePBClass;
import com.paraBanking.PomLayer.pom_Pb_RegisterPage;

import net.bytebuddy.build.BuildLogger;



public class TC_01_PB_Registration extends basePBClass {
	pom_Pb_RegisterPage pr;
	
	public TC_01_PB_Registration() {
		super();
	}
	
	@BeforeClass
	public void initSetup() {
		initiation(); 
		getRegisterUrl();
		
		pr = new pom_Pb_RegisterPage();
		
	}
	
	@Test(priority = 0)
	public void VTittle() {
		String Actual = pr.verifyTittle();
		System.out.println(Actual);
		Assert.assertEquals(Actual, "ParaBank | Register for Free Online Account Access");
	}
	
	@Test
	public void ValidData() throws InterruptedException {
		pr.typefirstName("Mack");
		pr.typelastName("Thomson");
		pr.typeAddress("7700");
		pr.typeCity("Brampton");
		pr.typeState("ON");
		pr.typeZipCode("K4D2k6");
		pr.typePhoneNo("7385003400");
		pr.typeSSN("142540022");
		pr.typeUsername("baxcv00786");
		pr.typePassword("Demo");
		pr.typeRPassword("Demo");
		pr.BtnRegister();
		
		Thread.sleep(3000);
		boolean res = driver.getPageSource().contains("Your account was created successfully. You are now logged in.");
		
		checkpoint(res);
		//pr.clear();
		
		
	}
	
	public void checkpoint(boolean res) {
		if(res==true) {
			Assert.assertTrue(true);
		}
		else {
			screenshot("NotRegistered");
			Assert.assertTrue(false);
		}
	}
	
	
	@Test
	public void FnameCanotNumber() throws InterruptedException {
		
		pr.typefirstName("8765");
		pr.typelastName("Thomson");
		pr.typeAddress("7700");
		pr.typeCity("Brampton");
		pr.typeState("ON");
		pr.typeZipCode("K4D2k6");
		pr.typePhoneNo("7385003400");
		pr.typeSSN("142540022");
		pr.typeUsername("Mak00786");
		pr.typePassword("Demo");
		pr.typeRPassword("Demo");
		pr.BtnRegister();
		screenshot("FirstNameCanotbeNumber");
		Thread.sleep(3000);
		
		boolean res = driver.getPageSource().contains("First Name Canot be number");
		checkpoint(res);
		//pr.clear();
	}
	
	@Test
	public void emptyField() throws InterruptedException {
		pr.BtnRegister();
		screenshot("FirstNameCanotbeNumber");
		Thread.sleep(3000);
		
		boolean res = driver.getPageSource().contains("First name is required.");
		checkpoint(res);
		System.out.println("All Fields Required");
	}
	
	
	@AfterMethod
	public void cleardata() {
		pr.clear();
	}
	
	
	@AfterClass
	public void Close() {
		
		driver.close();
	}
	

}
