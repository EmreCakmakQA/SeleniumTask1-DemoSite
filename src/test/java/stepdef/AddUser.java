package stepdef;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThat;

import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import cucumber.api.java.After;
import cucumber.api.java.Before;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class AddUser {
	
	// Task 1 - Demo Site
	private static WebDriver driver;
	private static String URL = "http://thedemosite.co.uk/";
	
	
	@Before
	public void setup() {
		System.setProperty("webdriver.chrome.driver", "src/test/resources/drivers/chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().window().setSize(new Dimension(1366, 768));
	}
	@After
	public void tearDown() {
		driver.close();
	}
	
	@Given("^I can open the demo site$")
	public void i_can_open_the_demo_site() throws InterruptedException {
		driver.get(URL);
		assertEquals("FREE example PHP code and online MySQL database - example username password protected site", driver.getTitle());
		Thread.sleep(2000);
	}
	

	@When("^I add a user$")
	public void i_add_a_user() throws InterruptedException {
		driver.findElement(By.linkText("3. Add a User")).click();
	    driver.findElement(By.name("username")).click();
	    driver.findElement(By.name("username")).sendKeys("guest");
	    driver.findElement(By.name("password")).click();
	    driver.findElement(By.name("password")).sendKeys("guest");
	    driver.findElement(By.name("FormsButton2")).click();
	    Thread.sleep(2000);
	}

	@Then("^I can log in as the user$")
	public void i_can_log_in_as_the_user() throws InterruptedException {
		driver.findElement(By.linkText("4. Login")).click();
		Thread.sleep(1000);
	    driver.findElement(By.name("username")).click();
	    driver.findElement(By.name("username")).sendKeys("guest");
	    driver.findElement(By.name("password")).click();
	    driver.findElement(By.name("password")).sendKeys("guest");
	    driver.findElement(By.name("FormsButton2")).click();
	    driver.findElement(By.cssSelector("center > b")).click();
	    assertThat(driver.findElement(By.cssSelector("center > b")).getText(), is("**Successful Login**"));
	    Thread.sleep(2000);
	}
}
