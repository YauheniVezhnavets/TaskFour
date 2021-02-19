package com.epam.task.four.enteties;

import com.epam.task.four.enteties.enums.MedicineGroup;

import javax.xml.bind.annotation.*;



@XmlAccessorType(XmlAccessType.FIELD)
@XmlType (name = "pill",namespace = "http://www.example.com/medicines")
public class Pill extends Medicine {

    @XmlElement(name = "dosage-milligrams", namespace = "http://www.example.com/medicines", required = true)
    private int dosageMilligrams;

    public Pill(){
    }

    public Pill(String name, MedicineGroup medicineGroup, int shelfLife, int dosageMilligrams) {
        super(name, medicineGroup, shelfLife);
        this.dosageMilligrams = dosageMilligrams;
    }

    public Pill(Medicine current) {
        super(current.getName(),
                current.getMedicineGroup(),
                current.getShelfLife());
    }

    public int getDosageMilligrams() {
        return dosageMilligrams;
    }

    public void setDosageMilligrams(int dosageMilligrams) {
        this.dosageMilligrams = dosageMilligrams;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        if (!super.equals(o)) {
            return false;
        }

        Pill pill = (Pill) o;

        return getDosageMilligrams() == pill.getDosageMilligrams();
    }

    @Override
    public int hashCode() {
        int result = super.hashCode();
        result = 31 * result + getDosageMilligrams();
        return result;
    }

    @Override
    public String toString() {
        return "Pill{" + "dosageMilligrams=" + dosageMilligrams + '}';
    }
}
