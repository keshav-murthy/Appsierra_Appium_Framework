package pages2;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebElement;

import base.BasePage;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;

public class DragPage extends BasePage {

	@AndroidFindBy(xpath = "//android.widget.Button[@text='DRAGGABLE (MINIMAL)']")
	public WebElement dragMin;

	@AndroidFindBy(xpath = "//android.widget.Button[@text='DRAGGABLE (BASIC)']")
	public WebElement dragBasic;

	@AndroidFindBy(xpath = "//android.widget.Button[@text='DRAG ON LONG PRESS']")
	public WebElement dragLongPress;

	@AndroidFindBy(xpath = "//android.widget.Button[@text='DRAGGABLE WITH SECTION']")
	public WebElement dragSection;

	@AndroidFindBy(xpath = "//android.widget.Button[@text='DRAGGABLE (USES ONCHECKCANDROP)']")
	public WebElement onCheckAndDrop;

	@AndroidFindBy(xpath = "//android.widget.Button[@text='DRAGGABLE (GRID LAYOUT)']")
	public WebElement gridLayout;

	@AndroidFindBy(xpath = "//android.widget.Button[@text='DRAGGABLE (STAGGERED GRID LAYOUT)']")
	public WebElement staggeredGridLayout;

	private static final Logger lOGGER = LogManager.getLogger(DragPage.class.getName());

	public DragPage(AppiumDriver driver) {
		super(driver);
	}
}