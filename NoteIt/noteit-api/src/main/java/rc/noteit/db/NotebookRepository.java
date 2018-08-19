package rc.noteit.db;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import rc.noteit.model.Notebook;

import java.util.UUID;

@Repository
public interface NotebookRepository extends JpaRepository<Notebook, UUID> {
}
