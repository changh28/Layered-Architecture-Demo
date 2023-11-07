package LayeredArchitectureDemo.exception;

import LayeredArchitectureDemo.exception.ErrorMessage.builder;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import javax.servlet.http.HttpServletRequest;
import java.time.Instant;

/**
 * Global exception handler for REST APIs
 * Intercepts exceptions thrown in REST API
 * Converts them into the unified format
 */
@RestControllerAdvice
public class GlobalExceptionHandler {

    private static final Logger LOG = LoggerFactory.getLogger(GlobalExceptionHandler.class);

    private final HttpServletRequest request;

    public GlobalExceptionHandler(HttpServletRequest request) {
        this.request = request;
    }


    /**
     * Catches exceptions in processing messages
     * Returns customized exceptions
     */
    @ExceptionHandler(MessageException.class)
    public ResponseEntity<ErrorMessage> messageException(MessageException e) {
        return ErrorMessage.builder()
            .timestamp(Instant.now())
            .error(e.getErrorMessage().getError())
            .path(request.getRequestURI())
            .details(e.getErrorMessage().getDetails())
            .build();
    }

    /**
     * Catches unknown exceptions not handled by the previous handlers
     * Returns customized exceptions
     */
    @ExceptionHandler(Exception.class)
    public ResponseEntity<ErrorMessage> exception(Exception e) {
        LOG.error("Unknown exception:" + e);
        return ErrorMessage.builder()
            .timestamp(Instant.now())
            .error(e.getMessage())
            .path(request.getRequestURI())
            .build();
    }
}
