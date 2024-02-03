package mi.springtemplates.global.exception;

import lombok.extern.slf4j.Slf4j;
import mi.springtemplates.global.responseDto.ApiResponse;
import mi.springtemplates.global.utils.ResponseUtils;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.LinkedHashMap;
import java.util.Map;

@Slf4j(topic = "global exception handler")
@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(RuntimeException.class)
    public ApiResponse<?> handleRuntimeException(RuntimeException e) {
        log.info(e.getMessage());
        return ResponseUtils.error(e.getMessage());
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ApiResponse<?> validationExceptionHandler(MethodArgumentNotValidException e) {
        Map<String, String> errors = new LinkedHashMap<>();
        e.getBindingResult().getFieldErrors()
                .forEach(error -> errors.put(
                        error.getField(), error.getDefaultMessage()
                ));
        return ResponseUtils.error(HttpStatus.BAD_REQUEST, errors);
    }
}

