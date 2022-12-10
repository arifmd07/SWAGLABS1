package StepDefination;

import static org.junit.Assert.assertEquals;

import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.support.FindBy;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.github.bonigarcia.wdm.WebDriverManager;
import junit.framework.Assert;
	
public class SeduceLogin {
	/*
	 * WebDriver driver=null;
	 * 
	 * @FindBy(id="user-name") WebElement user;
	 * 
	 * @FindBy(name=("password")) WebElement pass;
	 * 
	 * @Given("browser is open") public void browser_is_open() {
	 * //System.out.println("browser is open");
	 * //System.setProperty("webdriver.chrome.driver",
	 * "C:\\Users\\arif0\\eclipse-workspace\\CucumberJava\\src\\test\\resources\\drivers\\chromedriver.exe"
	 * ); WebDriverManager.chromedriver().setup(); driver= new ChromeDriver(); }
	 * 
	 * @When("user given URL") public void user_given_URL() {
	 * driver.get("https://www.saucedemo.com/"); }
	 * 
	 * @When("user enters username and password") public void
	 * user_enters_username_and_password() {
	 * driver.findElement(By.id("user-name")).sendKeys("standard_user");
	 * driver.findElement(By.name("password")).sendKeys("secret_sauce"); }
	 * 
	 * @When("user hits enter") public void user_hits_enter() {
	 * driver.findElement(By.id("login-button")).click();
	 * 
	 * 
	 * }
	 * 
	 * @Then("user is navigated to the home page") public void
	 * user_is_navigated_to_the_home_page() {
	 * driver.getPageSource().contains("Sauce Labs Backpack"); }
	 */
	WebDriver driver;
	@Before
	public void beforeScenario(Scenario scenario) {

		System.out.println("--------------------------------");
		System.out.println(scenario.getName() +" :"+ "status  :" + scenario.getStatus());
		System.out.println("--------------------------------");
		WebDriverManager.edgedriver().setup();
		driver = new EdgeDriver();
	}

	@After
	public void afterScenario(Scenario scenario) throws InterruptedException {

		if (scenario.isFailed()) {

			TakesScreenshot ts = (TakesScreenshot) driver;
			byte[] src = ts.getScreenshotAs(OutputType.BYTES);
			scenario.attach(src, "image/png", "Screenshots");
		}
		System.out.println("--------------------------------");
		System.out.println(scenario.getName() +" :"+ "status  :" + scenario.getStatus());
		System.out.println("--------------------------------");
		if (driver != null) {
			Thread.sleep(4000);
			driver.close();
		}
	}
	@Given("browser open")
	public void browser_open() {
	    
	}
	@When("user given URL")
	public void user_given_url() {
		driver.get("https://www.saucedemo.com/"); 
	}
	@When("user enters username and password")
	public void user_enters_username_and_password() {
		driver.findElement(By.id("user-name")).sendKeys("standard_user");
		driver.findElement(By.name("password")).sendKeys("secret_sauce");
	    
	}
	@When("user hits enter")
	public void user_hits_enter() throws InterruptedException {
		driver.findElement(By.id("login-button")).click();
		Thread.sleep(3000);
	}
	
	@Then("user is navigated to the home page")
	public void user_is_navigated_to_the_home_page() {
		 driver.getPageSource().contains("PRODUCTS")  ;
		 System.out.println("show this messeage");
	}


//	@When("user given{string} and {string}")
//	public void user_given(String userName, String password) throws InterruptedException {
//		driver.findElement(By.id("user-name")).sendKeys(userName);
//		driver.findElement(By.name("password")).sendKeys(password);
//		Thread.sleep(3000);
//		
	@When("user given {string} and {string}")
	public void user_given_and(String userName, String password) {
		driver.findElement(By.id("user-name")).sendKeys(userName);
		driver.findElement(By.name("password")).sendKeys(password);
		
		
		
		
	 
	}
	@When("user click login button")
	public void user_click_login_button() {
		
		driver.findElement(By.id("login-button")).click();
		
		
	   
	}
	@Then("user successfully login to homepage")
	public void user_successfully_login_to_homepage() {
		
		String title =	driver.getTitle();
		System.out.println(title);
		assertEquals(title,"Swag Labs");
		driver.findElement(By.name("add-to-cart-sauce-labs-backpack")).click();
	
		
	 driver.getPageSource().contains("PRODUCTS");
	
	}
	}



