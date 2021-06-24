package pages2;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebElement;

import base.BasePage;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;

public class SwipePage extends BasePage {

	@AndroidFindBy(xpath = "//android.widget.Button[@text='SWIPEABLE (MINIMAL)']")
	public WebElement swipableMin;

	@AndroidFindBy(xpath = "//android.widget.Button[@text='SWIPEABLE (BASIC)']")
	public WebElement swipableBasic;

	@AndroidFindBy(xpath = "//android.widget.Button[@text='SWIPE ON LONG PRESS']")
	public WebElement swipableLongPress;

	@AndroidFindBy(xpath = "//android.widget.Button[@text='BUTTON UNDER SWIPEABLE ITEM']")
	public WebElement buttonUnderSwipe;

	@AndroidFindBy(xpath = "//android.widget.Button[@text='SWIPEABLE (VERTICAL)']")
	public WebElement verticalSwipable;

	@AndroidFindBy(xpath = "//android.widget.Button[@text='SWIPEABLE WITH VIEWPAGER']")
	public WebElement viewPagerSwipable;

	private static final Logger lOGGER = LogManager.getLogger(SwipePage.class.getName());

	public SwipePage(AppiumDriver driver) {
		super(driver);
	}
}