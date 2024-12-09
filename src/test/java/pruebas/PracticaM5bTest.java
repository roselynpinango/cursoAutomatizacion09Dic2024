package pruebas;

import java.time.Duration;

import org.openqa.selenium.Alert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;
import paginas.PaginaAlerta;

public class PracticaM5bTest {
	String url = "https://demoqa.com/alerts";
	WebDriver driver;
	
	@BeforeSuite
	public void setUp() {
		WebDriverManager.chromedriver().setup();
		
		// Hacer zoom in en la página
		ChromeOptions options = new ChromeOptions();
		double zoom = 0.8;
		options.addArguments("--force-device-scale-factor="+zoom);
		
		driver = new ChromeDriver(options);
		driver.get(url);
		driver.manage().window().maximize();
	}
	
	@Test
	public void alertaNotificacion() {
		PaginaAlerta pagina = new PaginaAlerta(driver);
		pagina.hacerClicEnNotificacion();
		
		Alert alerta = driver.switchTo().alert();
		alerta.accept(); // Clic en Aceptar
	}
	
	@Test
	public void alertaDemora() {
		PaginaAlerta pagina = new PaginaAlerta(driver);
		pagina.hacerClicEnDemora();
		
		// Hay que introducir una espera explicita
		WebDriverWait espera = new WebDriverWait(driver, Duration.ofSeconds(20));
		espera.until(ExpectedConditions.alertIsPresent());
		
		Alert alerta = driver.switchTo().alert();
		alerta.accept();
	}
	
	@AfterSuite
	public void tearDown() {
		//driver.close();
	}
}
