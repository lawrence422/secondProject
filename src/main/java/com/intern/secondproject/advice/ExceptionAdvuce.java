package com.intern.secondproject.advice;

import com.intern.secondproject.dao.pojo.JsonResult;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class ExceptionAdvuce {
    @ExceptionHandler
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    public JsonResult<String> exception(Exception e){
        return JsonResult.fail(HttpStatus.INTERNAL_SERVER_ERROR.value(),e.getCause().toString());
    }
}
