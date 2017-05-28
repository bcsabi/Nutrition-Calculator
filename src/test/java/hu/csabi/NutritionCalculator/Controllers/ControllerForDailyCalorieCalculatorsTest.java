package hu.csabi.NutritionCalculator.Controllers;

import junit.framework.Assert;
import org.junit.Before;
import org.junit.Test;


public class ControllerForDailyCalorieCalculatorsTest {

    private ControllerForDailyCalorieCalculators CFDCC = new ControllerForDailyCalorieCalculators();

    @Before
    public void setUp(){
        CFDCC.metricBMRFormula(24,"Male",90,182,5);
    }


    @Test
    public void metricBMRFormula() throws Exception {
        //BMR = 66 + (13.7 x weight in kg) + (5 x height in cm) - (6.8 x age in years)
        CFDCC.metricBMRFormula(20,"Male",120,185,5);

        double exceptedBMR = 66 + (13.7 * 120) + (5 * 185) - (6.8 * 20);
        double actualBMR = CFDCC.getBMR();
        Assert.assertEquals(exceptedBMR,actualBMR,0.01);

        double exceptedCalorieToMaintainWeight = (66 + (13.7 * 120) + (5 * 185) - (6.8 * 20)) * 1.725;
        double actualCalorieToMaintainWeight = CFDCC.getCalorieToMaintainWeight();
        Assert.assertEquals(exceptedCalorieToMaintainWeight,actualCalorieToMaintainWeight,0.01);
    }

    @Test
    public void englishBMRFormula() throws Exception {
        //BMR = 655 + (4.35 x weight in pounds) + (4.7 x height in inches) - (4.7 x age in years)
        CFDCC.englishBMRFormula(18,"Female", 57, 145,3);

        double exceptedBMR = 655 + (4.35 * 57) + (4.7 * 145) - (4.7 * 18);
        double actualBMR = CFDCC.getBMR();
        Assert.assertEquals(exceptedBMR,actualBMR,0.01);

        double exceptedCalorieToMaintainWeight = (655 + (4.35 * 57) + (4.7 * 145) - (4.7 * 18)) * 1.55;
        double actualCalorieToMaintainWeight = CFDCC.getCalorieToMaintainWeight();
        Assert.assertEquals(exceptedCalorieToMaintainWeight,actualCalorieToMaintainWeight,0.01);
    }

    @Test
    public void getBMR() throws Exception {
        double excepted = 66 + (13.7 * 90) + (5 * 182) - (6.8 * 24);
        double actual = CFDCC.getBMR();

        Assert.assertEquals(excepted,actual);
    }

    @Test
    public void setBMR() throws Exception {
        CFDCC.setBMR(2010);
        double excepted = 2010;
        double actual = CFDCC.getBMR();

        Assert.assertEquals(excepted,actual);
    }

    @Test
    public void getCalorieToMaintainWeight() throws Exception {
        double excepted = (66 + (13.7 * 90) + (5 * 182) - (6.8 * 24)) * 1.725;
        double actual = CFDCC.getCalorieToMaintainWeight();

        Assert.assertEquals(excepted,actual);

    }

    @Test
    public void setCalorieToMaintainWeight() throws Exception {
        CFDCC.setCalorieToMaintainWeight(2450.5);
        double excepted = 2450.5;
        double actual = CFDCC.getCalorieToGainWeight();

        Assert.assertEquals(excepted,actual);
    }

    @Test
    public void getCalorieToLoseWeight() throws Exception {
        double excepted = (66 + (13.7 * 90) + (5 * 182) - (6.8 * 24)) * 1.725 - 550;
        double actual = CFDCC.getCalorieToLoseWeight();

        Assert.assertEquals(excepted,actual);
    }

    @Test
    public void setCalorieToLoseWeight() throws Exception {
        CFDCC.setCalorieToLoseWeight(2450.5);
        double excepted = 2450.5;
        double actual = CFDCC.getCalorieToLoseWeight();

        Assert.assertEquals(excepted,actual);
    }

    @Test
    public void getCalorieToGainWeight() throws Exception {
        double excepted = (66 + (13.7 * 90) + (5 * 182) - (6.8 * 24)) * 1.725 + 550;
        double actual = CFDCC.getCalorieToGainWeight();

        Assert.assertEquals(excepted,actual);
    }

    @Test
    public void setCalorieToGainWeight() throws Exception {
        CFDCC.setCalorieToGainWeight(2450.5);
        double excepted = 2450.5;
        double actual = CFDCC.getCalorieToGainWeight();

        Assert.assertEquals(excepted,actual);
    }

    @Test
    public void getBMRAsString() throws Exception {
        String excepted = "2045.80";
        String actual = CFDCC.getBMRAsString();

        Assert.assertEquals(excepted,actual);
    }

    @Test
    public void getCalorieToMaintainWeightAsString() throws Exception {
        String excepted = "3529.01";
        String actual = CFDCC.getCalorieToMaintainWeightAsString();

        Assert.assertEquals(excepted,actual);
    }

    @Test
    public void getCalorieToLoseWeightAsString() throws Exception {
        String excepted = "2979.01";
        String actual = CFDCC.getCalorieToLoseWeightAsString();

        Assert.assertEquals(excepted,actual);
    }

    @Test
    public void getCalorieToGainWeightAsString() throws Exception {
        String excepted = "3529.01";
        String actual = CFDCC.getCalorieToMaintainWeightAsString();

        Assert.assertEquals(excepted,actual);
    }

    @Test
    public void getProteinToMaintainWeightAsString() throws Exception {
        String excepted = "132.34";
        String actual = CFDCC.getProteinToMaintainWeightAsString();

        Assert.assertEquals(excepted,actual);
    }

    @Test
    public void getCarbohydrateToMaintainWeightAsString() throws Exception {
        String excepted = "485.24";
        String actual = CFDCC.getCarbohydrateToMaintainWeightAsString();

        Assert.assertEquals(excepted,actual);
    }

    @Test
    public void getFatToMaintainWeightAsString() throws Exception {
        String excepted = "117.63";
        String actual = CFDCC.getFatToMaintainWeightAsString();

        Assert.assertEquals(excepted,actual);
    }

    @Test
    public void getProteinToLoseWeightAsString() throws Exception {
        String excepted = "111.71";
        String actual = CFDCC.getProteinToLoseWeightAsString();

        Assert.assertEquals(excepted,actual);
    }

    @Test
    public void getCarbohydrateToLoseWeightAsString() throws Exception {
        String excepted = "409.61";
        String actual = CFDCC.getCarbohydrateToLoseWeightAsString();

        Assert.assertEquals(excepted,actual);
    }

    @Test
    public void getFatToLoseWeightAsString() throws Exception {
        String excepted = "99.30";
        String actual = CFDCC.getFatToLoseWeightAsString();

        Assert.assertEquals(excepted,actual);
    }

    @Test
    public void getProteinToGainWeightAsString() throws Exception {
        String excepted = "152.96";
        String actual = CFDCC.getProteinToGainWeightAsString();

        Assert.assertEquals(excepted,actual);
    }

    @Test
    public void getCarbohydrateToGainWeighAsString() throws Exception {
        String excepted = "560.86";
        String actual = CFDCC.getCarbohydrateToGainWeighAsString();

        Assert.assertEquals(excepted,actual);
    }

    @Test
    public void getFatToGainWeightAsString() throws Exception {
        String excepted = "135.97";
        String actual = CFDCC.getFatToGainWeightAsString();

        Assert.assertEquals(excepted,actual);
    }


}
