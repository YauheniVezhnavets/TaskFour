package com.epam.task.four.enteties;

import com.epam.task.four.enteties.enums.FlavoringType;
import com.epam.task.four.enteties.enums.MedicineGroup;

import javax.xml.bind.annotation.*;


@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "FlavoredSyrup")
public class FlavoredSyrup extends Syrup {

    @XmlElement(name="flavoring-type", required = true, namespace = "http://www.example.com/medicines")
    private FlavoringType flavoring;

    public FlavoredSyrup() {
    }

    public FlavoredSyrup(String name, MedicineGroup medicineGroup, int shelfLife, int volumeMilliliters,
                         FlavoringType flavoring) {
        super(name, medicineGroup, shelfLife, volumeMilliliters);
        this.flavoring = flavoring;
    }

    public FlavoringType getFlavoringType() {
        return flavoring;
    }

    public void setFlavoringType(FlavoringType flavoring) {
        this.flavoring = flavoring;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;

        FlavoredSyrup that = (FlavoredSyrup) o;

        return flavoring == that.flavoring;
    }

    @Override
    public int hashCode() {
        int result = super.hashCode();
        result = 31 * result + (flavoring != null ? flavoring.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "FlavoredSyrup{" + "flavoring=" + flavoring + '}';
    }
}




