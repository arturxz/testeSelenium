package site_com_mulheres;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

import org.junit.After;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.DesiredCapabilities;

public class Interface {
	
	public static WebDriver driver;
	public static String site = "https://www.commulheres.com/"; 
	
	@Before
	public void executaAntes() {
		// Setting System path
		System.setProperty("webdriver.gecko.driver","C:\\Users\\pc\\Downloads\\geckodriver.exe");
		//System.setProperty("webdriver.chrome.driver","C:\\Users\\artur\\eclipse\\chromedriver.exe");
		
		// Setting some abilities to the gecko driver
		DesiredCapabilities capabilities = DesiredCapabilities.firefox();
		capabilities.setCapability("marionette", true);
		
		// Create a new instance of the Firefox driver
		driver = new FirefoxDriver();
		//driver = new ChromeDriver();
        //Launch the Online Store Website
		driver.get(site);
 
	}
	
	@After
	public void executaDepois() {
		driver.quit();
	}
	
	// TESTES DA PAGINA PRINCIPAL	
	@Test
	public void testeTituloPaginaPrincipal() {
		assertEquals("COM� Mulheres", driver.getTitle());
	}

	// TESTES DOS BOT�ES DA BARRA DE NAVEGACAO
	@Test
	public void testeBotaoEventosNav() {
		driver.findElement(By.xpath(".//a[@href='/eventos']")).click();
		assertEquals(site+"eventos", driver.getCurrentUrl());
	}

	@Test
	public void testeBotaoSobreNav() {
		driver.findElement(By.xpath(".//a[@href='/sobre']")).click();
		assertEquals(site+"sobre", driver.getCurrentUrl());
	}
	
	@Test
	public void testeBotaoContatoNav() {
		driver.findElement(By.xpath(".//a[@href='/contato']")).click();
		assertEquals(site+"contato", driver.getCurrentUrl());
	}
	
	// TESTES DOS BOTOES DO CORPO DA PAGINA PRINCIPAL
	@Test
	public void testeBotaoNosConheca() {
		driver.findElement( By.id("button-component").xpath(".//a[@href='/sobre']") ).click();
		assertEquals(site+"sobre", driver.getCurrentUrl());
	}
	
	@Test
	public void testeBotaoEntreEmContato() {
		driver.findElement( By.id("button-component").xpath(".//a[@href='/contato']") ).click();
		assertEquals(site+"contato", driver.getCurrentUrl());
	}
	
	//TESTE DE REFRESH
	@Test
	public void testeRefreshContato() {
		driver.findElement(By.xpath(".//a[@href='/contato']")).click();
		driver.navigate().refresh();
		assertEquals(site+"contato", driver.getCurrentUrl());
	}

	//TESTE DE INPUT
	@Test
	public void testeInputContato() {
		driver.findElement(By.xpath(".//a[@href='/contato']")).click();
		WebElement inputNome = driver.findElement(By.id("name"));
		inputNome.sendKeys("Jusley");
		
		WebElement inputEmail = driver.findElement(By.id("email"));
		inputEmail.sendKeys("jusleyarley@gmail.com");
		
		WebElement inputAssunto = driver.findElement(By.id("subject"));
		inputAssunto.sendKeys("Testando");
		
		WebElement inputMensagem = driver.findElement(By.id("message"));
		inputMensagem.sendKeys("Testando");
		
		driver.findElement(By.id("button-component")).submit();
		
		assertEquals("Efetue a verifica��o do rob�.", driver.findElement( By.xpath(".//p[@class='answer']") ).getText() );
	}

	
}

