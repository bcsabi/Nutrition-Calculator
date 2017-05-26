package hu.csabi.NutritionCalculator.Models;

/**
 * Az elmentett fogyasztások osztálya.
 */
public class Consumption {

    /**
     * Egy elmentett fogyasztás dátuma.
     */
    private String date;
    /**
     * Egy elmentett fogyasztás dátumához tartozó fehérje bevitel.
     */
    private double protein;
    /**
     * Egy elmentett fogyasztás dátumához tartozó szénhidrát bevitel.
     */
    private double carbohydrate;
    /**
     * Egy elmentett fogyasztás dátumához tartozó zsír bevitel.
     */
    private double fat;
    /**
     * Egy elmentett fogyasztás dátumához tartozó kalória bevitel.
     */
    private double calorie;

    public Consumption(){};

    public Consumption(String date, double protein, double carbohydrate, double fat, double calorie) {
        this.date = date;
        this.protein = protein;
        this.carbohydrate = carbohydrate;
        this.fat = fat;
        this.calorie = calorie;
    }

    /**
     * String formátumban visszaadja egy elmentett fogyasztás dátumát.
     * @return string formátumban egy elmentett fogyasztás dátuma.
     */
    public String getDate() {
        return date;
    }

    /**
     * Beállítja egy elmentett fogyasztáshoz tartozó dátumot.
     * @param date egy elmentett fogyasztáshoz tartozó dátum.
     */
    public void setDate(String date) {
        this.date = date;
    }

    /**
     * Double formátumban visszaadja egy elmentett fogyasztás dátumához tartozó fehérje bevitelt.
     * @return double formátumban egy elmentett fogyasztás dátumához tartozó fehérje bevitel.
     */
    public double getProtein() {
        return protein;
    }

    /**
     * Beállítja egy elmentett fogyasztás dátumához tartozó fehérje bevitelt.
     * @param protein egy elmentett fogyasztás dátumához tartozó fehérje bevitel.
     */
    public void setProtein(double protein) {
        this.protein = protein;
    }

    /**
     * Double formátumban visszaadja egy elmentett fogyasztás dátumához tartozó szénhidrát bevitelt.
     * @return double formátumban egy elmentett fogyasztás dátumához tartozó szénhidrát bevitel.
     */
    public double getCarbohydrate() {
        return carbohydrate;
    }

    /**
     * Beállítja egy elmentett fogyasztás dátumához tartozó szénhidrát bevitelt.
     * @param carbohydrate egy elmentett fogyasztás dátumához tartozó szénhidrát bevitel.
     */
    public void setCarbohydrate(double carbohydrate) {
        this.carbohydrate = carbohydrate;
    }

    /**
     * Double formátumban visszaadja egy elmentett fogyasztás dátumához tartozó zsír bevitelt.
     * @return double formátumban egy elmentett fogyasztás dátumához tartozó zsír bevitel.
     */
    public double getFat() {
        return fat;
    }

    /**
     * Beállítja egy elmentett fogyasztás dátumához tartozó zsír bevitelt.
     * @param fat egy elmentett fogyasztás dátumához tartozó zsír bevitel.
     */
    public void setFat(double fat) {
        this.fat = fat;
    }

    /**
     * Double formátumban visszaadja egy elmentett fogyasztás dátumához tartozó kalória bevitelt.
     * @return double formátumban egy elmentett fogyasztás dátumához tartozó kalória bevitel.
     */
    public double getCalorie() {
        return calorie;
    }

    /**
     * Beállítja egy elmentett fogyasztás dátumához tartozó kalória bevitelt.
     * @param calorie egy elmentett fogyasztás dátumához tartozó kalória bevitel.
     */
    public void setCalorie(double calorie) {
        this.calorie = calorie;
    }


}
