package pages2;

import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebElement;

import base.BasePage;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;

public class ViewPagerSwipablePage extends BasePage {

	@AndroidFindBy(id = "android:id/text1")
	public List<WebElement> items;

	@AndroidFindBy(id = "android:id/button1")
	public WebElement ok;

	@AndroidFindBy(id = "android:id/button1")
	public List<WebElement> buttons;

	@AndroidFindBy(xpath = "//android.widget.TextView[@text='PAGE 1']")
	public WebElement page1;

	@AndroidFindBy(xpath = "//android.widget.TextView[@text='PAGE 2']")
	public WebElement page2;

	private static final Logger lOGGER = LogManager.getLogger(ViewPagerSwipablePage.class.getName());

	public ViewPagerSwipablePage(AppiumDriver driver) {
		super(driver);
	}

	public void swipeItems() {

		for (int i = 0; i < 5; i++) {
			wait.forElementToBeVisible(items.get(i));
			scrollOrSwipe(0.5, 0.2, 0.8, 0.2);
		}

		wait.forElementToBeVisible(page2);
		click(page2);
		for (int i = 0; i < 5; i++) {
			wait.forElementToBeVisible(items.get(i));
			scrollOrSwipe(0.5, 0.2, 0.2, 0.2);
		}
		lOGGER.info("Swiping the items in 2 different pages");
	}
}