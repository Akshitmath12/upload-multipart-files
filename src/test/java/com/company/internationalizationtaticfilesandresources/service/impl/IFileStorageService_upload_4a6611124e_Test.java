package com.company.internationalizationtaticfilesandresources.service.impl;

import com.company.internationalizationtaticfilesandresources.dto.ResponseMessage;
import com.company.internationalizationtaticfilesandresources.enums.ExceptionEnum;
import com.company.internationalizationtaticfilesandresources.enums.SuccessMessageEnum;
import com.company.internationalizationtaticfilesandresources.exception.UploadFailedException;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.mock.web.MockMultipartFile;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.doThrow;
import static org.mockito.Mockito.when;

public class IFileStorageService_upload_4a6611124e_Test {

    @Mock
    private FileStorageService fileStorageService;

    @BeforeEach
    public void setup() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void testUploadSuccess() throws IOException {
        MultipartFile file = new MockMultipartFile("file", "hello.txt", "text/plain", "Hello World".getBytes());
        ResponseMessage responseMessage = new ResponseMessage();
        responseMessage.setMessage(SuccessMessageEnum.FILE_UPLOAD_IS_SUCCESS.name());
        when(fileStorageService.upload(file)).thenReturn(responseMessage);
        ResponseMessage result = fileStorageService.upload(file);
        assertEquals(SuccessMessageEnum.FILE_UPLOAD_IS_SUCCESS.name(), result.getMessage());
    }

    @Test
    public void testUploadFailure() throws IOException {
        MultipartFile file = new MockMultipartFile("file", "hello.txt", "text/plain", "Hello World".getBytes());
        doThrow(new IOException()).when(fileStorageService).upload(any(MultipartFile.class));
        assertThrows(IOException.class, () -> fileStorageService.upload(file));
    }
}
