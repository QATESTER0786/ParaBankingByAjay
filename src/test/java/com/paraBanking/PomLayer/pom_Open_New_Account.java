package com.paraBanking.PomLayer;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.paraBanking.BasePackage.basePBClass;

public class pom_Open_New_Account extends basePBClass  {
  
	
	@FindBy(xpath="//*[@id=\"leftPanel\"]/ul/li[1]/a")
	WebElement OpenAccountLink;
	
	//Initiate Page elements
		public pom_Open_New_Account() {
			PageFactory.initElements(driver, this);
		}
		public void clickOpenAccount() {
			OpenAccountLink.click();
		}
}
