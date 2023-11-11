import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.List;

public class FirstClass {
    public static void main(String[] args) throws InterruptedException {
        System.setProperty("webdriver.chrome.driver", "src/main/resources/chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();

        driver.get("https://www.google.com/");
        String searchFieldXpath = "//textarea[@id='APjFqb']";

        WebElement searchElement = driver.findElement(By.xpath(searchFieldXpath));
        searchElement.sendKeys("automation");
        System.out.println("Search field is displayed " + searchElement.isDisplayed());
        Thread.sleep(2000);
        searchElement.submit();

        WebElement searchResults = driver.findElement(By.id("rso"));
        String firstResultTitle = searchResults.findElement(By.xpath("//a/h3")).getText();
        System.out.println("First result title is " + firstResultTitle);
        List<WebElement> allResultTitles = searchResults.findElements(By.xpath("//a/h3"));
        List<WebElement> allMenus = driver.findElements(By.className("hdtb-mitem"));
        Thread.sleep(2000);
        System.out.println("Current URL is " + driver.getCurrentUrl());
        System.out.println("Current title is " + driver.getTitle());
        for(WebElement v : allMenus){
            System.out.println("Menu title:");
            System.out.print(v.getText());
        }
        allResultTitles.get(0).click();
        System.out.println("Current URL after click is " + driver.getCurrentUrl());
        System.out.println("Current title after click is " + driver.getTitle());
        driver.navigate().back();
        System.out.println("Current URL after back is " + driver.getCurrentUrl());
        System.out.println("Current title after back is " + driver.getTitle());
        driver.close();
    }
}
