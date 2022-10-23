package org.example;

import org.openqa.selenium.By;
import java.lang.Thread;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

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

        //driver.findElement(By.xpath("//button[text()='Расширенный поиск']")).click();

        driver.findElement(By.cssSelector("button[data-ftid='sales__filter_advanced-button']")).click();

        WebElement mileage = driver.findElement(By.cssSelector("input[data-ftid='sales__filter_mileage-from']"));
        mileage.click();
        Thread.sleep(300);
        mileage.sendKeys("1");
        Thread.sleep(300);
        mileage.sendKeys(Keys.ENTER);
    }
}