package com.epam.task.four.validation;

import org.junit.Assert;
import org.junit.Test;

public class XmlValidationTest {
    private static final String PATH_TO_XSD = "src/main/resources/medicines.xsd";
    private static final String VALID_XML = "src/main/resources/medicines.xml";
    private static final String INVALID_XML = "src/main/resources/Medicine.xml";

    private XmlValidator validator = new XmlValidator(PATH_TO_XSD);

    @Test
    public void testXmlValidatorShouldPassWhenCorrectFile() {
        boolean result = validator.isValid(VALID_XML);

        Assert.assertTrue(result);
    }

    @Test
    public void testXmlValidatorShouldPassWhenInvalidFile() {
        boolean result = validator.isValid(INVALID_XML);

        Assert.assertFalse(result);
    }
}
