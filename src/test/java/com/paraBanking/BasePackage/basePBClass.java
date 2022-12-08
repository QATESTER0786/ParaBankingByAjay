package com.paraBanking.BasePackage;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.BeforeClass;

public class basePBClass {

	public static Properties prop = new Properties();
	public static WebDriver driver;
	
	//Step1 Create constructor
	
	public basePBClass() {
		
		//step 2 Create File Input Class to read from Config File
		
				
						try {
							String Path ="D:\\QA COURSE\\JavaTest\\Para_Bank\\src\\test\\java\\Configuration\\Config.properties";
								FileInputStream f1 = new FileInputStream(Path);
								prop.load(f1); // Reading file 
						}
						catch(FileNotFoundException e) {
							e.printStackTrace();
						}
						catch(IOException a) {
							a.printStackTrace();
							
						}
	} //End of Constructor
	
	//Common Method for Code 
	
	
	public static void initiation() {
		//Browser Open
		//Window Maximize
		//Page Timeout
		//Page Load
		// Url Open
		
		//Reading Property form Config File
		
		String browserName= prop.getProperty("browser");
		
		
		
		//Checking Browser Name 
		
		if(browserName.equals("Firefox")) {
			System.setProperty("webdriver.gecko.driver", System.getProperty("user.dir")+"\\Driver\\geckodriver.exe");
			driver = new FirefoxDriver();
		}
				else if(browserName.equals("Chrome")){
					System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir")+"\\Driver\\chromedriver.exe");
					driver = new ChromeDriver();
				}
				
						else if(browserName.equals("Internet")){
									
								}
				
									else if(browserName.equals("Safari")){
										
									}
				
										else{
											System.out.println("Invalid Browser");
										}
				
		
		//Maximizing Window
		
		driver.manage().window().maximize();
		
		//Setting Time for Page Load
		
		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(30));
		
		
		//reading url from Config File
		
		//driver.get(prop.getProperty("urlRegistration"));
		
		//Implicit Wait
		
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		
	}
	
	
	//Method for open Login Url
		public static void getRegisterUrl() {
			driver.get(prop.getProperty("urlRegistration"));
		}
	
	//Method for open Login Url
	public static void getLoginUrl() {
	     driver.get(prop.getProperty("urlLogin"));
	}
	
	
	public static void screenshot(String Filename) {
		try {
			//Create file object to take screenshot
			File file = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
			
			
			String FolderpathScreenshot = "D:\\QA COURSE\\JavaTest\\Para_Bank\\src\\test\\java\\screenshots";
			
			//copy the file into desired location by using FileUtils 
			
			FileUtils.copyFile(file, new File(FolderpathScreenshot + Filename + ".jpg"));
		} catch (IOException e) {
			e.printStackTrace();
		}

	}
	
	
	}
