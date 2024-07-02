package test.test;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.Test;

public class Login {
    @Test
    public static void main(String[] args) throws InterruptedException {
    	System.setProperty("Webdriver.driver", "C:\\Users\\kiran\\Downloads\\chromedriver-win64 (1)\\chromedriver.exe");

        ChromeOptions options = new ChromeOptions();
        ChromeDriver driver = new ChromeDriver(options);

        // Navigate to the URL
        driver.navigate().to("https://timessouthnov0623.mediology.in/wp-admin/");
        driver.manage().window().maximize();

        // Log in
        driver.findElement(By.id("user_login")).sendKeys("mediology");
        driver.findElement(By.id("user_pass")).sendKeys("default@123");
        driver.findElement(By.id("wp-submit")).click();

        // Navigate and perform actions
        driver.findElement(By.id("menu-posts")).click();
        Thread.sleep(2000);
        driver.findElement(By.xpath("//div[@id='wpwrap']/div[@id='adminmenumain']/div[@id='adminmenuwrap']/ul[@id='adminmenu']/li[@id='menu-posts']/ul[1]/li[4]/a[1]")).click();
        driver.findElement(By.id("tag-name")).sendKeys("automationcat");
        driver.findElement(By.id("tag-slug")).sendKeys("automationcatslug");
        driver.findElement(By.id("tag-description")).sendKeys("description for tags");
        Thread.sleep(3000);

        // Scroll and add category
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollBy(0,300);");
        Thread.sleep(3000);
        driver.findElement(By.xpath("(//input[@value='Add New Category'])[1]")).click();
        js.executeScript("window.scrollBy(0,1700);");
        driver.findElement(By.cssSelector("a[class='wp-has-submenu wp-not-current-submenu menu-top toplevel_page_sortd-settings menu-top-last'] div[class='wp-menu-name']")).click();
        js.executeScript("window.scrollBy(0,1700);");
        Thread.sleep(3000);
        driver.findElement(By.xpath("//a[@href='admin.php?page=sortd-manage-settings']")).click();
        Thread.sleep(3000);
        js.executeScript("window.scrollBy(0,1700);");
        driver.findElement(By.xpath("//div[@id='wpbody-content']/div[5]/div[2]/div[1]/div[2]/div[2]/div[1]/span[1]/a[1]/i[1]")).click();
        Thread.sleep(3000);
        js.executeScript("window.scrollBy(0,400);");

        // Open a new tab
        ((JavascriptExecutor) driver).executeScript("window.open();");
        Set<String> windowHandles = driver.getWindowHandles();

        // Check if more than one window handle is available
        if (windowHandles.size() > 1) {
            // Switch to the new tab (index 1)
            driver.switchTo().window((String) windowHandles.toArray()[1]);

            // Set up mobile emulation
            Map<String, String> mobileEmulation = new HashMap<>();
            mobileEmulation.put("deviceName", "Pixel 2");
            options.setExperimentalOption("mobileEmulation", mobileEmulation);
            
            // Open browser in mobile mode
            ChromeDriver mobileDriver = new ChromeDriver(options);
            mobileDriver.navigate().to("https://10juneproject-mediology-in.demo.sortd.mobi");

            // Switch back to the original window
            driver.switchTo().window((String) windowHandles.toArray()[0]);
        } else {
            System.out.println("Unable to open new tab. Only one window handle available.");
        }

        // Close the browser
        driver.quit();
    }
}
