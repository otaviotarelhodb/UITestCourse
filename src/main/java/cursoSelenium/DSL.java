package cursoSelenium;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriver.TargetLocator;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

public class DSL {
	
	private WebDriver driver;
	
	
	public DSL(WebDriver driver) {
		this.driver = driver;
	}

	public void escreve(String idCampo, String texto) {
		escreve(By.id(idCampo), texto);
	}
	
	public void escreve(By by, String texto) {
		findElement(by).sendKeys(texto);
	}
	
	public String obterValorCampoById(String idCampo) {
		return findElement(By.id(idCampo)).getAttribute("value");
	}
	
	public void click(String idCampo) {
		findElement(By.id(idCampo)).click();
	}
	
	public boolean isRadioOrCheckSelected(String idCampo) {
		return findElement(By.id(idCampo)).isSelected();
	}
	
	public void selectFromComboBox(String id, String value) {
		WebElement element = findElement(By.id(id));
		Select combo = new Select(element);
		//combo.selectByIndex(3);
		//combo.selectByValue("superior");
		combo.selectByVisibleText(value);
	}
	
	public String getSelectedFromComboBox(String id) {
		WebElement element = findElement(By.id(id));
		Select combo = new Select(element);
		return combo.getFirstSelectedOption().getText();
	}
	
	public void clickLink(String id) {
		findElement(By.linkText(id)).click();
	}
	
	public String getText(String id) {
		return getText(By.id(id));
	}
	
	public String getText(By by) {
		return findElement(by).getText();
	}
	
	public void switchToFrame(String id) {
		getSwitch().frame(id);
	}
	
	public void switchToWindows(String id) {
		getSwitch().window(id);
	}
	
	public void switchToDefaultContent() {
		getSwitch().defaultContent();
	}
	
	public Alert switchToAlert() {
		return getSwitch().alert();
	}
	
	private TargetLocator getSwitch() {
		return driver.switchTo();
	}
	
	private WebElement findElement(By by) {
		return driver.findElement(by);
	}
}
