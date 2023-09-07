package com.company.internationalizationtaticfilesandresources.handler;

import com.company.internationalizationtaticfilesandresources.dto.ResponseMessage;
import com.company.internationalizationtaticfilesandresources.enums.ExceptionEnum;
import com.company.internationalizationtaticfilesandresources.exception.UploadFailedException;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class GlobalExceptionHandler_uploadHandler_701f2d919f_Test {

    private GlobalExceptionHandler globalExceptionHandler;

    @BeforeEach
    public void setUp() {
        globalExceptionHandler = new GlobalExceptionHandler();
    }

    @Test
    public void testUploadHandler() {
        ResponseEntity<ResponseMessage> responseEntity = globalExceptionHandler.uploadHandler();
        assertEquals(HttpStatus.NOT_FOUND, responseEntity.getStatusCode());
        assertEquals(ExceptionEnum.UPLOAD_FAILED.name(), responseEntity.getBody().getMessage());
    }

    @Test
    public void testUploadHandler_WithUploadFailedException() {
        ResponseEntity<ResponseMessage> responseEntity = globalExceptionHandler.handleUploadFailedException(new UploadFailedException("Upload failed"));
        assertEquals(HttpStatus.NOT_FOUND, responseEntity.getStatusCode());
        assertEquals("Upload failed", responseEntity.getBody().getMessage());
    }
}
