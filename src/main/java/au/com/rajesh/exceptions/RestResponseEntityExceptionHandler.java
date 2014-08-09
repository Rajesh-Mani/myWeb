package au.com.rajesh.exceptions;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import au.com.rajesh.service.pokerTest.ServiceException;

@ControllerAdvice
public class RestResponseEntityExceptionHandler extends ResponseEntityExceptionHandler{

    @ExceptionHandler(value = { ServiceException.class })
    protected ResponseEntity<Object> handleConflict(ServiceException ex, WebRequest request) {
    	RestError restError = new RestError(HttpStatus.INTERNAL_SERVER_ERROR.value(), ex.getErrorCode(),ex.getErrorMessage(),"");
        return handleExceptionInternal(ex, restError, 
          new HttpHeaders(), HttpStatus.INTERNAL_SERVER_ERROR, request);
    }
}
