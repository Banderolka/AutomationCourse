package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class MainPage extends BasePage {

    @FindBy(xpath = "//div[@class=\"kitt-content\"]//ul[contains(@class,\"icons kitt-top-menu__list_center\")]")
    WebElement menuItems;

    @FindBy(xpath = "//li[@class=\"kitt-top-menu__item kitt-top-menu__item_first kitt-top-menu__item_opened\"]//div[@class=\"kitt-top-menu__dropdown kitt-top-menu__dropdown_icons\"]")
    WebElement menuInsurance;

    public MainPage(WebDriver driver){
        PageFactory.initElements(driver, this);
    }

    public void selectMenuItems(String itemName){
        menuItems.findElement(By.xpath(".//a[@aria-label='" + itemName + "']")).click();
    }

    public void selectMenuInsurance(String itemName){
        menuInsurance.findElement(By.xpath(".//a[contains(@data-cga_click_top_menu,'" + itemName +"')]")).click();
    }



}
