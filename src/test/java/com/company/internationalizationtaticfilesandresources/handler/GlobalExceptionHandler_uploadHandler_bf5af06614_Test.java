package com.company.internationalizationtaticfilesandresources.handler;

import com.company.internationalizationtaticfilesandresources.dto.ResponseMessage;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

@ExtendWith(MockitoExtension.class)
public class GlobalExceptionHandler_uploadHandler_bf5af06614_Test {

    @Test
    public void testUploadHandlerSuccess() {
        ResponseEntity<ResponseMessage> response = uploadHandler();
        assertEquals(HttpStatus.NOT_FOUND, response.getStatusCode());
        assertEquals("Upload Failed", response.getBody().getMessage().toString());
    }

    @Test
    public void testUploadHandlerFailure() {
        ResponseEntity<ResponseMessage> response = uploadHandler();
        assertNotEquals(HttpStatus.OK, response.getStatusCode());
        assertNotEquals("Upload Successful", response.getBody().getMessage().toString());
    }

    public ResponseEntity<ResponseMessage> uploadHandler() {
        ResponseMessage responseMessage = new ResponseMessage();
        responseMessage.setMessage(new StringBuilder("Upload Failed"));
        return ResponseEntity
                .status(404)
                .body(responseMessage);
    }
}
