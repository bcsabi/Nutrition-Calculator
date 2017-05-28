package hu.csabi.NutritionCalculator.Controllers;

import hu.csabi.NutritionCalculator.Models.Consumption;
import hu.csabi.NutritionCalculator.Models.XMLReaderForConsumptions;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;


public class ControllerForConsumptionsXMLTest {

    private Consumption consumption = new Consumption("2015.05.26", 224.5, 478.2, 98,3785);
    private ControllerForConsumptionsXML CFCXML = new ControllerForConsumptionsXML();
    private ArrayList<Consumption> consumptions = new ArrayList<>();

    @Before
    public void setUp(){
        consumptions.add(consumption);
        XMLReaderForConsumptions xmlReaderForConsumptions = new XMLReaderForConsumptions(consumptions);
    }

    @Test
    public void getProteinByDate() throws Exception {
        double excepted = 224.5;
        double actual = CFCXML.getProteinByDate(0);

        Assert.assertEquals(excepted,actual,0.01);
    }

    @Test
    public void getCarbohydrateByDate() throws Exception {
        double excepted = 478.2;
        double actual = CFCXML.getCarbohydrateByDate(0);

        Assert.assertEquals(excepted,actual,0.01);
    }

    @Test
    public void getFatByDate() throws Exception {
        double excepted = 98;
        double actual = CFCXML.getFatByDate(0);

        Assert.assertEquals(excepted,actual,0.01);
    }

    @Test
    public void getCalorieByDate() throws Exception {
        double excepted = 3785;
        double actual = CFCXML.getCalorieByDate(0);

        Assert.assertEquals(excepted,actual,0.01);
    }

    @Test
    public void getProteinByDateAsString() throws Exception {
        String excepted = "Protein: 224.50 grams";
        String actual = CFCXML.getProteinByDateAsString(0);

        Assert.assertEquals(excepted,actual);

    }

    @Test
    public void getCarbohydrateByDateAsString() throws Exception {
        String excepted = "Carbohydrate: 478.20 grams";
        String actual = CFCXML.getCarbohydrateByDateAsString(0);

        Assert.assertEquals(excepted,actual);
    }

    @Test
    public void getFatByDateAsString() throws Exception {
        String excepted = "Fat: 98.00 grams";
        String actual = CFCXML.getFatByDateAsString(0);

        Assert.assertEquals(excepted,actual);
    }

    @Test
    public void getCalorieByDateAsString() throws Exception {
        String excepted = "Calorie: 3785.00 grams";
        String actual = CFCXML.getCalorieByDateAsString(0);

        Assert.assertEquals(excepted,actual);
    }



}
