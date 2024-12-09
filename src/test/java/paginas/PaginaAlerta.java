package paginas;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class PaginaAlerta {
	@FindBy(css="#alertButton")
	WebElement btnNotificacion;
	
	@FindBy(id="timerAlertButton")
	WebElement btnDemora;
	
	public PaginaAlerta(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
	
	public void hacerClicEnNotificacion() {
		btnNotificacion.click();
	}
	
	public void hacerClicEnDemora() {
		btnDemora.click();
	}
}
