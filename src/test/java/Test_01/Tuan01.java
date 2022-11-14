package Test_01;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class Tuan01 {

    @Test
    public void main() throws InterruptedException {


        System.setProperty("webdriver.chrome.driver", "C:\\testing\\chromedriver.exe");

        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();

        System.out.println("Truy cập trang bach hoa xanh");
        driver.get("https://www.bachhoaxanh.com/");



        String title = driver.getTitle();
        System.out.println("Title của trang: " + title);
        Thread.sleep(2000);

        System.out.println("Đang nhap tai khoan bhx");
        WebElement login = driver.findElement(By.xpath("//a[@class='histories']"));
        login.click();
        Thread.sleep(2000);

        System.out.println("Nhap sđt");
        driver.findElement(By.id("phone")).sendKeys("0977206372");
        Thread.sleep(2000);

        System.out.println("Click btn tiep tuc");
        WebElement ctn = driver.findElement(By.xpath("//body/section[1]/div[1]/div[1]/form[1]/button[1]"));
        ctn.click();
        Thread.sleep(2000);

        System.out.println("Nhap password");
        driver.findElement(By.id("Password")).sendKeys("250320");
        Thread.sleep(2000);

        System.out.println("Click btn login");
        WebElement btn_login = driver.findElement(By.xpath("//button[@onclick='submitLogin()']"));
        btn_login.click();
        Thread.sleep(2000);

       String Text = driver.findElement(By.xpath("//h3[contains(text(),'Lịch sử mua hàng')]")).getText();
        System.out.println("Dong text: "+Text);
        Thread.sleep(5000);

        driver.close();
        System.out.println("Tat trinh duyet chrome");

        driver.quit();
        System.out.println("Dong tat cac cua so ma chuong trinh da mo");
    }

}
