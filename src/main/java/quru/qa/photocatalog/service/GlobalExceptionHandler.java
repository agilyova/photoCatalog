package quru.qa.photocatalog.service;

import jakarta.servlet.http.HttpServletRequest;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import quru.qa.photocatalog.controller.error.ApiError;
import quru.qa.photocatalog.ex.PhotoNotFoundException;

@RestControllerAdvice
public class GlobalExceptionHandler {

  @Value("${api.version}")
  private String apiVersion;

  private static final Logger LOG = LoggerFactory.getLogger(GlobalExceptionHandler.class);


  @ExceptionHandler(PhotoNotFoundException.class)
  @ResponseStatus(HttpStatus.NOT_FOUND)
  public ResponseEntity<ApiError> handleNotFoundException(PhotoNotFoundException ex, HttpServletRequest request) {
    LOG.error(request.getRequestURI(), ex);
    return new ResponseEntity<>(
      new ApiError(
        apiVersion,
        HttpStatus.NOT_FOUND.toString(),
        "PhotoNotFound",
        request.getRequestURI(),
        ex.getMessage()
      ),
      HttpStatus.NOT_FOUND
    );
  }
}
