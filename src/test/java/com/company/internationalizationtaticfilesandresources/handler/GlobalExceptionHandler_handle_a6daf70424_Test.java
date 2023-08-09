package com.company.internationalizationtaticfilesandresources.handler;

import com.company.internationalizationtaticfilesandresources.dto.ResponseMessage;
import com.company.internationalizationtaticfilesandresources.exception.DeleteFailedException;
import com.company.internationalizationtaticfilesandresources.exception.DownloadFailedException;
import com.company.internationalizationtaticfilesandresources.exception.NotFoundException;
import com.company.internationalizationtaticfilesandresources.exception.UploadFailedException;
import org.apache.tomcat.util.http.fileupload.impl.FileSizeLimitExceededException;
import org.junit.jupiter.api.Test;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

public class GlobalExceptionHandler_handle_a6daf70424_Test {

    @Test
    public void testHandle() {
        ResponseEntity<ResponseMessage> response = handle();
        assertEquals(HttpStatus.INTERNAL_SERVER_ERROR, response.getStatusCode());
        assertEquals("File size to large!", response.getBody().getMessage().toString());
    }

    @Test
    public void testHandleWithDifferentMessage() {
        ResponseEntity<ResponseMessage> response = handle();
        assertNotEquals("Different message", response.getBody().getMessage().toString());
    }

    public ResponseEntity<ResponseMessage> handle() {
        return ResponseEntity
                .status(500)
                .body(ResponseMessage.builder()
                        .message(new StringBuilder("File size to large!"))
                        .build());
    }
}
