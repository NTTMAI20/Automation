package Mai_165744;

import org.bouncycastle.operator.bc.BcSignerOutputStream;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import javax.swing.text.html.Option;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;
import java.util.concurrent.TimeUnit;

public class Mai_165744 {

    // Khai báo
    WebDriver driver;
    Select select;
    Random rand;
    Option option;
    // Khai báo + khởi tạo
    Actions actions;
    String projectPath = System.getProperty("user.dir");
    String osName = System.getProperty("os.name");

    @BeforeClass
    public void beforeClass() {
        if (osName.contains("Mac")) { // Mac
            System.setProperty("webdriver.gecko.driver", projectPath + "/browserDrivers/geckodriver");
        } else { // Windows
            System.setProperty("webdriver.gecko.driver", projectPath + "\\browserDrivers\\geckodriver.exe");
        }

        // Khởi tạo
        driver = new ChromeDriver();
        rand = new Random();
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
    }

    @Test
    public void TC01_DemoQA() {
        try {
            actions = new Actions(driver);
            driver.get("https://demoqa.com/automation-practice-form");
            driver.manage().window().maximize();
            // xoa quang cao
            JavascriptExecutor js = (JavascriptExecutor) driver;
            WebElement adDeleteEl = driver.findElement(By.id("fixedban"));
            js.executeScript("arguments[0].setAttribute('style', 'display:none')", adDeleteEl);

            driver.findElement(By.xpath("//input[@id='firstName']")).sendKeys("test");
            sleepInSecond(3);
            driver.findElement(By.xpath("//input[@id='lastName']")).sendKeys("Nguyen");
            sleepInSecond(3);
            driver.findElement(By.xpath("//input[@id='userEmail']")).sendKeys("abc@gmai.com");
            sleepInSecond(3);
            driver.findElement(By.xpath("//label[contains(text(),'Male')]")).click();
            sleepInSecond(3);
            driver.findElement(By.xpath("//input[@id='userNumber']")).sendKeys("0322254877");
            sleepInSecond(3);

            driver.findElement(By.xpath("//input[@id='dateOfBirthInput']")).click();
            select = new Select(driver.findElement(By.xpath("//select[@class='react-datepicker__year-select']")));
            select.selectByVisibleText("2000");
            select = new Select(driver.findElement(By.xpath("//select[@class='react-datepicker__month-select']")));
            select.selectByVisibleText("April");
            driver.findElement(By.xpath("//div[@aria-label='Choose Tuesday, April 11th, 2000']")).click();
            sleepInSecond(3);

            WebElement subTestEl = driver.findElement(By.xpath("//input[@id='subjectsInput']"));
            subTestEl.sendKeys("Ma");
            subTestEl.sendKeys(Keys.ARROW_DOWN);
            subTestEl.sendKeys(Keys.ENTER);
            sleepInSecond(3);

            //Scroll xuống
            actions.sendKeys(Keys.PAGE_DOWN).build().perform();

            driver.findElement(By.xpath("//label[normalize-space()='Music']")).click();
            sleepInSecond(3);
            driver.findElement(By.xpath("//input[@id='uploadPicture']")).sendKeys(System.getProperty("user.dir") + "\\src\\img\\imgHi.jpg");
            sleepInSecond(3);
            driver.findElement(By.xpath("//textarea[@id='currentAddress']")).sendKeys("123 HCM");
            sleepInSecond(3);

            WebElement stateTestEl = driver.findElement(By.id("state"));
            actions.sendKeys(Keys.PAGE_DOWN).build().perform();
            sleepInSecond(2);
            actions.moveToElement(stateTestEl).click().build().perform();
            actions.sendKeys(Keys.chord(Keys.DOWN, Keys.ENTER)).perform();

            WebElement stateCity = driver.findElement(By.id("city"));
            actions.moveToElement(stateCity).click().build().perform();
            actions.sendKeys(Keys.chord(Keys.DOWN, Keys.ENTER)).perform();
            sleepInSecond(5);
            // ((JavascriptExecutor)driver).executeScript("document.getElementById('submit').click()");
            driver.findElement(By.id("submit")).click();
        } catch (Exception ex) {
            System.out.println("Có thao tác không thực hiện được");
        }
    }

