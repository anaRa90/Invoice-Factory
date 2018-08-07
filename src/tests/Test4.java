package tests;
//popunjavanje fakture  uz pokusaj cancel komande i brisanja add
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.NewInvoicePage;


public class Test4 extends Browser{
	NewInvoicePage newInvoice;
	
//	popunjavanje fakture uz izostavljanje podataka i verifikacija da se mora prava vrsta podataka upisati
//	verifikacija ako se koristi Cancel da se trazi potvrda istog
	@Test(priority=3)
	  public void test4() {
		newInvoice = new NewInvoicePage(driver);
		
		newInvoice.fillFields1("00028", "00028"); //pre svakog pustanja testa moraju da se promene ovi podaci
		Assert.assertTrue(newInvoice.service());
		Assert.assertTrue(newInvoice.notice());
		newInvoice.fillFields2("consalting", "?","d","d", "d", "d");
		Assert.assertTrue(newInvoice.numericMessage1());
		Assert.assertTrue(newInvoice.numericMessage2());
		Assert.assertTrue(newInvoice.numericMessage3());
		Assert.assertTrue(newInvoice.numericMessage4());
		newInvoice.fillFields3("102","102");
		Assert.assertTrue(newInvoice.numericMessage5());
		Assert.assertTrue(newInvoice.numericMessage6());
		newInvoice.fillFields4("5", "6","20","20");
		Assert.assertTrue(newInvoice.deleteContent());
		Assert.assertTrue(newInvoice.alertVis());
		newInvoice.cancel2();
		Assert.assertTrue(newInvoice.cancelAlert());
		newInvoice.cancelNo();
		newInvoice.back2();
		Assert.assertTrue(newInvoice.backAlert());
		newInvoice.backNo();
		newInvoice.tab2();
		Assert.assertTrue(newInvoice.tabAlert());
		newInvoice.tabNo();
	}
}
