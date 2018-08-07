package tests;
import org.testng.Assert;
import org.testng.annotations.Test;

import pages.NewInvoicePage;



//testiranje prazne fakture(komande back, cancel, tab, save)


public class Test3 extends Browser{
	NewInvoicePage newInvoice;
	
//	testiranje komandi Back, Cancel, tab Invoices i Save za novu, praznu fakturu
	@Test(priority=2)
	  public void test3() {
		
		newInvoice = new NewInvoicePage(driver);
		newInvoice.firstMessages();
		Assert.assertTrue(newInvoice.firstMessage1());
		Assert.assertTrue(newInvoice.firstMessage2());
		newInvoice.back1();
		Assert.assertTrue(newInvoice.backEmpty());
		newInvoice.cancel1();
		Assert.assertTrue(newInvoice.cancelEmpty());
		newInvoice.tab1();
		Assert.assertTrue(newInvoice.tabEmpty());
		newInvoice.invEmpty();
		Assert.assertTrue(newInvoice.clientEr());
		Assert.assertTrue(newInvoice.businessEr());
		Assert.assertTrue(newInvoice.invoiceEr());
		Assert.assertTrue(newInvoice.basisEr());
		Assert.assertTrue(newInvoice.currencyEr());
		Assert.assertTrue(newInvoice.bankEr());
	}
}

