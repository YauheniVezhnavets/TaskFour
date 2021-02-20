package com.epam.task.four.parser;

import com.epam.task.four.enteties.Medicine;
import com.epam.task.four.enteties.Medicines;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.xml.sax.SAXException;

import javax.xml.XMLConstants;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBElement;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;
import javax.xml.validation.Schema;
import javax.xml.validation.SchemaFactory;
import java.io.File;
import java.util.ArrayList;
import java.util.List;

public class JaxbParser implements Parser {
    private static final Logger LOGGER = LogManager.getLogger(JaxbParser.class);
    private static final String SCHEMA_NAME = "src/main/resources/medicines.xsd";


    public List<Medicine> parse(String file) throws ParserException {
        JAXBContext jaxbContext;
        Medicines medicines;
        try {
            jaxbContext = JAXBContext.newInstance(Medicines.class);
            Unmarshaller unmarshaller = jaxbContext.createUnmarshaller();
            SchemaFactory factory = SchemaFactory.newInstance(XMLConstants.W3C_XML_SCHEMA_NS_URI);
            File schemaLocation = new File(SCHEMA_NAME);

            Schema schema = factory.newSchema(schemaLocation);
            unmarshaller.setSchema(schema);
            medicines = (Medicines) unmarshaller.unmarshal(new File(file));
            return  parseMedicines(medicines.getMedicineJaxbElementList());
        } catch (JAXBException | SAXException e) {
            throw new ParserException(e.getMessage(),e);
        }
    }

    public List<Medicine> parseMedicines(List<JAXBElement<? extends Medicine>> medicineList) throws JAXBException {
        List<Medicine> medicines = new ArrayList<>();
        for (JAXBElement element : medicineList) {
            Medicine medicine = (Medicine) element.getValue();
            medicines.add(medicine);
        }
        return medicines;
    }
}



