package com.epam.task.four.parser;

public class DomParserTest extends ParserTest {

    @Override
    protected Parser createStringProcessor() {
        return new DomParser();
    }
}


//TaskFour.iml

//<?xml version="1.0" encoding="UTF-8"?>
//<module type="JAVA_MODULE" version="1.8" />