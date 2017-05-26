package hu.csabi.NutritionCalculator.Models;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import java.io.InputStream;
import java.util.ArrayList;

import java.util.List;
import java.util.stream.Collectors;

/**
 * Az élelmiszerek beolvasását megvalósító osztály.
 */
public class XMLReaderForFoods {

    /**
     * Élelmiszereket tartalmazó lista.
     */
    private ArrayList<Food> foods = new ArrayList<>();

    /**
     * Beállítja az élelmiszereket tartalmazó listát üres listává.
     */
    public void initTheFoodList(){
        this.foods = new ArrayList<>();
    }

    /**
     * Függvény a Foods.xml file olvasására.
     * @throws Exception File-ból való beolvasás során kialakuló kivétel kezelésére.
     */
    public void xmlReader() throws Exception {

        InputStream xmlFile = ClassLoader.class.getResourceAsStream("/hu/csabi/NutritionCalculator/Foods.xml");

        DocumentBuilderFactory documentBuilderFactory = DocumentBuilderFactory.newInstance();
        DocumentBuilder documentBuilder = documentBuilderFactory.newDocumentBuilder();
        Document document = documentBuilder.parse(xmlFile);

        NodeList list = document.getElementsByTagName("Foods");
        Node node = list.item(0);
        Element element = (Element) node;

        int iterator = document.getElementsByTagName("Name").getLength();

        for(int i = 0 ; i < iterator; i++)
        {
            if(node.getNodeType() == Node.ELEMENT_NODE)
            {
                Food food = new Food();

                food.setName(element.getElementsByTagName("Name").item(i).getTextContent());
                food.setProtein(Double.parseDouble(element.getElementsByTagName("Protein").item(i).getTextContent()));
                food.setCarbohydrate(Double.parseDouble(element.getElementsByTagName("Carbohydrate").item(i).getTextContent()));
                food.setFat(Double.parseDouble(element.getElementsByTagName("Fat").item(i).getTextContent()));
                food.setCalorie(Double.parseDouble(element.getElementsByTagName("Calorie").item(i).getTextContent()));

                foods.add(food);
            }
        }
    }

    /**
     * Visszaad egy List-et az élelmiszerek nevével.
     * @return List az élelmiszerek nevével.
     */
    public List<String> getTheFoodNames() {
        return foods.stream()
                .map(Food::getName)
                .collect(Collectors.toList());
    }

    /**
     * Visszaad egy List-et az élelmiszerek fehérje mennyiségével.
     * @return List az élelmiszerek fehérje mennyiségével.
     */
    public List<Double> getProteinList() {
        return foods.stream()
                .map(Food::getProtein)
                .collect(Collectors.toList());
    }

    /**
     * Visszaad egy List-et az élelmiszerek szénhidrát mennyiségével.
     * @return List az élelmiszerek szénhidrát mennyiségével.
     */
    public List<Double> getCarbohydrateList() {
        return foods.stream()
                .map(Food::getCarbohydrate)
                .collect(Collectors.toList());
    }

    /**
     * Visszaad egy List-et az élelmiszerek zsír mennyiségével.
     * @return List az élelmiszerek zsír mennyiségével.
     */
    public List<Double> getFatList() {
        return foods.stream()
                .map(Food::getFat)
                .collect(Collectors.toList());
    }

    /**
     * Visszaad egy List-et az élelmiszerek kalória mennyiségével.
     * @return List az élelmiszerek kalória mennyiségével.
     */
    public List<Double> getCalorieList() {
        return foods.stream()
                .map(Food::getCalorie)
                .collect(Collectors.toList());
    }
}
