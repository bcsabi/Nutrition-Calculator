package hu.csabi.NutritionCalculator.Controllers;

import org.junit.Assert;
import org.junit.Test;


public class ControllerForNutritionCalculatorsTest {

    private ControllerForNutritionCalculators CFNC = new ControllerForNutritionCalculators(225.54,642.90,117.94,4723.42);


    @Test
    public void initTheCounters() throws Exception {
        CFNC.initTheCounters();

        double excepted = 0;
        double actual = CFNC.getProteinCounter();
        Assert.assertEquals(excepted,actual,0.01);

        actual = CFNC.getCarbohydrateCounter();
        Assert.assertEquals(excepted,actual,0.01);

        actual = CFNC.getFatCounter();
        Assert.assertEquals(excepted,actual,0.01);

        actual = CFNC.getCalorieCounter();
        Assert.assertEquals(excepted,actual,0.01);

    }

    @Test
    public void getProteinCounter() throws Exception {
        double excepted = 225.54;
        double actual = CFNC.getProteinCounter();

        Assert.assertEquals(excepted,actual,0.01);
    }

    @Test
    public void setProteinCounter() throws Exception {
        CFNC.setProteinCounter(364.20);
        double excepted = 364.20;
        double actual = CFNC.getProteinCounter();

        Assert.assertEquals(excepted,actual,0.01);
    }

    @Test
    public void getCarbohydrateCounter() throws Exception {
        double excepted = 642.90;
        double actual = CFNC.getCarbohydrateCounter();

        Assert.assertEquals(excepted,actual,0.01);
    }

    @Test
    public void setCarbohydrateCounter() throws Exception {
        CFNC.setCarbohydrateCounter(567.23);
        double excepted = 567.23;
        double actual = CFNC.getCarbohydrateCounter();

        Assert.assertEquals(excepted,actual,0.01);
    }

    @Test
    public void getFatCounter() throws Exception {
        double excepted = 117.94;
        double actual = CFNC.getFatCounter();

        Assert.assertEquals(excepted,actual,0.01);
    }

    @Test
    public void setFatCounter() throws Exception {
        CFNC.setFatCounter(89.42);
        double excepted = 89.42;
        double actual = CFNC.getFatCounter();

        Assert.assertEquals(excepted,actual,0.01);
    }

    @Test
    public void getCalorieCounter() throws Exception {
        double excepted = 4723.42;
        double actual = CFNC.getCalorieCounter();

        Assert.assertEquals(excepted,actual,0.01);
    }

    @Test
    public void setCalorieCounter() throws Exception {
        CFNC.setCalorieCounter(2784.94);
        double excepted = 2784.94;
        double actual = CFNC.getCalorieCounter();

        Assert.assertEquals(excepted,actual,0.01);
    }

    @Test
    public void addToProteinCounter() throws Exception {
        CFNC.addToProteinCounter(17.2,"100");
        double excepted = 242.74;
        double actual = CFNC.getProteinCounter();

        Assert.assertEquals(excepted,actual,0.01);
    }
    @Test
    public void addToCarbohydrateCounter() throws Exception {
        CFNC.addToCarbohydrateCounter(77.8,"100");
        double excepted = 720.7;
        double actual = CFNC.getCarbohydrateCounter();

        Assert.assertEquals(excepted,actual,0.01);
    }

    @Test
    public void addToFatCounter() throws Exception {
        CFNC.addToFatCounter(7.4,"100");
        double excepted = 125.34;
        double actual = CFNC.getFatCounter();

        Assert.assertEquals(excepted,actual,0.01);
    }

    @Test
    public void addToCalorieCounter() throws Exception {
        CFNC.addToCalorieCounter(378.21,"100");
        double excepted = 5101.63;
        double actual = CFNC.getCalorieCounter();

        Assert.assertEquals(excepted,actual,0.01);
    }

    @Test
    public void getProteinCounterAsString() throws Exception {
        String excepted = "Protein: 225.54 grams";
        String actual = CFNC.getProteinCounterAsString();

        Assert.assertEquals(excepted,actual);
    }

    @Test
    public void getCarbohydrateCounterAsString() throws Exception {
        String excepted = "Carbohydrate: 642.90 grams";
        String actual = CFNC.getCarbohydrateCounterAsString();

        Assert.assertEquals(excepted,actual);
    }

    @Test
    public void getFatCounterAsString() throws Exception {
        String excepted = "Fat: 117.94 grams";
        String actual = CFNC.getFatCounterAsString();

        Assert.assertEquals(excepted,actual);
    }

    @Test
    public void getCalorieCounterAsString() throws Exception {
        String excepted = "Calorie: 4723.42 grams";
        String actual = CFNC.getCalorieCounterAsString();

        Assert.assertEquals(excepted,actual);
    }


}
