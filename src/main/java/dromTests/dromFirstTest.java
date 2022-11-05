package dromTests;

import core.BaseTest;
import org.junit.Test;

public class dromFirstTest extends BaseTest {

    @Test
    public void setFilter() throws InterruptedException {
        String mark = "Toyota";
        String model = "Harrier";
        String mileage = "1";

        SearchModule searchModule = new SearchModule();
        searchModule.setUpMarkModel(mark, model);
        searchModule.setUpFuel();
        searchModule.setSellCheck();
        searchModule.setYear();
        searchModule.filterExtend();
        searchModule.setMileage(mileage);

    }
}
