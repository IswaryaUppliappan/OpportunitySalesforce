package oppourtunity.salesforce;

import java.time.Duration;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

import io.github.bonigarcia.wdm.WebDriverManager;

public class OppCreate {

	public static void main(String[] args) throws InterruptedException  {
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
        driver.findElement(By.xpath("//div[text()='New']")).click();
        WebElement p = driver.findElement(By.xpath("(//input[contains(@type,'text')])[3]"));
        p.sendKeys("Salesforce Automation by Iswarya");
        String s=p.getText();
        WebElement c = driver.findElement(By.xpath("(//input[contains(@type,'text')])[2]"));
        c.sendKeys("4/5/2023");
        WebElement drop = driver.findElement(By.xpath("(//div[contains(@class,'slds-combobox slds-dropdown-trigger slds-dropdown-trigger_click')])[2]"));
        driver.executeScript("arguments[0].click();", drop);
        driver.findElement(By.xpath("//span[@title='Needs Analysis']")).click();
        driver.findElement(By.xpath("//button[text()='Save']")).click();
        String actual_Result=driver.findElement(By.xpath("//a[@title='Salesforce Automation by Iswarya']")).getText();
        String  expected_Result= "Salesforce Automation by Iswarya";
        Assert.assertEquals(actual_Result,expected_Result);
        //driver.close();       
	}
}