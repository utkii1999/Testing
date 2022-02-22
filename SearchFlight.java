package StepDefinitions;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.opentelemetry.exporter.logging.SystemOutLogExporter;

public class SearchFlight {
	static WebDriver driver;
	

	@Given("user is on home page of website")
	public void user_is_on_home_page_of_website() {
		String projectPath = System.getProperty("user.dir");
		System.out.println("PROJECT PATH = "+ projectPath);

		System.setProperty("WebDriver.chrome.driver", projectPath + "/src/test/resources/drivers/chromedriver.exe");
		ChromeOptions options = new ChromeOptions();
		options.addArguments("--disable-notifications");
		driver= new ChromeDriver(options);

		driver.manage().timeouts().implicitlyWait(40, TimeUnit.SECONDS);
		driver.manage().timeouts().pageLoadTimeout(40, TimeUnit.SECONDS);

		driver.manage().window().maximize();

		driver.navigate().to("https://www.spicejet.com/");
		
		System.out.println("Successful!!!!!!!!!!!!!!");
	}

	@When("user click on from box")
	public void user_click_on_from_box() {
		driver.findElement(By.xpath("//div[text()='From']")).click();

	}

	@And("selects city")
	public void selects_city() {
		driver.findElement(By.xpath("//div[text()='Goa International Airport']")).click();
	}

	@Then("user selects destination city")
	public void user_selects_destination_city() {
		driver.findElement(By.xpath("//div[text()='Delhi']")).click();

	}

	@Then("departure date")
	public void departure_date() {
		driver.findElement(By.xpath("//div[@data-testid='undefined-month-February-2022']//div[text()='28']")).click();
	}

	@Then("return date")
	public void return_date() {
		driver.findElement(By.cssSelector("div[data-testid^='return-date']")).click();
		driver.findElement(By.xpath("//div[@data-testid='undefined-month-March-2022']//div[text()='10']")).click();
	}

	@Then("user clicks on search flight")
	public void user_clicks_onn_search_flight() {
		driver.findElement(By.xpath(
				"//body/div[@id='react-root']/div[@id='main-container']/div[1]/div[1]/div[3]/div[2]/div[7]/div[2]/div[1]"))
				.click();

	}

	@When("user is selected the flight")
	public void user_is_selected_the_flight() {
		driver.findElement(By.xpath("//div[text()='SG 8412']")).click();
		System.out.println("Your flight number " + driver.findElement(By.xpath("//div[text()='SG 8412']")).getText());
		driver.findElement(By.xpath(
				"//body/div[@id='react-root']/div[@id='main-container']/div[1]/div[1]/div[6]/div[2]/div[5]/div[1]/div[1]/div[2]/div[3]/div[1]/div[1]/div[1]/div[2]"))
				.click();
		System.out.println("Your flight price is  " + driver.findElement(By.xpath(
				"//body/div[@id='react-root']/div[@id='main-container']/div[1]/div[1]/div[5]/div[1]/div[1]/div[2]/div[1]/div[1]/div[2]"))
				.getText());
	}

	@And("hits continue button")
	public void hits_continue_button() {
		driver.findElement(By.xpath(
				"//body/div[@id='react-root']/div[@id='main-container']/div[1]/div[1]/div[5]/div[1]/div[1]/div[2]/div[2]"))
				.sendKeys(Keys.ENTER);
	}

	@Given("user is on passenger details page")
	public void user_is_on_passenger_details_page() {
		System.out.println("Passenger details page");

	}

	@When("user fills contact details")
	public void user_fills_contact_details() {
		driver.findElement(By.xpath("//*[@data-testid='first-inputbox-contact-details']")).sendKeys("Utkarsh");
		driver.findElement(By.xpath("//*[@data-testid='last-inputbox-contact-details']")).sendKeys("Gupta");
		driver.findElement(By.xpath("//*[@data-testid='contact-number-input-box']")).sendKeys("9458692087");
		driver.findElement(By.xpath("//*[@data-testid='emailAddress-inputbox-contact-details']"))
				.sendKeys("abc@gmail.com");
		driver.findElement(By.xpath("//*[@data-testid='city-inputbox-contact-details']")).sendKeys("Budaun");
	}

	@When("passenger information")
	public void passenger_information() {
		driver.findElement(By.xpath("//*[@data-testid='traveller-0-first-traveller-info-input-box']"))
				.sendKeys("Utkarsh");
		driver.findElement(By.xpath("//*[@data-testid='traveller-0-last-traveller-info-input-box']")).sendKeys("Gupta");
		driver.findElement(By.xpath("//*[@data-testid='sc-member-mobile-number-input-box']")).sendKeys("9458692087");

	}

	@Then("click on continue button")
	public void click_on_continue_button() {
		driver.findElement(By.xpath("//*[@data-testid='traveller-info-continue-cta']")).sendKeys(Keys.ENTER);

	}

	@Given("user is on add-ons page")
	public void user_is_on_add_ons_page() {
		System.out.println("User is on add-ons page");
	}

	@When("user clicks on add your seat")
	public void user_clicks_on_add_your_seat() {
		driver.findElement(By.xpath("//div[@data-testid='bookingFlow-seats-add-cta']")).click();
	}
	
	@And("selects seat")
	public void selects_seat()
	{
		driver.findElement(By.xpath("//div[text()='3B']")).click();
		driver.findElement(By.xpath("//div[text()='Select Meals']")).sendKeys(Keys.ENTER);
		
		
	}

}
