package rc.noteit.model;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.util.UUID;

@Entity
public class NotebookColor {
    @Id
    private UUID id;
    private String hexCode;
    private String name;


    protected NotebookColor() {
        this.id = UUID.randomUUID();
    }

    public NotebookColor(String name, String hexCode) {
        this();
        this.name = name;
        this.hexCode = hexCode;
    }


    public static String defaultColorHexCode(){
        return "#06749A";
    }


    public UUID getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getHexCode() {
        return hexCode;
    }
}