    @Test
    public void TC02_BHX() {
        try {
            driver.get("https://www.bachhoaxanh.com/");
            driver.manage().window().maximize();
            sleepInSecond(3);

            driver.findElement(By.cssSelector(".shiptoHere")).click();
            sleepInSecond(3);
            driver.findElement(By.xpath("//li[@class='selected']")).click();
            sleepInSecond(3);
            driver.findElement(By.cssSelector("li[data-distid='2087']")).click();
            sleepInSecond(3);
            driver.findElement(By.cssSelector("div[class='ward-container sb-container boxprovince'] li:nth-child(1)")).click();
            sleepInSecond(3);
            WebElement cate = driver.findElement(By.xpath("//img[@alt='Thịt heo các loại']"));
            sleepInSecond(3);
            cate.click();
            driver.findElement(By.xpath("//a[@title='Ba rọi heo C.P khay 500g']")).click();
            sleepInSecond(3);
            driver.findElement(By.xpath("//aside[@class='infosell infosell-normal']//a[2]//div[1]//i[1]")).click();
            sleepInSecond(3);
            driver.findElement(By.xpath("//a[@class='choosebuy detailbuy']")).click();
            sleepInSecond(3);
            driver.findElement(By.xpath("//b[@class='sumorder']")).click();
            sleepInSecond(3);
            driver.findElement(By.xpath("//button[contains(text(),'ĐẶT HÀNG')]")).click();
            sleepInSecond(3);
            driver.findElement(By.xpath("//label[@for='ProfileItems_0_Gender0']")).click();
            sleepInSecond(3);
            driver.findElement(By.cssSelector("#ProfileItems_0_CustomerName")).sendKeys("Mai Nguyễn");
            sleepInSecond(3);
            WebElement phone = driver.findElement(By.xpath("//input[@id='ProfileItems_0_CustomerPhone']"));
            phone.sendKeys("0938727300");
            sleepInSecond(3);
            String valuePhone = phone.getAttribute("value");
            if (valuePhone.equals("")) {
                phone.sendKeys("0938727300");
            }

            WebElement address = driver.findElement(By.cssSelector("#ProfileItems_0_Address"));
            sleepInSecond(3);
            String valueAddress = address.getAttribute("value");
            if (valueAddress.equals("")) {
                address.sendKeys("IT Test");
            }

            driver.findElement(By.xpath("//div[@class='loadMorePaymentType']")).click();
            sleepInSecond(3);

            List<WebElement> paymentList = driver.findElements(By.xpath("//div[@class='listpayment']"));
            for (WebElement element : paymentList) {
                System.out.println(element.getText());
            }

            driver.findElement(By.xpath("//div[@class='payment-cash']//span[@class='payment-info']//span[1]")).click();
            sleepInSecond(3);

            driver.findElement(By.xpath("//a[contains(text(),'XÁC NHẬN ĐƠN HÀNG')]")).click();
            sleepInSecond(3);

        } catch (Exception ex) {
            System.out.println("Có thao tác không thực hiện được");
        }

    }

