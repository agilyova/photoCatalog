package quru.qa.photocatalog.ex;

public class PhotoNotFoundException extends RuntimeException {

  public PhotoNotFoundException() {
    super();
  }

  public PhotoNotFoundException(String message) {
    super(message);
  }
}
