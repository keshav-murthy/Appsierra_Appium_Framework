package pages2;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import base.BasePage;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;

public class HeaderPage extends BasePage {

	@AndroidFindBy(xpath = "//android.widget.Button[@text='HEADER/FOOTER (MINIMAL)']")
	public WebElement headerMin;

	@AndroidFindBy(xpath = "//android.widget.Button[@text='EXPANDABLE WITH HEADER/FOOTER']")
	public WebElement expandableHeader;

	@AndroidFindBy(xpath = "//android.widget.Button[@text='HEADER/FOOTER (ADD/REMOVE ITEMS)']")
	public WebElement addOrRemove;

	private static final Logger lOGGER = LogManager.getLogger(HeaderPage.class.getName());

	public HeaderPage(AppiumDriver driver) {
		super(driver);
	}

	public void selectHeaderMin() {

		wait.forElementToBeVisible(headerMin);
		click(headerMin);
		lOGGER.info("Selecting Header minimum from the list");
	}

	public void selectExpandableHeader() {

		wait.forElementToBeVisible(expandableHeader);
		click(expandableHeader);
		lOGGER.info("Selecting Expandable Header from the list");
	}

	public void selectAddOrRemove() {

		wait.forElementToBeVisible(addOrRemove);
		click(addOrRemove);
		lOGGER.info("Selecting Add or remove in header from the list");
	}
}