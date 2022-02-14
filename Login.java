package demos;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Login {
	public static void main(String[] args)
	{
		// 1.Define the web driver
			System.setProperty("webdriver.chrome.driver","C:\\chromedriver.exe");
			WebDriver driver=new ChromeDriver();
			
		// 2.Open the web browser and navigate to the page.
			driver.get("https://auth.geeksforgeeks.org/");
			
		// Find Elements:Locate the element,Determine the action,Pass any parameters
			
		// 3. Enter username
			driver.findElement(By.name("user")).sendKeys("utkigupta1999@gmail.com");
			
		// 4. Enter password
			driver.findElement(By.name("pass")).sendKeys("Utkii@1999");
			
		// 5. Click Login
			driver.findElement(By.xpath("//button[contains(text(),'Sign In')]")).click();
			
		// 6. Get Confirmation
			//String message=driver.findElement(By.xpath("//i[contains(text(),'edit')]")).getText();
			//System.out.println("Confirmation: "+ message);
			
		// 7. Get Page Title
			String pageTitle=driver.getTitle();
			System.out.println(pageTitle);
			
		// 8. Close your browser
		driver.quit();
	}
}
