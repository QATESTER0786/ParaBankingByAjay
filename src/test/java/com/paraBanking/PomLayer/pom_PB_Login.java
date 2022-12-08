package com.paraBanking.PomLayer;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.paraBanking.BasePackage.basePBClass;

public class pom_PB_Login extends basePBClass  {
	//Object Repository
	
	@FindBy(name="username")
	WebElement Username;
	@FindBy(name="password") WebElement Password;
	@FindBy(xpath="/html/body/div[1]/div[3]/div[1]/div/form/div[3]/input") WebElement LoginBtn;
	
	//Initiate Page elements
	public pom_PB_Login() {
		PageFactory.initElements(driver, this);
	}
	public void typeUsername(String name) {
		Username.sendKeys(name);
	}
	public void typePassword(String Pass) {
		Password.sendKeys(Pass);
	}
	public void clickLoginBtn() {
		LoginBtn.click();
	}
	public String verifyTittle() {
		return driver.getTitle();
	}
}
