package pages;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class NewInvoicePage extends PageObject {

	public NewInvoicePage(WebDriver driver) {
		super(driver);
	}

	Actions builder = new Actions(driver);
	
	@FindBy (xpath = "//h4[contains(text(),'Invoices List')]")
	WebElement userP;
	
	@FindBy (id="add-new-invoice")
	WebElement addInv;
	
	@FindBy (xpath="//div[text()='First choose currency']")
	WebElement chooseCurrency;
	
	@FindBy (xpath="//div[text()='First choose business']")
	WebElement chooseBusiness;
	
	@FindBy (id="inv-form-back-btn")
	WebElement backBut;
	
	@FindBy (id="inv-form-cancel-btn")
	WebElement cancelBut;
	
	@FindBy (id="inv-form-save-btn")
	WebElement saveBut;
	
	@FindBy (id="nav-bar-invoices")
	WebElement invTab;
	
	@FindBy (id="click-to-enter")
	WebElement tit;
	
	@FindBy (id="inv-form-number")
	WebElement invoice;
	
	@FindBy (id="inv-form-date-duedate")
	WebElement duedate;
	
	@FindBy (id="inv-form-date-submitted")
	WebElement submitted;
	
	@FindBy (id="inv-form-basis")
	WebElement basis;
	
	@FindBy (id="add-content-btn")
	WebElement addBt;
	
	@FindBy (id="inv-form-service-0")
	WebElement service;
	
	@FindBy (id="inv-form-note-0")
	WebElement note;
	
	@FindBy (id="inv-form-days-0")
	WebElement days;
	
	@FindBy (id="inv-form-hours-0")
	WebElement hours;
	
	@FindBy (id="inv-form-rate-0")
	WebElement rate;
	
	@FindBy (className="v-dialog__activator")
	List<WebElement>delete;
	
	@FindBy (id="inv-form-discount")
	WebElement discount;
	
	@FindBy (id="inv-form-tax")
	WebElement tax;
	
	@FindBy (xpath="//div[contains(text(),'must be numeric')]")
	List<WebElement>mustNumeric1;
	
	@FindBy (xpath="//div[contains(text(),' must be 0 or more')]")
	List<WebElement>mustNumeric2;
	
	@FindBy (xpath="//div[contains(text(),' 100 or less')]")
	List<WebElement>mustLess100;
	
	@FindBy (id="inv-form-total")
	WebElement total;
	
	@FindBy(xpath="//div[contains(text(), 'is required')]")
	List<WebElement>message;

	@FindBy (className="v-select__slot")
	List<WebElement>status;
	
	@FindBy (className="v-list__tile__title")
	List<WebElement>list;
	
	@FindBy(className="body-2")
	WebElement alert;
	
	@FindBy (xpath="//div[text()='Yes']")
	List<WebElement>yesDelete;
	
	@FindBy (xpath="//div[text()='No']")
	List<WebElement>noDelete;
	
	@FindBy (className="v-date-picker-header__value")
	WebElement month_year;
	
	@FindBy (xpath="//li[text()='1983']")
	WebElement year;
	
	@FindBy (xpath="//div[contains(text(),'Aug')]")
	WebElement month;
	
	@FindBy (xpath="//div[text()='1']")
	WebElement day;
	
	@FindBy (xpath="//div[text()='Cancel']")
	List<WebElement>dateCancel;
	
	@FindBy (xpath="//div[text()='OK']")
	List<WebElement>dateOk;
	
	@FindBy (xpath="//div[contains(text(),'discard this change')]")
	WebElement alertCancel;
	
	@FindBy (xpath="//div[contains(text(),'successfully saved')]")
	WebElement saved;
	
//verifikacija da kada se udje na dodavanje nove fakture pokazuju poruke kod currency i bank polja
	public void firstMessages() {
		wait.until(ExpectedConditions.elementToBeClickable(addInv));
		addInv.click();
	}
	
	public boolean firstMessage1() {
		wait.until(ExpectedConditions.visibilityOf(chooseBusiness));
		return chooseBusiness.isDisplayed();
	}
	
	public boolean firstMessage2() {
		wait.until(ExpectedConditions.visibilityOf(chooseCurrency));
		return chooseCurrency.isDisplayed();
	}
	
//	klik na Back kod prazne fakture i verifikacija vracanja na home page
	public void back1() {
		wait.until(ExpectedConditions.elementToBeClickable(cancelBut));
		backBut.click();
	}
	
	public boolean backEmpty() {
		wait.until(ExpectedConditions.visibilityOf(userP));
		return userP.isDisplayed();
	}
	
//	klik na Cancel kod prazne fakture i verifikacija vracanja na home page	
	public void cancel1() {
		wait.until(ExpectedConditions.elementToBeClickable(addInv));
		addInv.click();
		wait.until(ExpectedConditions.elementToBeClickable(saveBut));
		cancelBut.click();	
	}
	
	public boolean cancelEmpty() {
		wait.until(ExpectedConditions.visibilityOf(userP));
		return userP.isDisplayed();
	}
	
//	klik na tab Invoices kod prazne fakture i verifikacija vracanja na home page
	public void tab1() {
		wait.until(ExpectedConditions.elementToBeClickable(addInv));
		addInv.click();
		wait.until(ExpectedConditions.elementToBeClickable(saveBut));
		invTab.click();
	}
		
	public boolean tabEmpty() {
		wait.until(ExpectedConditions.visibilityOf(userP));
		return userP.isDisplayed();
	}
	
//	ukoliko se ide na Save za praznu fakturu
	public void invEmpty() {
		wait.until(ExpectedConditions.elementToBeClickable(addInv));
		addInv.click();
		wait.until(ExpectedConditions.elementToBeClickable(saveBut));
		saveBut.click();
	}
	
//	verifikacija da teksta da ova polja moraju da se popune
	public boolean clientEr() {
		wait.until(ExpectedConditions.visibilityOf(message.get(5)));
		return message.get(0).isDisplayed();
	}
	
	public boolean businessEr() {
		wait.until(ExpectedConditions.visibilityOf(message.get(5)));
		return message.get(1).isDisplayed();
	}
	
	public boolean invoiceEr() {
		wait.until(ExpectedConditions.visibilityOf(message.get(5)));
		return message.get(2).isDisplayed();
	}
	
	public boolean basisEr() {
		wait.until(ExpectedConditions.visibilityOf(message.get(5)));
		return message.get(3).isDisplayed();
	}
	
	public boolean currencyEr() {
		wait.until(ExpectedConditions.visibilityOf(message.get(5)));
		return message.get(4).isDisplayed();
	}
	
	public boolean bankEr() {
		wait.until(ExpectedConditions.visibilityOf(message.get(5)));
		return message.get(5).isDisplayed();
	}
	
//	ukoliko se ide na Save kada se popune ova polja
	public void fillFields1(String invoiceNum, String basisNum) {
		wait.until(ExpectedConditions.elementToBeClickable(status.get(0)));
		status.get(0).click();
		list.get(14).click();
		status.get(1).click();
		list.get(10).click();
		status.get(2).click();
		list.get(5).click();
		invoice.click();
		invoice.sendKeys(invoiceNum);
		basis.click();
		basis.sendKeys(basisNum);
		status.get(3).click();
		list.get(2).click();
		addBt.click();
		status.get(4).click();
		list.get(0).click();
		saveBut.click();
	}
	
//	verifikacija teksta da i ova polja moraju biti popunjena
	public boolean service() {
		wait.until(ExpectedConditions.visibilityOf(message.get(1)));
		return message.get(0).isDisplayed();
	}
	
	public boolean notice() {
		wait.until(ExpectedConditions.visibilityOf(message.get(1)));
		return message.get(1).isDisplayed();
	}
	
//	popunjavanje potrebnih polja u vidu slova
	public void fillFields2(String serv, String not, String day, String rat, String disc, String taxe) {
		service.click();
		service.sendKeys(serv);
		note.click();
		note.sendKeys(not);
		Action day1 = builder.doubleClick(days).build();
		day1.perform();
		wait.until(ExpectedConditions.elementToBeClickable(days));
		days.sendKeys(day);
		Action rat1 = builder.doubleClick(rate).build();
		rat1.perform();
		wait.until(ExpectedConditions.elementToBeClickable(rate));
		rate.sendKeys(rat);
		Action count1 = builder.doubleClick(discount).build();
		count1.perform();
		wait.until(ExpectedConditions.elementToBeClickable(discount));
		discount.sendKeys(disc);
		Action count2 = builder.doubleClick(tax).build();
		count2.perform();
		wait.until(ExpectedConditions.elementToBeClickable(tax));
		tax.sendKeys(taxe);
	}
	
//	verifikacija teksta da moraju biti uneseni brojevi
	public boolean numericMessage1() {
		wait.until(ExpectedConditions.visibilityOf(mustNumeric2.get(1)));
		return mustNumeric1.get(0).isDisplayed();
	}
	
	public boolean numericMessage2() {
		wait.until(ExpectedConditions.visibilityOf(mustNumeric2.get(1)));
		return mustNumeric1.get(1).isDisplayed();
	}
	
	public boolean numericMessage3() {
		wait.until(ExpectedConditions.visibilityOf(mustNumeric2.get(1)));
		return mustNumeric2.get(0).isDisplayed();
	}
	
	public boolean numericMessage4() {
		wait.until(ExpectedConditions.visibilityOf(mustNumeric2.get(1)));
		return mustNumeric2.get(1).isDisplayed();
	}
	
//	popunjavanje potrebnih polja brojevima vecim od 100
	public void fillFields3(String disc, String taxe) {
		Action count1 = builder.doubleClick(discount).build();
		count1.perform();
		wait.until(ExpectedConditions.elementToBeClickable(discount));
		discount.sendKeys(disc);
		Action count2 = builder.doubleClick(tax).build();
		count2.perform();
		wait.until(ExpectedConditions.elementToBeClickable(tax));
		tax.sendKeys(taxe);
	}
	
//	verifikacija teksta da moraju biti uneseni brojevi do 100
		
	public boolean numericMessage5() {
		wait.until(ExpectedConditions.visibilityOf(mustLess100.get(1)));
		return mustLess100.get(0).isDisplayed();
	}
	
	public boolean numericMessage6() {
		wait.until(ExpectedConditions.visibilityOf(mustLess100.get(1)));
		return mustLess100.get(0).isDisplayed();
	}
	
//	popunjavanje potrebnih polja brojevima i dodavanje jos jednog CONTENTS-a i brisanje istog
	public void fillFields4(String day, String rat, String disc, String taxe) {
		Action day1 = builder.doubleClick(days).build();
		day1.perform();
		wait.until(ExpectedConditions.elementToBeClickable(days));
		days.sendKeys(day);
		Action rat1 = builder.doubleClick(rate).build();
		rat1.perform();
		wait.until(ExpectedConditions.elementToBeClickable(rate));
		rate.sendKeys(rat);
		Action count1 = builder.doubleClick(discount).build();
		count1.perform();
		wait.until(ExpectedConditions.elementToBeClickable(discount));
		discount.sendKeys(disc);
		Action count2 = builder.doubleClick(tax).build();
		count2.perform();
		wait.until(ExpectedConditions.elementToBeClickable(tax));
		tax.sendKeys(taxe);
		addBt.click();
		delete.get(1).click();
		yesDelete.get(0).click();
		saveBut.click();
	}
	
//	verifikacija da je izbrisan jedan content iz INVOICE CONTENTS
	public boolean deleteContent(){
		return delete.size() == 1;
	}
//	verifikacija prikazivanja alerta kad nesto jos nije popunjeno, u ovom slucaju Title
	public boolean alertVis() {
		wait.until(ExpectedConditions.visibilityOf(alert));
		return alert.isDisplayed();
	}
	
//	verifikacija da kada se klikne na Cancel je potrebno potvditi odbacivanje fakture koja ima neke podatke
	public void cancel2() {
		wait.until(ExpectedConditions.elementToBeClickable(cancelBut));
		cancelBut.click();
	}
	
	public boolean cancelAlert() {
		wait.until(ExpectedConditions.visibilityOf(alertCancel));
		return alertCancel.isDisplayed();
	}
	
	public void cancelNo() {
		wait.until(ExpectedConditions.elementToBeClickable(noDelete.get(1)));
		noDelete.get(1).click();
	}
	
	
//	verifikacija da kada se klikne na Back je potrebno potvditi odbacivanje fakture koja ima neke podatke
	public void back2() {
		wait.until(ExpectedConditions.elementToBeClickable(backBut));
		backBut.click();
	}
	
	public boolean backAlert() {
		wait.until(ExpectedConditions.visibilityOf(alertCancel));
		return alertCancel.isDisplayed();
	}
	
	public void backNo() {
		wait.until(ExpectedConditions.elementToBeClickable(noDelete.get(1)));
		noDelete.get(1).click();
	}
	
//	verifikacija da kada se klikne na tab Invoice je potrebno potvditi odbacivanje fakture koja ima neke podatke
	public void tab2() {
		wait.until(ExpectedConditions.elementToBeClickable(invTab));
		invTab.click();
	}
	
	public boolean tabAlert() {
		wait.until(ExpectedConditions.visibilityOf(alertCancel));
		return alertCancel.isDisplayed();
	}
	
	public void tabNo() {
		wait.until(ExpectedConditions.elementToBeClickable(noDelete.get(1)));
		noDelete.get(1).click();
	}
	
//	dopunjavanje Titla fakture i datuma
	public void fillFields5(String title) {
		Action titl = builder.click(tit).sendKeys(title).build();
		titl.perform();
		submitted.click();
		wait.until(ExpectedConditions.elementToBeClickable(month_year));
		month_year.click();
		month_year.click();
		year.click();
		wait.until(ExpectedConditions.elementToBeClickable(month));
		month.click();
		wait.until(ExpectedConditions.elementToBeClickable(day));
		day.click();
		wait.until(ExpectedConditions.elementToBeClickable(dateCancel.get(0)));
		dateCancel.get(0).click();
		wait.until(ExpectedConditions.visibilityOf(duedate));
		duedate.click();
		wait.until(ExpectedConditions.elementToBeClickable(dateOk.get(0)));
		dateOk.get(0).click();
		wait.until(ExpectedConditions.elementToBeClickable(saveBut));
		saveBut.click();
		
	}
//	verifikacija da se pokazuje poruka da je faktura sacuvana
	public boolean saveAlert() {
		wait.until(ExpectedConditions.visibilityOf(saved));
		return saved.isDisplayed();
	}

}
