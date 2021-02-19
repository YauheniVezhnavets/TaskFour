package com.epam.task.four.parser;


public class SaxParserTest extends ParserTest {

    @Override
    protected Parser createStringProcessor() {
        return new SaxParser();
    }
}
