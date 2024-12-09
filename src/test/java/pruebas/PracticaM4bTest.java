package pruebas;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;
import paginas.PaginaInicio;

public class PracticaM4bTest {
	String url = "http://www.automationpractice.pl";
	WebDriver driver;
	
	@Parameters("navegador")
	@BeforeTest
	public void setUp(String navegador) {
		if (navegador.equalsIgnoreCase("Edge")) {
			driver = new EdgeDriver();
		} else if (navegador.equalsIgnoreCase("Firefox")) {
			driver = new FirefoxDriver();
		} else if (navegador.equalsIgnoreCase("Chrome")) {
			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver(); 
		}
		
		driver.get(url);
		driver.manage().window().maximize();
	}
	
	@Test
	public void buscarPalabra() {
		PaginaInicio inicio = new PaginaInicio(driver);
		inicio.escribirPalabraABuscar("dress");
		inicio.hacerClicEnBuscar();
	}
}
