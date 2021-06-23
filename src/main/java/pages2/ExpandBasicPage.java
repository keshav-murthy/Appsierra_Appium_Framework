package pages2;

import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

import base.BasePage;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;

public class ExpandBasicPage extends BasePage {

	@AndroidFindBy(id = "android:id/text1")
	public List<WebElement> items;

	@AndroidFindBy(id = "android:id/button1")
	public WebElement ok;

	@AndroidFindBy(id = "android:id/button1")
	public List<WebElement> buttons;

	private static final Logger lOGGER = LogManager.getLogger(ExpandBasicPage.class.getName());

	public ExpandBasicPage(AppiumDriver driver) {
		super(driver);
	}

	public void expandItems() {

		for (int i = 0; i < 3; i++) {
			wait.forElementToBeVisible(items.get(i));
			click(items.get(i));
			Assert.assertEquals(items.size(), 7);
			click(items.get(i));
		}
		lOGGER.info("Expanding and verfying display of items present inside");
	}
}