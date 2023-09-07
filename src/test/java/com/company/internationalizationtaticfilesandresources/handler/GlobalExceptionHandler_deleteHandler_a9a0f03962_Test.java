package com.company.internationalizationtaticfilesandresources.handler;

import com.company.internationalizationtaticfilesandresources.dto.ResponseMessage;
import com.company.internationalizationtaticfilesandresources.enums.ExceptionEnum;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

public class GlobalExceptionHandler_deleteHandler_a9a0f03962_Test {

    private GlobalExceptionHandler globalExceptionHandler;

    @BeforeEach
    public void setUp() {
        globalExceptionHandler = new GlobalExceptionHandler();
    }

    @Test
    public void testDeleteHandler() {
        ResponseEntity<ResponseMessage> responseEntity = globalExceptionHandler.deleteHandler();
        assertEquals(HttpStatus.INTERNAL_SERVER_ERROR, responseEntity.getStatusCode());
        assertEquals(ExceptionEnum.DELETE_FAILED.name(), responseEntity.getBody().getMessage().toString());
    }

    @Test
    public void testDeleteHandlerWithDifferentStatus() {
        ResponseEntity<ResponseMessage> responseEntity = globalExceptionHandler.deleteHandler();
        assertNotEquals(HttpStatus.OK, responseEntity.getStatusCode());
    }
}
