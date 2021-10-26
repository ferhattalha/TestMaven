package day04;

import com.sun.tools.javac.Main;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

public class C03_Test02 {
/*
1. http://zero.webappsecurity.com sayfasina gidin
2. Signin buttonuna tiklayin
3. Login alanine  “username” yazdirin
4. Password alanine “password” yazdirin
5. Sign in buttonuna tiklayin
6. Pay Bills sayfasina gidin
7. amount kismina yatirmak istediginiz herhangi bir miktari yazin
8. tarih kismina “2020-09-10” yazdirin
9. Pay buttonuna tiklayin
10. “The payment was successfully submitted.” mesajinin ciktigini control edin */


    public static void main(String[] args) {
      WebDriverManager.chromedriver().setup();
      WebDriver driver = new ChromeDriver();
      driver.manage().timeouts().implicitlyWait(13, TimeUnit.SECONDS);

      //1. http://zero.webappsecurity.com sayfasina gidin
      driver.get("http://zero.webappsecurity.com");

      //2. Signin buttonuna tiklayin
      driver.findElement(By.id("signin_button")).click();

     //3. Login alanine  “username” yazdirin
      WebElement login=driver.findElement(By.id("user_login"));
      login.sendKeys("username");

      //4. Password alanine “password” yazdirin
      WebElement password=driver.findElement(By.id("user_password"));
      password.sendKeys("password");

      //5. Sign in buttonuna tiklayin
      driver.findElement(By.xpath("//*[@id=\"login_form\"]/div[2]/input")).click();

      //6. Pay Bills sayfasina gidin
      WebElement ödeme=driver.findElement(By.xpath("//*[@id=\"pay_bills_tab\"]/a"));
      ödeme.click();

      //7. amount kismina yatirmak istediginiz herhangi bir miktari yazin
      WebElement amount=driver.findElement(By.xpath("//*[@id=\"sp_amount\"]"));
      amount.sendKeys("50");

      //8. tarih kismina “2020-09-10” yazdirin

      WebElement date=driver.findElement(By.xpath("//*[@id=\"sp_date\"]"));
      date.sendKeys("2021-10-07");

      driver.findElement(By.xpath("//*[@id=\"ui-datepicker-div\"]/table/tbody/tr[2]/td[5]/a")).click();
      //9. Pay buttonuna tiklayin

      driver.findElement(By.xpath("//*[@id=\"pay_saved_payees\"]")).click();
      //10. “The payment was successfully submitted.” mesajinin ciktigini control edin

      WebElement aciklama=driver.findElement(By.xpath("//*[@id=\"alert_content\"]/span"));

      if (aciklama.isDisplayed()){
        System.out.println("The payment was successfully submitted testi PASS");
      } else {
        System.out.println("The payment was successfully submitted testi FAILED");

      }

    driver.close();

    }
  }


