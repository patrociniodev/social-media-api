package br.com.isaacpatrocinio.social_media_api.resources.exceptions;

import br.com.isaacpatrocinio.social_media_api.services.exceptions.ObjectNotFoundException;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.time.Instant;

@ControllerAdvice
public class ResourceExceptionHandler {

    @ExceptionHandler(ObjectNotFoundException.class)
    public ResponseEntity<StandardError> objectNotFound(ObjectNotFoundException e, HttpServletRequest request) {
        Instant timestamp = Instant.now();
        HttpStatus httpStatus = HttpStatus.NOT_FOUND;
        String error = "Not found";
        StandardError stdErr = new StandardError(
                timestamp,
                httpStatus.value(),
                error,
                e.getMessage(),
                request.getRequestURI()
        );

        return ResponseEntity.status(httpStatus).body(stdErr);
    }
}
