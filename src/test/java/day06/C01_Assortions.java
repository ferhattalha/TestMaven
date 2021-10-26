package day06;


import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Ignore;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

public class C01_Assortions {

    /*
    1) Bir class oluşturun: BestBuyAssertions
2)  https://www.bestbuy.com/Adresine gidin farkli test method’lari olusturarak asagidaki testleri yapin
 ○ Sayfa URL’inin https://www.bestbuy.com/ ‘a esit oldugunu test edin
 ○ titleTest => Sayfa başlığının “Rest” içermediğini(contains) test edin
 ○ logoTest => BestBuy logosunun görüntülendigini test edin
 ○ FrancaisLinkTest => Fransizca Linkin görüntülendiğini test edin
     */

    static WebDriver driver;

    @BeforeClass

    public static void setup() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
        driver.get("https://www.bestbuy.com/");

    }

    @Test
    public void urlTest() {
        String expectedURL = "https://www.bestbuy.com/";
        String actualURL = driver.getCurrentUrl();
        Assert.assertEquals("istenen Url bulunamadı", expectedURL, actualURL);
    }
    @Test
    public void titleTest(){
        String istenmeyenKelime="Rest";
        String actualTitle=driver.getTitle();
        Assert.assertFalse("istenmeyen kelime title da var", actualTitle.contains(istenmeyenKelime));

    }

    @Test
    public void logoTest() {
        WebElement logo = driver.findElement(By.xpath("//img[@class='logo']"));
        Assert.assertTrue("logo gorunuyor", logo.isDisplayed());
    }

    @Test
    public void fransizcaTesti() {


        WebElement fransizcaLinki = driver.findElement(By.xpath("//button[@class='is-active']"));
        Assert.assertTrue("fransizca link gorunuyor", fransizcaLinki.isDisplayed());


    }

    @Ignore
    public static void tearDawn() {
        driver.close();
    }
}
