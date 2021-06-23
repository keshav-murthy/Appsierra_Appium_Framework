package pages2;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebElement;

import base.BasePage;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;

public class ConfirmationPage extends BasePage {

	@AndroidFindBy(xpath = "//android.widget.TextView[@text='OK']")
	public WebElement ok;

	@AndroidFindBy(xpath = "//android.widget.TextView[@text='English']")
	public WebElement english;

	private static final Logger lOGGER = LogManager.getLogger(ConfirmationPage.class.getName());

	public ConfirmationPage(AndroidDriver<WebElement> driver) {
		super(driver);
	}

	public void clickOnOk() {

		wait.forElementToBeVisible(ok);
		click(ok);
		lOGGER.info("Clicking on OK button of confirmation page");
	}

	public void selectEnglishLanguage() {

//		scrollOrSwipe(0.4, 0.8, 0.8, 0.3);
		scrollToElementWithText("Assamese");
		wait.forElementToBeVisible(english);
		click(english);
		lOGGER.info("Selecting English from the language list");
	}
}