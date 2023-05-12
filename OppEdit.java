package oppourtunity.salesforce;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

public class OppEdit {

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
        WebElement k = driver.findElement(By.xpath("(//input[@type='search'])[2]"));
        k.sendKeys("Salesforce Automation by Iswarya");
        k.sendKeys(Keys.ENTER);
        Thread.sleep(3000);
        driver.findElement(By.xpath("(//div[@class='forceVirtualActionMarker forceVirtualAction'])[1]")).click();
        WebElement s = driver.findElement(By.xpath("//div[text()='Edit']"));
        driver.executeScript("arguments[0].click();", s);    
        WebElement drop = driver.findElement(By.xpath("(//input[contains(@type,'text')])[3]"));
        drop.clear();
        drop.sendKeys("8/5/2023");
        WebElement drop1 = driver.findElement(By.xpath("(//div[contains(@class,'slds-combobox slds-dropdown-trigger slds-dropdown-trigger_click')])[3]"));
        driver.executeScript("arguments[0].click();", drop1);
        driver.findElement(By.xpath("//span[@title='Perception Analysis']")).click();
        WebElement drop2 = driver.findElement(By.xpath("(//div[contains(@class,'slds-combobox slds-dropdown-trigger slds-dropdown-trigger_click')])[6]"));
        driver.executeScript("arguments[0].click();", drop2);
        driver.findElement(By.xpath("//span[@title='In progress']")).click();
        WebElement d = driver.findElement(By.xpath("//textarea[contains(@class,'slds-textarea')]"));
        //driver.executeScript("arguments[0].click();", d);
        d.clear();
        d.sendKeys("SalesForce");
        driver.findElement(By.xpath("//button[text()='Save']")).click();
        boolean result = driver.findElement(By.xpath("//span[@title='Perception Analysis']")).isDisplayed();
        String actual_Result=driver.findElement(By.xpath("//div[@class='toastContent slds-notify__content']")).getText();
        String  expected_Result= "Opportunity \"Salesforce Automation by Iswarya\" was saved.";
        Assert.assertEquals(actual_Result,expected_Result);
       

       

	}

}
