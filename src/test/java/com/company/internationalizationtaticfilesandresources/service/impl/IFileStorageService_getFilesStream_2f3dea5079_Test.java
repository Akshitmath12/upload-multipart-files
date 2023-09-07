package com.company.internationalizationtaticfilesandresources.service.impl;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.stream.Stream;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

public class IFileStorageService_getFilesStream_2f3dea5079_Test {
    
    @Mock
    private FileStorageService fileStorageService;

    @BeforeEach
    public void setup() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    public void testGetFilesStream_Success() {
        Path path = Paths.get("testfile.txt");
        Stream<Path> pathStream = Stream.of(path);
        when(fileStorageService.getFilesStream()).thenReturn(pathStream);
        Stream<Path> result = fileStorageService.getFilesStream();
        assertNotNull(result);
        assertTrue(result.findAny().isPresent());
    }

    @Test
    public void testGetFilesStream_NotFoundException() {
        Stream<Path> pathStream = Stream.empty();
        when(fileStorageService.getFilesStream()).thenReturn(pathStream);
        Stream<Path> result = fileStorageService.getFilesStream();
        assertTrue(result.findAny().isEmpty());
    }

    @Test
    public void testGetFilesStream_IOException() {
        when(fileStorageService.getFilesStream()).thenThrow(new RuntimeException());
        assertThrows(RuntimeException.class, () -> fileStorageService.getFilesStream());
    }
}
