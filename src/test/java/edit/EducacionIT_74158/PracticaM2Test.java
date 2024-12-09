package edit.EducacionIT_74158;

import org.testng.annotations.Test;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.github.javafaker.Faker;

public class PracticaM2Test {
	String url = "http://www.automationpractice.pl/";
	
	@Test
	public void registrarUsuario() {
		// 1) Definir qué navegador usaremos
		WebDriver driver = new EdgeDriver();
		
		// 2) Abrir el navegador en la página de prueba
		//driver.get(url);
		driver.navigate().to(url);
		
		// 3) Hacer clic en 'Sign in'
		WebElement lnkSign = driver.findElement(By.className("login"));
		lnkSign.click();
		
		// 4) Escribir el correo electrónico
		WebElement txtEmail = driver.findElement(By.cssSelector("#email_create"));
		txtEmail.sendKeys("correo06Nov@gmail.com");
		
		// 5) Hacer clic en 'Create an Account'
		//WebElement btnCreate = driver.findElement(By.id("SubmitCreate"));
		//btnCreate.click();
		
		driver.findElement(By.id("SubmitCreate")).click();
		
		// Es necesaria una espera para que cargue el formulario
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//input[@id='id_gender1']")));
		
		// 6) Seleccionar el Título
		driver.findElement(By.xpath("//input[@id='id_gender1']")).click();
		
		// 7) Escribir el nombre
		driver.findElement(By.name("customer_firstname")).sendKeys("Arturo");
		
		// 8) Escribir el apellido
		driver.findElement(By.id("customer_lastname")).sendKeys("Lopez");
		
		// 9) Blanquear el valor del correo
		WebElement txtEmailForm = driver.findElement(By.xpath("//input[@id='email']"));
		txtEmailForm.clear();
		
		// 10) Escribir el nuevo valor del correo
		// 10.1) Añadir un numero aleatorio al correo electronico con Java
		//String email = "correo" + Math.random() + "@gmail.com";
		
		// 10.2) Utilizar una libreria Java que genere datos aleatorios
		Faker faker = new Faker();
		String email = faker.internet().emailAddress();
		
		txtEmailForm.sendKeys(email);
		
		// Extra: Usos de JavaFaker
		System.out.println("Usos de JavaFaker");
		System.out.println("Dirección: " + faker.address().fullAddress());
		System.out.println("Nombre: " + faker.address().firstName());
		System.out.println("TDC: " + faker.finance().creditCard());
		System.out.println("Fecha Nacimiento: " + faker.date().birthday());
		
		// 11) Escribir la contraseña
		driver.findElement(By.cssSelector("#passwd")).sendKeys("1q2w3e4r5t");
		
		// 12) Seleccionar de la lista desplegable la fecha de nacimiento
		Select days = new Select(driver.findElement(By.name("days")));
		days.selectByVisibleText("18  ");
		
		Select months = new Select(driver.findElement(By.xpath("//select[@id='months']")));
		months.selectByValue("6");
		
		Select years = new Select(driver.findElement(By.id("years")));
		years.selectByIndex(29);
		
		// 13) Hacer clic en el checkbox
		driver.findElement(By.cssSelector("#newsletter")).click();
		
		// 14) Hacer clic en 'Register'
		driver.findElement(By.id("submitAccount")).click();
	}
}
