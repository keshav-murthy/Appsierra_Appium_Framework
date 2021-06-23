package pages2;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebElement;

import base.BasePage;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;

public class HomePage extends BasePage {

	@AndroidFindBy(xpath = "//android.widget.TextView[@text='API Demos']")
	public WebElement apiDemos;

	@AndroidFindBy(xpath = "//android.widget.TextView[@text='SWIPE']")
	public WebElement swipe;

	@AndroidFindBy(xpath = "//android.widget.TextView[@text='EXPAND']")
	public WebElement expand;

	@AndroidFindBy(xpath = "//android.widget.TextView[@text='HEADER']")
	public WebElement header;

	@AndroidFindBy(xpath = "//android.widget.TextView[@text='ADAPTER']")
	public WebElement adapter;

	@AndroidFindBy(xpath = "//android.widget.TextView[@text='ADVANCED']")
	public WebElement advanced;

	private static final Logger lOGGER = LogManager.getLogger(HomePage.class.getName());

	public HomePage(AppiumDriver driver) {
		super(driver);
	}

	public void clickOnApiDemos() {

		wait.forElementToBeVisible(apiDemos);
		click(apiDemos);
		lOGGER.info("Selecting APIDemos option from the list avalaible on home page");
	}

	public void clickOnSwipe() {

		wait.forElementToBeVisible(swipe);
		click(swipe);
		lOGGER.info("Selecting swipe option from the list avalaible on home page");
	}

	public void clickOnExpand() {

		wait.forElementToBeVisible(expand);
		click(expand);
		lOGGER.info("Selecting expand option from the list avalaible on home page");
	}

	public void clickOnHeader() {

		wait.forElementToBeVisible(header);
		click(header);
		lOGGER.info("Selecting header option from the list avalaible on home page");
	}

	public void clickOnAdapter() {

		wait.forElementToBeVisible(adapter);
		click(adapter);
		lOGGER.info("Selecting adapter option from the list avalaible on home page");
	}

	public void clickOnAdvanced() {

		wait.forElementToBeVisible(advanced);
		click(advanced);
		lOGGER.info("Selecting advanced option from the list avalaible on home page");
	}
}