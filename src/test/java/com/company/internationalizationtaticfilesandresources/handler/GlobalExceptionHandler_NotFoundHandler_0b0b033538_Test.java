package com.company.internationalizationtaticfilesandresources.handler;

import com.company.internationalizationtaticfilesandresources.dto.ResponseMessage;
import com.company.internationalizationtaticfilesandresources.enums.ExceptionEnum;
import org.junit.jupiter.api.Test;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.Assert.assertNotEquals; // correct import

public class GlobalExceptionHandler_NotFoundHandler_0b0b033538_Test {

    @Test
    public void testNotFoundHandler() {
        GlobalExceptionHandler globalExceptionHandler = new GlobalExceptionHandler();
        ResponseEntity<ResponseMessage> result = globalExceptionHandler.NotFoundHandler();
        assertEquals(HttpStatus.NOT_FOUND, result.getStatusCode());
        assertEquals(ExceptionEnum.NOT_FOUND_FILE.name(), result.getBody().getMessage().toString());
    }

    @Test
    public void testNotFoundHandlerWithDifferentException() {
        GlobalExceptionHandler globalExceptionHandler = new GlobalExceptionHandler();
        ResponseEntity<ResponseMessage> result = globalExceptionHandler.NotFoundHandler();
        assertNotEquals(HttpStatus.BAD_REQUEST, result.getStatusCode());
        assertNotEquals(ExceptionEnum.UPLOAD_FAILED.name(), result.getBody().getMessage().toString());
    }
}
