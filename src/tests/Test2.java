package tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import pages.InvoicePage;

public class Test2 extends Browser {
	InvoicePage invoicePage;
	
//	testiranje home page
	@Test(priority=1)
	  public void test2() {
		invoicePage = new InvoicePage(driver);
		
		invoicePage.clientSelect1();
		invoicePage.fromDate();
		invoicePage.toDate();
		  
		invoicePage.filterThisMonth();
		Assert.assertTrue(invoicePage.numThisMonth());
		  
		invoicePage.filterLastMonth();
		Assert.assertTrue(invoicePage.numLastMonth());
		  
		invoicePage.filterRest();
		Assert.assertTrue(invoicePage.numRest());
		  
		invoicePage.refresh();
		  Assert.assertTrue(invoicePage.numRef());
		  
		  //menjanje statusa za odredjenog klijenta: sent, draft...
		  invoicePage.clientSelect2();
		  invoicePage.change();
		  Assert.assertTrue(invoicePage.message());
		  invoicePage.acceptChange();
		  
		  //preview fakture
		  invoicePage.preview();
		  Assert.assertTrue(invoicePage.previewPage());
		  
		  //edit fakture
		  invoicePage.edit();
		  Assert.assertTrue(invoicePage.saveAlert());
		  
		  //delete fakture
		  invoicePage.delete();
		  Assert.assertTrue(invoicePage.deleteMessage());
		  invoicePage.acceptDelete();
		  Assert.assertTrue(invoicePage.succDelete());
	}
}
