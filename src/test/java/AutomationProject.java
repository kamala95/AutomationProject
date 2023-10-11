import com.github.javafaker.Faker;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;


public class AutomationProject {
    public static void main(String[] args) throws InterruptedException {
        WebDriver driver = new ChromeDriver();

        // Navigate to http://duotify.us-east-2.elasticbeanstalk.com/register.php
        driver.navigate().to("http://duotify.us-east-2.elasticbeanstalk.com/register.php");
        Thread.sleep(1000);

        // Verify that the title is "Welcome to Duotify!" (Use Assert class methods for all assertions)
        Assert.assertEquals(driver.getTitle(),"Welcome to Duotify!");
        Thread.sleep(1000);

        // Click on Signup here
        driver.findElement(By.id("hideLogin")).click();

        //Fill out the form with the required info
        Faker faker = new Faker();

        String firstName = faker.name().firstName();
        String lastName = faker.name().lastName();
        String email = faker.internet().emailAddress();
        String password = faker.internet().password();

        driver.findElement(By.id("username")).sendKeys(firstName + lastName);
        Thread.sleep(1000);
        driver.findElement(By.id("firstName")).sendKeys(firstName);
        Thread.sleep(1000);
        driver.findElement(By.id("lastName")).sendKeys(lastName);
        Thread.sleep(1000);
        driver.findElement(By.id("email")).sendKeys(email);
        Thread.sleep(1000);
        driver.findElement(By.id("email2")).sendKeys(email);
        Thread.sleep(1000);
        driver.findElement(By.id("password")).sendKeys(password);
        Thread.sleep(1000);
        driver.findElement(By.id("password2")).sendKeys(password);
        Thread.sleep(1000);

        // Click on Sign up
        driver.findElement(By.name("registerButton")).sendKeys(Keys.ENTER);

        //  Once logged in to the application, verify that the URL is: http://duotify.us-east-2.elasticbeanstalk.com/browse.php?
        Assert.assertEquals(driver.getCurrentUrl(), "http://duotify.us-east-2.elasticbeanstalk.com/browse.php?");

        //In the left navigation bar, verify that your first and last name matches the first and last name that you used when signing up.
        WebElement nameFirstAndLast = driver.findElement(By.id("nameFirstAndLast"));
        Thread.sleep(1000);
        Assert.assertEquals(nameFirstAndLast.getText(),firstName + " " + lastName);
        Thread.sleep(1000);

        // Click on the username on the left navigation bar and verify the username on the main window is correct and then click logout.
        nameFirstAndLast.click();
        Thread.sleep(1000);
        WebElement nameFirstAndLast2 = driver.findElement(By.className("userInfo"));
        Assert.assertEquals(nameFirstAndLast2.getText(), firstName + " " + lastName);
        Thread.sleep(1000);
        driver.findElement(By.id("rafael")).click();
        Thread.sleep(1000);

       // Verify that you are logged out by verifying the URL is: http://duotify.us-east-2.elasticbeanstalk.com/register.php
        Assert.assertEquals(driver.getCurrentUrl(), "http://duotify.us-east-2.elasticbeanstalk.com/register.php");

        //Login using the same username and password when you signed up.
        driver.findElement(By.id("loginUsername")).sendKeys(firstName + lastName);
        Thread.sleep(1000);
        driver.findElement(By.id("loginPassword")).sendKeys(password);
        Thread.sleep(1000);
         driver.findElement(By.name("loginButton")).sendKeys(Keys.ENTER);
         Thread.sleep(1000);

         // Verify successful login by verifying that the home page contains the text "You Might Also Like".
         WebElement homePageText = driver.findElement(By.id("mainContent"));
         Assert.assertTrue(homePageText.getText().trim().contains("You Might Also Like"));
         Thread.sleep(1000);

         // Log out once again and verify that you are logged out.
         WebElement nameFirstAndLast3 = driver.findElement(By.id("nameFirstAndLast"));
         Thread.sleep(1000);
         nameFirstAndLast3.click();
         Thread.sleep(1000);
         driver.findElement(By.id("rafael")).sendKeys(Keys.ENTER);
         Thread.sleep(1000);
         Assert.assertEquals(driver.getCurrentUrl(), "http://duotify.us-east-2.elasticbeanstalk.com/register.php");



        driver.quit();



    }
}