    //  @Test
//    public void TC_01_Default_Dropdown() {
//        driver.get("https://demo.nopcommerce.com/");
//
//        driver.findElement(By.cssSelector("a.ico-register")).click();
//
//        driver.findElement(By.cssSelector("input#FirstName")).sendKeys("Joe");
//        driver.findElement(By.cssSelector("input#LastName")).sendKeys("Biden");
//        sleepInSecond(3);
//        // Khởi tạo select để thao tác vs Day dropdown
//        select = new Select(driver.findElement(By.cssSelector("select[name='DateOfBirthDay']")));
//        select.selectByVisibleText("1");
//        sleepInSecond(3);
//        // Dropdown item expected
//        String[] monthExpected = {"Month", "January", "February", "March", "April",
//                "May", "June", "July", "August",
//                "September", "October", "November", "December"};
//
//        // Khởi tạo select để thao tác vs Month dropdown
//        select = new Select(driver.findElement(By.cssSelector("select[name='DateOfBirthMonth']")));
//        sleepInSecond(3);
//        // Lấy ra tất cả các item đưa vào List Element
//        List<WebElement> monthItems = select.getOptions();
//
//        // Khai báo ArrayList để chứa text get ra từ List Element trên
//        List<String> monthItemText = new ArrayList<String>();
//
//        // Duyệt vòng lặp
//        for (WebElement element : monthItems) {
//            // Add vào ArrayList
//            monthItemText.add(element.getText());
//        }
//
//        // Verify bằng nhau
//        Assert.assertEquals(monthItemText, Arrays.asList(monthExpected));
//
//        select.selectByVisibleText("May");
//
//        // Khởi tạo select để thao tác vs Year dropdown
//        select = new Select(driver.findElement(By.cssSelector("select[name='DateOfBirthYear']")));
//        select.selectByVisibleText("1965");
//        sleepInSecond(3);
//        String emailAddress = "joebiden" + rand.nextInt(9999) + "@hotmail.com";
//
//        driver.findElement(By.cssSelector("input#Email")).sendKeys(emailAddress);
//        driver.findElement(By.cssSelector("input#Company")).sendKeys("White House");
//        driver.findElement(By.cssSelector("input#Password")).sendKeys("123456");
//        driver.findElement(By.cssSelector("input#ConfirmPassword")).sendKeys("123456");
//        sleepInSecond(10);
//        driver.findElement(By.cssSelector("button#register-button")).click();
//
//        Assert.assertEquals(driver.findElement(By.cssSelector("div.result")).getText(), "Your registration completed");
//
//        driver.findElement(By.cssSelector("a.ico-account")).click();
//
//        Assert.assertEquals(driver.findElement(By.cssSelector("input#FirstName")).getAttribute("value"), "Joe");
//        Assert.assertEquals(driver.findElement(By.cssSelector("input#LastName")).getAttribute("value"), "Biden");
//
//        select = new Select(driver.findElement(By.cssSelector("select[name='DateOfBirthDay']")));
//        Assert.assertEquals(select.getFirstSelectedOption().getText(), "1");
//
//        select = new Select(driver.findElement(By.cssSelector("select[name='DateOfBirthMonth']")));
//        Assert.assertEquals(select.getFirstSelectedOption().getText(), "May");
//
//        select = new Select(driver.findElement(By.cssSelector("select[name='DateOfBirthYear']")));
//        Assert.assertEquals(select.getFirstSelectedOption().getText(), "1965");
//
//        Assert.assertEquals(driver.findElement(By.cssSelector("input#Email")).getAttribute("value"), emailAddress);
//        Assert.assertEquals(driver.findElement(By.cssSelector("input#Company")).getAttribute("value"), "White House");
//    }

    //    @Test
//    public void TC_02_Default_Dropdown() {
//        sleepInSecond(5);
//        driver.get("https://rode.com/en/support/where-to-buy");
//
//        select = new Select(driver.findElement(By.id("country")));
//
//        select.selectByValue("Vietnam");
//        sleepInSecond(3);
//
//        Assert.assertEquals(select.getFirstSelectedOption().getText(), "Vietnam");
//
//        List<WebElement> dealers = driver.findElements(By.cssSelector("div#map h4"));
//
//        for (WebElement element : dealers) {
//            System.out.println(element.getText());
//        }
//    }
    @AfterClass
    public void afterClass() {
        driver.quit();
    }

    public void sleepInSecond(long timeInSecond) {
        try {
            Thread.sleep(timeInSecond * 1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
