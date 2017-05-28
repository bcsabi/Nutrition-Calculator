package hu.csabi.NutritionCalculator.Models;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
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
    private ArrayList<Consumption> consumptions = new ArrayList<>();


    @Before
    public void setUp(){
       consumptions.add(consumption1);
       consumptions.add(consumption2);
       consumptions.add(consumption3);
       xmlReaderForConsumptions = new XMLReaderForConsumptions(consumptions);
    }


    @Test
    public void initTheConsumptionsList() throws Exception {
        xmlReaderForConsumptions.initTheConsumptionsList();

        int excepted = 0;
        int actual = xmlReaderForConsumptions.getDateList().size();
        Assert.assertEquals(excepted,actual);

        actual = xmlReaderForConsumptions.getProteinList().size();
        Assert.assertEquals(excepted,actual);

        actual = xmlReaderForConsumptions.getCarbohydrateList().size();
        Assert.assertEquals(excepted,actual);

        actual = xmlReaderForConsumptions.getFatList().size();
        Assert.assertEquals(excepted,actual);

        actual = xmlReaderForConsumptions.getCalorieList().size();
        Assert.assertEquals(excepted,actual);

    }


    @Test
    public void getDateList() throws Exception {
        List<String> excepted = Arrays.asList("2017.05.22.", "2017.05.23.", "2017.05.24.");
        Assert.assertEquals(excepted,xmlReaderForConsumptions.getDateList());

    }

    @Test
    public void getProteinList() throws Exception {
        List<Double> excepted = Arrays.asList(232.4,60.4,189.4);
        Assert.assertEquals(excepted,xmlReaderForConsumptions.getProteinList());
    }

    @Test
    public void getCarbohydrateList() throws Exception {
        List<Double> excepted = Arrays.asList(100.5,242.1,200.4);
        Assert.assertEquals(excepted,xmlReaderForConsumptions.getCarbohydrateList());
    }

    @Test
    public void getFatList() throws Exception {
        List<Double> excepted = Arrays.asList(20.8,20.8,89.2);
        Assert.assertEquals(excepted,xmlReaderForConsumptions.getFatList());
    }

    @Test
    public void getCalorieList() throws Exception {
        List<Double> excepted = Arrays.asList( 2225.5,1842.4,4242.2);
        Assert.assertEquals(excepted,xmlReaderForConsumptions.getCalorieList());

    }


}
