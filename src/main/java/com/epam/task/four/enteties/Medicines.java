package com.epam.task.four.enteties;




import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.*;
import java.util.ArrayList;
import java.util.List;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlRootElement(name = "medicines")

public class Medicines {
    @XmlElements({
            @XmlElement(name="pill", type=Pill.class),
            @XmlElement(name="syrup", type=Syrup.class),
            @XmlElement(name="flavored-syrup", type=FlavoredSyrup.class)
    })

    private List<Medicine> medicineList;

    public List<Medicine> getMedicineList() {
        if (medicineList == null) {
            medicineList = new ArrayList<Medicine>();
        }
        return this.medicineList;
    }
}

