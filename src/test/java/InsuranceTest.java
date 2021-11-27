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
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.concurrent.TimeUnit;


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

       String baseUrlIns = "https://online.sber.insure/store/travel/?_ga=2.153558577.827813117.1637922399-580027590.1637922399";
//        WebDriver driverIns =  new ChromeDriver();
        driver.get(baseUrlIns);

        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
//        driver.findElement(By.xpath("//*[contains(text(), \"Минимальная\")]")).click();

//        WebDriverWait wait = new WebDriverWait(driver, 1000);
////        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[contains(text(), \"Оформить\")]")));
////        driver.findElement(By.xpath("//*[contains(text(), \"Оформить\")]")).click();

//        WebElement element= driver.findElement(By.xpath("//*[contains(text(),\"Оформить\")]"));

//        JavascriptExecutor executor = (JavascriptExecutor) driver;
//        executor.executeScript("arguments[0].click();", element);

//        JavascriptExecutor jse = (JavascriptExecutor)driver;
//        jse.executeScript("window.scrollTo(0," + element.getLocation().y + ")");

//        driver.findElement((By.xpath("//*[contains(text(), \"Контакты\")]"))).click();
        ((JavascriptExecutor)driver).executeScript("arguments[0].scrollIntoView();"
                , driver.findElement(By.xpath("//*[contains(text(), \"Контакты\")]")));

        Actions actions = new Actions(driver);
        actions.moveToElement(driver.findElement(By.xpath("//*[contains(text(), \"Оформить\")]"))).build().perform();
        driver.findElement(By.xpath("//*[contains(text(), \"Оформить\")]")).click();
    }

    @After
    public void afterTest(){
//        driver.quit();
    }
}
