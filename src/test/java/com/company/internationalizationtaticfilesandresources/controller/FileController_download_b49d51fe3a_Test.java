package com.company.internationalizationtaticfilesandresources.controller;

import com.company.internationalizationtaticfilesandresources.dto.ResponseMessage;
import com.company.internationalizationtaticfilesandresources.service.FileStorageService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.core.io.Resource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.nio.file.Path;
import java.util.stream.Stream;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;
import static org.junit.jupiter.api.Assertions.assertEquals;

@RequiredArgsConstructor
@Slf4j
public class FileController_download_b49d51fe3a_Test {

    private FileStorageService fileStorageService;
    private Resource resource;

    @BeforeEach
    public void setUp() {
        fileStorageService = mock(FileStorageService.class);
        resource = mock(Resource.class);
    }

    @Test
    public void testDownloadSuccess() {
        String fileName = "testFile.txt";
        when(fileStorageService.download(fileName)).thenReturn(resource);
        when(resource.getFilename()).thenReturn(fileName);

        ResponseEntity<Resource> response = download(fileName);
        assertEquals(HttpStatus.CREATED, response.getStatusCode());
        assertEquals(MediaType.MULTIPART_FORM_DATA, response.getHeaders().getContentType());
        assertEquals(resource, response.getBody());
    }

    @Test
    public void testDownloadFailure() {
        String fileName = "nonExistentFile.txt";
        when(fileStorageService.download(fileName)).thenReturn(null);

        ResponseEntity<Resource> response = download(fileName);
        assertEquals(HttpStatus.NOT_FOUND, response.getStatusCode());
    }

    public ResponseEntity<Resource> download(String fileName) {
        Resource file = fileStorageService.download(fileName);
        if (file == null) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
        return ResponseEntity
                .status(HttpStatus.CREATED)
                .contentType(MediaType.MULTIPART_FORM_DATA)
                .header(HttpHeaders.CONTENT_DISPOSITION,
                        "attachment: fileName =\""+file.getFilename() + "\"")
                .body(file);
    }
}
