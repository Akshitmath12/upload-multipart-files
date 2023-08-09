package com.company.internationalizationtaticfilesandresources.service.impl;

import com.company.internationalizationtaticfilesandresources.enums.ExceptionEnum;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.io.TempDir;
import org.mockito.InjectMocks;
import org.mockito.MockitoAnnotations;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.*;

public class IFileStorageService_init_0ef02243a9_Test {

    private static final Logger log = LoggerFactory.getLogger(IFileStorageService_init_0ef02243a9_Test.class);

    @InjectMocks
    FileStorageService fileStorageService;

    @TempDir
    Path tempDir;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void testInit_success() throws IOException {
        Path directory = tempDir.resolve("testDir");
        Files.createDirectory(directory);
        fileStorageService.init();
        verify(log, times(1)).info(anyString(), eq(directory.getRoot()));
    }

    @Test
    public void testInit_failure() throws IOException {
        assertThrows(RuntimeException.class, () -> {
            throw new IOException();
        });
        verify(log, times(1)).error(ExceptionEnum.DIRECTORY_CREATED_FAILED.name());
    }
}
