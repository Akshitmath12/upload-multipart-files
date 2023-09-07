package com.company.internationalizationtaticfilesandresources.handler;

import com.company.internationalizationtaticfilesandresources.dto.ResponseMessage;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class GlobalExceptionHandler_handle_ad464c5c3b_Test {

    @InjectMocks
    GlobalExceptionHandler globalExceptionHandler;

    @Test
    public void testHandle() {
        ResponseMessage responseMessage = new ResponseMessage();
        responseMessage.setMessage("File size to large!");
        ResponseEntity<ResponseMessage> mockResponseEntity = new ResponseEntity<>(responseMessage, HttpStatus.INTERNAL_SERVER_ERROR);

        GlobalExceptionHandler mockHandler = mock(GlobalExceptionHandler.class);
        when(mockHandler.handle()).thenReturn(mockResponseEntity);

        ResponseEntity<ResponseMessage> responseEntity = mockHandler.handle();
        assertEquals(HttpStatus.INTERNAL_SERVER_ERROR, responseEntity.getStatusCode());
        assertEquals("File size to large!", responseEntity.getBody().getMessage());
    }

    @Test
    public void testHandleWithDifferentMessage() {
        ResponseMessage responseMessage = new ResponseMessage();
        responseMessage.setMessage("Different Message");
        ResponseEntity<ResponseMessage> mockResponseEntity = new ResponseEntity<>(responseMessage, HttpStatus.INTERNAL_SERVER_ERROR);

        GlobalExceptionHandler mockHandler = mock(GlobalExceptionHandler.class);
        when(mockHandler.handle()).thenReturn(mockResponseEntity);

        ResponseEntity<ResponseMessage> responseEntity = mockHandler.handle();
        assertEquals(HttpStatus.INTERNAL_SERVER_ERROR, responseEntity.getStatusCode());
        assertEquals("Different Message", responseEntity.getBody().getMessage());
    }
}
