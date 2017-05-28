package hu.csabi.NutritionCalculator.Models;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;

public class XMLReaderForFoodsTest {

    private XMLReaderForFoods xmlReaderForFoods = new XMLReaderForFoods();

    @Before
    public void setUp() throws Exception{
        xmlReaderForFoods.xmlReader();
    }


    @Test
    public void initTheFoodList() throws Exception {
        xmlReaderForFoods.initTheFoodList();

        int excepted = 0;
        int actual = xmlReaderForFoods.getTheFoodNames().size();
        Assert.assertEquals(excepted,actual);

        actual= xmlReaderForFoods.getProteinList().size();
        Assert.assertEquals(excepted,actual);

        actual= xmlReaderForFoods.getCarbohydrateList().size();
        Assert.assertEquals(excepted,actual);

        actual= xmlReaderForFoods.getFatList().size();
        Assert.assertEquals(excepted,actual);

        actual= xmlReaderForFoods.getCalorieList().size();
        Assert.assertEquals(excepted,actual);

    }

    @Test
    public void xmlReader() throws Exception {
        xmlReaderForFoods.initTheFoodList();
        xmlReaderForFoods.xmlReader();

        int excepted = 4;
        int actual = xmlReaderForFoods.getTheFoodNames().size();

        Assert.assertEquals(excepted,actual);
    }

    @Test
    public void getTheFoodNames() throws Exception {
        List<String> excepted = Arrays.asList("White rice", "Chicken breast", "Egg", "Broccoli");
        List<String> actual = xmlReaderForFoods.getTheFoodNames();

        Assert.assertEquals(excepted,actual);

    }

    @Test
    public void getProteinList() throws Exception {
        List<Double> excepted = Arrays.asList(6.6,21.2,12.6,2.8);
        List<Double> actual = xmlReaderForFoods.getProteinList();

        Assert.assertEquals(excepted,actual);

    }

    @Test
    public void getCarbohydrateList() throws Exception {
        List<Double> excepted = Arrays.asList(79.3,0.0,1.8,6.6);
        List<Double> actual = xmlReaderForFoods.getCarbohydrateList();

        Assert.assertEquals(excepted,actual);
    }

    @Test
    public void getFatList() throws Exception {
        List<Double> excepted = Arrays.asList(0.6,2.6,9.5,0.3);
        List<Double> actual = xmlReaderForFoods.getFatList();

        Assert.assertEquals(excepted,actual);
    }

    @Test
    public void getCalorieList() throws Exception {
        List<Double> excepted = Arrays.asList(360.0,124.0,143.0,34.0);
        List<Double> actual = xmlReaderForFoods.getCalorieList();

        Assert.assertEquals(excepted,actual);
    }



}
