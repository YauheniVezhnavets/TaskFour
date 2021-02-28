package com.epam.task.four.enteties;

import com.epam.task.four.enteties.enums.MedicineGroup;

import javax.xml.bind.annotation.*;


@XmlAccessorType(XmlAccessType.FIELD)
@XmlSeeAlso({FlavoredSyrup.class})
@XmlType(name = "Syrup")
public class Syrup extends Medicine {

    @XmlElement(name="volume-milliliters", required = true, namespace = "http://www.example.com/medicines")
    private int volumeMilliliters;

    public Syrup() {
    }

    public Syrup(String name, MedicineGroup medicineGroup, int shelfLife, int volumeMilliliters) {
        super(name, medicineGroup, shelfLife);
        this.volumeMilliliters = volumeMilliliters;
    }

    public int getVolumeMilliliters() {
        return volumeMilliliters;
    }

    public void setVolumeMilliliters(int volumeMilliliters) {
        this.volumeMilliliters = volumeMilliliters;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;

        Syrup syrup = (Syrup) o;

        return getVolumeMilliliters() == syrup.getVolumeMilliliters();
    }

    @Override
    public int hashCode() {
        int result = super.hashCode();
        result = 31 * result + getVolumeMilliliters();
        return result;
    }

    @Override
    public String toString() {
        return "Syrup{" + "volumeMilliliters=" + volumeMilliliters + '}';
    }
}
