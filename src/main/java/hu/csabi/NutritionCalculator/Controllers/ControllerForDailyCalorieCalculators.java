package hu.csabi.NutritionCalculator.Controllers;

/**
 * A napi kalória szükséglet kalkulátort kezelő osztály.
 */
public class ControllerForDailyCalorieCalculators {

    /**
     * A felhasználó alapanyagcseréjének (BMR) értékét tárolja.
     */
    private double bmr = 0;
    /**
     * A felhasználó testsúlyának megörzéséhez javasolt kalória mennyiséget tárolja.
     */
    private double calorieToMaintainWeight = 0;
    /**
     * A felhasználó testsúlyának csökkentéséhez javasolt kalória mennyiséget tárolja.
     */
    private double calorieToLoseWeight = 0;
    /**
     * A felhasználó testsúlyának növeléséhez javasolt kalória mennyiséget tárolja.
     */
    private double calorieToGainWeight = 0;

    /**
     * Metric BMR formula szerint (kg,cm) számoló függvény.
     * A függvény képes a felhasználó kalóriaszükségletének a  kiszámítására
     * a felhasználó neme, kora, testsúlya, magassága és sportolási aktivitása szerint.
     * Férfi:
     * BMR = 66 + (13.7 x weight in kg) + (5 x height in cm) - (6.8 x age in years)
     * Teljes energiagiény = BMR * X , ahol X = {1.2 ; 1.375 ; 1.55 ; 1.725; 1.9} sportolási aktivitástól függően.
     * Női:
     * BMR = 655 + (9.6 x weight in kg) + (1.8 x height in cm) - (4.7 x age in years)
     * Teljes energiagiény = BMR * X , ahol X = {1.2 ; 1.375 ; 1.55 ; 1.725; 1.9} sportolási aktivitásfól függően.
     * Forrás http://www.healthyweightforum.org/eng/weight-loss/calories-need.asp
     * @param age a felhasználó életkora.
     * @param gender a felhasználó neme.
     * @param weight a felhasználó testsúlya.
     * @param height a felhasználó magassága.
     * @param train a felhasználó aktivitása.
     */
    public void metricBMRFormula(int age, String gender, int weight, int height, int train){

        double active;

        if(gender.equals("Male"))
        {
            if(train < 1) {active = 1.2;}
            else if(train < 3) {active = 1.375;}
            else if(train < 5) {active = 1.55;}
            else if(train < 6) {active = 1.725;}
            else {active = 1.9;}
            bmr = (66 + (13.7 * weight) + (5 * height) - (6.8 * age));
            calorieToMaintainWeight = bmr * active;
            calorieToLoseWeight = calorieToMaintainWeight - 550;
            calorieToGainWeight = calorieToMaintainWeight + 550;
        }

        else
        {
            if(train < 1) {active = 1.2;}
            else if(train < 3) {active = 1.375;}
            else if(train < 5) {active = 1.55;}
            else if(train < 6) {active = 1.725;}
            else {active = 1.9;}
            bmr = (655 + (9.6 * weight) + (1.8 * height) - (4.7 * age));
            calorieToMaintainWeight = bmr * active;
            calorieToLoseWeight = calorieToMaintainWeight - 550;
            calorieToGainWeight = calorieToMaintainWeight + 550;
        }

    }

    /**
     * English BMR formula szerint (lb/in) számoló függvény.
     * A függvény képes a felhasználó kalóriaszükségletének a kiszámítására
     * a felhasználó neme, kora, testsúlya, magassága és sportolási aktivitása szerint.
     * Férfi:
     * BMR = 66 + (6.23 x weight in pounds) + (12.7 x height in inches) - (6.8 x age in years)
     * Teljes energiagiény = BMR * X , ahol X = {1.2 ; 1.375 ; 1.55 ; 1.725; 1.9} sportolási aktivitásfól függően.
     * Női:
     * BMR = 655 + (4.35 x weight in pounds) + (4.7 x height in inches) - (4.7 x age in years)
     * Teljes energiaigény = BMR * X , ahol X = {1.2 ; 1.375 ; 1.55 ; 1.725; 1.9} sportolási aktivitásfól függően.
     * Forrás: http://www.healthyweightforum.org/eng/weight-loss/calories-need.asp
     * @param age a felhasználó életkora.
     * @param gender a felhasználó neme.
     * @param weight a felhasználó testsúlya.
     * @param height a felhasználó magassága.
     * @param train a felhasználó aktivitása.
     */

