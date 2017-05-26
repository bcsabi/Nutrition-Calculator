package hu.csabi.NutritionCalculator.Models;

import org.junit.Test;

import java.util.Arrays;
import java.util.List;


public class XMLReaderForConsumptionsTest {

    private XMLReaderForConsumptions xmlReaderForConsumptions = new XMLReaderForConsumptions();

    private Consumption consumption1 = new Consumption("2017.05.22.", 232.4, 100.5,
            20.8,2225.5);

    private Consumption consumption2 = new Consumption("2017.05.23.", 60.4, 242.1,
            20.8,1842.4);

    private Consumption consumption3 = new Consumption("2017.05.24.", 189.4, 200.4,
            89.2,4242.2);

    private List<Consumption> consumptions = Arrays.asList(consumption1,consumption2,consumption3);


    @Test
    public void initTheConsumptionsList() throws Exception {
      /*  xmlReaderForConsumptions.initTheConsumptionsList();
        int excepted = 0;
        int actual = consumptions.size();
        Assert.assertEquals(excepted,actual);*/
    }

    @Test
    public void xmlReader() throws Exception {
    }

    @Test
    public void getDateList() throws Exception {
        /*List<String> excepted = Arrays.asList("2017.05.22.", "2017.05.23.", "2017.05.24.");
        Assert.assertEquals(excepted,xmlReaderForConsumptions.getDateList());*/

    }

    @Test
    public void getProteinList() throws Exception {
    }

    @Test
    public void getCarbohydrateList() throws Exception {
    }

    @Test
    public void getFatList() throws Exception {
    }

    @Test
    public void getCalorieList() throws Exception {
    }


}
