package com.epam.task.four.enteties;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;


@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "")
@XmlRootElement(name = "medicines")

public class Medicines {

    @XmlElementRef(name = "medicine", namespace = "http://www.example.com/medicines", type = JAXBElement.class)
    private List<JAXBElement<? extends Medicine>> medicineList;

    public List<JAXBElement<? extends Medicine>> getMedicineJaxbElementList() {
        if (medicineList == null) {
            medicineList = new ArrayList<>();
        }
        return this.medicineList;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }

        Medicines medicines = (Medicines) o;

        return Objects.equals(medicineList, medicines.medicineList);
    }

    @Override
    public int hashCode() {
        return medicineList != null ? medicineList.hashCode() : 0;
    }

    @Override
    public String toString() {
        return "Medicines{" + "medicineList=" + medicineList + '}';
    }
}

