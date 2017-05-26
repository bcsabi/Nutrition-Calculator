package hu.csabi.NutritionCalculator.Models;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * A fogyasztási napló beolvasását megvalósító osztály.
 */
public class XMLReaderForConsumptions {

    /**
     * Az elmentett fogyasztásokat tartalmazó lista.
     */
    private ArrayList<Consumption> consumptions = new ArrayList<>();

    /**
     * Az elmentett fogyasztásokat tartalmazó lista kiürítését megvalósító metódus.
     */
    public void initTheConsumptionsList(){
        this.consumptions = new ArrayList<>();
    }

    /**
     * A függvény az elmentett fogyasztásokat olvassa be a Consumptions xml-ből.
     * @throws Exception A file-ból való beolvasás során keletkezendő kivételek kezelésére.
     */
    public void xmlReader() throws Exception{

        File xmlFile = new File("Consumptions.xml");

        DocumentBuilderFactory documentBuilderFactory = DocumentBuilderFactory.newInstance();
        DocumentBuilder documentBuilder = documentBuilderFactory.newDocumentBuilder();
        Document document = documentBuilder.parse(xmlFile);

        NodeList list = document.getElementsByTagName("Consumptions");
        Node node = list.item(0);
        Element element = (Element) node;

        int iterator = document.getElementsByTagName("Date").getLength();

        for(int i = 0 ; i < iterator; i++)
        {
            if(node.getNodeType() == Node.ELEMENT_NODE)
            {
                Consumption consumption = new Consumption();

                consumption.setDate(element.getElementsByTagName("Date").item(i).getTextContent());
                consumption.setProtein(Double.parseDouble(element.getElementsByTagName("Protein").item(i).getTextContent()));
                consumption.setCarbohydrate(Double.parseDouble(element.getElementsByTagName("Carbohydrate").item(i).getTextContent()));
                consumption.setFat(Double.parseDouble(element.getElementsByTagName("Fat").item(i).getTextContent()));
                consumption.setCalorie(Double.parseDouble(element.getElementsByTagName("Calorie").item(i).getTextContent()));

                consumptions.add(consumption);
            }
        }
    }

    /**
     * Vissza adja a mentett fogyasztási dátumokat tartalmazó listát.
     * @return String típusú List a fogyasztási dátumokkal.
     */
    public List<String> getDateList() {
        return consumptions.stream()
                .map(Consumption::getDate)
                .collect(Collectors.toList());
    }

    /**
     * Visszaadja a mentett fogyasztási dátumokhoz tartozó fehérje beviteleket tartalmazó listát.
     * @return Double típusú List a fogyasztási dátumokhoz tartozó fehérje bevitelekkel.
     */
    public List<Double> getProteinList() {
        return consumptions.stream()
                .map(Consumption::getProtein)
                .collect(Collectors.toList());
    }

    /**
     * Visszaadja a mentett fogyasztási dátumokhoz tartozó szénhidrát beviteleket tartalmazó listát.
     * @return Double típusú List a fogyasztási dátumokhoz tartozó szénhidrát bevitelekkel.
     */
    public List<Double> getCarbohydrateList() {
        return consumptions.stream()
                .map(Consumption::getCarbohydrate)
                .collect(Collectors.toList());
    }

    /**
     * Visszaadja a mentett fogyasztási dátumokhoz tartozó zsír beviteleket tartalmazó listát.
     * @return Double típusú List a fogyasztási dátumokhoz tartozó zsír bevitelekkel.
     */
    public List<Double> getFatList() {
        return consumptions.stream()
                .map(Consumption::getFat)
                .collect(Collectors.toList());
    }

    /**
     * Visszaadja a mentett fogyasztási dátumokhoz tartozó kalória beviteleket tartalmazó listát.
     * @return Double típusú List a fogyasztási dátumokhoz tartozó kalória bevitelekkel.
     */
    public List<Double> getCalorieList() {
        return consumptions.stream()
                .map(Consumption::getCalorie)
                .collect(Collectors.toList());
    }
}
