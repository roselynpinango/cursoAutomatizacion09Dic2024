package paginas;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class PaginaInicio {
	// (1) Elementos Web que se van a utilizar en tus pruebas
	@FindBy(partialLinkText="Sign")
	WebElement lnkSignIn;
	
	@FindBy(name="search_query")
	WebElement txtBuscador;
	
	@FindBy(xpath="//button[@name='submit_search']")
	WebElement btnBuscar;
	
	// (2) Constructor de la Página 
	public PaginaInicio(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
	
	// (3) Acciones que se pueden hacer sobre los elementos web
	public void hacerClicEnSignIn() {
		lnkSignIn.click();
	}
	
	public void escribirPalabraABuscar(String palabra) {
		txtBuscador.sendKeys(palabra);
	}
	
	public void hacerClicEnBuscar() {
		btnBuscar.click();
	}
}
