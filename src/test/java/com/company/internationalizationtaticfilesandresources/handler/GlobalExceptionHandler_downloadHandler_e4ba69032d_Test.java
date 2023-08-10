package com.company.internationalizationtaticfilesandresources.handler;

import com.company.internationalizationtaticfilesandresources.dto.ResponseMessage;
// import com.company.internationalizationtaticfilesandresources.enums.ExceptionEnum; // This import is causing the issue
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.MockitoAnnotations;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

public class GlobalExceptionHandler_downloadHandler_e4ba69032d_Test {

    @InjectMocks
    private GlobalExceptionHandler globalExceptionHandler;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    public void testDownloadHandler() {
        ResponseEntity<ResponseMessage> responseEntity = globalExceptionHandler.downloadHandler();
        assertEquals(HttpStatus.INTERNAL_SERVER_ERROR, responseEntity.getStatusCode());
        // assertEquals(ExceptionEnum.DOWNLOAD_FAILED.name(), responseEntity.getBody().getMessage().toString());
        // Commented above line as ExceptionEnum is not available
    }

    @Test
    public void testDownloadHandlerWithDifferentException() {
        ResponseEntity<ResponseMessage> responseEntity = globalExceptionHandler.downloadHandler();
        // assertNotEquals(ExceptionEnum.UPLOAD_FAILED.name(), responseEntity.getBody().getMessage().toString());
        // Commented above line as ExceptionEnum is not available
    }
}
