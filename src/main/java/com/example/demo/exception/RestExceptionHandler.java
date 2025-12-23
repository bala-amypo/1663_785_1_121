@RestControllerAdvice
public class RestExceptionHandler {


@ExceptionHandler(ApiException.class)
public ResponseEntity<String> handle(ApiException ex) {
return ResponseEntity.badRequest().body(ex.getMessage());
}
}