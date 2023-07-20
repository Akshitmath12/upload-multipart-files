// Test generated by RoostGPT for test test2 using AI Type Open AI and AI Model gpt-4

package com.company.internationalizationtaticfilesandresources.handler;

import com.company.internationalizationtaticfilesandresources.dto.ResponseMessage;
import com.company.internationalizationtaticfilesandresources.enums.ExceptionEnum;
import com.company.internationalizationtaticfilesandresources.exception.DownloadFailedException;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class GlobalExceptionHandler_downloadHandler_e4ba69032d_Test {
    private GlobalExceptionHandler globalExceptionHandler;

    @BeforeEach
    public void setUp() {
        globalExceptionHandler = new GlobalExceptionHandler();
    }

    @Test
    public void testDownloadHandler() {
        ResponseEntity<ResponseMessage> response = globalExceptionHandler.downloadHandler();
        assertEquals(HttpStatus.INTERNAL_SERVER_ERROR, response.getStatusCode());
        assertEquals(ExceptionEnum.DOWNLOAD_FAILED.name(), response.getBody().getMessage().toString());
    }

    @Test
    public void testDownloadHandlerWithException() {
        DownloadFailedException ex = new DownloadFailedException("Download failed");
        ResponseEntity<ResponseMessage> response = globalExceptionHandler.handleDownloadFailedException(ex);
        assertEquals(HttpStatus.INTERNAL_SERVER_ERROR, response.getStatusCode());
        assertEquals("Download failed", response.getBody().getMessage().toString());
    }
}
