package rc.noteit.api;

import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import rc.noteit.api.viewmodel.NoteCreateUpdateViewModel;
import rc.noteit.db.NoteRepository;
import rc.noteit.db.NotebookRepository;
import rc.noteit.model.Note;

import javax.persistence.EntityNotFoundException;
import javax.validation.ValidationException;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

/*
Requests can be tested using the built in HTTP Rest Client. Use the
examples found in 'noteit.http' file.
 */

@RestController
@RequestMapping("/api/notes")
public class NoteController {
    private NoteRepository noteRepository;
    private NotebookRepository notebookRepository;

    public NoteController(NoteRepository noteRepository, NotebookRepository notebookRepository) {
        this.noteRepository = noteRepository;
        this.notebookRepository = notebookRepository;
    }

    @GetMapping("/all")
    public List<Note> all() {
        var notes = this.noteRepository.findAll();

        return notes;
    }

    @GetMapping("/byId/{id}")
    public Note byId(@PathVariable String id) {
        var note = this.noteRepository.findById(UUID.fromString(id)).orElse(null);

        if (note == null) {
            throw new EntityNotFoundException();
        }

        return note;
    }

    @GetMapping("/byNotebook/{notebookId}")
    public List<Note> byNotebook(@PathVariable String notebookId) {
        List<Note> notes = new ArrayList<>();

        var notebook = this.notebookRepository.findById(UUID.fromString(notebookId));
        if (notebook.isPresent()) {
            notes = this.noteRepository.findAllByNotebook(notebook.get());
        }

        return notes;
    }

    @PostMapping
    public void createOrUpdate(@RequestBody NoteCreateUpdateViewModel noteCreateViewModel, BindingResult bindingResult){
        if(bindingResult.hasErrors()){
            throw new ValidationException();
        }

        // grab actual notebook from database to make link with note
        var notebook = this.notebookRepository.findById(UUID.fromString(noteCreateViewModel.getNotebookId())).get();

        // create a note instance from view model and link it with notebook instance
        var note = new Note(
                noteCreateViewModel.getId(),
                noteCreateViewModel.getTitle(),
                noteCreateViewModel.getDescription(),
                notebook);

        // save note instance to db
        this.noteRepository.save(note);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable String id) {
        this.noteRepository.deleteById(UUID.fromString(id));
    }
}
