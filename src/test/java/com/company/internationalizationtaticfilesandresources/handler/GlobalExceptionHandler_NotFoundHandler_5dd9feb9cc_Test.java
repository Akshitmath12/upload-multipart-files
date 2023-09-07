package com.company.internationalizationtaticfilesandresources.handler;

import com.company.internationalizationtaticfilesandresources.dto.ResponseMessage;
import com.company.internationalizationtaticfilesandresources.enums.ExceptionEnum;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.MockitoAnnotations;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

public class GlobalExceptionHandler_NotFoundHandler_5dd9feb9cc_Test {

    @InjectMocks
    private GlobalExceptionHandler globalExceptionHandler;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void testNotFoundHandler() {
        ResponseEntity<ResponseMessage> responseEntity = globalExceptionHandler.NotFoundHandler();
        assertEquals(HttpStatus.NOT_FOUND, responseEntity.getStatusCode());
        assertEquals(ExceptionEnum.NOT_FOUND_FILE.name(), responseEntity.getBody().getMessage());
    }

    @Test
    public void testNotFoundHandlerWithDifferentStatus() {
        ResponseEntity<ResponseMessage> responseEntity = globalExceptionHandler.NotFoundHandler();
        assertNotEquals(HttpStatus.OK, responseEntity.getStatusCode());
    }
}
