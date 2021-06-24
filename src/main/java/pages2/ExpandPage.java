package pages2;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebElement;

import base.BasePage;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;

public class ExpandPage extends BasePage {

	@AndroidFindBy(xpath = "//android.widget.Button[@text='EXPANDABLE (MINIMAL)']")
	public WebElement expandMin;

	@AndroidFindBy(xpath = "//android.widget.Button[@text='EXPANDABLE (BASIC)']")
	public WebElement expandBasic;

	@AndroidFindBy(xpath = "//android.widget.Button[@text='EXPANDABLE (ADD/REMOVE ITEMS)']")
	public WebElement addOrRemove;

	@AndroidFindBy(xpath = "//android.widget.Button[@text='EXPANDABLE (GROUPS ALREADY EXPANDED)']")
	public WebElement groups;

	private static final Logger lOGGER = LogManager.getLogger(ExpandPage.class.getName());

	public ExpandPage(AppiumDriver driver) {
		super(driver);
	}
}