package helper;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import pageObject.BasePage;

public class DropDown extends BasePage {
    WebDriver driver;

    By DropDownArrow = By.xpath("//div[starts-with(@class,'mat-select-arrow ng')]");
    By list = By.xpath("//div[@role='listbox']/mat-option/span");
    public void Enter_Drop_down(String value) throws InterruptedException {
        click(DropDownArrow);
        Thread.sleep(2000);
        int count = getEl(list).size();
        WebElement option = driver.findElement(By.xpath("//mat-option[@role='option']/span[normalize-space(text()) = '"+value+"']"));
        System.out.println("Total items present in the dropdown : "+count);
        option.click();
    }
}
