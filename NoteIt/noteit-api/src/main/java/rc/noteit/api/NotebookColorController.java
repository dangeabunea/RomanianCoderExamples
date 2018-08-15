package rc.noteit.api;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import rc.noteit.db.NotebookColorRepository;
import rc.noteit.notes.NotebookColor;

import java.util.List;

/*
Requests can be tested using the built in HTTP Rest Client. Use the
examples found in 'noteit.http' file.
 */

@RestController
@RequestMapping("/api/colors")
public class NotebookColorController {
    private NotebookColorRepository repository;

    public NotebookColorController(NotebookColorRepository repository) {
        this.repository = repository;
    }

    @GetMapping("/all")
    public List<NotebookColor> all(){
        return this.repository.findAll();
    }
}
