package com.company.internationalizationtaticfilesandresources.handler;

import com.company.internationalizationtaticfilesandresources.dto.ResponseMessage;
import com.company.internationalizationtaticfilesandresources.enums.ExceptionEnum;
import org.junit.jupiter.api.Test;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class GlobalExceptionHandler_deleteHandler_8b95a53cd2_Test {

    @Test
    public void testDeleteHandlerSuccess() {
        GlobalExceptionHandler handler = new GlobalExceptionHandler();
        ResponseEntity<ResponseMessage> response = handler.deleteHandler();
        
        assertEquals(HttpStatus.INTERNAL_SERVER_ERROR, response.getStatusCode());
        assertEquals(ExceptionEnum.DELETE_FAILED.name(), response.getBody().getMessage());
    }

    @Test
    public void testDeleteHandlerFailure() {
        GlobalExceptionHandler handler = new GlobalExceptionHandler();
        ResponseEntity<ResponseMessage> response = handler.deleteHandler();
        
        // TODO: Change the expected status and message to match the failure scenario
        HttpStatus expectedStatus = HttpStatus.OK;
        String expectedMessage = "Success";
        
        assertEquals(expectedStatus, response.getStatusCode());
        assertEquals(expectedMessage, response.getBody().getMessage());
    }
}
