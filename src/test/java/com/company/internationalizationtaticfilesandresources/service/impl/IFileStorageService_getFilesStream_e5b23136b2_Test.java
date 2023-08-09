// Test generated by RoostGPT for test test2 using AI Type Open AI and AI Model gpt-4

package com.company.internationalizationtaticfilesandresources.service.impl;

import com.company.internationalizationtaticfilesandresources.exception.NotFoundException;
import org.junit.jupiter.api.Assertions;
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

import static org.mockito.Mockito.*;

public class IFileStorageService_getFilesStream_e5b23136b2_Test {

    @InjectMocks
    private FileStorageService fileStorageService;

    @Mock
    private Path ROOT;

    @BeforeEach
    public void setup() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void testGetFilesStream_Success() throws IOException {
        Path path = Paths.get("src/test/resources");
        when(Files.walk(ROOT)).thenReturn(Stream.of(path));

        Stream<Path> result = fileStorageService.getFilesStream();

        Assertions.assertNotNull(result);
        Assertions.assertEquals(path, result.findFirst().get());
    }

    @Test
    public void testGetFilesStream_FileNotFound() throws IOException {
        when(Files.walk(ROOT)).thenReturn(Stream.empty());

        Assertions.assertThrows(NotFoundException.class, () -> fileStorageService.getFilesStream());
    }

    @Test
    public void testGetFilesStream_IOException() throws IOException {
        when(Files.walk(ROOT)).thenThrow(new IOException());

        Assertions.assertThrows(RuntimeException.class, () -> fileStorageService.getFilesStream());
    }
}
