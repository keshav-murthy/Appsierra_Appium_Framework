package com.demoTests;

import org.testng.annotations.Test;

import base.TestBase;
import pages2.ButtonUnderSwipePage;
import pages2.SwipableBasicPage;
import pages2.SwipableLongPressPage;
import pages2.SwipableMinPage;
import pages2.VerticalSwipablePage;
import pages2.ViewPagerSwipablePage;

public class SwippingTest extends TestBase {

	@Test(priority = 1)
	public void verifyMinSwipe() {

		pages2.homePage().wait.forElementToBeVisible(pages2.homePage().swipe);
		pages2.homePage().swipe.click();
		pages2.swipePage().wait.forElementToBeVisible(pages2.swipePage().swipableMin);
		pages2.swipePage().swipableMin.click();
		SwipableMinPage swipable = new SwipableMinPage(driver);
		swipable.swipeItems();
	}

//	@Test(priority = 2)
	public void verifyBasicSwipe() {

		pages2.homePage().wait.forElementToBeVisible(pages2.homePage().swipe);
		pages2.homePage().swipe.click();
		pages2.swipePage().wait.forElementToBeVisible(pages2.swipePage().swipableBasic);
		pages2.swipePage().swipableBasic.click();
		SwipableBasicPage swipable = new SwipableBasicPage(driver);
		swipable.swipeItems();
	}

//	@Test(priority = 3)
	public void verifyLongPressSwipe() {

		pages2.homePage().wait.forElementToBeVisible(pages2.homePage().swipe);
		pages2.homePage().swipe.click();
		pages2.swipePage().wait.forElementToBeVisible(pages2.swipePage().swipableLongPress);
		pages2.swipePage().swipableLongPress.click();
		SwipableLongPressPage swipable = new SwipableLongPressPage(driver);
		swipable.swipeItems();
	}

//	@Test(priority = 4)
	public void verifyButtonUnderSwipe() {

		pages2.homePage().wait.forElementToBeVisible(pages2.homePage().swipe);
		pages2.homePage().swipe.click();
		pages2.swipePage().wait.forElementToBeVisible(pages2.swipePage().buttonUnderSwipe);
		pages2.swipePage().buttonUnderSwipe.click();
		ButtonUnderSwipePage swipable = new ButtonUnderSwipePage(driver);
		swipable.swipeItems();
	}

//	@Test(priority = 5)
	public void verifyVerticalSwipable() {

		pages2.homePage().wait.forElementToBeVisible(pages2.homePage().swipe);
		pages2.homePage().swipe.click();
		pages2.swipePage().wait.forElementToBeVisible(pages2.swipePage().verticalSwipable);
		pages2.swipePage().verticalSwipable.click();
		VerticalSwipablePage swipable = new VerticalSwipablePage(driver);
		swipable.swipeItems();
	}

//	@Test(priority = 6)
	public void verifyViewPagerSwipable() {

		pages2.homePage().wait.forElementToBeVisible(pages2.homePage().swipe);
		pages2.homePage().swipe.click();
		pages2.swipePage().wait.forElementToBeVisible(pages2.swipePage().viewPagerSwipable);
		pages2.swipePage().viewPagerSwipable.click();
		ViewPagerSwipablePage swipable = new ViewPagerSwipablePage(driver);
		swipable.swipeItems();
	}
}