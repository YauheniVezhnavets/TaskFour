package com.epam.task.four;


import com.epam.task.four.enteties.Medicine;
import com.epam.task.four.parser.Parser;
import com.epam.task.four.parser.ParserException;
import com.epam.task.four.validation.XmlValidator;

import java.util.ArrayList;
import java.util.List;

public class Director {
    private XmlValidator xmlValidator;
    private Parser parser;

    public Director(XmlValidator xmlValidator, Parser parser) {
        this.xmlValidator = xmlValidator;
        this.parser = parser;
    }

    public List<Medicine> parse (String fileName) throws ParserException {
        if(xmlValidator.isValid(fileName)){
            return  parser.parse(fileName);
        }
        return new ArrayList<>();
    }
}
