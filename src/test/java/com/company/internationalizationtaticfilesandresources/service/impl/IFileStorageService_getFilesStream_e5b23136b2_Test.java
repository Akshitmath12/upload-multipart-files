package com.company.internationalizationtaticfilesandresources.service.impl;

import com.company.internationalizationtaticfilesandresources.exception.NotFoundException;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.junit.jupiter.MockitoExtension;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class IFileStorageService_getFilesStream_e5b23136b2_Test {

    @InjectMocks
    FileStorageService fileStorageService = new FileStorageService();

    @Test
    public void testGetFilesStream_success() {
        Path path = mock(Path.class);
        Stream<Path> pathStream = Stream.of(path);

        try {
            when(Files.walk(Paths.get("ROOT"))).thenReturn(pathStream);
            when(Files.isRegularFile(path)).thenReturn(true);

            Stream<Path> result = fileStorageService.getFilesStream();
            assertNotNull(result);
            assertTrue(result.findAny().isPresent());

        } catch (Exception e) {
            fail("Test failed due to exception: " + e.getMessage());
        }
    }

    @Test
    public void testGetFilesStream_noFilesFound() {
        Path path = mock(Path.class);
        Stream<Path> pathStream = Stream.of(path);

        try {
            when(Files.walk(Paths.get("ROOT"))).thenReturn(pathStream);
            when(Files.isRegularFile(path)).thenReturn(false);

            assertThrows(NotFoundException.class, () -> fileStorageService.getFilesStream());

        } catch (Exception e) {
            fail("Test failed due to exception: " + e.getMessage());
        }
    }

    @Test
    public void testGetFilesStream_ioException() {
        try {
            when(Files.walk(Paths.get("ROOT"))).thenThrow(new IOException());

            assertThrows(RuntimeException.class, () -> fileStorageService.getFilesStream());

        } catch (Exception e) {
            fail("Test failed due to exception: " + e.getMessage());
        }
    }
}
