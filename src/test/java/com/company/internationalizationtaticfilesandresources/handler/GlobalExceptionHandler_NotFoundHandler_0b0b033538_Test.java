package com.company.internationalizationtaticfilesandresources.handler;

import com.company.internationalizationtaticfilesandresources.dto.ResponseMessage;
import com.company.internationalizationtaticfilesandresources.exception.NotFoundException;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

public class GlobalExceptionHandler_NotFoundHandler_0b0b033538_Test {

    private GlobalExceptionHandler exceptionHandler;

    @BeforeEach
    public void setUp() {
        exceptionHandler = new GlobalExceptionHandler();
    }

    @Test
    public void testNotFoundHandler() {
        ResponseEntity<ResponseMessage> response = exceptionHandler.NotFoundHandler();
        assertEquals(HttpStatus.NOT_FOUND, response.getStatusCode());
        assertEquals("NOT_FOUND_FILE", response.getBody().getMessage());
    }

    @Test
    public void testNotFoundHandlerWithDifferentStatus() {
        ResponseEntity<ResponseMessage> response = exceptionHandler.NotFoundHandler();
        assertNotEquals(HttpStatus.OK, response.getStatusCode());
    }
}
