package pages2;

import io.appium.java_client.AppiumDriver;

public class PageObjectManager2 {

	private AppiumDriver driver;
	private HomePage homePage;
	private HeaderPage headerPage;
	private DragPage dragPage;
	private ExpandPage expandPage;
	private SwipePage swipePage;
	
	public PageObjectManager2(AppiumDriver driver) {
		this.driver = driver;
	}

	public HomePage homePage() {
		return (homePage == null) ? homePage = new HomePage(driver) : homePage;
	}

	public HeaderPage headerPage() {
		return (headerPage == null) ? headerPage = new HeaderPage(driver) : headerPage;
	}

	public DragPage dragPage() {
		return (dragPage == null) ? dragPage = new DragPage(driver) : dragPage;
	}
	
	public ExpandPage expandPage() {
		return (expandPage == null) ? expandPage = new ExpandPage(driver) : expandPage;
	}
	
	public SwipePage swipePage() {
		return (swipePage == null) ? swipePage = new SwipePage(driver) : swipePage;
	}
}