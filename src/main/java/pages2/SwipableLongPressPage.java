package pages2;

import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebElement;

import base.BasePage;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;

public class SwipableLongPressPage extends BasePage {

	@AndroidFindBy(id = "android:id/text1")
	public List<WebElement> items;

	@AndroidFindBy(id = "android:id/button1")
	public WebElement ok;

	private static final Logger lOGGER = LogManager.getLogger(SwipableLongPressPage.class.getName());

	public SwipableLongPressPage(AppiumDriver driver) {
		super(driver);
	}

	public void swipeItems() {

		double j = 0.2;

		for (int i = 0; i < 5; i++) {
			wait.forElementToBeVisible(items.get(i));
			if (!(i % 2 == 0)) {
				scrollOrSwipeLongPress(0.2, j, 1, j);
			} else {
				scrollOrSwipeLongPress(0.8, j, 0, j);
				wait.forElementToBeVisible(ok);
				click(ok);
				j = j + 0.1;
			}
		}
		lOGGER.info("Swiping the item list left to right and vice-versa");
	}
}