package com.company.internationalizationtaticfilesandresources.service.impl;

import com.company.internationalizationtaticfilesandresources.dto.ResponseMessage;
import com.company.internationalizationtaticfilesandresources.enums.ExceptionEnum;
import com.company.internationalizationtaticfilesandresources.enums.SuccessMessageEnum;
import com.company.internationalizationtaticfilesandresources.exception.UploadFailedException;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.mock.web.MockMultipartFile;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class IFileStorageService_upload_3b48639aa2_Test {

    @Mock
    Path ROOT;

    @InjectMocks
    FileStorageService fileStorageService;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void testUploadSuccess() throws IOException {
        MultipartFile file = new MockMultipartFile("file", "Hello, World!".getBytes());
        when(ROOT.resolve(file.getOriginalFilename())).thenReturn(Paths.get("file"));

        ResponseMessage responseMessage = fileStorageService.upload(file);
        assertEquals(SuccessMessageEnum.FILE_UPLOAD_IS_SUCCESS.name(), responseMessage.getMessage().toString());
    }

    @Test
    public void testUploadFailure() {
        MultipartFile file = new MockMultipartFile("file", "Hello, World!".getBytes());
        when(ROOT.resolve(file.getOriginalFilename())).thenReturn(Paths.get("file"));
        doThrow(IOException.class).when(Files.copy(any(), any()));

        assertThrows(UploadFailedException.class, () -> fileStorageService.upload(file));
    }
}
