package com.company.internationalizationtaticfilesandresources.handler;

import com.company.internationalizationtaticfilesandresources.dto.ResponseMessage;
import com.company.internationalizationtaticfilesandresources.enums.ExceptionEnum;
import com.company.internationalizationtaticfilesandresources.exception.DownloadFailedException;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class GlobalExceptionHandler_downloadHandler_22018509ea_Test {

    private GlobalExceptionHandler globalExceptionHandler;

    @BeforeEach
    public void setUp() {
        globalExceptionHandler = new GlobalExceptionHandler();
    }

    @Test
    public void testDownloadHandler() {
        ResponseEntity<ResponseMessage> responseEntity = globalExceptionHandler.downloadHandler();
        assertEquals(HttpStatus.INTERNAL_SERVER_ERROR, responseEntity.getStatusCode());
        assertEquals(ExceptionEnum.DOWNLOAD_FAILED.name(), responseEntity.getBody().getMessage().toString());
    }

    @Test
    public void testDownloadHandlerWithException() {
        DownloadFailedException exception = new DownloadFailedException(ExceptionEnum.DOWNLOAD_FAILED.name());
        ResponseEntity<ResponseMessage> responseEntity = globalExceptionHandler.downloadHandler(exception);
        assertEquals(HttpStatus.INTERNAL_SERVER_ERROR, responseEntity.getStatusCode());
        assertEquals(ExceptionEnum.DOWNLOAD_FAILED.name(), responseEntity.getBody().getMessage().toString());
    }
}
