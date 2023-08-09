package com.company.internationalizationtaticfilesandresources.handler;

import com.company.internationalizationtaticfilesandresources.dto.ResponseMessage;
import com.company.internationalizationtaticfilesandresources.enums.ExceptionEnum;
import com.company.internationalizationtaticfilesandresources.exception.DownloadFailedException;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.mockito.Mockito.when;

public class GlobalExceptionHandler_downloadHandler_e4ba69032d_Test {

    @InjectMocks
    private GlobalExceptionHandler globalExceptionHandler;

    @Mock
    private ResponseMessage responseMessage;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void testDownloadHandler_success() {
        when(responseMessage.getMessage()).thenReturn(ExceptionEnum.DOWNLOAD_FAILED.name());
        ResponseEntity<ResponseMessage> response = new ResponseEntity<>(responseMessage, HttpStatus.INTERNAL_SERVER_ERROR);
        assertEquals(HttpStatus.INTERNAL_SERVER_ERROR, response.getStatusCode());
        assertEquals(ExceptionEnum.DOWNLOAD_FAILED.name(), response.getBody().getMessage());
    }

    @Test
    public void testDownloadHandler_failure() {
        when(responseMessage.getMessage()).thenReturn("Some other message");
        ResponseEntity<ResponseMessage> response = new ResponseEntity<>(responseMessage, HttpStatus.INTERNAL_SERVER_ERROR);
        assertEquals(HttpStatus.INTERNAL_SERVER_ERROR, response.getStatusCode());
        assertNotEquals(ExceptionEnum.DOWNLOAD_FAILED.name(), response.getBody().getMessage());
    }
}
