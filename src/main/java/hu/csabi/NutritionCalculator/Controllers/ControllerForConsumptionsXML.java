package hu.csabi.NutritionCalculator.Controllers;

import hu.csabi.NutritionCalculator.Models.XMLReaderForConsumptions;
import hu.csabi.NutritionCalculator.Models.XMLWriterForConsumptions;

import java.time.LocalDate;
import java.util.List;


/**
 * A fogyasztási naplót vezérlő osztály.
 */
public class ControllerForConsumptionsXML {

    /**
     * Az XMLReaderForConsumptions osztályt meghívó objektum deklarálása.
     */
    private XMLReaderForConsumptions xmlReaderForConsumptions = new XMLReaderForConsumptions();
    /**
     * Az XMLWriterForConsumptions osztályt meghívó objektum deklarálása.
     */
    private XMLWriterForConsumptions xmlWriterForConsumptions = new XMLWriterForConsumptions();

    /**
     * Betölti az elmentett dátumokhoz tartozó tápérték beviteleket majd vissza ad egy listát a fogyasztási dátumokkal.
     * Az elmentett fogyasztásokat tartalmazó listát beállítja üres listára, majd meghívja
     * az XMLReaderForConsumptions osztály xmlReader függvényét, amely feltölti ezen listát
     * az elmentett fogyasztási adatokkal. Visszaadja a beolvasott dátumokat.
     * @return egy String típusú List a fogyasztási dátumokkal.
     */
    public List<String> loadDates() throws Exception {
        try{
            xmlReaderForConsumptions.initTheConsumptionsList();
            xmlReaderForConsumptions.xmlReader();
        }
        catch (Exception e){
            e.printStackTrace();
        }

        return xmlReaderForConsumptions.getDateList();
    }

    /**
     * Az elfogyasztott tápértékek mentését megvalósító függvény.
     * A függvény meghívja az XMLWriterForConsumptions xmlWriter függvényét,
     * amely megpróbálja kiírni a Consumtions.xml-be az adott nap
     * dátumát (pl.: 2017.04.15) és a dátumhoz tartozó tápérték fogyasztásokat.
     * Ha nem sikerül akkor meghívja az XMLWRiterForConumptions xmlCreator függvényét,
     * majd újra megpróbálja kiírni a Consumtions.xml-be menteni kívánt adatokat.
     * @param protein a bevitt fehérje mennyiség.
     * @param carbohydrate a bevitt szénhidrát mennyiség.
     * @param fat a bevitt zsír mennyiség.
     * @param calorie a bevitt calória mennyiség.
     * @throws Exception az XML létrehozásakor, írásakor kivétel keletkezhet.
     */
    public void saveConsumptions(double protein, double carbohydrate, double fat, double calorie) throws Exception {

        LocalDate today = LocalDate.now();
        String date = today.toString().replace("-",".");

        if(xmlReaderForConsumptions.getDateList().contains(date)){
            xmlWriterForConsumptions.xmlModify(xmlReaderForConsumptions.getDateList().indexOf(date), String.format("%.2f", protein),
                    String.format("%.2f",carbohydrate),String.format("%.2f",fat),String.format("%.2f",calorie));
        }
        else {
            try {
                xmlWriterForConsumptions.xmlWriter(date, String.format("%.2f", protein),
                        String.format("%.2f", carbohydrate), String.format("%.2f", fat), String.format("%.2f", calorie));
            }
            catch (Exception e) {
                try {
                    xmlWriterForConsumptions.xmlCreator();
                    xmlWriterForConsumptions.xmlWriter(date, String.format("%.2f", protein),
                            String.format("%.2f", carbohydrate), String.format("%.2f", fat), String.format("%.2f", calorie));
                }
                catch (Exception e2) {
                    e2.printStackTrace();
                }
            }
        }
    }

    /**
     * Visszaadja a kiválasztott dátumhoz tartozó fehérje bevitelt.
     * @param index A kiválasztott dátum indexe.
     * @return Double formátumban a kiválasztott dátumhoz tartozó fehérje bevitel.
     */
    public double getProteinByDate(int index){
        return xmlReaderForConsumptions.getProteinList().get(index);
    }

    /**
     * Visszaadja a kiválasztott dátumhoz tartozó szénhidrát bevitelt.
     * @param index A kiválasztott dátum indexe.
     * @return Double formátumban a kiválasztott dátumhoz tartozó szénhidrát bevitel.
     */
    public double getCarbohydrateByDate(int index){
        return xmlReaderForConsumptions.getCarbohydrateList().get(index);
    }

    /**
     * Visszaadja a kiválasztott dátumhoz tartozó zsír bevitelt.
     * @param index A kiválasztott dátum indexe.
     * @return Double formátumban a kiválasztott dátumhoz tartozó zsír bevitel.
     */
    public double getFatByDate(int index){
        return xmlReaderForConsumptions.getFatList().get(index);
    }

    /**
     * Visszaadja a kiválasztott dátumhoz tartozó kalória bevitelt.
     * @param index A kiválasztott dátum indexe.
     * @return Double formátumban a kiválasztott dátumhoz tartozó kalória bevitel.
     */
    public double getCalorieByDate(int index){
        return xmlReaderForConsumptions.getCalorieList().get(index);
    }

    /**
     * Egy String-et ad vissza, "Protein: x grams", ahol x = a kiválasztott dátumhoz tartozó fehérje bevitel.
     * @param index A kiválasztott dátum indexe.
     * @return Egy String, "Protein: x grams", ahol x = a kiválasztott dátumhoz tartozó fehérje bevitel.
     */
    public String getProteinByDateAsString(int index){
        return String.format("Protein: %.2f grams",xmlReaderForConsumptions.getProteinList().get(index));
    }

    /**
     * Egy String-et ad vissza, "Carbohydrate: x grams", ahol x = a kiválasztott dátumhoz tartozó szénhidrát bevitel.
     * @param index A kiválasztott dátum indexe.
     * @return Egy String, "Carbohydrate: x grams", ahol x = a kiválasztott dátumhoz tartozó szénhidrát bevitel.
     */
    public String getCarbohydrateByDateAsString(int index){
        return String.format("Carbohydrate: %.2f grams",xmlReaderForConsumptions.getCarbohydrateList().get(index));
    }

    /**
     * Egy String-et ad vissza, "Fat: x grams", ahol x = a kiválasztott dátumhoz tartozó zsír bevitel.
     * @param index A kiválasztott dátum indexe.
     * @return Egy String, "Fat: x grams", ahol x = a kiválasztott dátumhoz tartozó zsír bevitel.
     */
    public String getFatByDateAsString(int index){
        return String.format("Fat: %.2f grams",xmlReaderForConsumptions.getFatList().get(index));
    }

    /**
     * Egy String-et ad vissza, "Calorie: x grams", ahol x = a kiválasztott dátumhoz tartozó kalória bevitel.
     * @param index A kiválasztott dátum indexe.
     * @return Egy String, "Calorie: x grams", ahol x = a kiválasztott dátumhoz tartozó kalória bevitel.
     */
    public String getCalorieByDateAsString(int index){
        return String.format("Calorie: %.2f grams",xmlReaderForConsumptions.getCalorieList().get(index));
    }


}
