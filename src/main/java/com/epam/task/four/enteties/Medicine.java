package com.epam.task.four.enteties;

import com.epam.task.four.enteties.enums.MedicineGroup;

import javax.xml.bind.annotation.*;


@XmlType(name = "Medicine")
@XmlAccessorType(XmlAccessType.FIELD)
@XmlSeeAlso({
        Pill.class,
        Syrup.class
})

public abstract class Medicine {
    @XmlElement(required = true, namespace = "http://www.example.com/medicines")
    private String name;
    @XmlElement(required = true, namespace = "http://www.example.com/medicines")
    private MedicineGroup medicineGroup;
    @XmlElement(required = true, namespace = "http://www.example.com/medicines")
    private int shelfLife;

    public Medicine() {
    }

    public Medicine(String name, MedicineGroup medicineGroup, int shelfLife) {
        this.name = name;
        this.medicineGroup = medicineGroup;
        this.shelfLife = shelfLife;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public MedicineGroup getMedicineGroup() {
        return medicineGroup;
    }

    public void setMedicineGroup(MedicineGroup medicineGroup) {
        this.medicineGroup = medicineGroup;
    }

    public int getShelfLife() {
        return shelfLife;
    }

    public void setShelfLife(int shelfLife) {
        this.shelfLife = shelfLife;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }

        Medicine medicine = (Medicine) o;

        if (getShelfLife() != medicine.getShelfLife()) {
            return false;
        }
        if (getName() != null ? !getName().equals(medicine.getName()) : medicine.getName() != null) {
            return false;
        }
        return getMedicineGroup() == medicine.getMedicineGroup();
    }

    @Override
    public int hashCode() {
        int result = getName() != null ? getName().hashCode() : 0;
        result = 31 * result + (getMedicineGroup() != null ? getMedicineGroup().hashCode() : 0);
        result = 31 * result + getShelfLife();
        return result;
    }

    @Override
    public String toString() {
        return "Medicine{" + "name='" + name + '\'' + ", medicineGroup=" + medicineGroup +
                ", shelfLife=" + shelfLife + '}';
    }
}
