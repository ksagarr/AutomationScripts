package Search_Automation.script;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class MavenSearchAutomation {
	
	public static void searchScript() {
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.get("https://www.myntra.com/");
		driver.findElement(By.className("desktop-searchBar")).sendKeys("tshirt");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		List<WebElement> list=driver.findElements(By.xpath("//div[@ class=\" desktop-autoSuggest desktop-showContent\"]/ul/li"));
		list.stream().filter(ls -> ls.getText().equals("Tshirt Cotton") ).findFirst()
		.ifPresent(ls -> ls.click());
		}

	public static void main(String[] args) {
	
		searchScript();
		 
	}

}
