package rc.noteit.api;

import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import rc.noteit.api.viewmodel.NotebookCreateUpdateViewModel;
import rc.noteit.db.NotebookRepository;
import rc.noteit.notes.Notebook;

import javax.validation.ValidationException;
import java.util.List;
import java.util.UUID;

/*
Requests can be tested using the built in HTTP Rest Client. Use the
examples found in 'noteit.http' file.
 */

@RestController
@RequestMapping("/api/notebooks")
public class NotebookController {
    private NotebookRepository notebookRepository;

    public NotebookController(NotebookRepository notebookRepository) {
        this.notebookRepository = notebookRepository;
    }

    @GetMapping("/all")
    public List<Notebook> all() {
        var allCategories = this.notebookRepository.findAll();
        return allCategories;
    }

    @PostMapping
    public void create(@RequestBody NotebookCreateUpdateViewModel notebookCreateUpdateViewModel,
                       BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            throw new ValidationException();
        }

        // create notebook instance from view model
        var notebook = new Notebook(
                notebookCreateUpdateViewModel.getId(),
                notebookCreateUpdateViewModel.getName(),
                notebookCreateUpdateViewModel.getColor()
        );

        // save notebook instance to db
        this.notebookRepository.save(notebook);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable String id) {
        this.notebookRepository.deleteById(UUID.fromString(id));
    }
}
