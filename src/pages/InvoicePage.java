package pages;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class InvoicePage extends PageObject{

	public InvoicePage(WebDriver driver) {
		super(driver);
	}

	@FindBy (xpath = "//h4[contains(text(),'Invoices List')]")
	WebElement userP;
	
	@FindBy (xpath="//div[contains(text(),'Preview Invoice')]")
	WebElement previewP;
	
	@FindBy (xpath ="//label[contains(text(), 'Select client')]")
	WebElement selectClient;
	
	@FindBy (xpath = "//div[contains(text(), 'Petar Petrovic')]")
	WebElement client1;
	
	@FindBy (xpath = "//div[contains(text(), 'Marija Marijanovic')]")
	WebElement client2;
	
	@FindBy (id="filter-from")
	WebElement from;
	
	@FindBy (id="filter-to")
	WebElement to;
	
	@FindBy (className="v-date-picker-header__value")
	WebElement month;
	
	@FindBy (xpath="//div[contains(text(),'Jan')]")
	WebElement fromMonth;
	
	@FindBy (xpath="//div[text()='1']")
	WebElement fromDay;
	
	@FindBy (xpath="//div[text()='OK']")
	WebElement fromOk;
	
	@FindBy (xpath="//i[contains(text(), 'chevron_left')]")
	List<WebElement>toMonthLeft;
	
	@FindBy (xpath="//i[contains(text(), 'chevron_right')]")
	List<WebElement>toMonthRight;
	
	@FindBy (xpath="//div[text()='Any Time']")
	WebElement toAnyTime;
	
	@FindBy (xpath="//strong[contains(text(),'Petar Petrovic')]")
	List<WebElement>listClient1;
	
	@FindBy (className="tooltip")
	List<WebElement>allClients;

	@FindBy (id="filter-period")
	WebElement filterPeriod;
	
	@FindBy (id="this-month")
	WebElement thisMonth;
	
	@FindBy (id="last-month")
	WebElement lastMonth;
	
	@FindBy (id="reset-dates")
	WebElement restMonth;
	
	@FindBy (id="filter-reset")
	WebElement refButton;
	
	@FindBy (xpath="//div[contains(text(),'Paid')]")
	List<WebElement>statusClient;	
	
	@FindBy (className="v-select__selections")
	List<WebElement>selectedStatus;
	
	@FindBy (xpath="//div[contains(text(),'to change status')]")
	List<WebElement>changeMessage;
	
	@FindBy (xpath="//div[contains(text(),'YES')]")
	List<WebElement>yesChange;
	
	@FindBy (xpath="//button[@class='v-btn v-btn--icon']")
	List<WebElement>options;
	
	@FindBy (xpath="//a//i[contains(text(),'edit')]")
	List<WebElement>editButton;
	
	@FindBy (xpath="//a//i[contains(text(),'visibility')]")
	List<WebElement>previewButton;
	
	@FindBy (xpath="//i[contains(text(),'close')]")
	WebElement previewClose;
	
	@FindBy (xpath="//i[contains(text(),'delete')]")
	List<WebElement>deleteButton;
	
	@FindBy (id="inv-form-notes")
	WebElement editText;
	
	@FindBy (id="inv-form-save-btn")
	WebElement editBut;
	
	@FindBy (xpath="//div[contains(text(),'successfully saved')]")
	WebElement saved;
	
	@FindBy (xpath="//div[contains(text(),'delete this invoice?')]")
	List<WebElement>alertDelete;
	
	@FindBy (xpath="//div[contains(text(),'Yes')]")
	List<WebElement>deleteYes;
	
	@FindBy (xpath="//i[text()='expand_more']")
	WebElement arrow;
	
	@FindBy (id="navbar-logout-btn")
	WebElement logOutButton;
	
	@FindBy (xpath="//div[text()='Logout?']")
	WebElement outAlert;
	
	@FindBy (id="logut-yes")
	WebElement outYes;
	
//	verifikacija pocetne strane
	public boolean userPage(){
		wait.until(ExpectedConditions.visibilityOf(userP));
		return userP.isDisplayed();
	}
	
//	biranje prvog klijentna za testiranje
	public void clientSelect1() {
		selectClient.click();
		client1.click();
	}
	
// biranje datuma
	public void fromDate() {
		wait.until(ExpectedConditions.elementToBeClickable(from));
		from.click();
		wait.until(ExpectedConditions.elementToBeClickable(month));
		month.click();
		wait.until(ExpectedConditions.elementToBeClickable(fromMonth));
		fromMonth.click();
		wait.until(ExpectedConditions.elementToBeClickable(fromDay));
		fromDay.click();
		wait.until(ExpectedConditions.elementToBeClickable(fromOk));
		fromOk.click();	
	}	
	
	public void toDate() {
		wait.until(ExpectedConditions.elementToBeClickable(to));
		to.click();
		wait.until(ExpectedConditions.elementToBeClickable(toMonthLeft.get(0)));
		toMonthLeft.get(0).click();
		wait.until(ExpectedConditions.elementToBeClickable(toMonthRight.get(0)));
		toMonthRight.get(0).click();
		wait.until(ExpectedConditions.elementToBeClickable(fromOk));
		fromOk.click();		
	}
	
//	filtriranje za ovaj mesec
	public void filterThisMonth() {
		filterPeriod.click();
		thisMonth.click();	
	}
	
//	verifikacija da su izlistane fakture za ovaj mesec za datog klijenta
	public boolean numThisMonth() {
		wait.until(ExpectedConditions.visibilityOfAllElements(listClient1));
		return listClient1.size() == 1;
	}
	
//	filtriranje za predhodni mesec
	public void filterLastMonth() {
		filterPeriod.click();
		lastMonth.click();	
	}
	
//	verfikacija da su izlistane fakture za predhodni mesec
	public boolean numLastMonth() {
		wait.until(ExpectedConditions.visibilityOfAllElements(listClient1));
		return listClient1.size() == 3;
	}
	
//	uklanjanje filtera
	public void filterRest() {
		wait.until(ExpectedConditions.visibilityOfAllElements(listClient1));
		filterPeriod.click();
		restMonth.click();
	}
	
//	verifikacija da je filter uklonjen
	public boolean numRest() {
		wait.until(ExpectedConditions.visibilityOfAllElements(listClient1));
		return listClient1.size() == 5;
	}
	
//	koriscenje refresh-a
	public void refresh() {
		refButton.click();	
	}
	
//	verifikacija da je filter za klijente uklonjen
	public boolean numRef() {
		wait.until(ExpectedConditions.visibilityOfAllElements(allClients));
		return allClients.size() == 11;
	}

//	biranje drugog klijenta za testiranje
	public void clientSelect2() {
		selectClient.click();
		client2.click();
	}
	
//	promena statusa klijenta u Paid
	public void change() {
		allClients.get(1).click();
		wait.until(ExpectedConditions.visibilityOf(selectedStatus.get(3)));
		selectedStatus.get(3).click();
		wait.until(ExpectedConditions.elementToBeClickable(statusClient.get(1)));
		statusClient.get(1).click();
	}
	
//	verifikacija da se prikazuje poruka za potvrdu promene statusa
	public boolean message(){
		wait.until(ExpectedConditions.visibilityOf(changeMessage.get(1)));
		return changeMessage.get(1).isDisplayed();
	}
	
//	prihvatanje promene statusa
	public void acceptChange() {
		wait.until(ExpectedConditions.visibilityOf(yesChange.get(1)));
		yesChange.get(1).click();
	}
	
//	koriscenje preview-a
	public void preview() {
		driver.navigate().refresh();
		wait.until(ExpectedConditions.elementToBeClickable(options.get(1)));
		options.get(1).click();
		wait.until(ExpectedConditions.elementToBeClickable(previewButton.get(1)));
		previewButton.get(1).click();
	}
	
//	verifikacija da se otvorila preview page
	public boolean previewPage() {
		wait.until(ExpectedConditions.visibilityOf(previewP));
		return previewP.isDisplayed();
	}
	
//	koriscenje edit-a (upisivanje u Notes)
	public void edit() {
		previewClose.click();
		wait.until(ExpectedConditions.visibilityOf(userP));
		driver.navigate().refresh();
		selectClient.click();
		client2.click();
		wait.until(ExpectedConditions.elementToBeClickable(options.get(1)));
		options.get(1).click();
		wait.until(ExpectedConditions.elementToBeClickable(editButton.get(1)));
		editButton.get(1).click();
		editText.click();
		editText.sendKeys("This is note.");
		editBut.click();
		
	}
	
//	verifikacija da je promena sacuvana
	public boolean saveAlert() {
		wait.until(ExpectedConditions.visibilityOf(saved));
		return saved.isDisplayed();
	}
	
//	brisanje fakture
	public void delete() {
		wait.until(ExpectedConditions.visibilityOf(userP));
		driver.navigate().refresh();
		wait.until(ExpectedConditions.elementToBeClickable(selectClient));
		selectClient.click();
		client2.click();
		wait.until(ExpectedConditions.elementToBeClickable(options.get(1)));
		options.get(1).click();
		wait.until(ExpectedConditions.elementToBeClickable(deleteButton.get(1)));
		deleteButton.get(1).click();
	}
	
//	verifikacija sa se prikazuje upit za brisanje
	public boolean deleteMessage() {
		wait.until(ExpectedConditions.visibilityOf(alertDelete.get(1)));
		return alertDelete.get(1).isDisplayed();
	}
	
//	prihvatanje brisanja
	public void acceptDelete() {
		deleteYes.get(1).click();
	}
	
//	verifikacija da je faktura izbrisana
	public boolean succDelete() {
		return allClients.size() == 2;
	}

//	logout
	public void logout() {
		arrow.click();
		wait.until(ExpectedConditions.elementToBeClickable(logOutButton));
		logOutButton.click();
	}
	
//	verifikacija da se prikazuje upit za potvrdu logout-a
	public boolean logoutAlert() {
		wait.until(ExpectedConditions.visibilityOf(outAlert));
		return outAlert.isDisplayed();
	}
	
//	prihvatanje logout-a
	public void logoutYes() {
		wait.until(ExpectedConditions.elementToBeClickable(outYes));
		outYes.click();
	}
}

