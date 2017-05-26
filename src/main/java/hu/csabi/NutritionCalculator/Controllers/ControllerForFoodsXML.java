package hu.csabi.NutritionCalculator.Controllers;

import hu.csabi.NutritionCalculator.Models.XMLReaderForFoods;

import java.nio.file.NoSuchFileException;
import java.util.List;

/**
 * Az XML adatainkat kezelő osztály.
 */
public class ControllerForFoodsXML {

    /**
     * Az XMLReader osztályt meghívó objektum deklarálása.
     */
    private final XMLReaderForFoods xmlReaderForFoods = new XMLReaderForFoods();

    /**
     * Betölti az élelmiszereket és visszaad egy String típusú List-et az élelmiszerek nevével.
     * Meghívja az XMLReader osztályunk xmlReader függvényét, amely beolvassa az XML adatokat,
     * majd visszaadja az élelmiszerek nevét tartalmazó List-et.
     * @return List Az élelmiszerek nevével.
     */
    public List<String> loadFoods() throws Exception
    {
        try {

            xmlReaderForFoods.initTheFoodList();
            xmlReaderForFoods.xmlReader();
        }
        catch (NoSuchFileException e) {
            e.printStackTrace();
        }

        return xmlReaderForFoods.getTheFoodNames();
    }

    /**
     * Adott élelmiszerhez index alapján visszaadja a fehérje mennyiségét.
     * @param index Adott élelmiszerhez tartozó fehérje mennyiségnek az indexe.
     * @return Egy élelmiszerhez tartozó fehérje mennyiség.
     */
    public Double getProteinByIndex(int index){
        return xmlReaderForFoods.getProteinList().get(index);
    }

    /**
     * Adott élelmiszerhez index alapján visszaadja a szénhidrát mennyiségét.
     * @param index Adott élelmiszerhez tartozó szénhidrát mennyiségnek az indexe.
     * @return Egy élelmiszerhez tartozó szénhidrát mennyiség.
     */
    public Double getCarbohydrateByIndex(int index){
        return xmlReaderForFoods.getCarbohydrateList().get(index);
    }

    /**
     * Adott élelmiszerhez index alapján visszaadja a zsír mennyiségét.
     * @param index Adott élelmiszerhez tartozó zsír mennyiségnek az indexe.
     * @return Egy élelmiszerhez tartozó zsír mennyiség.
     */
    public Double getFatByIndex(int index){
        return xmlReaderForFoods.getFatList().get(index);
    }

    /**
     * Adott élelmiszerhez index alapján visszaadja a kalória mennyiségét.
     * @param index Adott élelmiszerhez tartozó kalória mennyiségnek az indexe.
     * @return Egy élelmiszerhez tartozó kalória mennyiség.
     */
    public Double getCalorieByIndex(int index){
        return xmlReaderForFoods.getCalorieList().get(index);
    }

    /**
     * Egy String-et ad vissza, "Food name: " + adott élelmiszer neve index alapján kiválasztva.
     * @param index Az adott élelmiszer indexe.
     * @return String "Food name: " + adott élelmiszer neve.
     */
    public String getFoodByIndexAsString(int index){
        return "Food name: " + xmlReaderForFoods.getTheFoodNames().get(index);
    }

    /**
     * Egy String-et ad vissza, "Protein: x grams", ahol x = adott indexen lévő élelmiszer fehérje mennyisége.
     * @param index Adott élelmiszerhez tartozó fehérje mennyiség indexe.
     * @return String "Protein: x grams", ahol x = adott indexen lévő élelmiszer fehérje mennyisége.
     */
    public String getProteinByIndexAsString(int index){
        return String.format("Protein: %.2f grams", xmlReaderForFoods.getProteinList().get(index));

    }

    /**
     * Egy String-et ad vissza, "Carbohydrate: x grams", ahol x = adott indexen lévő élelmiszer szénhidrát mennyisége.
     * @param index Adott élelmiszerhez tartozó szénhidrát mennyiség indexe.
     * @return String "Carbohydrate: x grams", ahol x = adott indexen lévő élelmiszer szénhidrát mennyisége.
     */
    public String getCarbohydrateByIndexAsString(int index){
        return String.format("Carbohydrate: %.2f grams", xmlReaderForFoods.getCarbohydrateList().get(index));
    }

    /**
     * Egy String-et ad vissza, "Fat: x grams", ahol x = adott indexen lévő élelmiszer zsír mennyisége.
     * @param index Adott élelmiszerhez tartozó zsír mennyiség indexe.
     * @return String "Fat: x grams", ahol x = adott indexen lévő élelmiszer zsír mennyisége.
     */
    public String getFatByIndexAsString(int index){
        return String.format("Fat: %.2f grams", xmlReaderForFoods.getFatList().get(index));
    }

    /**
     * Egy String-et ad vissza, "Calorie: x grams", ahol x = adott indexen lévő élelmiszer kalória mennyisége.
     * @param index Adott élelmiszerhez tartozó kalória mennyiség indexe.
     * @return String "Calorie: x grams", ahol x = adott indexen lévő élelmiszer kalória mennyisége.
     */
    public String getCalorieByIndexAsString(int index){
        return String.format("Calorie %.2f grams", xmlReaderForFoods.getCalorieList().get(index));
    }

}
