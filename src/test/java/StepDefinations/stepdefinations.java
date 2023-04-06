package StepDefinations;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class stepdefinations {

	WebDriver driver;

	@Given("I am on the Sauce Demo Login Page")
	public void i_am_on_the_sauce_demo_login_page() {
		System.setProperty("webdriver.chrome.driver", "/Users/bhumidobariya/Downloads/chromedriver");
		driver = new ChromeDriver();
		driver.get("https://www.saucedemo.com/");
	}

	@When("I fill the account information for account StandardUser into the Username field and the Password field")
	public void i_fill_the_account_information_for_account_standard_user_into_the_username_field_and_the_password_field() {
		driver.findElement(By.id("user-name")).sendKeys("standard_user");
		driver.findElement(By.id("password")).sendKeys("secret_sauce");
	}

	@When("I click the Login Button")
	public void i_click_the_login_button() {
		driver.findElement(By.id("login-button")).click();
	}

	@Then("I am redirected to the Sauce Demo Main Page")
	public void i_am_redirected_to_the_sauce_demo_main_page() {
		String titleString = driver.getCurrentUrl();
		System.out.println(titleString);
		Assert.assertEquals("https://www.saucedemo.com/inventory.html", titleString);

	}

	@Then("I verify the App Logo exists")
	public void i_verify_the_app_logo_exists() {
		String actuallogoString = "Swag Labs";
		String expectedlogoString = driver.findElement(By.className("app_logo")).getText();
		Assert.assertEquals(actuallogoString, expectedlogoString);
	}
	
	@When("I fill the account information for account LockedOutUser into the Username field and the Password field")
	public void i_fill_the_account_information_for_account_locked_out_user_into_the_username_field_and_the_password_field() {
		driver.findElement(By.id("user-name")).sendKeys("locked_out_user");
		driver.findElement(By.id("password")).sendKeys("secret_sauce");
		
	
	}
	@Then("I verify the Error Message contains the text {string}")
	public void i_verify_the_error_message_contains_the_text(String string) {
		String expectedString = "Sorry, this user has been banned.";
		String actualString = driver.findElement(By.xpath("//h3[@data-test='error']")).getText();
		Assert.assertEquals(expectedString, actualString);

	}

	

}
