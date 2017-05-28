package hu.csabi.NutritionCalculator.Controllers;

/**
 * A nutrition calculator-t kezelő osztály.
 */
public class ControllerForNutritionCalculators {

    /**
     * Változó deklarálása az elfogyasztott élelmiszerek fehérje mennyiségének az összegzésére.
     */
    private double proteinCounter = 0;
    /**
     * Változó deklarálása az elfogyasztott élelmiszerek szénhidrát mennyiségének az összegzésére.
     */
    private double carbohydrateCounter = 0;
    /**
     * Változó deklarálása az elfogyasztott élelmiszerek zsír mennyiségének az összegzésére.
     */
    private double fatCounter = 0;
    /**
     * Változó deklarálása az elfogyasztott élelmiszerek kalória mennyiségének az összegzésére.
     */
    private double calorieCounter = 0;

    /**
     * Az elfogyasztott ételek tápértékeinek összegzésére használt változók nullázása, az az kezdő értékre állítás.
     */
    public void initTheCounters(){
        this.proteinCounter = 0;
        this.carbohydrateCounter = 0;
        this.fatCounter = 0;
        this.calorieCounter = 0;
    }

    /**
     * Empty Constructor.
     */
    public ControllerForNutritionCalculators() {

    }

    /**
     * Constructor.
     * @param proteinCounter fehérje bevitel számláló.
     * @param carbohydrateCounter szénhidrát bevitel számláló.
     * @param fatCounter zsír bevitel számláló.
     * @param calorieCounter kalória bevitel számláló.
     */
    public ControllerForNutritionCalculators(double proteinCounter, double carbohydrateCounter, double fatCounter, double calorieCounter) {
        this.proteinCounter = proteinCounter;
        this.carbohydrateCounter = carbohydrateCounter;
        this.fatCounter = fatCounter;
        this.calorieCounter = calorieCounter;
    }

    /**
     * Visszaadja az elfogyasztott élelmiszerek fehérje mennyiségének az összegét.
     * @return az elfogyasztott élelmiszerek fehérje mennyiségének az össege.
     */
    public double getProteinCounter() {
        return proteinCounter;
    }

    /**
     * Beállítja az elfogyasztott élelmiszerek fehérje mennyiségének az összegét.
     * @param proteinCounter az elfogyasztott élelmiszerek fehérje mennyiségének az összege.
     */
    public void setProteinCounter(double proteinCounter) {
        this.proteinCounter = proteinCounter;
    }

    /**
     * Visszaadja az elfogyasztott élelmiszerek szénhidrát mennyiségének az összegét.
     * @return az elfogyasztott élelmiszerek szénhidrát mennyiségének az össege.
     */
    public double getCarbohydrateCounter() {
        return carbohydrateCounter;
    }

    /**
     * Beállítja az elfogyasztott élelmiszerek szénhidrát mennyiségének az összegét.
     * @param carbohydrateCounter az elfogyasztott élelmiszerek szénhidrát mennyiségének az összege.
     */
    public void setCarbohydrateCounter(double carbohydrateCounter) {
        this.carbohydrateCounter = carbohydrateCounter;
    }

    /**
     * Visszaadja az elfogyasztott ételek zsír mennyiségének az összegét.
     * @return az elfogyasztott ételek zsír mennyiségének az összege.
     */
    public double getFatCounter() {
        return fatCounter;
    }

    /**
     * Beállítja az elfogyasztott ételek zsír mennyiségének az összegét.
     * @param fatCounter az elfogyasztott ételek zsír mennyiségének az összege.
     */
    public void setFatCounter(double fatCounter) {
        this.fatCounter = fatCounter;
    }

    /**
     * Visszaadja az elfogyasztott ételek kalória mennyiségének az összegét.
     * @return az elfogyasztott ételek kalória mennyiségének az összege.
     */
    public double getCalorieCounter() {
        return calorieCounter;
    }

    /**
     * Beállítja az elfogyasztott ételek kalória mennyiségének az összegét.
     * @param calorieCounter az elfogyasztott ételek kalória mennyiségének az összege.
     */
    public void setCalorieCounter(double calorieCounter) {
        this.calorieCounter = calorieCounter;
    }

    /**
     * Hozzáadja az elfogyasztott étel fehérje mennyiségét a proteinCounter-höz.
     * @param protein az elfogyasztott étel fehérje mennyisége.
     * @param quantity az elfogyasztott mennyiség.
     */
    public void addToProteinCounter(double protein, String quantity){
        this.proteinCounter += protein / 100 * Double.parseDouble(quantity);
    }

    /**
     * Hozzáadja az elfogyasztott étel szénhidrát mennyiségét a carbohydrateCounter-höz.
     * @param carbohydrate az elfogyasztott étel szénhidrát értéke.
     * @param quantity az elfogyasztott mennyiség.
     */
    public void addToCarbohydrateCounter(double carbohydrate, String  quantity){
        this.carbohydrateCounter += carbohydrate / 100 * Double.parseDouble(quantity);
    }

    /**
     * Hozzáadja az elfogyasztott étel zsír mennyiségét a fatCounter-höz.
     * @param fat az elfogyasztott étel zsír mennyisége.
     * @param quantity az elfogyasztott mennyiség.
     */
    public void addToFatCounter(double fat, String quantity){
        this.fatCounter += fat / 100 * Double.parseDouble(quantity);
    }

    /**
     * Hozzáadja az elfogyasztott étel kalória mennyiségét a calorieCounter-höz.
     * @param calorie az elfogyasztott étel kalória mennyisége.
     * @param quantity az elfogyasztott mennyiség.
     */
    public void addToCalorieCounter(double calorie, String quantity){
        this.calorieCounter += calorie / 100 * Double.parseDouble(quantity);
    }

    /**
     * Egy String-et ad vissza, "Protein: x grams" , ahol x = 2 tizedesjegyig az összesített fehérje bevitel.
     * @return String formátumban, "Protein: x grams", ahol x = 2 tizedesjegyig az összesített fehérje bevitel.
     */
    public String getProteinCounterAsString(){
        return String.format("Protein: %.2f grams", proteinCounter);
    }

    /**
     * Egy String-et ad vissza, "Carbohydrate: x grams" , ahol x = 2 tizedesjegyig az összesített szénhidrát bevitel.
     * @return String formátumban, "Carbohydrate: x grams", ahol x = 2 tizedesjegyig az összesített szénhidrát bevitel.
     */
    public String getCarbohydrateCounterAsString(){
        return String.format("Carbohydrate: %.2f grams", carbohydrateCounter);
    }

    /**
     * Egy String-et ad vissza, "Fat: x grams" , ahol x = 2 tizedesjegyig az összesített zsír bevitel.
     * @return String formátumban, "Fat: x grams", ahol x = 2 tizedesjegyig az összesített zsír bevitel.
     */
    public String getFatCounterAsString(){
        return String.format("Fat: %.2f grams", fatCounter);
    }

    /**
     * Egy String-et ad vissza, "Calorie: x grams" , ahol x = 2 tizedesjegyig az összesített kalória bevitel.
     * @return String formátumban, "Calorie: x grams", ahol x = 2 tizedesjegyig az összesített kalória bevitel.
     */
    public String getCalorieCounterAsString(){
        return String.format("Calorie: %.2f grams", calorieCounter);
    }





}
