package hu.csabi.NutritionCalculator.Models;

/**
 * Az élelmiszerek osztálya.
 */
public class Food {

    /**
     * Az élelmiszer neve.
     */
    private String name;
    /**
     * Az élelmiszerhez tartozó fehérje mennyiség 100g-ban.
     */
    private double protein;
    /**
     * Az élelmiszerhez tartozó szénhidrát mennyiség 100g-ban.
     */
    private double carbohydrate;
    /**
     * Az élelmiszerhez tartozó zsír mennyiség 100g-ban.
     */
    private double fat;
    /**
     * Az élelmiszerhez tartozó kalória mennyiség 100g-ban.
     */
    private double calorie;

    public Food(){};

    public Food(String name, double protein, double carbohydrate, double fat, double calorie) {
        this.name = name;
        this.protein = protein;
        this.carbohydrate = carbohydrate;
        this.fat = fat;
        this.calorie = calorie;
    }

    /**
     * Visszaadja egy élelmiszer nevét.
     * @return egy élelmiszer neve.
     */
    public String getName() {
        return name;
    }

    /**
     * Beállítja egy élelmiszer nevét.
     * @param name egy élelmiszer neve.
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * Double formátumban visszaadja egy élelmiszerben lévő fehérje mennyiséget 100g-ban.
     * @return egy double érték egy élelmiszer 100g-ban lévő fehérje mennyiségével.
     */
    public double getProtein() {
        return protein;
    }

    /**
     * Beállítja egy élelmiszer 100g-ban lévő fehérje mennyiségét.
     * @param protein egy double érték egy élelmiszer 100g-ban lévő fehérje mennyiségével.
     */
    public void setProtein(double protein) {
        this.protein = protein;
    }

    /**
     * Double formátumban visszaadja egy élelmiszerben lévő szénhidrát mennyiséget 100g-ban.
     * @return egy double érték egy élelmiszer 100g-ban lévő szénhidrát mennyiségével.
     */
    public double getCarbohydrate() {
        return carbohydrate;
    }

    /**
     * Beállítja egy élelmiszer 100g-ban lévő szénhidrát mennyiségét.
     * @param carbohydrate egy double érték egy élelmiszer 100g-ban lévő szénhidrát mennyiségével.
     */
    public void setCarbohydrate(double carbohydrate) {
        this.carbohydrate = carbohydrate;
    }

    /**
     * Double formátumban visszaadja egy élelmiszerben lévő zsír mennyiséget 100g-ban.
     * @return egy double érték egy élelmiszer 100g-ban lévő zsír mennyiségével.
     */
    public double getFat() {
        return fat;
    }

    /**
     * Beállítja egy élelmiszer 100g-ban lévő zsír mennyiségét.
     * @param fat egy double érték egy élelmiszer 100g-ban lévő zsír mennyiségével.
     */
    public void setFat(double fat) {
        this.fat = fat;
    }

    /**
     * Double formátumban visszaadja egy élelmiszerben lévő kalória mennyiséget 100g-ban.
     * @return egy double érték egy élelmiszer 100g-ban lévő kalória mennyiségével.
     */
    public double getCalorie() {
        return calorie;
    }

    /**
     * Beállítja egy élelmiszer 100g-ban lévő kalória mennyiségét.
     * @param calorie egy double érték egy élelmiszer 100g-ban lévő kalória mennyiségével.
     */
    public void setCalorie(double calorie) {
        this.calorie = calorie;
    }


}
