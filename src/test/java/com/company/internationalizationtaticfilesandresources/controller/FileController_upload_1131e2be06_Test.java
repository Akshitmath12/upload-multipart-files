package com.company.internationalizationtaticfilesandresources.controller;

import com.company.internationalizationtaticfilesandresources.dto.ResponseMessage;
import com.company.internationalizationtaticfilesandresources.service.FileStorageService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.mock.web.MockMultipartFile;
import org.springframework.web.multipart.MultipartFile;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

public class FileController_upload_1131e2be06_Test {

    @Mock
    private FileStorageService fileStorageService;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void testUploadSuccess() {
        MultipartFile file = new MockMultipartFile("file", "hello.txt", 
        MediaType.TEXT_PLAIN_VALUE, "Hello, World!".getBytes());
        ResponseMessage responseMessage = new ResponseMessage("Upload successful");
        when(fileStorageService.upload(file)).thenReturn(responseMessage);

        ResponseEntity<ResponseMessage> result = upload(file);

        assertEquals(HttpStatus.OK, result.getStatusCode());
        assertEquals("Upload successful", result.getBody().getMessage());
    }

    @Test
    public void testUploadFailure() {
        MultipartFile file = new MockMultipartFile("file", "hello.txt", 
        MediaType.TEXT_PLAIN_VALUE, "Hello, World!".getBytes());
        ResponseMessage responseMessage = new ResponseMessage("Upload failed");
        when(fileStorageService.upload(file)).thenReturn(responseMessage);

        ResponseEntity<ResponseMessage> result = upload(file);

        assertEquals(HttpStatus.OK, result.getStatusCode());
        assertEquals("Upload failed", result.getBody().getMessage());
    }

    private ResponseEntity<ResponseMessage> upload(MultipartFile file) {
        return ResponseEntity.status(HttpStatus.OK)
                .body(fileStorageService.upload(file));
    }
}
