package com.epam.task.four.handlers;

import com.epam.task.four.enteties.FlavoredSyrup;
import com.epam.task.four.enteties.Medicine;
import com.epam.task.four.enteties.Pill;
import com.epam.task.four.enteties.Syrup;
import com.epam.task.four.enteties.enums.FlavoringType;
import com.epam.task.four.enteties.enums.MedicineGroup;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.xml.sax.Attributes;
import org.xml.sax.helpers.DefaultHandler;

import java.util.ArrayList;
import java.util.List;

public class MedicineHandler extends DefaultHandler {

    private static final Logger LOGGER = LogManager.getLogger(MedicineHandler.class);

    private static final String PILL = "pill";
    private static final String SYRUP = "syrup";
    private static final String FLAVORED_SYRUP = "flavored-syrup";
    private static final String NAME = "name";
    private static final String MEDICINE_GROUP = "medicine-group";
    private static final String SHELF_LIFE = "shelf-life";
    private static final String DOSAGE_MILLIGRAMS = "dosage-milligrams";
    private static final String VOLUME_MILLILITERS = "volume-milliliters";
    private static final String FLAVORING_TYPE  = "flavoring-type";



    private final List<Medicine> medicines;
    private Medicine current;
    private String currentString;


    public MedicineHandler() {
        medicines = new ArrayList<>();
    }

    public List<Medicine> getMedicines() {
        return medicines;
    }


    @Override
    public void startElement(String uri, String localName, String qName, Attributes attributes)  {
        switch (localName) {
            case PILL:
                current = new Pill();
                break;
            case SYRUP:
                current = new Syrup();
                break;
            case FLAVORED_SYRUP:
                current = new FlavoredSyrup();
                break;
            default:
                currentString = localName.toUpperCase();
            }
        }

    @Override
    public void endElement(String uri, String localName, String qName) {
        if (PILL.equals(localName)||(SYRUP.equals(localName)||(FLAVORED_SYRUP.equals(localName)))){
            medicines.add(current);
        }
    }


    @Override
    public void characters(char[] ch, int start, int length) {
        String stringElement = new String(ch, start, length).trim();
        if (currentString!=null){
            switch (currentString){
                case NAME:
                    current.setName(stringElement);
                    break;
                case MEDICINE_GROUP:
                    MedicineGroup medicineGroup = MedicineGroup.valueOf(stringElement) ;
                    current.setMedicineGroup(medicineGroup);
                    break;
                case SHELF_LIFE:
                    current.setShelfLife(Integer.parseInt(stringElement));
                    break;
                case DOSAGE_MILLIGRAMS:
                    Pill pill = (Pill) current;
                    pill.setDosageMilligrams(Integer.parseInt(stringElement));
                    current = pill;
                    break;
                case VOLUME_MILLILITERS:
                    Syrup syrup = (Syrup) current;
                    syrup.setVolumeMilliliters(Integer.parseInt(stringElement));
                    current = syrup;
                    break;
                case FLAVORING_TYPE:
                    FlavoredSyrup flavoredSyrup = (FlavoredSyrup) current;
                    FlavoringType flavoringType = FlavoringType.valueOf(stringElement.toUpperCase());
                    flavoredSyrup.setFlavoringType(flavoringType);
                    current = flavoredSyrup;
                default:

            }
        }
        currentString = null;
    }
}
