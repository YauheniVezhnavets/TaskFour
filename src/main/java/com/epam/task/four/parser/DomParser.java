package com.epam.task.four.parser;

import com.epam.task.four.enteties.FlavoredSyrup;
import com.epam.task.four.enteties.Medicine;
import com.epam.task.four.enteties.Pill;
import com.epam.task.four.enteties.Syrup;
import com.epam.task.four.enteties.enums.FlavoringType;
import com.epam.task.four.enteties.enums.MedicineGroup;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class DomParser implements Parser {
    private static final Logger LOGGER = LogManager.getLogger(DomParser.class);


    public List<Medicine> parse(String file) throws ParserException {
        List<Medicine> medicines=new ArrayList<>();

        try {
            DocumentBuilderFactory documentBuilderFactory = DocumentBuilderFactory.newInstance();
            DocumentBuilder documentBuilder = documentBuilderFactory.newDocumentBuilder();
            Document document = documentBuilder.parse(file);
            Element root = document.getDocumentElement();


            NodeList pillList = root.getElementsByTagName("pill");
            for (int i = 0; i < pillList.getLength(); i++) {
                Element pillElement = (Element) pillList.item(i);
                Medicine medicine = buildPill(pillElement);
                medicines.add(medicine);
            }
            NodeList syrupList = root.getElementsByTagName("syrup");
            for (int j = 0; j < syrupList.getLength(); j++) {
                Element syrupElement = (Element) syrupList.item(j);
                Medicine medicine = buildSyrup(syrupElement);
                medicines.add(medicine);
            }
            NodeList flavoredSyrupList = root.getElementsByTagName("flavored-syrup");
            for (int k = 0; k < flavoredSyrupList.getLength(); k++) {
                Element flavoredSyrupElement = (Element) flavoredSyrupList.item(k);
                Medicine medicine = buildFlavoredSyrup(flavoredSyrupElement);
                medicines.add(medicine);
            }

        } catch (ParserConfigurationException | SAXException | IOException e) {
            throw new ParserException(e.getMessage(),e);
        }
        return medicines;
    }


    private Pill buildPill(Element pillElement) {
        Pill pill = new Pill();
        String name = getElementTextContent(pillElement, "name");
        pill.setName(name);
        String medicineGroupSting = getElementTextContent(pillElement, "medicine-group");
        MedicineGroup medicineGroup = MedicineGroup.valueOf(medicineGroupSting);
        pill.setMedicineGroup(medicineGroup);
        String shelfLife = getElementTextContent(pillElement, "shelf-life");
        pill.setShelfLife(Integer.parseInt(shelfLife));
        String dosageMilligrams = getElementTextContent(pillElement, "dosage-milligrams");
        pill.setDosageMilligrams(Integer.parseInt(dosageMilligrams));
        return pill;
    }

    private Syrup buildSyrup(Element syrupElement) {
        Syrup syrup = new Syrup();
        String name = getElementTextContent(syrupElement, "name");
        syrup.setName(name);
        String medicineGroupSting = getElementTextContent(syrupElement, "medicine-group");
        MedicineGroup medicineGroup = MedicineGroup.valueOf(medicineGroupSting);
        syrup.setMedicineGroup(medicineGroup);
        String shelfLife = getElementTextContent(syrupElement, "shelf-life");
        syrup.setShelfLife(Integer.parseInt(shelfLife));
        String volumeMilliliters = getElementTextContent(syrupElement, "volume-milliliters");
        syrup.setVolumeMilliliters(Integer.parseInt(volumeMilliliters));
        return syrup;
    }

    private FlavoredSyrup buildFlavoredSyrup(Element flavoredSyrupElement) {
        FlavoredSyrup flavoredSyrup = new FlavoredSyrup();
        String name = getElementTextContent(flavoredSyrupElement, "name");
        flavoredSyrup.setName(name);
        String medicineGroupSting = getElementTextContent(flavoredSyrupElement, "medicine-group");
        MedicineGroup medicineGroup = MedicineGroup.valueOf(medicineGroupSting);
        flavoredSyrup.setMedicineGroup(medicineGroup);
        String shelfLife = getElementTextContent(flavoredSyrupElement, "shelf-life");
        flavoredSyrup.setShelfLife(Integer.parseInt(shelfLife));
        String volumeMilliliters = getElementTextContent(flavoredSyrupElement, "volume-milliliters");
        flavoredSyrup.setVolumeMilliliters(Integer.parseInt(volumeMilliliters));
        String flavoringTypeString = getElementTextContent(flavoredSyrupElement, "flavoring-type");
        FlavoringType flavoringType = FlavoringType.valueOf(flavoringTypeString.toUpperCase());
        flavoredSyrup.setFlavoringType(flavoringType);
        return flavoredSyrup;
    }


    private static String getElementTextContent(Element element, String elementName) {
        NodeList nList = element.getElementsByTagName(elementName);
        Node node = nList.item(0);
        return node.getTextContent();
    }
}
