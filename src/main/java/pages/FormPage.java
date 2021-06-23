package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import base.BasePage;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;

public class FormPage extends BasePage {

	WebDriver driver;

	@AndroidFindBy(xpath = "//android.view.ViewGroup[@content-desc='button-Active']")
	public WebElement activeButton;

	@AndroidFindBy(xpath = "//android.widget.ScrollView[@content-desc='Forms-screen']")
	public WebElement formScreen;

	public FormPage(AppiumDriver driver) {
		super(driver);
		this.driver = driver;
	}
}