package com.epam.task.four.parser;

public class JaxbParserTest extends ParserTest {

    @Override
    protected Parser createStringProcessor() {
        return new JaxbParser();
    }
}
