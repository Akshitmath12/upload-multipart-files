package com.company.internationalizationtaticfilesandresources.handler;

import com.company.internationalizationtaticfilesandresources.dto.ResponseMessage;
// import com.company.internationalizationtaticfilesandresources.enums.ExceptionEnum; // remove this line if not needed
import com.company.internationalizationtaticfilesandresources.exception.DeleteFailedException;
import com.company.internationalizationtaticfilesandresources.exception.DownloadFailedException;
import com.company.internationalizationtaticfilesandresources.exception.NotFoundException;
import com.company.internationalizationtaticfilesandresources.exception.UploadFailedException;
import org.apache.tomcat.util.http.fileupload.impl.FileSizeLimitExceededException;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.http.HttpStatus;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class GlobalExceptionHandler_handle_a6daf70424_Test {

    private GlobalExceptionHandler globalExceptionHandler;

    @BeforeEach
    public void setUp() {
        globalExceptionHandler = new GlobalExceptionHandler();
    }

    @Test
    public void testHandle() {
        ResponseEntity<ResponseMessage> responseEntity = globalExceptionHandler.handle();
        assertEquals(HttpStatus.INTERNAL_SERVER_ERROR, responseEntity.getStatusCode());
        assertEquals("File size to large!", responseEntity.getBody().getMessage().toString());
    }

    @Test
    public void testHandleWithDifferentMessage() {
        // TODO: Change the message in the handle method to "Different message!"
        ResponseEntity<ResponseMessage> responseEntity = globalExceptionHandler.handle();
        assertEquals(HttpStatus.INTERNAL_SERVER_ERROR, responseEntity.getStatusCode());
        assertEquals("Different message!", responseEntity.getBody().getMessage().toString());
    }
}
