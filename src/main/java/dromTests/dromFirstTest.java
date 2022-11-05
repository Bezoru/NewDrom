package dromTests;

import core.BaseTest;
import dataLurkers.SearchData;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;

public class dromFirstTest extends BaseTest {

    @Test
    public void setFilter() throws InterruptedException {
        String mark = "Toyota";
        String model = "Harrier";
        String mileage = "1";

        SearchModule searchModule = new SearchModule()
        .setUpMarkModel(mark, model)
        .setUpFuel()
        .setSellCheck()
        .setYear()
        .filterExtend()
        .setMileage(mileage);
        Thread.sleep(1000);

        SearchData searchData = new SearchData();
        Assert.assertTrue(driver.findElements(By.cssSelector("div.css-r91w5p.e3f4v4l2 span")).isEmpty());
        Assert.assertEquals(0,searchData.yearMoreThanCheck());
        Assert.assertEquals(0, searchData.mileageExist());

    }
}
