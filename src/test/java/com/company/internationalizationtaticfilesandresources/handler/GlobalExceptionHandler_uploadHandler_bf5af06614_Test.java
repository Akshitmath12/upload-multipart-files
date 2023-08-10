package com.company.internationalizationtaticfilesandresources.handler;

import com.company.internationalizationtaticfilesandresources.dto.ResponseMessage;
import com.company.internationalizationtaticfilesandresources.enums.ExceptionEnum;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

public class GlobalExceptionHandler_uploadHandler_bf5af06614_Test {

    private GlobalExceptionHandler globalExceptionHandler;

    @BeforeEach
    public void setUp() {
        globalExceptionHandler = new GlobalExceptionHandler();
    }

    @Test
    public void testUploadHandler() {
        ResponseEntity<ResponseMessage> result = globalExceptionHandler.uploadHandler();

        assertEquals(HttpStatus.NOT_FOUND, result.getStatusCode());
        assertEquals(ExceptionEnum.UPLOAD_FAILED.name(), result.getBody().getMessage());
    }

    @Test
    public void testUploadHandlerWithDifferentStatus() {
        ResponseEntity<ResponseMessage> result = globalExceptionHandler.uploadHandler();

        assertNotEquals(HttpStatus.OK, result.getStatusCode());
    }
}
