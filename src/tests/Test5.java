package tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import pages.InvoicePage;
import pages.Login;
import pages.NewInvoicePage;

public class Test5 extends Browser {
	Login login;
	InvoicePage invoicePage;
	NewInvoicePage newInvoice;
	
//	cuvanje potpune fakture  i uspesan logout
	@Test(priority=4)
	  public void test5() {
		login= new Login(driver);
		invoicePage = new InvoicePage(driver);
		newInvoice = new NewInvoicePage(driver);
		
		newInvoice.fillFields5("Monday");
		newInvoice.saveAlert();
		Assert.assertTrue(invoicePage.userPage());
		invoicePage.logout();
		Assert.assertTrue(invoicePage.logoutAlert());
		invoicePage.logoutYes();
		Assert.assertTrue(login.email_isDisplayed());
		
	}	
}
