package com.company.internationalizationtaticfilesandresources.controller;

import com.company.internationalizationtaticfilesandresources.dto.ResponseMessage;
import com.company.internationalizationtaticfilesandresources.service.FileStorageService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.http.ResponseEntity;

import java.nio.file.Path;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

public class FileController_getFile_7a9b8d2dbd_Test {

    @InjectMocks
    private FileController fileController;

    @Mock
    private FileStorageService fileStorageService;

    @BeforeEach
    public void setup() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void testGetFileSuccess() {
        Stream<Path> expectedStream = Stream.of(Path.of("file1.txt"), Path.of("file2.txt"));
        when(fileStorageService.getFilesStream()).thenReturn(expectedStream);

        ResponseEntity<Stream<Path>> response = fileController.getFile();

        assertEquals(ResponseEntity.ok(expectedStream), response);
        verify(fileStorageService, times(1)).getFilesStream();
    }

    @Test
    public void testGetFileFailure() {
        when(fileStorageService.getFilesStream()).thenThrow(new RuntimeException());

        try {
            ResponseEntity<Stream<Path>> response = fileController.getFile();
        } catch (RuntimeException e) {
            assertEquals(RuntimeException.class, e.getClass());
        }

        verify(fileStorageService, times(1)).getFilesStream();
    }
}
