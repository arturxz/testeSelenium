package teste;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class TesteUm {
	
	public static void main(String[] args) throws InterruptedException {
		// Setting System path
		System.setProperty("webdriver.gecko.driver","C:\\Users\\artur\\eclipse\\geckodriver.exe");
		
		// Create a new instance of the Firefox driver
		WebDriver driver = new FirefoxDriver();
		
        //Launch the Online Store Website
		driver.get("https://www.commulheres.com/");
 
        // Print a Log In message to the screen
        System.out.println("Successfully opened the website www.Store.Demoqa.com");
 
		//Wait for 5 Sec
		Thread.sleep(5000);
		
        // Close the driver
        driver.quit();
	}
}
