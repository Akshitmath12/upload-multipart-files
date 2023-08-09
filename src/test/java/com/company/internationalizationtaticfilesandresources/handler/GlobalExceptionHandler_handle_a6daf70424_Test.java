package com.company.internationalizationtaticfilesandresources.handler;

import com.company.internationalizationtaticfilesandresources.dto.ResponseMessage;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.MockitoAnnotations;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

public class GlobalExceptionHandler_handle_a6daf70424_Test {

    @InjectMocks
    private GlobalExceptionHandler globalExceptionHandler;

    @BeforeEach
    public void setUp() {
        globalExceptionHandler = new GlobalExceptionHandler();
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void testHandle() {
        ResponseEntity<ResponseMessage> responseEntity = globalExceptionHandler.handle();
        assertEquals(HttpStatus.INTERNAL_SERVER_ERROR, responseEntity.getStatusCode());
        assertEquals("File size to large!", responseEntity.getBody().getMessage());
    }

    @Test
    public void testHandleWithDifferentMessage() {
        ResponseEntity<ResponseMessage> responseEntity = globalExceptionHandler.handle();
        assertNotEquals("Different message", responseEntity.getBody().getMessage());
    }
}
