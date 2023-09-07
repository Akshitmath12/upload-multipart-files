package com.company.internationalizationtaticfilesandresources.controller;

import com.company.internationalizationtaticfilesandresources.dto.ResponseMessage;
import com.company.internationalizationtaticfilesandresources.service.FileStorageService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.core.io.Resource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

import java.nio.file.Path;
import java.util.stream.Stream;

@Slf4j
@RequiredArgsConstructor
public class FileController_download_fe47ae494d_Test {

    @InjectMocks
    FileController fileController;

    @Mock
    FileStorageService fileStorageService;

    @Mock
    Resource resource;

    @BeforeEach
    public void init() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void testDownload_Success() {
        String fileName = "testFile.txt";

        when(fileStorageService.download(fileName)).thenReturn(resource);
        when(resource.getFilename()).thenReturn(fileName);

        ResponseEntity<Resource> response = fileController.download(fileName);

        verify(fileStorageService, times(1)).download(fileName);
        assertEquals(HttpStatus.CREATED, response.getStatusCode());
        assertEquals(MediaType.MULTIPART_FORM_DATA, response.getHeaders().getContentType());
        assertEquals("attachment: fileName =\""+fileName+"\"", response.getHeaders().getFirst(HttpHeaders.CONTENT_DISPOSITION));
        assertEquals(resource, response.getBody());
    }

    @Test
    public void testDownload_Failure() {
        String fileName = "nonExistentFile.txt";

        when(fileStorageService.download(fileName)).thenReturn(null);

        try {
            ResponseEntity<Resource> response = fileController.download(fileName);
            fail("Expected an NullPointerException to be thrown");
        } catch (NullPointerException e) {
            verify(fileStorageService, times(1)).download(fileName);
        }
    }
}
