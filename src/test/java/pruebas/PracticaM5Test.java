package pruebas;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;
import paginas.PaginaInicio;
import paginas.PaginaLogin;
import utilities.DatosExcel;

public class PracticaM5Test {
	String url = "http://www.automationpractice.pl/";
	WebDriver driver;
	String directorioDatos = "..\\EducacionIT-74158\\Datos\\";
	String nombreArchivo = "Datos_Login.xlsx";
	String nombreHoja = "Hoja1";
	
	@BeforeSuite
	public void setUp() {
		WebDriverManager.chromedriver().setup();
		
		/* Configuraciones sobre el navegador */
		/*ChromeOptions options = new ChromeOptions();
		options.addArguments("incognito");
		
		driver = new ChromeDriver(options);*/
		
		driver = new ChromeDriver();
		driver.get(url);
		driver.manage().window().maximize();
	}
	
	@Test(dataProvider="Datos Login Excel")
	public void login(String email, String password) {
		PaginaInicio inicio = new PaginaInicio(driver);
		inicio.hacerClicEnSignIn();
		
		PaginaLogin login = new PaginaLogin(driver);
		login.escribirCorreo(email);
		login.escribirPassword(password);
		login.hacerClicEnLogin();
	}
	
	@DataProvider(name="Datos Login Excel")
	public Object[][] obtenerDatosExcel() throws Exception {
		return DatosExcel.leerExcel(directorioDatos + nombreArchivo, nombreHoja);
	}
	
	@DataProvider(name="Datos Login")
	public Object[][] obtenerDatos() {
		Object[][] datos = new Object[3][2];
		
		datos[0][0] = "correoabc@gmail.com";
		datos[0][1] = "2qeq2eq";
		
		datos[1][0] = "correodef@gmail.com";
		datos[1][1] = "4et43r54we";
		
		datos[2][0] = "correoghi@gmail.com";
		datos[2][1] = "33w4t445";
		
		return datos;
	}
	
	
	
	
	
	
	
	@AfterSuite
	public void tearDown() {
		//driver.close();
	}
}
