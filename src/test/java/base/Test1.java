package base;

import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import javax.swing.*;
import java.time.Duration;

public class Test1 {
    public static WebDriver driver;

    @BeforeClass
    public void setip() {
        driver = new ChromeDriver();
        driver.get("https://www.fitpeo.com/");
        driver.manage().window().maximize();


    }

    @org.testng.annotations.Test(priority = 0)
    public void revenuepage() {
        driver.findElement(By.xpath("//div[contains(text(),'Revenue Calculator')]")).click();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement element = wait.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector(".MuiSlider-root.MuiSlider-colorPrimary.MuiSlider-sizeMedium.css-duk49p")));
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].scrollIntoView();", element);
    }


    @Test(priority = 1)
    public void slider() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement slider = wait.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector("input[type='range']")));

        // Define the target value
        int targetValue = 820;

        // Continuously adjust the slider until the target value is reached
        while (true) {
            // Get the current value of the slider
            String ariaValueNow = slider.getAttribute("aria-valuenow");
            int currentValue = Integer.parseInt(ariaValueNow);

            // Check if the current value is equal to or greater than the target value
            if (currentValue >= targetValue) {
                break;
            }


            slider.sendKeys(Keys.ARROW_RIGHT);


            try {
                Thread.sleep(100); // 100ms delay
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

    }

    @Test(priority = 2)
    public void tg1(){
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

     driver.findElement(By.xpath("(//input[@type='checkbox'])[1]")).click();
     driver.findElement(By.xpath("(//input[@type='checkbox'])[2]")).click();
        driver.findElement(By.xpath("(//input[@type='checkbox'])[3]")).click();
        driver.findElement(By.xpath("(//input[@type='checkbox'])[8]")).click();
    }
    @Test(priority = 3)
    public void tg2(){
     String Expectedamount="$327838.00";
        String xpath = "//p[contains(@class, 'MuiTypography-root') and contains(@class, 'MuiTypography-body1')]";


        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement element = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(xpath)));


        String actualAmount = element.getText();
        System.out.println("Text of the element: " + actualAmount);

        Assert.assertEquals(actualAmount, Expectedamount);




    }
}

