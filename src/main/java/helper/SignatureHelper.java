package helper;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.time.Duration;

public class SignatureHelper {
    WebDriver driver;

    @FindBy(xpath = "//span[normalize-space()='Sign']") WebElement sign;
    @FindBy(xpath = "//span[normalize-space()='Submit']") WebElement Submit;
//    @FindBy(xpath = "//canvas[@style='touch-action: none;']") WebElement portfolioId;
    @FindBy(xpath = "//div[@role='region']//div//canvas") WebElement portfolioId;

    public SignatureHelper(WebDriver driver)
    {
        this.driver=driver;
        PageFactory.initElements(driver, this);

    }
    public void SignatureHelperClass() throws InterruptedException
    {
        sign.click();
        Thread.sleep(3000);
        Actions actions=new Actions(driver);
        actions.dragAndDropBy(portfolioId, 200, 100).build().perform();
        actions.dragAndDropBy(portfolioId, 350, 200).build().perform();
        Thread.sleep(7000);
        Submit.click();
    }
}
