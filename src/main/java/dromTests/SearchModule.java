package dromTests;

import core.BaseSeleniumPage;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import java.lang.Thread;

public class SearchModule extends BaseSeleniumPage {

    @FindBy(xpath = "//form[@name='filters']/div/*[1]/*[1]/div/*[1]/input")
    private WebElement markInput;

    @FindBy(xpath = "//form[@name='filters']/div/*[1]/*[2]/div/*[1]/input")
    private WebElement modelInput;

    @FindBy(xpath = "//form[@name='filters']/div/*[2]/*[3]/*[2]/*[1]")
    private WebElement fuelInput;

    @FindBy(xpath = "//form[@name='filters']/div/*[2]/*[3]/*[2]/*[2]/*[6]")
    private WebElement fuelInputValueHybride;

    @FindBy(xpath = "//form[@name='filters']/div/*[3]/*[3]/*[1]/*[1]/*[2]")
    private WebElement unselledCheck;

    @FindBy(xpath = "//form[@name='filters']/div/*[2]/*[2]/div/*[1]")
    private WebElement yearFrom;

    @FindBy(xpath = "//button[data-ftid='sales__filter_advanced-button']")
    private WebElement advancedFilter;

    @FindBy(css = "input[data-ftid='sales__filter_mileage-from']")
    private WebElement milageFrom;

    public SearchModule(){
        driver.get("https://auto.drom.ru/");
        PageFactory.initElements(driver, this);
    }

    public SearchModule setUpMarkModel(String markValue, String modelValue) throws InterruptedException {
        markInput.click();
        markInput.sendKeys(markValue);
        Thread.sleep(600);
        markInput.sendKeys(Keys.ENTER);

        modelInput.click();
        modelInput.sendKeys(modelValue);
        Thread.sleep(600);
        modelInput.sendKeys(Keys.ENTER);
        return this;
    }
    public SearchModule setUpFuel(){
        fuelInput.click();
        fuelInputValueHybride.click();
        return this;
    }

    public SearchModule setSellCheck(){
        unselledCheck.click();
        return this;
    }

    public SearchModule setYear() throws InterruptedException {
        yearFrom.click();
        driver.findElement(By.xpath("//div[text()='2007']")).click();
        Thread.sleep(600);
        return this;
    }

    public SearchModule filterExtend() throws InterruptedException {
        Thread.sleep(600);
        advancedFilter.click();
        return this;
    }

    public SearchModule setMileage(String mileage) throws InterruptedException {
        Thread.sleep(600);
        milageFrom.click();
        milageFrom.sendKeys(mileage);
        milageFrom.sendKeys(Keys.ENTER);
        return this;
    }
}
