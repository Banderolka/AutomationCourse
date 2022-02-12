import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.ArrayList;
import java.util.concurrent.TimeUnit;

import static junit.framework.TestCase.assertEquals;


public class InsuranceTest {
    WebDriver driver;
    String baseUrl;


    @Before
    public void beforeTest(){
        System.setProperty("webdriver.chrome.driver", "drv/chromedriver.exe");
        baseUrl = "http://www.sberbank.ru/ru/person";
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        driver.manage().window(). maximize();
        driver.get(baseUrl);
        driver.findElement(By.xpath("//*[@id=\"main-page\"]/div[4]/div/div/div/button")).click();
    }

    @Test
    public void testInsurance(){
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        driver.findElement(By.xpath("//a[@aria-label=\"Страхование\"]")).click();
        driver.findElement(By.xpath("//a[@data-cga_click_top_menu=\"Страхование_Все страховые программы_type_important\"]")).click();
        driver.findElement(By.xpath("//a[contains(@class, \"product-catalog__cardlink\")]//*[contains(text(), \"Страхование путешественников\")]")).click();

        WebElement title = driver.findElement(By.xpath("//h1[contains(text(), \"Страхование путешественников\")]"));
        Assert.assertEquals("Страхование путешественников", title.getText());

        driver.findElement(By.xpath("//a//*[contains(text(), \"Оформить онлайн\")]")).click();
        driver.findElement(By.xpath("//a//*[contains(text(), \"Оформить на сайте\")]")).click();

        ArrayList<String> tabs = new ArrayList<String>(driver.getWindowHandles());
        driver.switchTo().window(tabs.get(1));




        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);

        driver.manage().window(). maximize();
        driver.findElement(By.xpath("//*[contains(text(), \"Оформить\")]")).click();

        fildFaild(By.id("surname_vzr_ins_0"), "Lukinsky");
        fildFaild(By.id("name_vzr_ins_0"), "Ivan");
        fildFaild(By.id("birthDate_vzr_ins_0"), "27.09.1987");
        driver.findElement(By.xpath("//*[contains(text(), \"гражданин РФ\")]")).click();
        fildFaild(By.id("person_lastName"), "Гудименко");
        fildFaild(By.id("person_firstName"), "Олег");
        fildFaild(By.id("person_middleName"), "Александрович");
        fildFaild(By.id("person_birthDate"), "25.02.1979");
        driver.findElement(By.xpath("//html")).click();
        driver.findElement(By.xpath("//*[contains(text(), \"Мужской\")]")).click();
        fildFaild(By.id("passportSeries"), "1907");
        fildFaild(By.id("passportNumber"), "000101");
        fildFaild(By.id("documentDate"), "21.12.2001");
        driver.findElement(By.xpath("//html")).click();
        fildFaild(By.id("documentIssue"), "Паспортным столом города Тольятти");

        driver.findElement(By.xpath("//*[contains(text(), \"Продолжить\")]")).click();

        assertEquals("Lukinsky", driver.findElement(By.id("surname_vzr_ins_0")).getAttribute("value"));
        assertEquals("Ivan", driver.findElement(By.id("name_vzr_ins_0")).getAttribute("value"));
        assertEquals("27.09.1987", driver.findElement(By.id("birthDate_vzr_ins_0")).getAttribute("value"));
        assertEquals("гражданин РФ",
                driver.findElement(By.xpath("//*[contains(text(), \"гражданин РФ\")]")).getText());
        assertEquals("Гудименко", driver.findElement(By.id("person_lastName")).getAttribute("value"));
        assertEquals("Олег", driver.findElement(By.id("person_firstName")).getAttribute("value"));
        assertEquals("Александрович", driver.findElement(By.id("person_middleName")).getAttribute("value"));
        assertEquals("25.02.1979", driver.findElement(By.id("person_birthDate")).getAttribute("value"));
        assertEquals("Мужской",
                driver.findElement(By.xpath("//*[contains(text(), \"Мужской\")]")).getText());
        assertEquals("1907", driver.findElement(By.id("passportSeries")).getAttribute("value"));
        assertEquals("000101", driver.findElement(By.id("passportNumber")).getAttribute("value"));
        assertEquals("21.12.2001", driver.findElement(By.id("documentDate")).getAttribute("value"));
        assertEquals("Паспортным столом города Тольятти", driver.findElement(By.id("documentIssue")).getAttribute("value"));

        Assert.assertEquals("Поле не заполнено.",
                driver.findElement(By.xpath("//*[contains(text(), \"Поле не заполнено.\")]")).getText());

        Assert.assertEquals("При заполнении данных произошла ошибка",
                driver.findElement(By.xpath("//*[@class=\"alert-form alert-form-error\"]")).getText());


    }

    public void fildFaild(By locator, String value){
        driver.findElement(locator).clear();
        driver.findElement(locator).sendKeys(value);
    }

    @After
    public void afterTest(){
//        driver.quit();
    }
}

