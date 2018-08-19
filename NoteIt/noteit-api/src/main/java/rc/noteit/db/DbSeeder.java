package rc.noteit.db;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.stereotype.Component;
import rc.noteit.model.Note;
import rc.noteit.model.Notebook;
import rc.noteit.model.NotebookColor;

import java.util.Arrays;
import java.util.List;

/**
 * This component will only execute (and get instantiated) if the
 * property noteit.db.recreate is set to true in the
 * application.properties file
 */

@Component
@ConditionalOnProperty(name = "noteit.db.recreate", havingValue = "true")
public class DbSeeder implements CommandLineRunner {
    private NotebookRepository notebookRepository;
    private NoteRepository noteRepository;
    private NotebookColorRepository notebookColorRepository;

    public DbSeeder(NotebookRepository notebookRepository,
                    NoteRepository noteRepository,
                    NotebookColorRepository notebookColorRepository) {
        this.notebookRepository = notebookRepository;
        this.noteRepository = noteRepository;
        this.notebookColorRepository = notebookColorRepository;
    }


    @Override
    public void run(String... args) {
        // Remove all existing entities
        this.notebookRepository.deleteAll();
        this.noteRepository.deleteAll();
        this.notebookColorRepository.deleteAll();

        // Save colors
        List<NotebookColor> colors = Arrays.asList(
                new NotebookColor("Red", "#C70039"),
                new NotebookColor("Blue", "#06749A"),
                new NotebookColor("Violet", "#8E44AD"),
                new NotebookColor("Brown", "#7B241C"),
                new NotebookColor("Green", "#27AE60"),
                new NotebookColor("Orange", "#EB984E")
                );
        this.notebookColorRepository.saveAll(colors);

        // Save a default notebook
        var defaultNotebook = new Notebook("Default", NotebookColor.defaultColorHexCode());
        this.notebookRepository.save(defaultNotebook);

        // Save the welcome note
        var note = new Note("Hello", "Welcome to Note It", defaultNotebook);
        this.noteRepository.save(note);

        System.out.println("Initialized database");
    }
}
