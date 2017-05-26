package hu.csabi.NutritionCalculator.Models;

import junit.framework.Assert;
import org.junit.Before;
import org.junit.Test;


public class ConsumptionTest {

    private Consumption consumption;

    @Before
    public void setUp() throws Exception{
        consumption = new Consumption("2017.05.25.", 60.4, 100.5,
                20.8,200.5);

    }

    @Test
    public void getDate() throws Exception {
        String excepted = "2017.05.25.";
        String actual = consumption.getDate();
        Assert.assertEquals(excepted,actual);
    }

    @Test
    public void setDate() throws Exception {
        consumption = new Consumption();
        consumption.setDate("2017.04.16.");
        String excepted = "2017.04.16.";
        String actual = consumption.getDate();
        Assert.assertEquals(excepted,actual);

    }

    @Test
    public void getProtein() throws Exception {
        double excepted = 60.4;
        double actual = consumption.getProtein();
        Assert.assertEquals(excepted,actual);
    }

    @Test
    public void setProtein() throws Exception {
        consumption = new Consumption();
        consumption.setProtein(12.5);
        double excepted = 12.5;
        double actual = consumption.getProtein();
        Assert.assertEquals(excepted,actual);

    }

    @Test
    public void getCarbohydrate() throws Exception {
        double excepted = 100.5;
        double actual = consumption.getCarbohydrate();
        Assert.assertEquals(excepted,actual);
    }

    @Test
    public void setCarbohydrate() throws Exception {
        consumption = new Consumption();
        consumption.setCarbohydrate(72.1);
        double excepted = 72.1;
        double actual = consumption.getCarbohydrate();
        Assert.assertEquals(excepted,actual);
    }

    @Test
    public void getFat() throws Exception {
        double excepted = 20.8;
        double actual = consumption.getFat();
        Assert.assertEquals(excepted,actual);
    }

    @Test
    public void setFat() throws Exception {
        consumption = new Consumption();
        consumption.setFat(36.2);
        double excepted = 36.2;
        double actual = consumption.getFat();
        Assert.assertEquals(excepted,actual);
    }

    @Test
    public void getCalorie() throws Exception {
        double excepted = 200.5;
        double actual = consumption.getCalorie();
        Assert.assertEquals(excepted,actual);
    }

    @Test
    public void setCalorie() throws Exception {
        consumption = new Consumption();
        consumption.setCalorie(447.2);
        double excepted = 447.2;
        double actual = consumption.getCalorie();
        Assert.assertEquals(excepted,actual);
    }

}
