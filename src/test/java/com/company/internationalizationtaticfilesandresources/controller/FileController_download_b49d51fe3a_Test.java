package com.company.internationalizationtaticfilesandresources.controller;

import com.company.internationalizationtaticfilesandresources.dto.ResponseMessage;
import com.company.internationalizationtaticfilesandresources.service.FileStorageService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.core.io.Resource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.Mockito.when;

import java.nio.file.Path;
import java.util.stream.Stream;

@ExtendWith(MockitoExtension.class)
public class FileController_download_b49d51fe3a_Test {

    @InjectMocks
    private FileController fileController;

    @Mock
    private FileStorageService fileStorageService;

    @Mock
    private Resource resource;

    @Test
    public void testDownloadSuccess() {
        String fileName = "testFile.txt";
        when(fileStorageService.download(fileName)).thenReturn(resource);
        when(resource.getFilename()).thenReturn(fileName);
        ResponseEntity<Resource> responseEntity = fileController.download(fileName);
        assertEquals(HttpStatus.CREATED, responseEntity.getStatusCode());
        assertEquals(MediaType.MULTIPART_FORM_DATA, responseEntity.getHeaders().getContentType());
        assertEquals("attachment: fileName =\"" + fileName + "\"", responseEntity.getHeaders().getFirst(HttpHeaders.CONTENT_DISPOSITION));
    }

    @Test
    public void testDownloadFailure() {
        String fileName = "nonExistentFile.txt";
        when(fileStorageService.download(fileName)).thenReturn(null);
        ResponseEntity<Resource> responseEntity = fileController.download(fileName);
        assertNotNull(responseEntity);
        assertEquals(HttpStatus.NOT_FOUND, responseEntity.getStatusCode());
    }
}
