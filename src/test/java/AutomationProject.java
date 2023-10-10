import com.github.javafaker.Faker;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;


public class AutomationProject {
    public static void main(String[] args) throws InterruptedException {
        WebDriver driver = new ChromeDriver();
        driver.navigate().to("http://duotify.us-east-2.elasticbeanstalk.com/register.php");
        Thread.sleep(2000);
        Assert.assertEquals(driver.getTitle(),"Welcome to Duotify!");
        Thread.sleep(2000);
        driver.findElement(By.id("hideLogin")).click();

        Faker faker = new Faker();
        System.out.println(faker.name().username());
        System.out.println(faker.name());
        System.out.println(faker.);




    }
}


