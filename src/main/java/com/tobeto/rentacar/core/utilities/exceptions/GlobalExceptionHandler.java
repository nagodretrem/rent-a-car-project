package com.tobeto.rentacar.core.utilities.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.ArrayList;
import java.util.List;

@RestControllerAdvice
public class GlobalExceptionHandler
{
    @ExceptionHandler({MethodArgumentNotValidException.class})
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public List<String> handleValidationException(MethodArgumentNotValidException exception)
    {
        List<String> errors = new ArrayList<>();
        for (FieldError error:  exception.getBindingResult().getFieldErrors()) {
            errors.add(error.getDefaultMessage());
        }

        return errors;
    }
    @ExceptionHandler({BusinessException.class})
    @ResponseStatus(HttpStatus.NOT_ACCEPTABLE)
    public String handleBusinessException(BusinessException exception)
    {
        return exception.getMessage();
    }

    @ExceptionHandler({Exception.class})
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    public String handleUnkownError()
    {
        return "Unkown Error. Please try again.";
    }

}
