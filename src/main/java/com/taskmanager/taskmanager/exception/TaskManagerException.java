package com.taskmanager.taskmanager.exception;

import lombok.AllArgsConstructor;
import lombok.Getter;
import org.springframework.http.HttpStatus;

@Getter
@AllArgsConstructor
public class TaskManagerException extends RuntimeException{

    private final String  code;
    private final String errorMessage;
    private final HttpStatus statusCode;

}
