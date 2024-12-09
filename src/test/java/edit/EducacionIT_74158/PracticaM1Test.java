package edit.EducacionIT_74158;

import org.testng.annotations.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class PracticaM1Test {
	String url = "http://automationpractice.pl/";

	@Test
	public void buscarProductoEnEdge() {
		// Paso 1: Definir el navegador que vamos a usar
		WebDriver navegador = new EdgeDriver();
		navegador.manage().window().maximize(); // Maximiza la ventana
		navegador.manage().deleteAllCookies(); // Borrar las cookies
		
		// Paso 2: Abrir el navegador en la URL de prueba
		navegador.get(url);
		
		// Paso 3: Escribir el producto que queremos buscar
		WebElement txtBusqueda = navegador.findElement(By.id("search_query_top"));
		txtBusqueda.sendKeys("dress");
		
		// Paso 4: Hacer clic en el botón de búsqueda
		WebElement btnBuscar = navegador.findElement(By.name("submit_search"));
		btnBuscar.click();
		
		// Paso 5: Cerrar el navegador
		navegador.close(); // cierra la última pestaña que se usó en la prueba
		//navegador.quit(); // cierra todas las pestañas que se hayan usado
	}
	
	@Test
	public void buscarProductoEnFirefox() {
		// Paso 1: Definir el navegador que vamos a usar
		WebDriver navegador = new FirefoxDriver();
		
		// Paso 2: Abrir el navegador en la URL de prueba
		navegador.get(url);
		
		// Paso 3: Escribir el producto que queremos buscar
		WebElement txtBusqueda = navegador.findElement(By.id("search_query_top"));
		txtBusqueda.sendKeys("dress");
		
		// Paso 4: Hacer clic en el botón de búsqueda
		WebElement btnBuscar = navegador.findElement(By.name("submit_search"));
		btnBuscar.sendKeys(Keys.ENTER); // Simula que presionamos cierta tecla
		//btnBuscar.click();
	}
}
