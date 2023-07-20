// Test generated by RoostGPT for test test2 using AI Type Open AI and AI Model gpt-4

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
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.doThrow;
import static org.mockito.Mockito.when;

public class IFileStorageService_upload_3b48639aa2_Test {

    @InjectMocks
    private FileStorageService fileStorageService;

    @Mock
    private Path ROOT;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void testUploadSuccess() throws IOException {
        MultipartFile multipartFile = new MockMultipartFile("file", "filename.txt", "text/plain", "some xml".getBytes());
        when(ROOT.resolve(any())).thenReturn(Paths.get("filename.txt"));
        ResponseMessage responseMessage = fileStorageService.upload(multipartFile);
        assertEquals(SuccessMessageEnum.FILE_UPLOAD_IS_SUCCESS.name(), responseMessage.getMessage());
    }

    @Test
    public void testUploadFailure() throws IOException {
        MultipartFile multipartFile = new MockMultipartFile("file", "filename.txt", "text/plain", "some xml".getBytes());
        when(ROOT.resolve(any())).thenReturn(Paths.get("filename.txt"));
        doThrow(IOException.class).when(Files.copy(any(), any()));
        assertThrows(UploadFailedException.class, () -> fileStorageService.upload(multipartFile));
    }
}
