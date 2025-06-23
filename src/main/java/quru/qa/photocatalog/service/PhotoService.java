package quru.qa.photocatalog.service;

import quru.qa.photocatalog.domain.Photo;

import java.util.List;

public interface PhotoService {

  List<Photo> allPhotos();

  Photo photoByDescription(String description);
}
