package br.com.igorc.voting.api;

import br.com.igorc.voting.exception.BusinessException;
import br.com.igorc.voting.exception.NotFoundException;
import lombok.AllArgsConstructor;
import lombok.Getter;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

@RestControllerAdvice
public class ErrorHandler {

    @ResponseStatus(code = HttpStatus.BAD_REQUEST)
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ErrorResponse handleArgumentValidationException(MethodArgumentNotValidException exception) {
        List<FieldError> errors = exception.getBindingResult()
                .getFieldErrors()
                .stream()
                .map(e -> new FieldError(e.getField(), e.getDefaultMessage()))
                .collect(Collectors.toList());
        return new ErrorResponseWithFields(HttpStatus.BAD_REQUEST, exception.getMessage(), errors);
    }

    @ResponseStatus(code = HttpStatus.UNPROCESSABLE_ENTITY)
    @ExceptionHandler(BusinessException.class)
    public ErrorResponse handleBusinessException(BusinessException ex) {
        return new ErrorResponse(HttpStatus.UNPROCESSABLE_ENTITY, ex.getMessage());
    }

    @ResponseStatus(code = HttpStatus.NOT_FOUND)
    @ExceptionHandler(NotFoundException.class)
    public ErrorResponse handleNotFoundException(NotFoundException ex) {
        return new ErrorResponse(HttpStatus.NOT_FOUND, ex.getMessage());
    }

    @ResponseStatus(code = HttpStatus.INTERNAL_SERVER_ERROR)
    @ExceptionHandler(Exception.class)
    public ErrorResponse handleException(Exception ex) {
        return new ErrorResponse(HttpStatus.INTERNAL_SERVER_ERROR, ex.getMessage());
    }

    @Getter
    class ErrorResponse {
        private Integer status;
        private String error;
        private String message;
        private Date timestamp;

        public ErrorResponse(HttpStatus status, String message) {
            this.status = status.value();
            this.error = status.getReasonPhrase();
            this.message = message;
            this.timestamp = new Date();
        }
    }

    @Getter
    class ErrorResponseWithFields extends ErrorResponse {
        private List<FieldError> fieldErrors;

        public ErrorResponseWithFields(HttpStatus status, String message, List<FieldError> fieldErrors) {
            super(status, message);
            this.fieldErrors = fieldErrors;
        }
    }

    @AllArgsConstructor
    @Getter
    class FieldError {
        private String field;
        private String message;
    }

}
