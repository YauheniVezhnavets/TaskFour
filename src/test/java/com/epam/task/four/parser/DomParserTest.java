package com.epam.task.four.parser;

public class DomParserTest extends ParserTest {

    @Override
    protected Parser createStringProcessor() {
        return new DomParser();
    }
}


