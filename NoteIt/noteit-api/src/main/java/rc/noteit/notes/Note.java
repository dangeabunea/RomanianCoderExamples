package rc.noteit.notes;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import java.util.UUID;

@Entity
public class Note {
    @Id
    private UUID id;
    private String title;
    private String description;

    @ManyToOne(fetch = FetchType.LAZY)
    @JsonIgnore
    private Notebook notebook;


    protected Note(){
        this.id = UUID.randomUUID();
    }

    public Note(String title, String description, Notebook notebook){
        this();
        this.title = title;
        this.description = description;
        this.notebook = notebook;
    }

    public Note(String id, String title, String description, Notebook notebook){
        this(title, description, notebook);
        if(id != null){
            this.id = UUID.fromString(id);
        }
    }


    public UUID getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public String getDescription() {
        return description;
    }

    public Notebook getNotebook() {
        return notebook;
    }

    public String getNotebookId(){
        return this.notebook.getId().toString();
    }
}
