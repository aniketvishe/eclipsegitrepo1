package sauce.demo;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

 class Sauce {

    public static void main(String[] args) throws InterruptedException {
       
        System.setProperty("webdriver.chrome.driver",  "D:\\SANDBOX\\chromedriver-win64\\chromedriver.exe");

        
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--start-maximized"); 

        // Start ChromeDriver with ChromeOptions
        WebDriver positivedriver = new ChromeDriver(options);

        // Positive scenario
        positivedriver.get("https://www.saucedemo.com");
        login(positivedriver, "standard_user", "secret_sauce");
       // System.out.println("Positive Scenario: " + positivedriver.getCurrentUrl());
        
        Thread.sleep(9000);

        // Open a new Chrome 
        WebDriver negativeScenarioDriver = new ChromeDriver(options);
        negativeScenarioDriver.get("https://www.saucedemo.com");

        // Negative scenario
        login(negativeScenarioDriver, "vikul", "golang");
        //System.out.println("Negative Scenario: " + negativeScenarioDriver.getCurrentUrl());

        
    }

    private static void login(WebDriver driver, String username, String password) {
        WebElement usernameField = driver.findElement(By.id("user-name"));
        WebElement passwordField = driver.findElement(By.id("password"));
        WebElement loginButton = driver.findElement(By.id("login-button"));

        usernameField.sendKeys(username);
        passwordField.sendKeys(password);
        loginButton.click();
    }
}
