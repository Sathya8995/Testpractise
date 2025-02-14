import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class testDynamictable {
    @Test
    public static void test1() throws InterruptedException{
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.get("https://practice.expandtesting.com/dynamic-table");
        Thread.sleep(1000);
        driver.manage().window().maximize();

        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollBy(0,400)", "");
        WebElement actualCPUPercentage = driver.findElement(By.xpath("//p[@id=\"chrome-cpu\"]"));


        for (int i = 1;i<=4;i++){
            for (int j =1;j<=5;j++){
                WebElement taskName = driver.findElement(By.xpath("//table[@class=\"table table-striped\"]/tbody/tr["+i+"]/td[1]"));
                WebElement expectedCPUPercentage = driver.findElement(By.xpath("//table[@class=\"table table-striped\"]/tbody/tr["+i+"]/td["+j+"]"));
                WebElement chromeCPU = driver.findElement(By.xpath("//table[@class=\"table table-striped\"]/thead/tr[1]/th["+j+"]"));

                if (chromeCPU.getText().equals("CPU")){
                    if (taskName.getText().equals("Chrome")){
                        Assert.assertEquals(actualCPUPercentage.getText(),"Chrome CPU: "+expectedCPUPercentage.getText());
                    }
                }


            }


        }

    }
}
