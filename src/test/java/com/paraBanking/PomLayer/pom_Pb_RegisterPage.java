package com.paraBanking.PomLayer;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.paraBanking.BasePackage.basePBClass;

public class pom_Pb_RegisterPage extends basePBClass {
	
	@FindBy(name="customer.firstName")
	WebElement firstName;
	
	@FindBy(name="customer.lastName")
	WebElement lastName;
	
	@FindBy(name="customer.address.street")
	WebElement address;
	
	@FindBy(name="customer.address.city")
	WebElement city;
	
	@FindBy(name="customer.address.state")
	WebElement state;
	
	@FindBy(name="customer.address.zipCode")
	WebElement zip;
	
	
	@FindBy(name="customer.phoneNumber")
	WebElement phoneNumber;
	
	@FindBy(name="customer.ssn")
	WebElement ssn;
	
	@FindBy(name="customer.username")
	WebElement Username;
	
	
	@FindBy(name="customer.password")
	WebElement password;
	
	@FindBy(name="repeatedPassword")
	WebElement rPass;
	
	@FindBy(xpath="/html/body/div[1]/div[3]/div[2]/form/table/tbody/tr[13]/td[2]/input")
	WebElement btnRegister;
	
	//Initiate Page elements
		public pom_Pb_RegisterPage() {
			PageFactory.initElements(driver, this);
		}
		
		public void typefirstName(String fname) {
			firstName.sendKeys(fname);
		}
		
		public void typelastName(String lname) {
			lastName.sendKeys(lname);
		}
		
		public void typeAddress(String Address) {
			address.sendKeys(Address);
		}
		
		public void typeCity(String City) {
			city.sendKeys(City);
		}
		
		public void typeState(String State) {

			state.sendKeys(State);
		}
		public void typeZipCode(String Zip) {
			zip.sendKeys(Zip);
		}
		
		public void typePhoneNo(String Phone) {
			phoneNumber.sendKeys(Phone);
		}
		
		public void typeSSN(String SSN) {
			ssn.sendKeys(SSN);
		}
		
		public void typeUsername(String username) {
			Username.sendKeys(username);
		}
		
		public void typePassword(String Password) {
			password.sendKeys(Password);
		}
		
		public void typeRPassword(String RPass) {

			rPass.sendKeys(RPass);
		}
		public void BtnRegister() {
			btnRegister.click();
		}
		
		public String verifyTittle() {
			return driver.getTitle();
		}
		public void clear() {
			firstName.clear();
			lastName.clear();
			address.clear();
			city.clear();
			state.clear();
			password.clear();
			Username.clear();
			zip.clear();
			phoneNumber.clear();
			ssn.clear();
			rPass.clear();
			
		}
}
