package hu.csabi.NutritionCalculator.Controllers;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;


public class ControllerForFoodsXMLTest {

    private ControllerForFoodsXML CFFXML = new ControllerForFoodsXML();

    @Before
    public void setUp() throws Exception {
        CFFXML.loadFoods();
    }


    @Test
    public void loadFoods() throws Exception {
        List<String> excepted = Arrays.asList("White rice", "Chicken breast", "Egg", "Broccoli");
        List<String> actual = CFFXML.loadFoods();

        Assert.assertEquals(excepted,actual);
    }

    @Test
    public void getProteinByIndex() throws Exception {
        double excepted = 21.2;
        double actual = CFFXML.getProteinByIndex(1);

        Assert.assertEquals(excepted,actual,0.01);
    }

    @Test
    public void getCarbohydrateByIndex() throws Exception {
        double excepted = 79.3;
        double actual = CFFXML.getCarbohydrateByIndex(0);

        Assert.assertEquals(excepted,actual,0.01);
    }

    @Test
    public void getFatByIndex() throws Exception {
        double excepted = 9.5;
        double actual = CFFXML.getFatByIndex(2);

        Assert.assertEquals(excepted,actual,0.01);
    }

    @Test
    public void getCalorieByIndex() throws Exception {
        double excepted = 34;
        double actual = CFFXML.getCalorieByIndex(3);

        Assert.assertEquals(excepted,actual,0.01);
    }

    @Test
    public void getFoodByIndexAsString() throws Exception {
        String excepted = "Food name: Chicken breast";
        String actual = CFFXML.getFoodByIndexAsString(1);

        Assert.assertEquals(excepted,actual);

    }

    @Test
    public void getProteinByIndexAsString() throws Exception {
        String excepted = "Protein: 21.20 grams";
        String actual = CFFXML.getProteinByIndexAsString(1);

        Assert.assertEquals(excepted,actual);
    }

    @Test
    public void getCarbohydrateByIndexAsString() throws Exception {
        String excepted = "Carbohydrate: 79.30 grams";
        String actual = CFFXML.getCarbohydrateByIndexAsString(0);

        Assert.assertEquals(excepted,actual);
    }

    @Test
    public void getFatByIndexAsString() throws Exception {
        String excepted = "Fat: 9.50 grams";
        String actual = CFFXML.getFatByIndexAsString(2);

        Assert.assertEquals(excepted,actual);
    }

    @Test
    public void getCalorieByIndexAsString() throws Exception {
        String excepted = "Calorie: 360.00 grams";
        String actual = CFFXML.getCalorieByIndexAsString(0);

        Assert.assertEquals(excepted,actual);
    }


}
