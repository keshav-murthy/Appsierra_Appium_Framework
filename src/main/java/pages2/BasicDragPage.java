package pages2;

import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebElement;

import base.BasePage;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;

public class BasicDragPage extends BasePage {

	@AndroidFindBy(id = "com.h6ah4i.android.example.advrecyclerview:id/drag_handle")
	public List<WebElement> items;

	@AndroidFindBy(id = "android:id/button1")
	public WebElement ok;

	@AndroidFindBy(id = "android:id/button1")
	public List<WebElement> buttons;

	private static final Logger lOGGER = LogManager.getLogger(BasicDragPage.class.getName());

	public BasicDragPage(AppiumDriver driver) {
		super(driver);
	}

	public void dragItems() {

		for (int i = 0; i < 4; i++) {
			wait.forElementToBeVisible(items.get(i));
			dragAndDrop(items.get(i), items.get(i + 2));
		}
		lOGGER.info("Interchanging the position of items");
	}
}