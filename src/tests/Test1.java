package tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import pages.InvoicePage;
import pages.Login;


public class Test1 extends Browser{
	
	Login login;
	InvoicePage invoicePage;
	
//	testiranje logovanja	
	@Test(priority=0)
	  public void test1() {
		
		driver.get("http://app.invoice-factory.source-code.rs");
		  driver.manage().window().maximize();
		  login= new Login(driver);
		  invoicePage = new InvoicePage(driver);
	
		  login.logIn("","");
		  Assert.assertTrue(login.requiredE());
		  Assert.assertTrue(login.requiredP());
	
		  login.logIn("ana.r.jevtic@gmail.com","");
		  Assert.assertTrue(login.requiredP());
		  
		  login.logIn("ana.r.jevti@gmail.com", "qwe123");
		  Assert.assertTrue(login.inCredentials());
	
		  login.logIn("","qwe123");
		  Assert.assertTrue(login.requiredE());
		  
		  login.logIn("ana.r.jevticgmail.com", "qwe123");
		  Assert.assertTrue(login.validEmail());
		
		  login.logIn("ana.r.jevtic", "qwe123");
		  Assert.assertTrue(login.validEmail());
	 
		  login.logIn("ana.r.jevtic@gmail", "qwe123");
		  Assert.assertTrue(login.validEmail());
	
		  login.logIn("ana.r.jevtic@.com", "qwe123");
		  Assert.assertTrue(login.validEmail());
		 
		  login.logIn("@gmail.com", "qwe123");
		  Assert.assertTrue(login.validEmail());
		  
		  login.logIn("gmail.com", "qwe123");
		  Assert.assertTrue(login.validEmail());
	  
		  login.logIn(".com", "qwe123");
		  Assert.assertTrue(login.validEmail());
	
		  login.logIn("ana.r.jevtic@gmailcom", "qwe123");
		  Assert.assertTrue(login.validEmail());

		  login.logIn("ana.r.jevtic@gmail.com", "QWE123");
		  Assert.assertTrue(login.inCredentials());
		  
		  login.logIn("ana.r.jevtic@gmail.com", "qw123");
		  Assert.assertTrue(login.shortP());
		  
		  login.logIn("ana.r.jevtic@gmail.com", "qwk123333333333333333");
		  Assert.assertTrue(login.longP());
		  
		  login.logIn("ana.r.jevtic@gmail.com", "qwk123");
		  Assert.assertTrue(login.inCredentials());
	  
		  login.logIn("anaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaarjevtic@gmail.com", "qwe123");
		  Assert.assertTrue(login.validEmail());
	  
		  login.logIn("ana.r.jevti@gmail.com", "qwk123");
		  Assert.assertTrue(login.inCredentials());

		  login.logIn("ana.r.jevtic@gmail.com", "qwe123");
		  Assert.assertTrue(invoicePage.userPage());
		  
	}
}
