import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class LitifyTest extends Common {

    // Google URL and XPath
    String url = "http://www.google.com/";
    By googleSearch = By.xpath("//input[@title='Search']");
    By googleSearchButton = By.xpath("/descendant::input[@value='Google Search'][1]");

    // Litify XPath
    By litifyLink = By.xpath("/descendant::a[@href='https://www.litify.com/'][1]");
    By litifyHamburgerMenu = By.xpath("//i[contains(@class, 'icon-menu')]");
    By litifyAboutUs = By.xpath("//a[text() = 'About Litify']");
    By litifyOurStory = By.xpath("//li/a[text() = 'Our Story']");
    //  Our Page Title
    String ourTitleValue = "Our Story - Litify - Salesforce.com For Legal";


    @BeforeClass
    public void navigateToGoogle() {
        navigate(url);
    }

    @Test
    public void ValidateOurStoryPageFromGoogleSearch() throws InterruptedException {
        driver.findElement(googleSearch).sendKeys("Litify");
        threadWait();

        driver.findElement(googleSearchButton).click();
        threadWait();

        driver.findElement(litifyLink).click();

        driver.findElement(litifyHamburgerMenu).click();
        threadWait();

        driver.findElement(litifyAboutUs).click();
        driver.findElement(litifyOurStory).click();

        // Validate User is in the Our Page using title
        Assert.assertEquals(ourTitleValue, getTitleValue());
    }

    @AfterClass
    public void CloseBrowserSession() {
        closeBrowserSession();
    }
}
