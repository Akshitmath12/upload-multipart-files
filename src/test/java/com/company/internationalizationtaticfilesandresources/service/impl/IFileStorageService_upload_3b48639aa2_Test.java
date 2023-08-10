package com.company.internationalizationtaticfilesandresources.service.impl;

import com.company.internationalizationtaticfilesandresources.dto.ResponseMessage;
import com.company.internationalizationtaticfilesandresources.exception.UploadFailedException;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.mock.web.MockMultipartFile;
import org.springframework.web.multipart.MultipartFile;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.*;

public class IFileStorageService_upload_3b48639aa2_Test {

    @Mock
    private FileStorageService fileStorageService;

    @BeforeEach
    public void init() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void testUploadSuccess() {
        MultipartFile file = new MockMultipartFile("file", "hello.txt", "text/plain", "Hello, World!".getBytes());
        when(fileStorageService.upload(file)).thenReturn(new ResponseMessage("FILE_UPLOAD_IS_SUCCESS"));

        ResponseMessage response = fileStorageService.upload(file);

        verify(fileStorageService, times(1)).upload(file);
        assertEquals("FILE_UPLOAD_IS_SUCCESS", response.getMessage());
    }

    @Test
    public void testUploadFailure() {
        MultipartFile file = new MockMultipartFile("file", "hello.txt", "text/plain", "Hello, World!".getBytes());
        when(fileStorageService.upload(file)).thenThrow(new UploadFailedException());

        assertThrows(UploadFailedException.class, () -> fileStorageService.upload(file));
        verify(fileStorageService, times(1)).upload(file);
    }
}
