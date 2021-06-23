package pages2;

import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

import base.BasePage;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;

public class AddOrRemovePage extends BasePage {

	@AndroidFindBy(id = "android:id/text1")
	public List<WebElement> items;

	@AndroidFindBy(id = "android:id/button1")
	public WebElement ok;

	@AndroidFindBy(id = "android:id/button1")
	public List<WebElement> buttons;

	@AndroidFindBy(id = "com.h6ah4i.android.example.advrecyclerview:id/button_add_group_below")
	public List<WebElement> addGroupBelow;

	@AndroidFindBy(id = "com.h6ah4i.android.example.advrecyclerview:id/button_add_group_above")
	public List<WebElement> addGroupAbove;

	@AndroidFindBy(id = "com.h6ah4i.android.example.advrecyclerview:id/button_add_child_below")
	public List<WebElement> addChildBelow;

	@AndroidFindBy(id = "com.h6ah4i.android.example.advrecyclerview:id/button_add_child_above")
	public List<WebElement> addChildAbove;

	@AndroidFindBy(xpath = "(//android.widget.FrameLayout[@resource-id='com.h6ah4i.android.example.advrecyclerview:id/container'])[3]//android.widget.TextView")
	public List<WebElement> frames;

	@AndroidFindBy(id = "com.h6ah4i.android.example.advrecyclerview:id/menu_add_header")
	public WebElement addHeader;

	@AndroidFindBy(id = "com.h6ah4i.android.example.advrecyclerview:id/menu_add_footer")
	public WebElement addFooter;

	@AndroidFindBy(id = "com.h6ah4i.android.example.advrecyclerview:id/snackbar_text")
	public WebElement alert;

	private static final Logger lOGGER = LogManager.getLogger(AddOrRemovePage.class.getName());

	public AddOrRemovePage(AppiumDriver driver) {
		super(driver);
	}

	public void expandItems() {

		wait.forElementToBeVisible(addGroupBelow.get(0));
		click(addGroupBelow.get(0));
		wait.forElementToBeVisible(addGroupAbove.get(0));
		click(addGroupAbove.get(0));
		wait.forElementToBeVisible(items.get(1));
		click(items.get(1));
		wait.forElementToBeVisible(addChildBelow.get(0));
		click(addChildBelow.get(0));
		wait.forElementToBeVisible(addChildAbove.get(0));
		click(addChildAbove.get(0));
		printGroupContents();
		lOGGER.info("Expanding and verfying display of items present inside");
	}

	public void printGroupContents() {

		for (int i = 3; i < 8; i++) {
			List<WebElement> frames = driver.findElements(By.xpath(
					"(//android.widget.FrameLayout[@resource-id='com.h6ah4i.android.example.advrecyclerview:id/container'])["
							+ i + "]//android.widget.TextView"));
			System.out.println(frames.get(0).getText());
		}
	}

	public void verifyItems() {

		wait.forElementToBeVisible(addHeader);
		click(addHeader);
		wait.forElementToBeVisible(addFooter);
		click(addFooter);
		for (int j = 1; j < items.size() - 1; j++) {
			click(items.get(j));
			wait.forElementToBeVisible(alert);
			String alertText = alert.getText();
			alertText = alertText.substring(alertText.lastIndexOf(' ') + 1);
			lOGGER.info("Fetching text from the alert pop-up");
			Assert.assertEquals(Integer.parseInt(alertText), (j - 1));
			lOGGER.info("Verifying whether clicked correct item or not");
		}
	}
}