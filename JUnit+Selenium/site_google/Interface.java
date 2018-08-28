package site_google;

import static org.junit.Assert.assertEquals;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.DesiredCapabilities;

public class Interface {
	public static WebDriver driver;
	public static String site = "https://www.google.com.br/"; 
	
	@BeforeClass
	public static void executaAntes() {
		// Setting System path
		System.setProperty("webdriver.gecko.driver","C:\\Users\\artur\\eclipse\\geckodriver.exe");
		
		// Setting some abilities to the gecko driver
		DesiredCapabilities capabilities = DesiredCapabilities.firefox();
		capabilities.setCapability("marionette", true);
		
		// Create a new instance of the Firefox driver
		driver = new FirefoxDriver();
		
        //Launch the Online Store Website
		//driver.get(site);
 
	}
	
	@AfterClass
	public static  void executaDepois() {
		driver.quit();
	}
	
	@Test
	public void testePesquisaUFS() {
		driver.get(site);
		WebElement inputPesquisa = driver.findElement(By.id("lst-ib"));
		inputPesquisa.sendKeys("UFS");
		driver.findElement(By.name("btnK")).click();
		
		assertEquals("UFS - Pesquisa Google", driver.getTitle());
		
	}
	
	@Test
	public void testePesquisaUFPE() {
		driver.get(site);
		WebElement inputPesquisa = driver.findElement(By.id("lst-ib"));
		inputPesquisa.sendKeys("UFPE");
		driver.findElement(By.name("btnK")).click();
		
		assertEquals("UFPE - Pesquisa Google", driver.getTitle());
		
	}
	
	@Test
	public void testePesquisaUFBA() {
		driver.get(site);
		WebElement inputPesquisa = driver.findElement(By.id("lst-ib"));
		inputPesquisa.sendKeys("UFBA");
		driver.findElement(By.name("btnK")).click();
		
		assertEquals("UFBA - Pesquisa Google", driver.getTitle());
		
	}
	
	@Test
	public void testePesquisaUFAL() {
		driver.get(site);
		WebElement inputPesquisa = driver.findElement(By.id("lst-ib"));
		inputPesquisa.sendKeys("UFAL");
		driver.findElement(By.name("btnK")).click();
		
		assertEquals("UFAL - Pesquisa Google", driver.getTitle());
		
	}
	
	@Test
	public void testePesquisaUFC() {
		driver.get(site);
		WebElement inputPesquisa = driver.findElement(By.id("lst-ib"));
		inputPesquisa.sendKeys("UFC");
		driver.findElement(By.name("btnK")).click();
		
		assertEquals("UFC - Pesquisa Google", driver.getTitle());
		
	}

}
