package hu.csabi.NutritionCalculator.Models;
import org.w3c.dom.*;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.transform.OutputKeys;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import java.io.File;

/**
 * A fogyasztási napló XML formátumú létrehozását és módosítását megvalósító osztály.
 */
public class XMLWriterForConsumptions {


    /**
     * A fogyasztási napló létrehozására alkalmas függvény.
     * @throws Exception a kivételek kezelésére.
     */
    public void xmlCreator() throws Exception {

        DocumentBuilderFactory documentBuilderFactory = DocumentBuilderFactory.newInstance();
        DocumentBuilder documentBuilder = documentBuilderFactory.newDocumentBuilder();
        Document document = documentBuilder.newDocument();

        Element rootElement = document.createElement("Consumptions");
        document.appendChild(rootElement);

        TransformerFactory transformerFactory = TransformerFactory.newInstance();
        Transformer transformer = transformerFactory.newTransformer();
        DOMSource source = new DOMSource(document);
        StreamResult result = new StreamResult(new File("Consumptions.xml"));


        transformer.transform(source, result);


    }

    /**
     * A fogyasztási napló bővítésére alkalmas függvény.
     * @param date Az adott dátum, amikor a mentést elvégeztük.
     * @param protein A bevitt fehérje mennyiség.
     * @param carbohydrate A bevitt szénhidrát mennyiség.
     * @param fat A bevitt zsír mennyiség.
     * @param calorie A bevitt kalória mennyiség.
     * @throws Exception a kivételek kezelésére.
     */
    public void xmlWriter(String date, String protein, String carbohydrate, String fat, String calorie) throws Exception{

        String xmlFile = "Consumptions.xml";

        DocumentBuilderFactory documentBuilderFactory = DocumentBuilderFactory.newInstance();
        DocumentBuilder documentBuilder = documentBuilderFactory.newDocumentBuilder();
        Document document = documentBuilder.parse(xmlFile);

        Node rootElement = document.getFirstChild();

        Text lineBreak = document.createTextNode("\n\t");
        rootElement.appendChild(lineBreak);

        Element dateElement = document.createElement("Date");
        dateElement.appendChild(document.createTextNode(date));
        rootElement.appendChild(dateElement);

        Element proteinElement = document.createElement("Protein");
        proteinElement.appendChild(document.createTextNode(protein));
        rootElement.appendChild(proteinElement);

        Element carbohydrateElement = document.createElement("Carbohydrate");
        carbohydrateElement.appendChild(document.createTextNode(carbohydrate));
        rootElement.appendChild(carbohydrateElement);

        Element fatElement = document.createElement("Fat");
        fatElement.appendChild(document.createTextNode(fat));
        rootElement.appendChild(fatElement);

        Element calorieElement = document.createElement("Calorie");
        calorieElement.appendChild(document.createTextNode(calorie));
        rootElement.appendChild(calorieElement);

        TransformerFactory transformerFactory = TransformerFactory.newInstance();
        Transformer transformer = transformerFactory.newTransformer();
        DOMSource source = new DOMSource(document);
        StreamResult result = new StreamResult(new File(xmlFile));

        transformer.setOutputProperty(OutputKeys.INDENT,"yes");

        transformer.setOutputProperty("{http://xml.apache.org/xslt}indent-amount", "4");
        transformer.transform(source, result);

    }

    public void xmlModify(int index, String protein, String carbohydrate, String fat, String calorie) throws Exception{

        String xmlFile = "Consumptions.xml";

        DocumentBuilderFactory documentBuilderFactory = DocumentBuilderFactory.newInstance();
        DocumentBuilder documentBuilder = documentBuilderFactory.newDocumentBuilder();
        Document document = documentBuilder.parse(xmlFile);

        NodeList list = document.getElementsByTagName("Consumptions");
        Node node = list.item(0);
        Element element = (Element) node;

        element.getElementsByTagName("Protein").item(index).setTextContent(protein);
        element.getElementsByTagName("Carbohydrate").item(index).setTextContent(carbohydrate);
        element.getElementsByTagName("Fat").item(index).setTextContent(fat);
        element.getElementsByTagName("Calorie").item(index).setTextContent(calorie);

        TransformerFactory transformerFactory = TransformerFactory.newInstance();
        Transformer transformer = transformerFactory.newTransformer();
        DOMSource source = new DOMSource(document);
        StreamResult result = new StreamResult(new File(xmlFile));

        transformer.transform(source, result);

    }
}
