package day05;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;


public class Test01 {

    WebDriver driver;

    @Before

    public void setup() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
    }

    @Test
    public void test(){
        driver.get("https://www.amazon.com/");
        driver.manage().window().maximize();
        driver.navigate().refresh();

         String expTitle="Amazon";
         String actTitle=driver.getTitle();

         if(expTitle.contains(actTitle)){
             System.out.println("Başlık amazon ifadesi içeriyor test PASSED");
        } else{
             System.out.println("Başlık amazon ifadesi içermiyor test FAILED");
         }

        String excpsayfaBaslık="Amazon.com. Spend less. Smile more.";
        String actTitle1=driver.getTitle();

        if(excpsayfaBaslık.equals(actTitle1)){
            System.out.println("sayfa baslıgı Amazon.com. Spend less. Smile more. eşit Test PASSED");
        }else {
            System.out.println("sayfa baslıgı Amazon.com. Spend less. Smile more. eşit degil Test FAILED");
        }

                 String excUrl="amazon.com";
                 String actUrl=driver.getCurrentUrl();

                 if(excUrl.contains(actUrl)){
                     System.out.println("Url istenilen ifadeyi içeriyor test PASSED");
                 }else {
                     System.out.println("Url istenilen ifadeyi içermiyor test FAILED");
                 }

    }
    @After
    public void tearDown(){
        driver.close();
    }

}