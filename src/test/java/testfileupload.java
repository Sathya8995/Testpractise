import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import java.awt.*;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;
import java.io.IOException;
import java.time.Duration;

public class testfileupload {
    public static String choosefile = "//input[@id='fileInput']";
    public static String selectfile = "//form[@id='dropzone']/div[2]/button";
    public static String path = "C:\\Users\\sathy\\OneDrive\\Desktop\\sample.txt";
    public static String AutoITpath = "C:\\Users\\sathy\\IdeaProjects\\FileUpload.exe";
    public static String upload = "//button[@id='fileSubmit']";
    public static String uploadFile = "//button[@id='upload']";
    @Test
    public void fileUpload_Sendkeys() throws InterruptedException{
        WebDriverManager.chromedriver().setup();
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--headless");
        WebDriver driver = new ChromeDriver(options);
        //driver.manage().window().maximize();
        driver.get("https://practice.expandtesting.com/upload");
        Thread.sleep(1000);
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollTo(0,document.body.scrollHeight);");
        driver.findElement(By.xpath(choosefile)).sendKeys(path);
        Thread.sleep(1000);
        driver.findElement(By.xpath(upload)).click();

    }

    @Test
    public void fileUpload2Robot() throws InterruptedException, AWTException {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://easyupload.io/");
        Thread.sleep(1000);
        //click upload button
        driver.findElement(By.xpath(selectfile)).click();
        Thread.sleep(3000);

        StringSelection filepathSelection = new StringSelection(path);
        Toolkit.getDefaultToolkit().getSystemClipboard().setContents(filepathSelection,null);

        Robot rb = new Robot();
        rb.keyPress(KeyEvent.VK_CONTROL);
        rb.keyPress(KeyEvent.VK_V);
        rb.keyRelease(KeyEvent.VK_V);
        rb.keyRelease(KeyEvent.VK_CONTROL);
        rb.keyPress(KeyEvent.VK_ENTER);
        rb.keyRelease(KeyEvent.VK_ENTER);
        Thread.sleep(3000);

        //Adding an explicit wait
        WebDriverWait myWait = new WebDriverWait(driver, Duration.ofSeconds(2));
        WebElement upload = myWait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(uploadFile)));
        upload.click();


    }

    @Test
    public void fileUpload3AutoIT() throws InterruptedException, IOException {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://easyupload.io/");
        Thread.sleep(1000);
        //click upload button
        driver.findElement(By.xpath(selectfile)).click();

        //AutiItScript
        Runtime.getRuntime().exec(AutoITpath);

        //Adding an explicit wait
        WebDriverWait myWait = new WebDriverWait(driver, Duration.ofSeconds(5));
        WebElement upload = myWait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(uploadFile)));
        upload.click();

    }
}

