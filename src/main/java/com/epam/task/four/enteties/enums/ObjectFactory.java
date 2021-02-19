package com.epam.task.four.enteties.enums;


import com.epam.task.four.enteties.*;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlElementDecl;
import javax.xml.bind.annotation.XmlRegistry;
import javax.xml.namespace.QName;

@XmlRegistry
public class ObjectFactory {

    private final static QName PILL_QNAME =
            new QName("http://www.example.com/medicines", "pill");
    private final static QName SYRUP_QNAME =
            new QName("http://www.example.com/medicines", "syrup");
    private final static QName FLAVORED_SYRUP_QNAME =
            new QName("http://www.example.com/medicines", "flavored-syrup");


    public ObjectFactory() {
    }

    public Medicines createMedicines() {
        return new Medicines();
    }

    public Pill createPill() {
        return new Pill();
    }

    public Syrup createSyrup() {
        return new Syrup();
    }

    public FlavoredSyrup createFlavoredSyrup() {
        return new FlavoredSyrup();
    }


    @XmlElementDecl(namespace = "http://www.example.com/medicines", name = "pill")
    public JAXBElement<Pill> createPill(Pill value) {
        return new JAXBElement<Pill>(PILL_QNAME, Pill.class, null, value);
    }

    @XmlElementDecl(namespace = "http://www.example.com/medicines", name = "syrup")

    public JAXBElement<Syrup> createSyrup(Syrup value) {
        return new JAXBElement<Syrup>(SYRUP_QNAME, Syrup.class, null, value);
    }

    @XmlElementDecl(namespace = "http://www.example.com/medicines", name = "flavored-syrup",
            substitutionHeadNamespace = "http://www.example.com/medicines",
            substitutionHeadName = "syrup")
    public JAXBElement<FlavoredSyrup> createFlavoredSyrup(FlavoredSyrup value) {
        return new JAXBElement<FlavoredSyrup>(FLAVORED_SYRUP_QNAME, FlavoredSyrup.class, null, value);
    }
}


