package dataLurkers;

import core.BaseSeleniumPage;
import org.apache.commons.lang3.StringUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class SearchData extends BaseSeleniumPage {


    public int yearMoreThanCheck(){
        List<WebElement> nameslist = driver.findElements(By.xpath("//div[contains(@class, 'css-13ocj84 e727yh30')]/div[1]/div/span"));

        String[] names = new String[nameslist.size()];
        String[] years = new String[nameslist.size()];

        for (int i = 0; i < nameslist.size(); i++) {
            names[i] = nameslist.get(i).getText();
            years[i] = StringUtils.right(names[i], 4);
        }
        int yearcheck = 0;
        int[] yearsInNumbers = new int[years.length];
        for(int i = 0;i < yearsInNumbers.length;i++)
        {
            yearsInNumbers[i] = Integer.parseInt(years[i]);
            if(yearsInNumbers[i] < 2007){
                yearcheck++;
            }
        }
        return yearcheck;
    }

    public int mileageExist(){
        List<WebElement> milagelist = driver.findElements(By.cssSelector("div.css-1fe6w6s.e162wx9x0 > span:last-child"));
        String [] milages = new String[milagelist.size()];
        String[] miles = new String[milagelist.size()];


        int milescheck = 0;
        for (int i = 0; i < milagelist.size(); i++) {
            milages[i] = milagelist.get(i).getText();
            miles[i] = StringUtils.right(milages[i], 7);
            if (!miles[i].equalsIgnoreCase("тыс. км")) {
                milescheck++;
            }
        }
        return milescheck;
    }
}
