package com.epam.task.four.enteties;


import javax.xml.bind.annotation.*;
import java.util.ArrayList;
import java.util.List;



@XmlRootElement (name = "medicines", namespace = "http://www.example.com/medicines")
@XmlAccessorType(XmlAccessType.FIELD)
public class Medicines {

    @XmlElements({
            @XmlElement(name = "pill", namespace = "http://www.example.com/medicines", type = Pill.class),
            @XmlElement(name = "syrup", namespace = "http://www.example.com/medicines", type = Syrup.class),
            @XmlElement(name = "flavored-syrup", namespace = "http://www.example.com/medicines", type = FlavoredSyrup.class)
    })



    private List <Medicine> medicines = new ArrayList<>();

    public Medicines() {
    }

    public List<Medicine> getMedicines() {
        return medicines;
    }

    public void setMedicines(List<Medicine> medicines) {
        this.medicines = medicines;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Medicines medicines1 = (Medicines) o;

        return getMedicines() != null ? getMedicines().equals(medicines1.getMedicines()) : medicines1.getMedicines() == null;
    }

    @Override
    public int hashCode() {
        return getMedicines() != null ? getMedicines().hashCode() : 0;
    }
}

