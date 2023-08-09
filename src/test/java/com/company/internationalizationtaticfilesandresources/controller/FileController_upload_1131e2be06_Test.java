package com.company.internationalizationtaticfilesandresources.controller;

import com.company.internationalizationtaticfilesandresources.dto.ResponseMessage;
import com.company.internationalizationtaticfilesandresources.service.FileStorageService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.mock.web.MockMultipartFile;
import org.springframework.web.multipart.MultipartFile;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

public class FileControllerTest {

    @InjectMocks
    private FileController fileController;

    @Mock
    private FileStorageService fileStorageService;

    @BeforeEach
    public void setup() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void testUploadSuccess() {
        MultipartFile file = new MockMultipartFile("data", "filename.txt", "text/plain", "some xml".getBytes());
        ResponseMessage responseMessage = new ResponseMessage("Upload successful");
        when(fileStorageService.upload(file)).thenReturn(responseMessage);

        ResponseEntity<ResponseMessage> response = fileController.upload(file);

        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertEquals("Upload successful", response.getBody().getMessage());
    }

    @Test
    public void testUploadFailure() {
        MultipartFile file = new MockMultipartFile("data", "filename.txt", "text/plain", "some xml".getBytes());
        ResponseMessage responseMessage = new ResponseMessage("Upload failed");
        when(fileStorageService.upload(file)).thenReturn(responseMessage);

        ResponseEntity<ResponseMessage> response = fileController.upload(file);

        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertEquals("Upload failed", response.getBody().getMessage());
    }
}
