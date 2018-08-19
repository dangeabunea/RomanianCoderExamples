package rc.noteit.model;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Entity
public class Notebook {
    @Id
    private UUID id;
    private String name;
    private String color;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "notebook", cascade = CascadeType.ALL)
    @JsonIgnore
    private List<Note> notes;


    protected Notebook() {
        this.id = UUID.randomUUID();
        this.notes = new ArrayList<>();
        this.color = NotebookColor.defaultColorHexCode();
    }

    public Notebook(String name, String color) {
        this();
        this.name = name;
        this.color = color;
    }

    public Notebook(String id, String name, String color){
        this(name, color);
        if(id != null){
            this.id = UUID.fromString(id);
        }
    }


    public UUID getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public List<Note> getNotes() {
        return notes;
    }

    public int getNbOfNotes() {
        return this.notes.size();
    }

    public String getColor() {
        return color;
    }

}
