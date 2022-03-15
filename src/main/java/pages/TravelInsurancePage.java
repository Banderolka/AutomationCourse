package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class TravelInsurancePage extends BasePage {
    @FindBy(xpath = "//div[contains(@class, 'page-teaser-dict kitt-padding kitt-padding_bottom_extra kitt-padding_top_extra')]")
    WebElement teaser;


    @FindBy(xpath = "//div[contains(@data-pid, 'ColumnsContainer-4899217')]")
    WebElement registration;

    public TravelInsurancePage(WebDriver driver){
        PageFactory.initElements(driver, this);
    }

    public void selectApplyOnlineButton(String itemName){
    teaser.findElement(By.id(".//span[contains(text(),'" + itemName + "')]")).click();
    }

    public void selectApplySiteButton(String itemName){
        registration.findElement(By.id(".//span[contains(text(),'" + itemName + "')]")).click();
    }

}