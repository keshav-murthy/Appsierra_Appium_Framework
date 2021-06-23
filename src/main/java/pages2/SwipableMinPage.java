package pages2;

import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

import base.BasePage;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;

public class SwipableMinPage extends BasePage {

	@AndroidFindBy(id = "android:id/text1")
	public List<WebElement> items;

	@AndroidFindBy(id = "com.touchboarder.android.api.demos:id/progress")
	public WebElement percentageDisplay;

	private static final Logger lOGGER = LogManager.getLogger(SwipableMinPage.class.getName());

	public SwipableMinPage(AppiumDriver driver) {
		super(driver);
	}

	public void swipeItems() {

		for (int i = 0; i < 5; i++) {
			wait.forElementToBeVisible(items.get(i));
			scrollOrSwipe(0.2, 0.2, 0.8, 0.2);
		}
		lOGGER.info("Swiping the item list left to right");
	}

	public void verifyProgress() {

		wait.forElementToBeVisible(percentageDisplay);
		String display = percentageDisplay.getText();
		display = display.substring(0, display.indexOf('f') - 1);
		int display1 = Integer.parseInt(display);
		Assert.assertEquals(display1, 55);
	}
}