    public void englishBMRFormula(int age, String gender, int weight, int height, int train)
    {
        double active;

        if(gender.equals("Male"))
        {
            if(train < 1) {active = 1.2;}
            else if(train < 3) {active = 1.375;}
            else if(train < 5) {active = 1.55;}
            else if(train < 6) {active = 1.725;}
            else {active = 1.9;}
            bmr = (66 + (6.23 * weight) + (12.7 * height) - (6.8 * age));
            calorieToMaintainWeight = bmr * active;
            calorieToLoseWeight = calorieToMaintainWeight - 550;
            calorieToGainWeight = calorieToMaintainWeight + 550;

        }

        else
        {
            if(train < 1) {active = 1.2;}
            else if(train < 3) {active = 1.375;}
            else if(train < 5) {active = 1.55;}
            else if(train < 6) {active = 1.725;}
            else {active = 1.9;}
            bmr = (655 + (4.35 * weight) + (4.7 * height) - (4.7 * age));
            calorieToMaintainWeight = bmr * active;
            calorieToLoseWeight = calorieToMaintainWeight - 550;
            calorieToGainWeight = calorieToMaintainWeight + 550;

        }
    }

    /**
     * Visszaadja double formátumban a felhasználó alapanyagcseréjének az értékét.
     * @return double formátumban a felhasználó alapanyagcseréjének az értéke.
     */
    public double getBMR() {
        return bmr;
    }

    /**
     * Beállítja a felhasználó alapanyagcseréjének (BMR) az értékét.
     * @param bmr a felhasználó alapanyagcseréjének az értéke.
     */
    public void setBMR(double bmr) {
        this.bmr = bmr;
    }

    /**
     * Visszaadja double formátumban a felhasználó testsúlyának megörzéséhez javasolt kalória mennyiséget.
     * @return double formátumban a felhasználó testsúlyának megörzéséhez javasolt kalória mennyiség.
     */
    public double getCalorieToMaintainWeight() {
        return calorieToMaintainWeight;
    }

    /**
     * Beállítja a felhasználó testsúlyának megörzéséhez javasolt kalória mennyiséget.
     * @param calorieToMaintainWeight a felhasználó testsúlyának megörzéséhez javasolt kalória mennyiség.
     */
    public void setCalorieToMaintainWeight(double calorieToMaintainWeight) {
        this.calorieToGainWeight = calorieToMaintainWeight;
    }

    /**
     * Visszaadja double formátumban a felhasználó testsúlyának csökkentéséhez javasolt kalória bevitelt.
     * @return double formátumban a felhasználó testsúlyának csökkentéséhez javasolt kalória bevitel.
     */
    public double getCalorieToLoseWeight() {
        return calorieToLoseWeight;
    }

    /**
     * Beállítja a felhasználó testsúlyának csökkentéséhez javasolt kalória mennyiséget.
     * @param calorieToLoseWeight a felhasználó testsúlyának csökkentéséhez javasolt kalória mennyiség.
     */
    public void setCalorieToLoseWeight(double calorieToLoseWeight) {
        this.calorieToLoseWeight = calorieToLoseWeight;
    }

    /**
     * Visszaadja double formátumban a felhasználó testsúlyának növeléséhez javasolt kalória bevitelt.
     * @return double formátumban a felhasználó testsúlyának növeléséhez javasolt kalória bevitel.
     */
    public double getCalorieToGainWeight() {
        return calorieToGainWeight;
    }

    /**
     * Beállítja a felhasználó testsúlyának növeléséhez javasolt kalória mennyiséget.
     * @param calorieToGainWeight a felhasználó testsúlyának növeléséhez javasolt kalória mennyiség.
     */
    public void setCalorieToGainWeight(double calorieToGainWeight) {
        this.calorieToGainWeight = calorieToGainWeight;
    }

    /**
     * Visszaadja 2 tizedesjegyig, String formátumban a felhasználó alapanyagcseréjének az értékét.
     * @return 2 tizedesjegyig, String formátumban a felhasználó alapanyagcseréjének az értéke.
     */
    public String getBMRAsString(){
        return String.format("%.2f", this.bmr);
    }

    /**
     * Visszaadja 2 tizedesjegyig, String formátumban a felhasználó testsúlyának megörzéséhez javasolt kalória bevitelt.
     * @return 2 tizedesjegyig, String formátumban a felhasználó testsúlyának megörzéséhez javasolt kalória bevitel.
     */
    public String getCalorieToMaintainWeightAsString(){
        return String.format("%.2f", this.calorieToMaintainWeight);
    }

    /**
     * Visszaadja 2 tizedesjegyig, String formátumban a felhasználó testsúlyának csökkentéséhez javasolt kalória bevitelt.
     * @return 2 tizedesjegyig, String formátumban a felhasználó testsúlyának csökkentéséhez javasolt kalória bevitel.
     */
    public String getCalorieToLoseWeightAsString(){
        return String.format("%.2f", this.calorieToLoseWeight);
    }

