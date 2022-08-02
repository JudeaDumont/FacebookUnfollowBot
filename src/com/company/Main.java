package com.company;

import java.io.File;
import java.time.Duration;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.firefox.FirefoxProfile;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Main {

    public static void main(String[] args) throws InterruptedException {
        // TODO Auto-generated method stub

        //setting the driver executable
        System.setProperty("webdriver.gecko.driver", "C:\\Users\\dum75377\\Desktop\\selenium\\geckodriver\\geckodriver.exe");

        FirefoxOptions options = new FirefoxOptions()
                .setBinary("C:\\Program Files\\Mozilla Firefox\\firefox.exe").setProfile(
                        new FirefoxProfile(new File("C:\\Users\\dum75377\\AppData\\Roaming\\Mozilla\\Firefox\\Profiles\\fzmfc6nu.default-release"))
                );
        WebDriver driver = new FirefoxDriver(options);

        //Applied wait time
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

        //maximize window
        driver.manage().window().maximize();

        //open browser with desired URL
        driver.get("https://www.facebook.com");

        String button2 = "hu5pjgll lzf7d6o1";
        int i = 0;
        while (++i < Integer.MAX_VALUE) {

            List<WebElement> elements = driver.findElements(By.cssSelector("[aria-label=\"Actions for this post\"]"));

            try {
                for (WebElement element : elements) {
                    new WebDriverWait(driver, Duration.ofSeconds(2)).until(ExpectedConditions.elementToBeClickable(element)).click();
                    List<WebElement> elements1 = driver.findElements(By.xpath("//span[contains(text(),'Unfollow')]"));
                    for (WebElement webElement : elements1) {
                        new WebDriverWait(driver, Duration.ofSeconds(2)).until(ExpectedConditions.elementToBeClickable(webElement)).click();
                        Thread.sleep(2000);
                    }
                    if(elements1.size() == 0){
                        WebElement hideAll = driver.findElement(By.xpath("//span[contains(text(),'Hide all')]"));
                        new WebDriverWait(driver, Duration.ofSeconds(2)).until(ExpectedConditions.elementToBeClickable
                                (hideAll)).click();
                        Thread.sleep(2000);
                    }
                }
            } catch (Exception e) {
                System.out.println(";)");
                Thread.sleep(2000);
                driver.get("https://www.facebook.com");
                continue;
            }
            driver.navigate().refresh();
        }

        //closing the browser
        driver.close();
    }
}
