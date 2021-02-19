package com.epam.task.four.parser;

public class ParserFactory {


    public Parser create (ParserType type) {


        switch (type) {
            case DOM_PARSER:
                return new DomParser();
            case SAX_PARSER:
                return new SaxParser();
            case JAXB_PARSER:
                return new JaxbParser();
            default:
                throw new EnumConstantNotPresentException(
                        type.getDeclaringClass(), type.name());
        }
    }
}
