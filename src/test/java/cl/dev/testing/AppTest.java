package cl.dev.testing;

import cl.dev.testing.config.LogListener;
import junit.framework.TestCase;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.annotations.*;

public class AppTest extends TestCase {
	private static final Logger LOGGER = LoggerFactory.getLogger(LogListener.class);
	private static final String WEB_URL = "https://empresas.becl.presentation.veritran.cloud/IB/presentation/BLCK/index.htm";

	private static WebDriver driver;
	static By userNameEmpresa = By.id("txtRutEmpresa");
	static By userNameUsuario = By.id("txtRutUsuario");
	static By password = By.id("pswClave");
	static By btnIngresar = By.id("btnIngresar");

	static By cellBlack = By.id("5030833");
	static By cLCCC = By.id("100338");

	@BeforeTest
	public void setupTest() throws InterruptedException {
		driver = new ChromeDriver();
		driver.navigate().to(WEB_URL);
		Thread.sleep(8000);
	}

	@Test(testName = "Test: Ingreso a la Página")
	public void firstTest() throws InterruptedException {
		String title = driver.getTitle();
		LOGGER.info("title => " + title);
		Assert.assertEquals(title, title, "Banco Estado");
		// Thread.sleep(8000);
		driver.manage().window().maximize();

	}

	@Test(testName = "Test: Login")
	public static void login() throws InterruptedException {
		String titleBI = driver.getTitle();
		driver.findElement(userNameEmpresa).sendKeys("965579109");
		driver.findElement(userNameUsuario).sendKeys("105588569");
		driver.findElement(password).sendKeys("kib2012");
		driver.findElement(btnIngresar).click();
		Thread.sleep(20000);

		Assert.assertEquals(titleBI, titleBI, "btnIngresar");

	}

	@Test(testName = "Test: Menu Vertical")
	public static void menuVertical() throws InterruptedException {
		String texto1 = "Cartola en Línea de Línea de Crédito de Cuenta Corriente";
		// String texto2 = "Cartola Historica de Línea de Crédito de Chequera
		// Electronica";
		driver.findElement(cellBlack).click();
		Thread.sleep(2000);
		driver.findElement(cLCCC).click();
		Assert.assertEquals(texto1, texto1, "Cartola en Línea de Línea de Crédito de Cuenta Corriente");
		Thread.sleep(20000);

	}
	
	
	@Test(testName = "Test: Titulo")
	public static void verTitulo() {
		WebElement titulo = (driver.findElement(By.xpath("//*[@id=\"1422119\"]")));
			if(titulo.equals("//*[@id=\"1422119\"]")) {
				Assert.assertEquals("Cartola en Línea - Línea de Crédito Cuenta Corriente,  EXISTE !!!", titulo);
			}else {
				System.out.println("Titulo no existe, NO existe");
			}
		
	}

	@Test(testName = "Test: Buscar Linea")
	public static void buscarLinea() {
		String titleBuscarLinea = driver.getPageSource();
		if (titleBuscarLinea.equals("Buscar Línea")) {
			Assert.assertEquals(titleBuscarLinea, "Buscar Línea");
		} else {
			System.out.println("Buscar Línea, NO existe");
		}

	}

	@Test(testName = "Test: Selecione Linea")
	public static void selecioneLinea() {
		String titleSeleccioneLinea = driver.getPageSource();
		if (titleSeleccioneLinea.equals("Selecione Línea*")) {
			Assert.assertEquals(titleSeleccioneLinea, "Selecione Línea*");
		} else {
			System.out.println("Selecione Línea, NO existe");
		}

	}

	@Test(testName = "Ingreso Numero Linea")
	public static void ingresoNumeroLinea() {
		String titleIngresoNumeroLinea = driver.getPageSource();
		if (titleIngresoNumeroLinea.contentEquals("Ingrese Número de Línea")) {
			Assert.assertEquals(titleIngresoNumeroLinea, "Ingrese Número de Línea");
		} else {
			System.out.println("Ingrese Número de Línea, NO existe");
		}

	}

//    @AfterMethod
//    public void teardownTest (){
//        driver.quit();
//    }

}
