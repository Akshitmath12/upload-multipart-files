package com.company.internationalizationtaticfilesandresources.handler;

import com.company.internationalizationtaticfilesandresources.dto.ResponseMessage;
import com.company.internationalizationtaticfilesandresources.enums.ExceptionEnum;
import com.company.internationalizationtaticfilesandresources.exception.DeleteFailedException;
import org.junit.jupiter.api.Test;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

public class GlobalExceptionHandler_deleteHandler_8b95a53cd2_Test {

    @Test
    public void testDeleteHandler_Success() {
        GlobalExceptionHandler handler = new GlobalExceptionHandler();

        ResponseEntity<ResponseMessage> response = handler.deleteHandler();
        assertEquals(HttpStatus.INTERNAL_SERVER_ERROR, response.getStatusCode());
        assertEquals(ExceptionEnum.DELETE_FAILED.name(), response.getBody().getMessage().toString());
    }

    @Test
    public void testDeleteHandler_Failure() {
        GlobalExceptionHandler handler = new GlobalExceptionHandler();

        ResponseEntity<ResponseMessage> response = handler.deleteHandler();
        assertEquals(HttpStatus.INTERNAL_SERVER_ERROR, response.getStatusCode());
        assertNotEquals("Some other message", response.getBody().getMessage().toString());
    }
}
