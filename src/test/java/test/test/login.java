package test.test;

import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

public class login {
@Test
	public static void main(String[] args) throws InterruptedException {
		System.setProperty("Webdriver.driver", "C:\\Users\\kiran\\Downloads\\chromedriver-win64 (1)\\chromedriver.exe");
		ChromeDriver driver=new ChromeDriver();
		driver.navigate().to("https://timessouthnov0623.mediology.in/wp-admin/");
		driver.manage().window().maximize();
		driver.findElement(By.id("user_login")).sendKeys("mediology");
		driver.findElement(By.id("user_pass")).sendKeys("default@123");
		driver.findElement(By.id("wp-submit")).click();
		driver.findElement(By.id("menu-posts")).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("//div[@id='wpwrap']/div[@id='adminmenumain']/div[@id='adminmenuwrap']/ul[@id='adminmenu']/li[@id='menu-posts']/ul[1]/li[4]/a[1]")).click();
		driver.findElement(By.id("tag-name")).sendKeys("automationcat");
		driver.findElement(By.id("tag-slug")).sendKeys("automationcatslug");
		driver.findElement(By.id("tag-description")).sendKeys("description for tags");
		Thread.sleep(3000);
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0,300);");
Thread.sleep(3000);
		driver.findElement(By.xpath("(//input[@value='Add New Category'])[1]")).click();
		JavascriptExecutor j2s = (JavascriptExecutor) driver;
		j2s.executeScript("window.scrollBy(0,1700);");
		driver.findElement(By.cssSelector("a[class='wp-has-submenu wp-not-current-submenu menu-top toplevel_page_sortd-settings menu-top-last'] div[class='wp-menu-name']")).click();
		JavascriptExecutor j3s = (JavascriptExecutor) driver;
		j3s.executeScript("window.scrollBy(0,1700);");
		Thread.sleep(3000);
		driver.findElement(By.xpath("//a[@href='admin.php?page=sortd-manage-settings']")).click();
		Thread.sleep(3000);
		driver.findElement(By.xpath("//div[@id='wpbody-content']/div[5]/div[2]/div[1]/div[2]/div[2]/div[1]/span[1]/a[1]/i[1]")).click();
		Thread.sleep(3000);
		driver.findElement(By.xpath("//tbody/tr[@id='tr-19716']/td[2]")).click();
		
		((JavascriptExecutor) driver).executeScript("window.open();");
	        Set<String> windowHandles = driver.getWindowHandles();

	        // Check if more than one window handle is available
	        if (windowHandles.size() > 1) {
	            // Switch to the new tab (index 1)
	            driver.switchTo().window((String) windowHandles.toArray()[1]);

	            // Example: Navigate to another URL in the new tab
	            driver.get("https://10juneproject-mediology-in.demo.sortd.mobi");

	            // Example: Close the new tab (switch back to the first tab)
	            driver.close();
	            driver.switchTo().window((String) windowHandles.toArray()[0]);
	        } else {
	            System.out.println("Unable to open new tab. Only one window handle available.");
	        }
	}

}
