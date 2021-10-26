package day04;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

public class C04_Odev {

 /*
6. Add to Cart butonuna basin
7. Alisveris sepetine tiklayin
8. Sectiginiz urunun basarili olarak sepete eklendigini control edin
9. Sayfayi kapatin */

    public static void main(String[] args) throws InterruptedException {

        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(13, TimeUnit.SECONDS);
        //  1. “https://www.saucedemo.com” Adresine gidin
        driver.get("https://www.saucedemo.com");
        // 2. Username kutusuna “standard_user” yazdirin
        WebElement kullaniciAdi= driver.findElement(By.id("user-name"));
        kullaniciAdi.sendKeys("standard_user");
        //3. Password kutusuna “secret_sauce” yazdirin
        WebElement sifre =driver.findElement(By.xpath("(//input[@class='input_error form_input'])[2]"));
        sifre.sendKeys("secret_sauce");
        //4. Login tusuna basin
        driver.findElement(By.id("login-button")).click();
        //5.Ilk urunun ismini kaydedin ve bu urunun sayfasina gidin
        WebElement ilkUrun=driver.findElement(By.xpath("//*[@id=\"item_4_title_link\"]/div"));
        Thread.sleep(2000);
        ilkUrun.click();
        Thread.sleep(2000);

        //6. Add to Cart butonuna basin
        driver.findElement(By.xpath("//button[@class='btn btn_primary btn_small btn_inventory']")).click();
        //7. Alisveris sepetine tiklayin
        driver.findElement(By.className("shopping_cart_link")).click();
        Thread.sleep(2000);

        //8. Sectiginiz urunun basarili olarak sepete eklendigini control edin
        WebElement sepet=driver.findElement(By.xpath("(//div[@class='inventory_item_name'][1])"));
        Thread.sleep(2000);
        if (sepet.isDisplayed()){
            System.out.println("Urun basarili olarak sepete eklenmiştir test PASS");
        } else {
            System.out.println("Urun basarili olarak sepete eklenmemiştir test FAILED");
        }
        //9. Sayfayi kapatin
        //driver.quit();
    }
}






