package com.company.internationalizationtaticfilesandresources.service.impl;

import com.company.internationalizationtaticfilesandresources.enums.ExceptionEnum;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.io.TempDir;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.slf4j.Logger;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.*;

public class IFileStorageService_init_346f0673b9_Test {

    @TempDir
    Path tempDir;

    @Mock
    Logger log;

    @InjectMocks
    FileStorageService fileStorageService;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void testInit_success() {
        fileStorageService.init();
        verify(log).info(anyString(), any());
    }

    @Test
    public void testInit_failure() throws IOException {
        doThrow(IOException.class).when(fileStorageService).init();

        assertThrows(RuntimeException.class, () -> fileStorageService.init());
        verify(log).error(ExceptionEnum.DIRECTORY_CREATED_FAILED.name());
    }
}
