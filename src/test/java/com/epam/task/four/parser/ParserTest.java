package com.epam.task.four.parser;

import com.epam.task.four.enteties.FlavoredSyrup;
import com.epam.task.four.enteties.Medicine;
import com.epam.task.four.enteties.Pill;
import com.epam.task.four.enteties.Syrup;
import com.epam.task.four.enteties.enums.FlavoringType;
import com.epam.task.four.enteties.enums.MedicineGroup;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;

public abstract class ParserTest {
    private Parser parser = createStringProcessor();


    private static final String VALID_XML = "src/main/resources/medicines.xml";
    private static final String INVALID_XML = "src/main/resources/Medicine.xml";

    protected abstract Parser createStringProcessor();



    private final static List<Medicine> EXPECTED = Arrays.asList(
            new Pill("Ibuclin", MedicineGroup.ANTIBIOTICS, 5, 10),
            new Syrup("Pikovit", MedicineGroup.VITAMINS,   2, 200),
            new FlavoredSyrup("Doctor Mom", MedicineGroup.PAIN_RELIVERS, 2, 200, FlavoringType.LIME));



    @Before
    public void init() {
        parser = createStringProcessor();
    }

    @Test
    public void testParseShouldParseWhenXmlFileIsCorrect() throws ParserException {
        List<Medicine> actual = parser.parse(VALID_XML);
        Assert.assertEquals(EXPECTED, actual);
    }

    @Test(expected = ParserException.class)
    public void testParseShouldThrowExceptionWhenXmlInvalid() throws ParserException {
        parser.parse(INVALID_XML);
    }
}



