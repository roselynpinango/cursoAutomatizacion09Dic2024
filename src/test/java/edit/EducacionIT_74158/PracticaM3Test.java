package edit.EducacionIT_74158;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

import utilities.CapturaEvidencia;

public class PracticaM3Test {
	String url = "http://www.automationpractice.pl";
	WebDriver driver;
	String directorioEvidencias = "..\\EducacionIT-74158\\Evidencias\\";
	String nombreArchivoEvidencias = "Evidencias AutomationPractice.docx";
	File screen;
	
	@BeforeSuite
	public void abrirNavegador() {
		// (Paso 1) Definicion del navegador
		driver = new EdgeDriver();
		
		// (Paso 2) Abrir la pagina de prueba
		driver.get(url);
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		
	}
	
	/*
	@BeforeTest
	@BeforeClass
	@BeforeMethod
	*/
	
	@Test(description="CP002 - Ir a Contactanos", priority=87)
	public void irAAContactanos() throws InvalidFormatException, IOException, InterruptedException {
		CapturaEvidencia.escribirTituloEnDocumento(
				directorioEvidencias + nombreArchivoEvidencias,
				"Evidencias AutomationPractice.pl",
				20);
		
		// Capturar Evidencia 1: Pantalla Principal
		CapturaEvidencia.capturarPantallaEnDocumento(
				driver,
				directorioEvidencias + "img.jpg",
				directorioEvidencias + nombreArchivoEvidencias,
				"Paso 1: Pantalla Principal");
		
		WebElement lnkContact = driver.findElement(By.linkText("Contact us"));
		lnkContact.click();
		
		// Capturar Evidencia 2: Después de hacer clic en Contactanos
		CapturaEvidencia.capturarPantallaEnDocumento(
				driver,
				directorioEvidencias + "img.jpg",
				directorioEvidencias + nombreArchivoEvidencias,
				"Paso 2: Después de hacer clic en Contact us");
		
		Select selSubject = new Select(driver.findElement(By.cssSelector("#id_contact")));
		selSubject.selectByVisibleText("Webmaster");
		
		WebElement txtEmail = driver.findElement(By.xpath("//input[@id='email']"));
		txtEmail.sendKeys("correo@gmail.com");
		
		WebElement txtOrder = driver.findElement(By.id("id_order"));
		txtOrder.sendKeys("ORD-157");
		
		WebElement fileAdj = driver.findElement(By.name("fileUpload"));
		fileAdj.sendKeys("C:\\addIntegerData.txt"); // Windows
		
		// Linux o Mac
		//fileAdj.sendKeys("./nombreDirectorio/nombreArchivo.ext");
		
		WebElement txAMensaje = driver.findElement(By.tagName("textarea"));
		txAMensaje.sendKeys("Mensaje del comentario");
		
		// Capturar Evidencia 3: Al llenar el formulario
		CapturaEvidencia.capturarPantallaEnDocumento(
				driver,
				directorioEvidencias + "img.jpg",
				directorioEvidencias + nombreArchivoEvidencias,
				"Paso 3: Al llenar el formulario");
		
		WebElement btnSend = driver.findElement(By.id("submitMessage"));
		btnSend.click();
		
		// Capturar Evidencia 4: Al enviar el formulario de contacto
		CapturaEvidencia.capturarPantallaEnDocumento(
				driver,
				directorioEvidencias + "img.jpg",
				directorioEvidencias + nombreArchivoEvidencias,
				"Paso 4: Al enviar el formulario de contacto");
	}
	
	@Test(description="CP001 - Buscar un producto", priority=50)
	public void buscarProducto() throws IOException {
		// Capturar Evidencia 1: Pantalla Principal
		screen = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(screen, new File(directorioEvidencias + "01_PantallaPrincipal.jpg"));
		
		WebElement txtBuscador = driver.findElement(By.id("search_query_top"));
		txtBuscador.sendKeys("dress");
		
		// Capturar Evidencia 2: Palabra a Buscar
		screen = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(screen, new File(directorioEvidencias + "02_PalabraABuscar.jpg"));
		
		txtBuscador.sendKeys(Keys.ENTER);
		
		// Capturar Evidencia 3: Resultados de la Búsqueda
		screen = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(screen, new File(directorioEvidencias + "03_ResultadosBusqueda.jpg"));
		
		// Hacer chequeos para comprobar que todo salió bien
		String tituloEsperado = "Search - My Shop";
		String tituloActual = driver.getTitle(); 
		
		Assert.assertEquals(tituloEsperado, tituloActual);
		
		String urlEsperada = "http://www.automationpractice.pl/index.php?controller=search&orderby=position&orderway=desc&search_query=dress&submit_search=";
		String urlActual = driver.getCurrentUrl(); 
		
		Assert.assertEquals(urlEsperada, urlActual);
		
		/*
		 *  Assert.assertEquals("Search - My Shop", tituloActual);
			Assert.assertNotEquals("A", "B");
			Assert.assertTrue(1 == 1);
			Assert.assertFalse(2 == 3);
			Assert.assertNull(variable);
			Assert.assertNotNull(variable);
			*/
	}
	
	/*
	@AfterTest
	@AfterClass
	@AfterMethod
	*/
	
	@AfterSuite
	public void cerrarNavegador() {
		// Cerrar el navegador
		//driver.close();
	}
}
