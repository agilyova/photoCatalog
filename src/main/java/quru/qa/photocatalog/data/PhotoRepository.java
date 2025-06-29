package quru.qa.photocatalog.data;

import org.springframework.data.jpa.repository.JpaRepository;
import quru.qa.photocatalog.domain.Photo;

import java.util.Optional;
import java.util.UUID;

public interface PhotoRepository extends JpaRepository<PhotoEntity, UUID> {

}
