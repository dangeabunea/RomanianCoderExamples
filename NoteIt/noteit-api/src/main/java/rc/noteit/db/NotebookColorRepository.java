package rc.noteit.db;

import org.springframework.data.jpa.repository.JpaRepository;
import rc.noteit.model.NotebookColor;

import java.util.UUID;

public interface NotebookColorRepository extends JpaRepository<NotebookColor, UUID> {
}
