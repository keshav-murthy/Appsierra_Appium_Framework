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

	public void selectExpandMin() {

		wait.forElementToBeVisible(expandMin);
		click(expandMin);
		lOGGER.info("Selecting exapnd minimum from the list");
	}

	public void selectExpandBasic() {

		wait.forElementToBeVisible(expandBasic);
		click(expandBasic);
		lOGGER.info("Selecting expand basic from the list");
	}

	public void selectAddOrRemoveItem() {

		wait.forElementToBeVisible(addOrRemove);
		click(addOrRemove);
		lOGGER.info("Selecting add Or Remove from the list");
	}

	public void selectExpandInGroups() {

		wait.forElementToBeVisible(groups);
		click(groups);
		lOGGER.info("Selecting Expand In Groups from the list");
	}
}