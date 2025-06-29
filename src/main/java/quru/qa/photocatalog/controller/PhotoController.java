package quru.qa.photocatalog.controller;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import quru.qa.photocatalog.domain.Photo;
import quru.qa.photocatalog.service.PhotoService;

import java.util.List;

@RestController
@RequestMapping("api/photo")
public class PhotoController {

  private static final Logger LOG = LoggerFactory.getLogger(PhotoController.class);
  private final PhotoService photoService;

  @Autowired
  public PhotoController(PhotoService photoService) {
    this.photoService = photoService;
  }

  @GetMapping("/all")
  public List<Photo> allPhotos() {
    return photoService.allPhotos();
  }

  @GetMapping("/{id}")
  public Photo findById(@RequestParam("id") String id) {
    return photoService.findById(id);
  }
}
