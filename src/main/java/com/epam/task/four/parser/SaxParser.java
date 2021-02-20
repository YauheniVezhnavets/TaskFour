package com.epam.task.four.parser;

import com.epam.task.four.enteties.Medicine;
import com.epam.task.four.handlers.MedicineHandler;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.xml.sax.SAXException;
import org.xml.sax.XMLReader;
import org.xml.sax.helpers.XMLReaderFactory;

import java.io.IOException;
import java.util.List;

public class SaxParser implements Parser {
    private static final Logger LOGGER = LogManager.getLogger(SaxParser.class);


    public List<Medicine> parse(String file) throws ParserException {
        List<Medicine> medicines;
        final MedicineHandler medicineHandler = new MedicineHandler();

        try {
            XMLReader xmlReader = XMLReaderFactory.createXMLReader();
            xmlReader.setContentHandler(medicineHandler);
            xmlReader.parse(file);
            return medicines = medicineHandler.getMedicines();
        } catch (SAXException | IOException e) {
            throw new ParserException(e.getMessage(), e);
        }
    }
}
