package quru.qa.photocatalog.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import quru.qa.photocatalog.data.PhotoRepository;
import quru.qa.photocatalog.domain.Photo;
import quru.qa.photocatalog.service.PhotoService;

import java.util.List;

@Component
public class DbPhotoService implements PhotoService {

  private final PhotoRepository photoRepository;

  @Autowired
  public DbPhotoService(PhotoRepository photoRepository) {
    this.photoRepository = photoRepository;
  }

  @Override
  public List<Photo> allPhotos() {
    return photoRepository.findAll()
      .stream()
      .map(pe -> new Photo(
          pe.getDescription(),
          pe.getLastModifiedDate(),
          pe.getContent() != null ? new String(pe.getContent()) : ""
        )
      ).toList();
  }

  @Override
  public Photo photoByDescription(String description) {
    return null;
  }
}
