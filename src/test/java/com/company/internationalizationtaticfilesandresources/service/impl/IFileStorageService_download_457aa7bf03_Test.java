package com.company.internationalizationtaticfilesandresources.service.impl;

import com.company.internationalizationtaticfilesandresources.exception.DownloadFailedException;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.MockitoAnnotations;
import org.springframework.core.io.Resource;
import org.springframework.core.io.UrlResource;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.when;

public class IFileStorageService_download_457aa7bf03_Test {

    @InjectMocks
    FileStorageService fileStorageService;

    @BeforeEach
    public void init() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void testDownload_success() throws IOException {
        String fileName = "test.txt";
        Path file = Paths.get(fileName);
        Resource resource = new UrlResource(file.toUri());

        assertTrue(resource.equals(fileStorageService.download(fileName)));
    }

    @Test
    public void testDownload_fileNotExists() {
        String fileName = "test.txt";

        assertThrows(DownloadFailedException.class, () -> {
            fileStorageService.download(fileName);
        });
    }

    @Test
    public void testDownload_IOException() throws IOException {
        String fileName = "test.txt";

        assertThrows(DownloadFailedException.class, () -> {
            fileStorageService.download(fileName);
        });
    }
}
