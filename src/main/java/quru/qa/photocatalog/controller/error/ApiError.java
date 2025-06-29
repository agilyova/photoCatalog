package quru.qa.photocatalog.controller.error;


/*{
  "apiVersion": "2.0",
  "error": {
  "code": 404,
  "message": "File Not Found",
  "errors": [{
  "domain": "Calendar",
  "reason": "ResourceNotFoundException",
  "message": "File Not Found"
  }]
  }
  }*/

import java.util.List;
import java.util.Map;

public class ApiError {
  private final String apiVersion;
  private final Error error;

  public ApiError(String apiVersion, Error error) {
    this.apiVersion = apiVersion;
    this.error = error;
  }

  public ApiError(String apiVersion, String code, String message, String domain, String reason) {
    this.apiVersion = apiVersion;
    this.error = new Error(
      code,
      message,
      List.of(
        new ErrorItem(
          domain,
          reason,
          message
        )
      )
    );
  }

  public static ApiError fromAttributeMap(String apiVersion, Map<String, Object> attributeMap) {
    return new ApiError(
      apiVersion,
      attributeMap.get("status").toString(),
      attributeMap.getOrDefault("error", "No message found").toString(),
      attributeMap.getOrDefault("path", "No path found").toString(),
      attributeMap.getOrDefault("error", "No message found").toString()
    );
  }

  public Map<String, Object> toMapAttribute() {
    return Map.of(
      "apiVersion", apiVersion,
      "error", error
    );
  }

  public String getApiVersion() {
    return apiVersion;
  }

  public Error getError() {
    return error;
  }

  private record Error(String code, String message, List<ErrorItem> errors) {
  }

  private record ErrorItem(String domain, String reason, String message) {
  }
}