    /**
     * Visszaadja 2 tizedesjegyig, String formátumban a felhasználó testsúlyának növeléséhez javasolt kalória bevitelt.
     * @return 2 tizedesjegyig, String formátumban a felhasználó testsúlyának növeléséhez javasolt kalória bevitel.
     */
    public String getCalorieToGainWeightAsString(){
        return String.format("%.2f", this.calorieToGainWeight);
    }

    /**
     * Visszaadja 2 tizedesjegyig, String formátumban a felhasználó testsúlyának megörzéséhez javasolt fehérje bevitelt.
     * @return 2 tizedesjegyig, String formátumban a felhasználó testsúlyának megörzéséhez javasolt fehérje bevitel.
     */
    public String getProteinToMaintainWeightAsString(){
        return String.format("%.2f", this.calorieToMaintainWeight * 0.15 / 4);
    }

    /**
     * Visszaadja 2 tizedesjegyig, String formátumban a felhasználó testsúlyának megörzéséhez javasolt szénhidrát bevitelt.
     * @return 2 tizedesjegyig, String formátumban a felhasználó testsúlyának megörzéséhez javasolt szénhidrát bevitel.
     */
    public String getCarbohydrateToMaintainWeightAsString(){
        return String.format("%.2f", this.calorieToMaintainWeight * 0.55 / 4);
    }

    /**
     * Visszaadja 2 tizedesjegyig, String formátumban a felhasználó testsúlyának megörzéséhez javasolt zsír bevitelt.
     * @return 2 tizedesjegyig, String formátumban a felhasználó testsúlyának megörzéséhez javasolt zsír bevitel.
     */
    public String getFatToMaintainWeightAsString(){
        return String.format("%.2f", this.calorieToMaintainWeight * 0.30 / 9);
    }

    /**
     * Visszaadja 2 tizedesjegyig, String formátumban a felhasználó testsúlyának csökkentéséhez javasolt fehérje bevitelt.
     * @return 2 tizedesjegyig, String formátumban a felhasználó testsúlyának csökkentéséhez javasolt fehérje bevitel.
     */
    public String getProteinToLoseWeightAsString(){
        return String.format("%.2f", this.calorieToLoseWeight * 0.15 / 4);
    }

    /**
     * Visszaadja 2 tizedesjegyig, String formátumban a felhasználó testsúlyának csökkentéséhez javasolt szénhidrát bevitelt.
     * @return 2 tizedesjegyig, String formátumban a felhasználó testsúlyának csökkentéséhez javasolt szénhidrát bevitel.
     */
    public String getCarbohydrateToLoseWeightAsString(){
        return String.format("%.2f", this.calorieToLoseWeight * 0.55 / 4);
    }

    /**
     * Visszaadja 2 tizedesjegyig, String formátumban a felhasználó testsúlyának csökkentéséhez javasolt zsír bevitelt.
     * @return 2 tizedesjegyig, String formátumban a felhasználó testsúlyának csökkentéséhez javasolt zsír bevitel.
     */
    public String getFatToLoseWeightAsString(){
        return String.format("%.2f", this.calorieToLoseWeight * 0.30 / 9);
    }

    /**
     * Visszaadja 2 tizedesjegyig, String formátumban a felhasználó testsúlyának növeléséhez javasolt fehérje bevitelt.
     * @return 2 tizedesjegyig, String formátumban a felhasználó testsúlyának növeléséhez javasolt fehérje bevitel.
     */
    public String getProteinToGainWeightAsString(){
        return String.format("%.2f", this.calorieToGainWeight * 0.15 / 4);
    }

    /**
     * Visszaadja 2 tizedesjegyig, String formátumban a felhasználó testsúlyának növeléséhez javasolt szénhidrát bevitelt.
     * @return 2 tizedesjegyig, String formátumban a felhasználó testsúlyának növeléséhez javasolt szénhidrát bevitel.
     */
    public String getCarbohydrateToGainWeighAsString(){
        return String.format("%.2f", this.calorieToGainWeight * 0.55 / 4);
    }

    /**
     * Vissza adja 2 tizedesjegyig, String formátumban a felhasználó testsúlyának növeléséhez javasolt zsír bevitelt.
     * @return 2 tizedesjegyig, String formátumban a felhasználó testsúlyának növeléséhez javasolt zsír bevitel.
     */
    public String getFatToGainWeightAsString(){
        return String.format("%.2f", this.calorieToGainWeight * 0.30 / 9);
    }
}
