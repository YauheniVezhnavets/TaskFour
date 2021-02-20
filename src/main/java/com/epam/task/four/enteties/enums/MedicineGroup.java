package com.epam.task.four.enteties.enums;


import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlEnumValue;
import javax.xml.bind.annotation.XmlType;

@XmlType(name = "medicine-group")
@XmlEnum
public enum  MedicineGroup {

    @XmlEnumValue("VITAMINS")
    VITAMINS,

    @XmlEnumValue("ANTIBIOTICS")
    ANTIBIOTICS,

    @XmlEnumValue("PAIN_RELIVERS")
    PAIN_RELIVERS;

}
