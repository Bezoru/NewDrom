package org.example;

import org.openqa.selenium.By;
import java.lang.Thread;
import java.util.List;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.junit.Assert;

public class Main {
    public static void main(String[] args) throws InterruptedException {
        System.setProperty("webdriver.chrome.driver","C:\\webdriver\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();

        driver.get("https://auto.drom.ru/");

        WebElement marka = driver.findElement(By.xpath("//form[@name='filters']/div/*[1]/*[1]/div/*[1]/input"));
        marka.click();
        marka.sendKeys("Toyota");
        Thread.sleep(300);
        marka.sendKeys(Keys.ENTER);

        WebElement model = driver.findElement(By.xpath("//form[@name='filters']/div/*[1]/*[2]/div/*[1]/input"));
        Thread.sleep(600);
        model.click();
        Thread.sleep(300);
        model.sendKeys("Harrier");
        Thread.sleep(300);
        model.sendKeys(Keys.ENTER);

        driver.findElement(By.xpath("//form[@name='filters']/div/*[2]/*[3]/*[2]/*[1]")).click();
        WebElement fuel = driver.findElement(By.xpath("//form[@name='filters']/div/*[2]/*[3]/*[2]/*[2]/*[6]"));
        Thread.sleep(600);
        fuel.click();

        driver.findElement(By.xpath("//form[@name='filters']/div/*[3]/*[3]/*[1]/*[1]/*[2]")).click();

        driver.findElement(By.xpath("//form[@name='filters']/div/*[2]/*[2]/div/*[1]")).click();

        driver.findElement(By.xpath("//div[text()='2007']")).click();
        Thread.sleep(600);

        driver.findElement(By.cssSelector("button[data-ftid='sales__filter_advanced-button']")).click();

        WebElement mileage = driver.findElement(By.cssSelector("input[data-ftid='sales__filter_mileage-from']"));
        mileage.click();
        Thread.sleep(300);
        mileage.sendKeys("1");
        Thread.sleep(300);
        mileage.sendKeys(Keys.ENTER);

        Thread.sleep(1000);

        List<WebElement> spans = driver.findElements(By.cssSelector("div.css-r91w5p.e3f4v4l2 span"));

        Assert.assertTrue(driver.findElements(By.cssSelector("div.css-r91w5p.e3f4v4l2 span")).isEmpty());

        /*for (WebElement currentSpan: spans){

            try{
                Assert.assertTrue(currentSpan.getCssValue("text-decoration").contains("line-through"));
                System.out.println("Link:" + currentSpan.getText() + " IS blue.");
            }catch(AssertionError e){
                System.out.println("Link:" + currentSpan.getText() + " is NOT blue");
            }
        }*/

    }
}