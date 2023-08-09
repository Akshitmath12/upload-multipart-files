package com.company.internationalizationtaticfilesandresources.handler;

import com.company.internationalizationtaticfilesandresources.dto.ResponseMessage;
import com.company.internationalizationtaticfilesandresources.enums.ExceptionEnum;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

public class GlobalExceptionHandler_NotFoundHandler_0b0b033538_Test {

    private GlobalExceptionHandler globalExceptionHandler;

    @BeforeEach
    public void setUp() {
        globalExceptionHandler = new GlobalExceptionHandler();
    }

    @Test
    public void testNotFoundHandler() {
        ResponseEntity<ResponseMessage> responseEntity = globalExceptionHandler.NotFoundHandler();

        assertEquals(HttpStatus.NOT_FOUND, responseEntity.getStatusCode());
        assertEquals(ExceptionEnum.NOT_FOUND_FILE.name(), responseEntity.getBody().getMessage().toString());
    }

    @Test
    public void testNotFoundHandlerWithDifferentStatus() {
        ResponseEntity<ResponseMessage> responseEntity = globalExceptionHandler.NotFoundHandler();

        // This test should fail as the status is always NOT_FOUND (404)
        assertNotEquals(HttpStatus.OK, responseEntity.getStatusCode());
    }
}
