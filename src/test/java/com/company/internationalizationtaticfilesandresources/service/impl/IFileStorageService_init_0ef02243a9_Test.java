package com.company.internationalizationtaticfilesandresources.service.impl;

import com.company.internationalizationtaticfilesandresources.service.FileStorageService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.slf4j.Logger;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.*;

public class IFileStorageService_init_0ef02243a9_Test {

    @Mock
    private Logger log;

    @InjectMocks
    private FileStorageService fileStorageService;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    public void testInit_Successful() throws IOException {
        Path ROOT = Paths.get("test");

        when(Files.createDirectory(ROOT)).thenReturn(ROOT);

        fileStorageService.init();

        verify(log, times(1)).info(anyString(), eq(ROOT.getRoot()));
        verify(log, never()).error(anyString());
    }

    @Test
    public void testInit_DirectoryCreationFailed() throws IOException {
        Path ROOT = Paths.get("test");

        when(Files.createDirectory(ROOT)).thenThrow(IOException.class);

        assertThrows(RuntimeException.class, () -> fileStorageService.init());

        verify(log, times(1)).error(anyString());
    }
}
