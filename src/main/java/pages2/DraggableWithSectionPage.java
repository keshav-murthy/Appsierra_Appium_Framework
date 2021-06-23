package pages2;

import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebElement;

import base.BasePage;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;

public class DraggableWithSectionPage extends BasePage {

	@AndroidFindBy(id = "com.h6ah4i.android.example.advrecyclerview:id/drag_handle")
	public List<WebElement> items;

	@AndroidFindBy(id = "android:id/button1")
	public WebElement ok;

	@AndroidFindBy(id = "android:id/button1")
	public List<WebElement> buttons;

	private static final Logger lOGGER = LogManager.getLogger(DraggableWithSectionPage.class.getName());

	public DraggableWithSectionPage(AppiumDriver driver) {
		super(driver);
	}

	public void dragItemsInSectionA() {

		wait.forElementToBeVisible(items.get(0));
		dragAndDrop(items.get(0), items.get(2));
		dragAndDrop(items.get(0), items.get(1));
		lOGGER.info("Interchanging the position of items");
	}

	public void dragItemsInSectionB() {

		wait.forElementToBeVisible(items.get(3));
		dragAndDrop(items.get(3), items.get(5));
		dragAndDrop(items.get(3), items.get(4));
		lOGGER.info("Interchanging the position of items");
	}

	public void dragItemsInSectionC() {

		scrollOrSwipe(0.5, 0.9, 0.5, 0.1);
		wait.forElementToBeVisible(items.get(0));
		dragAndDrop(items.get(0), items.get(2));
		dragAndDrop(items.get(0), items.get(1));
		lOGGER.info("Interchanging the position of items");
	}

	public void dragItemsInSectionD() {

		wait.forElementToBeVisible(items.get(3));
		dragAndDrop(items.get(3), items.get(5));
		dragAndDrop(items.get(3), items.get(4));
		lOGGER.info("Interchanging the position of items");
	}

	public void dragItemsInSectionE() {

		scrollOrSwipe(0.5, 0.9, 0.5, 0.1);
		wait.forElementToBeVisible(items.get(4));
		dragAndDrop(items.get(4), items.get(6));
		dragAndDrop(items.get(4), items.get(5));
		lOGGER.info("Interchanging the position of items");
	}

	public void dragItems() {

		dragItemsInSectionA();
		dragItemsInSectionB();
		dragItemsInSectionC();
		dragItemsInSectionD();
		dragItemsInSectionE();
	}
}