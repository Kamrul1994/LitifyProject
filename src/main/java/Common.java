import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

public class Common {
    public WebDriver driver;

    // Initialize driver
    public WebDriver getDriver(String OS, String browserName){
        if(browserName.equalsIgnoreCase("chrome")){
            if(OS.equalsIgnoreCase("Mac")){
                System.setProperty("webdriver.chrome.driver", "Drivers/chromedriver");
            }else if(OS.equalsIgnoreCase("Windows")){
                System.setProperty("webdriver.chrome.driver", "../Drivers/chromedriver.exe");
            }
            driver = new ChromeDriver();
        }
        // return driver - for future uses if needed
        return driver;
    }

    public void clickButton(String element){
        driver.findElement(By.xpath(element)).click();
    }

    // Send keys to element
    public void enterTextKey(String element, String value){
        driver.findElement(By.xpath(element)).sendKeys(value
        );
    }

    public String getTextFromElement(String element) {
        return driver.findElement(By.xpath(element)).getText();
    }

    // Clear column from field
    public void clearTextField(String element) {
        try {
            driver.findElement(By.xpath(element)).isDisplayed();
        } catch (Exception e) {
            System.out.println("Element Not Found!");
        }
        driver.findElement(By.xpath(element)).clear();
    }

    // Method used to wait for element
    public boolean isElementVisible(String element) {
        if (!driver.findElement(By.xpath(element)).isDisplayed()) {
            driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
            return driver.findElement(By.xpath(element)).isDisplayed();
        }else
            return true;
    }

    // Call to teardown of the session
    public void closeBrowserSession() {
        driver.quit();
    }

    // Navigate to URL after initializing and configuring the environment - USING: MAC
    public void navigate(String url) {
        getDriver("Mac", "chrome").navigate().to(url);
    }

    // Sleep to let the page load
    public void threadWait() throws InterruptedException {
        Thread.sleep(2000);
    }

    // Get the title of the current page
    public String getTitleValue() {
        return driver.getTitle();
    }

}