package week7_1;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class Scenario {
	public static WebDriver driver;

	@Given("User navigates to Login Page")
	public void user_navigates_to_login_page() throws InterruptedException {
		System.setProperty("webdriver.chrome.driver", "./Resource/geckodriver.exe");
		WebDriver driver = new FirefoxDriver();
		driver.get("https://www.saucedemo.com/");
		Thread.sleep(5000);
	}

	@When("User enters valid Username and Password")
	public void user_enters_valid_username_and_password() {
		By uName = By.id("user-name");
		driver.findElement(uName).sendKeys("problem_user");

		By pWord = By.id("password");
		driver.findElement(pWord).sendKeys("secret_sauce");
	}

	@And("Clicks on Login button")
	public void clicks_on_login_button() {
		By loginBtn = By.id("login-button");
		driver.findElement(loginBtn).click();
	}

	@Then("User should Login Successfully and navigates to Dashboard")
	public void user_should_login_successfully() {
		By productsTitle = By.className("title");
		String actText = driver.findElement(productsTitle).getText();
		System.out.println(actText + " Expected Title ");

	}

	@When("user add products in the cart")
	public void user_add_products_in_the_cart() {
		By addCart = By.xpath("//button[@id='add-to-cart-sauce-labs-backpack']");
		driver.findElement(addCart).click();

		By navigateCart = By.xpath("//a[@class ='shopping_cart_link']");
		driver.findElement(navigateCart).click();

	}

	@When("user should able to make the Purchase successfully")
	public void user_should_able_to_make_the_purchase_successfully() {
		By checkOut = By.xpath("//button[contains(@class, 'checkout_button')]");
		driver.findElement(checkOut).click();
		
		By firstName = By.xpath("//input[starts-with(@placeholder,'First Name')]");
		driver.findElement(firstName).sendKeys("Laxman");
		
		By sName = By.xpath("//input[@id='last-name']");
		driver.findElement(sName).sendKeys("Baskaran");
		
		By postalCode = By.xpath("//input[@name = 'postalCode' and @id = 'postal-code']");
		driver.findElement(postalCode).sendKeys("626132");
		
		By Continue = By.xpath("//input[@name = 'continue' or @id = 'continue']");
		driver.findElement(Continue).click();
	}

	@Then("user should get a proper COnfirmation Screen")
	public void user_should_get_a_proper_c_onfirmation_screen() {
		By SuccessScreen = By.xpath("//h2[text()='Thank you for your order!']");
		String sucScreen = driver.findElement(SuccessScreen).getText();
		System.out.println("\033[1m" + sucScreen + " (Order initiated successfully) ");

	}

}
