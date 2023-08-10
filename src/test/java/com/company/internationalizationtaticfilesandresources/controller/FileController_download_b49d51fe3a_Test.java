package com.company.internationalizationtaticfilesandresources.controller;

import com.company.internationalizationtaticfilesandresources.dto.ResponseMessage;
import com.company.internationalizationtaticfilesandresources.service.FileStorageService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.core.io.ByteArrayResource;
import org.springframework.core.io.Resource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.FileNotFoundException;
import java.nio.file.Path;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class FileController_download_b49d51fe3a_Test {

    @Mock
    private FileStorageService fileStorageService;

    @InjectMocks
    private FileController fileController;

    @Test
    public void testDownloadSuccess() {
        String fileName = "testfile.txt";
        Resource mockResource = new ByteArrayResource("file content".getBytes());

        when(fileStorageService.download(fileName)).thenReturn(mockResource);

        ResponseEntity<Resource> response = fileController.download(fileName);

        assertEquals(HttpStatus.CREATED, response.getStatusCode());
        assertEquals(MediaType.MULTIPART_FORM_DATA, response.getHeaders().getContentType());
        assertEquals("attachment; filename=\""+mockResource.getFilename()+"\"", response.getHeaders().getFirst(HttpHeaders.CONTENT_DISPOSITION));
        assertEquals(mockResource, response.getBody());
    }

    @Test
    public void testDownloadFileNotFound() {
        String fileName = "nonexistentfile.txt";

        when(fileStorageService.download(fileName)).thenThrow(new FileNotFoundException(fileName));

        assertThrows(FileNotFoundException.class, () -> {
            fileController.download(fileName);
        });
    }
}
