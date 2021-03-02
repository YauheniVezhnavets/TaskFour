package com.epam.task.four.validation;

import com.epam.task.four.handlers.MedicineExceptionHandler;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.xml.sax.SAXException;

import javax.xml.XMLConstants;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import javax.xml.validation.Schema;
import javax.xml.validation.SchemaFactory;
import java.io.File;
import java.io.IOException;

public class XmlValidator {

    private static final Logger LOGGER = LogManager.getLogger(XmlValidator.class);
    private String xsdSchema;


    public XmlValidator(String xsdSchema) {
        this.xsdSchema = xsdSchema;
    }

    public boolean isValid(String filename) {

        Schema schema;
        SchemaFactory factory = SchemaFactory.newInstance(XMLConstants.W3C_XML_SCHEMA_NS_URI);
        try {

            schema = factory.newSchema(new File(xsdSchema));
            SAXParserFactory saxParserFactory = SAXParserFactory.newInstance();
            saxParserFactory.setSchema(schema);

            SAXParser parser = saxParserFactory.newSAXParser();

            parser.parse(filename, new MedicineExceptionHandler());
            return true;
        } catch (ParserConfigurationException e) {
            LOGGER.error(filename + " config error: " + e.getMessage(),e);
            return false;
        } catch (SAXException e) {
            LOGGER.error(filename + " SAX error: " + e.getMessage(),e);
            return false;
        } catch (IOException e) {
           LOGGER.error("I/O error: " + e.getMessage(),e);
            return false;
        }
    }
}
