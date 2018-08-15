package rc.noteit.api.viewmodel;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

public class NoteCreateUpdateViewModel {
    private String id;

    @NotNull
    @Min(3)
    private String title;

    private String description;

    @NotNull
    private String notebookId;


    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }


    public String getNotebookId() {
        return notebookId;
    }
}
