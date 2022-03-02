package mpack;

import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.util.Map;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import org.yaml.snakeyaml.Yaml;

import io.github.bonigarcia.wdm.WebDriverManager;
import junit.framework.Assert;


public class TestNdtvYaml {
	
	WebDriver driver;
	
	static Map<String, String> data ;


	static String projectPath = System.getProperty("user.dir");
	@BeforeClass
	public static void getYaml() {
		try {
			InputStream inputstream = new FileInputStream(new File(projectPath + "/src/test/java/config/temperature.yml"));
			 Yaml yaml = new Yaml();
			 data = yaml.load(inputstream);
//			System.out.println(data);
		}
		 catch (Exception e) {
				System.out.println(e.getMessage());
				System.out.println(e.getCause());
				System.out.println(e.getStackTrace());
			}
	}
	@Test(priority = 1)
	public void testNdtvPage() {
		//WebDriverManager.chromedriver().driverVersion("85.0.4183.38").setup();
		WebDriverManager.chromedriver().setup();
		ChromeOptions options = new ChromeOptions();
		options.addArguments("--disable-notifications");
		driver = new ChromeDriver(options);

		driver.get(data.get("website_link"));
		driver.manage().window().maximize();
		driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);

		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		String actual = driver.findElement(By.linkText(data.get("liveTv_linktext"))).getText();
	    System.out.println(actual);
		Assert.assertEquals(actual, "LIVE TV");

	}
	
	@Test(priority = 2)
	public void testWeatherPage() {
		driver.findElement(By.xpath(data.get("way_to_weather_tab"))).click();
		driver.findElement(By.xpath(data.get("weather_tab"))).click();
		Assert.assertTrue(driver.findElement(By.cssSelector(data.get("weather_page"))).isDisplayed());

	}
	
	@Test(priority = 3)
	public void testWeather() {

		WebElement checkbox = driver.findElement(By.id(data.get("city")));
		if (!checkbox.isSelected()) {
			checkbox.click();

		}
		
		System.out.println("Celcius Temperature in " + data.get("city")+" "+driver.findElement(By.xpath(data.get("celcius_temp"))).getText());
		System.out.println("Fahrenheit Temperature in " + data.get("city")+" "+ driver.findElement(By.xpath(data.get("fahrenheit_temp"))).getText());


	}

	
}


//package mpack;
//
//import java.io.FileInputStream;
//import java.io.InputStream;
//import java.util.Properties;
//import java.util.concurrent.TimeUnit;
//
//import org.openqa.selenium.By;
//import org.openqa.selenium.WebDriver;
//import org.openqa.selenium.WebElement;
//import org.openqa.selenium.chrome.ChromeDriver;
//import org.openqa.selenium.chrome.ChromeOptions;
//import org.testng.Assert;
//import org.testng.annotations.BeforeClass;
//import org.testng.annotations.Test;
//
//import io.github.bonigarcia.wdm.WebDriverManager;
//
//public class testNdtv {
//	WebDriver driver;
//
//	static Properties prop = new Properties();
//	
//
//	@BeforeClass
//	public static void getProperties() {
//		try {
//
//			InputStream input = new FileInputStream(projectPath + "/src/test/java/config/config.properties");
//			prop.load(input);
//		} catch (Exception e) {
//			System.out.println(e.getMessage());
//			System.out.println(e.getCause());
//			System.out.println(e.getStackTrace());
//		}
//	}
//
//	@Test(priority = 1)
//	public void testNdtvPage() {
//		//WebDriverManager.chromedriver().driverVersion("85.0.4183.38").setup();
//		WebDriverManager.chromedriver().setup();
//		ChromeOptions options = new ChromeOptions();
//		options.addArguments("--disable-notifications");
//		driver = new ChromeDriver(options);
//
//		driver.get(prop.getProperty("website_link"));
//
//		driver.manage().window().maximize();
//		driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);
//
//		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
//
//		String actual = driver.findElement(By.linkText(prop.getProperty("liveTv_linktext"))).getText();
//		System.out.println(actual);
//		Assert.assertEquals(actual, "LIVE TV");
//
//	}
//
//	
//

//}
//
//			
//
//
//
//
//
//
//
//
//
//
//
