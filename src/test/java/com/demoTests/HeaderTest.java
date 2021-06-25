package com.demoTests;

import org.testng.annotations.Test;

import base.TestBase;
import pages2.AddOrRemovePage;
import pages2.ExpandableHeaderPage;
import pages2.MinimumHeaderPage;

public class HeaderTest extends TestBase {

	@Test(priority = 1)
	public void verifyMinHeader() throws Exception {

		pages2.homePage().wait.forElementToBeVisible(pages2.homePage().header);
		pages2.homePage().header.click();
		pages2.headerPage().wait.forElementToBeVisible(pages2.headerPage().headerMin);
		pages2.headerPage().headerMin.click();
		MinimumHeaderPage min = new MinimumHeaderPage(driver);
		min.verifyItems();
	}

//	@Test(priority = 2)
	public void verifyExpandableHeader() {

		pages2.homePage().wait.forElementToBeVisible(pages2.homePage().header);
		pages2.homePage().header.click();
		pages2.headerPage().wait.forElementToBeVisible(pages2.headerPage().headerMin);
		pages2.headerPage().expandableHeader.click();
		ExpandableHeaderPage expand = new ExpandableHeaderPage(driver);
		expand.verifyItems();
	}

//	@Test(priority = 3)
	public void verifyAddOrRemoveInHeader() {

		pages2.homePage().wait.forElementToBeVisible(pages2.homePage().header);
		pages2.homePage().header.click();
		pages2.headerPage().wait.forElementToBeVisible(pages2.headerPage().headerMin);
		pages2.headerPage().addOrRemove.click();
		AddOrRemovePage add = new AddOrRemovePage(driver);
		add.verifyItems();
	}
}