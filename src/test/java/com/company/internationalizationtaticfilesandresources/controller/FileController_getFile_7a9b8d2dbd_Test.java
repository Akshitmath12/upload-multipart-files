package com.company.internationalizationtaticfilesandresources.controller;

import com.company.internationalizationtaticfilesandresources.dto.ResponseMessage;
import com.company.internationalizationtaticfilesandresources.service.FileStorageService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.nio.file.Path;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

@ExtendWith(SpringExtension.class)
public class FileController_getFile_7a9b8d2dbd_Test {

    @InjectMocks
    private FileController fileController = new FileController();

    @Mock
    private FileStorageService fileStorageService;

    @BeforeEach
    public void setUp() {
        // TODO: Initialize your test setup here
    }

    @Test
    public void testGetFileSuccess() {
        Stream<Path> expectedFilesStream = Stream.of(Path.of("testFile1.txt"), Path.of("testFile2.txt"));
        when(fileStorageService.getFilesStream()).thenReturn(expectedFilesStream);

        ResponseEntity<Stream<Path>> responseEntity = fileController.getFile();

        assertEquals(HttpStatus.OK, responseEntity.getStatusCode());
        assertEquals(expectedFilesStream, responseEntity.getBody());
    }

    @Test
    public void testGetFileFailure() {
        when(fileStorageService.getFilesStream()).thenThrow(new RuntimeException());

        try {
            ResponseEntity<Stream<Path>> responseEntity = fileController.getFile();
        } catch (RuntimeException e) {
            assertEquals(RuntimeException.class, e.getClass());
        }
    }
}
