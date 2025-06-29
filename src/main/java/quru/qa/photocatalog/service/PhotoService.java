package quru.qa.photocatalog.service;

import quru.qa.photocatalog.domain.Photo;

import java.util.List;
import java.util.UUID;

public interface PhotoService {

  List<Photo> allPhotos();

  Photo photoByDescription(String description);

  Photo findById(String id);
}
