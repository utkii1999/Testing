
package mpack;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Demo {

	public static void main(String[] args) throws InterruptedException {
		
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.get("http://www.tutorialsninja.com/demo/");
		driver.manage().window().maximize();
		driver.findElement(By.xpath("//a[@title='My Account']")).click();
		Thread.sleep(2000);
		driver.findElement(By.linkText("Login")).click();
		driver.findElement(By.id("input-email")).sendKeys("utkarshgupta0408@gmail.com");
		driver.findElement(By.id("input-password")).sendKeys("Uthi@0410");
		driver.findElement(By.xpath("//input[@value='Login']")).click();
		System.out.println(driver.findElement(By.xpath("//ul[@class='breadcrumb']//a[text()='Account']")).isDisplayed());
		driver.findElement(By.name("search")).sendKeys("iPhone");
		driver.findElement(By.cssSelector("i[class$='fa-search'")).click();
	}

}
