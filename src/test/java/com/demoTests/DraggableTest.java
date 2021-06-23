package com.demoTests;

import org.testng.annotations.Test;

import base.TestBase;
import pages2.BasicDragPage;
import pages2.DragOnCheckPage;
import pages2.DraggableWithSectionPage;
import pages2.GridDragPage;
import pages2.LongPressDragPage;
import pages2.MinimunDragPage;
import pages2.StaggeredGridDragPage;

public class DraggableTest extends TestBase {

	@Test(priority = 1)
	public void verifyMinDrag() {

		pages2.dragPage().wait.forElementToBeVisible(pages2.dragPage().dragMin);
		pages2.dragPage().dragMin.click();
		MinimunDragPage min = new MinimunDragPage(driver);
		min.dragItems();
	}

	@Test(priority = 2)
	public void verifyBasicDrag() {

		pages2.dragPage().wait.forElementToBeVisible(pages2.dragPage().dragBasic);
		pages2.dragPage().dragBasic.click();
		BasicDragPage basic = new BasicDragPage(driver);
		basic.dragItems();
	}

	@Test(priority = 3)
	public void verifyLongPressSwipe() {

		pages2.dragPage().wait.forElementToBeVisible(pages2.dragPage().dragLongPress);
		pages2.dragPage().dragLongPress.click();
		LongPressDragPage min = new LongPressDragPage(driver);
		min.dragItems();
	}

	@Test(priority = 4)
	public void verifyDragInSections() {

		pages2.dragPage().wait.forElementToBeVisible(pages2.dragPage().dragSection);
		pages2.dragPage().dragSection.click();
		DraggableWithSectionPage sec = new DraggableWithSectionPage(driver);
		sec.dragItems();
	}

	@Test(priority = 5)
	public void verifyDragOnCheck() {

		pages2.dragPage().wait.forElementToBeVisible(pages2.dragPage().onCheckAndDrop);
		pages2.dragPage().onCheckAndDrop.click();
		DragOnCheckPage check = new DragOnCheckPage(driver);
		check.dragItems();
	}

	@Test(priority = 6)
	public void verifyGridDrag() {

		pages2.dragPage().wait.forElementToBeVisible(pages2.dragPage().gridLayout);
		pages2.dragPage().gridLayout.click();
		GridDragPage grid = new GridDragPage(driver);
		grid.dragItems();
	}

	@Test(priority = 7)
	public void verifyStaggeredGridDrag() {

		pages2.dragPage().wait.forElementToBeVisible(pages2.dragPage().staggeredGridLayout);
		pages2.dragPage().staggeredGridLayout.click();
		StaggeredGridDragPage stag = new StaggeredGridDragPage(driver);
		stag.dragItems();
	}
}