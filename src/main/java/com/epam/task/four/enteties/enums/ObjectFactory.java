package com.epam.task.four.enteties.enums;


import com.epam.task.four.enteties.*;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlElementDecl;
import javax.xml.bind.annotation.XmlRegistry;
import javax.xml.namespace.QName;

@XmlRegistry
public class ObjectFactory {

    private final static QName MEDICINE_QNAME =
            new QName("http://www.example.com/medicines", "Medicine");

    private final static QName PILL_QNAME =
            new QName("http://www.example.com/medicines", "Pill");
    private final static QName SYRUP_QNAME =
            new QName("http://www.example.com/medicines", "Syrup");
    private final static QName FLAVORED_SYRUP_QNAME =
            new QName("http://www.example.com/medicines", "FlavoredSyrup");


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


    @XmlElementDecl(namespace = "http://www.example.com/medicines", name = "medicine")
    public JAXBElement<Medicine> createMedicine(Medicine value) {
        return new JAXBElement<>(MEDICINE_QNAME, Medicine.class, null, value);
    }


    @XmlElementDecl(namespace = "http://www.example.com/medicines", name = "pill",
            substitutionHeadNamespace = "http://www.example.com/medicines",
            substitutionHeadName = "medicine")
    public JAXBElement<Pill> createPill(Pill value) {
        return new JAXBElement<>(PILL_QNAME, Pill.class, null, value);
    }

    @XmlElementDecl(namespace = "http://www.example.com/medicines", name = "syrup",
            substitutionHeadNamespace = "http://www.example.com/medicines",
            substitutionHeadName = "medicine")
    public JAXBElement<Syrup> createSyrup(Syrup value) {
        return new JAXBElement<>(SYRUP_QNAME, Syrup.class, null, value);
    }

    @XmlElementDecl(namespace = "http://www.example.com/medicines", name = "flavoring-syrup",
            substitutionHeadNamespace = "http://www.example.com/medicines",
            substitutionHeadName = "medicine")
    public JAXBElement<FlavoredSyrup> createFlavoredSyrup(FlavoredSyrup value) {
        return new JAXBElement<>(FLAVORED_SYRUP_QNAME, FlavoredSyrup.class, null, value);
    }
}


