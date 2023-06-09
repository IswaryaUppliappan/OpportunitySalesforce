package oppourtunity.salesforce;

import java.time.Duration;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

public class OppSort {

	public static void main(String[] args) throws InterruptedException {
		ChromeOptions option = new ChromeOptions();
		option.addArguments("--disable-notifications");
		ChromeDriver driver = new ChromeDriver(option);
		driver.manage().window().maximize();
		driver.get("https://login.salesforce.com/");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		driver.findElement(By.id("username")).sendKeys("hari.radhakrishnan@qeagle.com");
		driver.findElement(By.id("password")).sendKeys("Leaf@1234");
		driver.findElement(By.id("Login")).click();
		driver.findElement(By.xpath("//div[contains(@class,'slds-icon-waffle')]")).click();
		driver.findElement(By.xpath("//button[text()='View All']")).click();
        driver.findElement(By.xpath("//p[text()='Sales']")).click();
        WebElement opp=driver.findElement(By.xpath("(//span[text()='Opportunities'])[1]"));
        driver.executeScript("arguments[0].click();", opp);
        WebElement s = driver.findElement(By.xpath("//div[@class='test-listviewdisplayswitcher forceListViewManagerDisplaySwitcher']"));
        s.click();
        WebElement t = driver.findElement(By.xpath("//span[text()='Display as Table']"));
        driver.executeScript("arguments[0].click();", t);
        WebElement k = driver.findElement(By.xpath("(//a[@class='toggle slds-th__action slds-text-link--reset '])[5]"));
        k.click();
        Thread.sleep(3000);
        WebElement a = driver.findElement(By.xpath("(//a[@class='toggle slds-th__action slds-text-link--reset '])[5]"));
        a.click();
        String actual_Result=driver.findElement(By.xpath("//span[@class='countSortedByFilteredBy']")).getText();
		String expected_Result="14 items � Sorted by Close Date �";
		Assert.assertEquals(actual_Result,expected_Result);
		}
        

	}

