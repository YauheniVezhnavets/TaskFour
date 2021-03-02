package com.epam.task.four.parser;

import com.epam.task.four.enteties.Medicine;

import java.util.List;

public interface Parser {

    List <Medicine> parse (String file) throws ParserException;
}
