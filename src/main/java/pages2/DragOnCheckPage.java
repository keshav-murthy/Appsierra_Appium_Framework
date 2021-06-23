package pages2;

import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import base.BasePage;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;

public class DragOnCheckPage extends BasePage {

	@FindBy(id = "com.h6ah4i.android.example.advrecyclerview:id/drag_handle")
	List<WebElement> items;

	@FindBy(id = "android:id/button1")
	WebElement ok;

	@FindBy(id = "android:id/button1")
	List<WebElement> buttons;

	private static final Logger lOGGER = LogManager.getLogger(DragOnCheckPage.class.getName());

	public DragOnCheckPage(AppiumDriver driver) {
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