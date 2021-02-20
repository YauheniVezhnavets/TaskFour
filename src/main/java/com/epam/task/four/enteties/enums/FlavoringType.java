package com.epam.task.four.enteties.enums;


import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlEnumValue;
import javax.xml.bind.annotation.XmlType;

@XmlType(name = "flavoring-type")
@XmlEnum
public enum FlavoringType {

    @XmlEnumValue("LIME")
    LIME,

    @XmlEnumValue("CHERRY")
    CHERRY,

    @XmlEnumValue("APPLE")
    APPLE,

    @XmlEnumValue("ORANGE")
    ORANGE;

}
