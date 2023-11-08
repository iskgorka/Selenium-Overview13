import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.List;

public class FirstRozetkaTest {
    public static void main(String[] args) throws InterruptedException {
        System.setProperty("webdriver.chrome.driver", "src/main/resources/chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        try {
            driver.manage().window().maximize();
            driver.navigate().to("https://www.google.com/");
            System.out.println("Current URL is: " + driver.getCurrentUrl());
            WebElement searchGoogleField = driver.findElement(By.id("APjFqb"));
            searchGoogleField.isDisplayed();
            searchGoogleField.sendKeys("rozetka.com.ua");
            searchGoogleField.submit();

            WebElement searchGoogleResults = driver.findElement(By.xpath("//a/h3"));
            searchGoogleResults.isDisplayed();
            searchGoogleResults.click();
            System.out.println("Current URL is: " + driver.getCurrentUrl());

            WebElement searchRozetkaField = driver.findElement(By.xpath("//input[@name='search']"));
            //WebElement searchGreenButton = driver.findElement(By.xpath("//button[@class=\"button button_color_green button_size_medium search-form__submit\"]"));
            searchRozetkaField.isDisplayed();
            searchRozetkaField.sendKeys("apple watch 8");
            searchRozetkaField.submit();
            //searchGreenButton.click();
            Thread.sleep(1000);
            List<WebElement> suggestList = driver.findElements(By.xpath("//li[@class='search-suggest__item ng-star-inserted']"));
            suggestList.get(0).click();
            
        } finally {
            driver.close();
        }
    }
}
