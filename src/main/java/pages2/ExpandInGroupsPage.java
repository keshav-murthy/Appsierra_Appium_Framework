package pages2;

import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

import base.BasePage;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;

public class ExpandInGroupsPage extends BasePage {

	@AndroidFindBy(id = "android:id/text1")
	public List<WebElement> items;

	@AndroidFindBy(id = "android:id/button1")
	public WebElement ok;

	@AndroidFindBy(id = "android:id/button1")
	public List<WebElement> buttons;

	@AndroidFindBy(id = "com.h6ah4i.android.example.advrecyclerview:id/menu_add_group_bottom_2")
	public WebElement addGroupBelow;

	@AndroidFindBy(id = "com.h6ah4i.android.example.advrecyclerview:id/button_add_group_above")
	public List<WebElement> addGroupAbove;

	@AndroidFindBy(id = "com.h6ah4i.android.example.advrecyclerview:id/button_add_child_below")
	public List<WebElement> addChildBelow;

	@AndroidFindBy(id = "com.h6ah4i.android.example.advrecyclerview:id/button_add_child_above")
	public List<WebElement> addChildAbove;

	@AndroidFindBy(xpath = "(//android.widget.FrameLayout[@resource-id='com.h6ah4i.android.example.advrecyclerview:id/container'])[3]//android.widget.TextView")
	public List<WebElement> frames;

	private static final Logger lOGGER = LogManager.getLogger(ExpandInGroupsPage.class.getName());

	public ExpandInGroupsPage(AppiumDriver driver) {
		super(driver);
	}

	public void expandItems() {

		wait.forElementToBeVisible(addGroupBelow);
		click(addGroupBelow);
		for (int i = 0; i < items.size(); i++) {
			wait.forElementToBeVisible(items.get(i));
			Assert.assertTrue(items.size() >= 6);
			click(items.get(i));
		}
		lOGGER.info("Expanding and verfying display of items present inside");
	}
}