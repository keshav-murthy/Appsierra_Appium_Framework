package pages2;

import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

import base.BasePage;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;

public class ExpandMinPage extends BasePage {

	@AndroidFindBy(id = "android:id/text1")
	public List<WebElement> items;

	@AndroidFindBy(id = "android:id/button1")
	public WebElement ok;

	@AndroidFindBy(id = "android:id/button1")
	public List<WebElement> buttons;

	private static final Logger lOGGER = LogManager.getLogger(ExpandMinPage.class.getName());

	public ExpandMinPage(AppiumDriver driver) {
		super(driver);
	}

	public void expandItems() {

		for (int i = 0; i < 4; i++) {
			wait.forElementToBeVisible(items.get(i));
			click(items.get(i));
			Assert.assertEquals(items.size(), 8);
			click(items.get(i));
			if (i == 2)
				scrollOrSwipe(0.5, 0.8, 0.5, 0.6);
		}
		lOGGER.info("Expanding and verfying display of items present inside");
	}
}