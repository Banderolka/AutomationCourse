package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class InsurancePage extends BasePage {
    @FindBy(xpath = "//div[@class='product-catalog__section product-catalog__gradient-right kitt-grid kitt-grid_fixed kitt-padding_bottom_extra ']")
        WebElement lineInsurance;

    public InsurancePage(WebDriver driver){
        PageFactory.initElements(driver, this);
    }

    public void selectTravelInsurance(String itemName){
    lineInsurance.findElement(By.xpath(".//*[contains(text(), '" + itemName +"')]")).click();
    }

}
