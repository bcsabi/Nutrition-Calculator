package hu.csabi.NutritionCalculator.Models;

import org.junit.Before;
import org.junit.Test;

import junit.framework.Assert;

public class FoodTest {

    private Food food;

    @Before
    public void setUp()throws Exception{
        food = new Food("Szalonna", 17.2, 2.3 , 24.3 , 376.2);
    }

    @Test
    public void getName() throws Exception {
        String excepted = "Szalonna";
        String actual = food.getName();
        Assert.assertEquals(excepted,actual);
    }

    @Test
    public void setName() throws Exception {
        food = new Food();
        food.setName("Paprika");
        String excepted = "Paprika";
        String actual = food.getName();
        Assert.assertEquals(excepted,actual);
    }

    @Test
    public void getProtein() throws Exception {
        double excepted = 17.2;
        double actual = food.getProtein();
        Assert.assertEquals(excepted,actual);
    }

    @Test
    public void setProtein() throws Exception {
        food = new Food();
        food.setProtein(0.7);
        double excepted = 0.7;
        double actual = food.getProtein();
        Assert.assertEquals(excepted,actual);
    }

    @Test
    public void getCarbohydrate() throws Exception {
        double excepted = 2.3;
        double actual = food.getCarbohydrate();
        Assert.assertEquals(excepted,actual);
    }

    @Test
    public void setCarbohydrate() throws Exception {
        food = new Food();
        food.setCarbohydrate(4.2);
        double excepted = 4.2;
        double actual = food.getCarbohydrate();
        Assert.assertEquals(excepted,actual);

    }

    @Test
    public void getFat() throws Exception {
        double excepted = 24.3;
        double actual = food.getFat();
        Assert.assertEquals(excepted,actual);
    }

    @Test
    public void setFat() throws Exception {
        food = new Food();
        food.setFat(0.1);
        double excepted = 0.1;
        double actual = food.getFat();
        Assert.assertEquals(excepted,actual);
    }

    @Test
    public void getCalorie() throws Exception {
        double excepted = 376.2;
        double actual = food.getCalorie();
        Assert.assertEquals(excepted,actual);
    }

    @Test
    public void setCalorie() throws Exception {
        food = new Food();
        food.setCalorie(162.9);
        double excepted = 162.9;
        double actual = food.getCalorie();
        Assert.assertEquals(excepted,actual);
    }


}
