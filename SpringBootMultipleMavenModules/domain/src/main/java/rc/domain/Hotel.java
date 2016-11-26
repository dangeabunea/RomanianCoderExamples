package rc.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Hotel {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private long id;
    private String name;
    private int classification;
    private boolean isOpen;

    protected Hotel(){}

    public Hotel(String name, int classification, boolean isOpen){
        this.name = name;
        this.classification = classification;
        this.isOpen = isOpen;
    }

    public String getName() {
        return name;
    }

    public int getClassification() {
        return classification;
    }

    public long getId() {
        return id;
    }

    public boolean isOpen() {
        return isOpen;
    }
}
