package com.demoTests;

import org.testng.annotations.Test;

import base.TestBase;
import pages2.AddOrRemovePage;
import pages2.ExpandBasicPage;
import pages2.ExpandInGroupsPage;
import pages2.ExpandMinPage;

public class ExpandableTest extends TestBase {

//	@Test(priority = 1)
	public void verifyMinExpand() {

		pages2.homePage().wait.forElementToBeVisible(pages2.homePage().expand);
		pages2.homePage().expand.click();
		pages2.expandPage().wait.forElementToBeVisible(pages2.expandPage().expandMin);
		pages2.expandPage().expandMin.click();
		ExpandMinPage min = new ExpandMinPage(driver);
		min.expandItems();
	}

//	@Test(priority = 2)
	public void verifyBasicExpand() {

		pages2.homePage().wait.forElementToBeVisible(pages2.homePage().expand);
		pages2.homePage().expand.click();
		pages2.expandPage().wait.forElementToBeVisible(pages2.expandPage().expandBasic);
		pages2.expandPage().expandBasic.click();
		ExpandBasicPage basic = new ExpandBasicPage(driver);
		basic.expandItems();
	}

//	@Test(priority = 3)
	public void verifyAddOrRemove() {

		pages2.homePage().wait.forElementToBeVisible(pages2.homePage().expand);
		pages2.homePage().expand.click();
		pages2.expandPage().wait.forElementToBeVisible(pages2.expandPage().addOrRemove);
		pages2.expandPage().addOrRemove.click();
		AddOrRemovePage addRem = new AddOrRemovePage(driver);
		addRem.expandItems();
	}

	@Test(priority = 4)
	public void verifyExpandInGroups() {

		pages2.homePage().wait.forElementToBeVisible(pages2.homePage().expand);
		pages2.homePage().expand.click();
		pages2.expandPage().wait.forElementToBeVisible(pages2.expandPage().groups);
		pages2.expandPage().groups.click();
		ExpandInGroupsPage groups = new ExpandInGroupsPage(driver);
		groups.expandItems();
	}
}