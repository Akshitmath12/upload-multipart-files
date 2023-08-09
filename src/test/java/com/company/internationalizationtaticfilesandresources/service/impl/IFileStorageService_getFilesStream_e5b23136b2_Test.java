package com.company.internationalizationtaticfilesandresources.service.impl;

import com.company.internationalizationtaticfilesandresources.exception.NotFoundException;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

public class IFileStorageService_getFilesStream_e5b23136b2_Test {

    @InjectMocks
    FileStorageService fileStorageService;

    @Mock
    Path ROOT;

    @BeforeEach
    public void setup() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void testGetFilesStream_Success() {
        Path path = Paths.get("/path/to/directory/with/files");
        when(ROOT.toAbsolutePath()).thenReturn(path);

        Stream<Path> result = fileStorageService.getFilesStream();

        assertNotNull(result);
        assertTrue(result.findAny().isPresent());
    }

    @Test
    public void testGetFilesStream_NotFoundException() {
        Path path = Paths.get("/path/to/directory/without/files");
        when(ROOT.toAbsolutePath()).thenReturn(path);

        assertThrows(NotFoundException.class, () -> fileStorageService.getFilesStream());
    }

    @Test
    public void testGetFilesStream_IOException() {
        Path path = Paths.get("/path/to/nonexistent/directory");
        when(ROOT.toAbsolutePath()).thenReturn(path);

        assertThrows(RuntimeException.class, () -> fileStorageService.getFilesStream());
    }
}
