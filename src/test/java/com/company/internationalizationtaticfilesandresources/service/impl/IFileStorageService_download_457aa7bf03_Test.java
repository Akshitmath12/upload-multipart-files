package com.company.internationalizationtaticfilesandresources.service.impl;

import com.company.internationalizationtaticfilesandresources.exception.DownloadFailedException;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.core.io.Resource;
import org.springframework.core.io.UrlResource;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class IFileStorageService_download_457aa7bf03_Test {

    @Mock
    private UrlResource urlResource;

    @InjectMocks
    private FileStorageService fileStorageService = new FileStorageService();

    private static final Path ROOT = Paths.get("uploads");

    @BeforeEach
    public void setUp() throws IOException {
        when(urlResource.exists()).thenReturn(true);
        when(urlResource.isReadable()).thenReturn(true);
        when(urlResource.getInputStream()).thenReturn(Files.newInputStream(ROOT));
    }

    @Test
    public void testDownload_Success() throws Exception {
        Resource resource = fileStorageService.download("testFile.txt");
        assertTrue(resource.exists());
        assertTrue(resource.isReadable());
    }

    @Test
    public void testDownload_Failure() throws Exception {
        when(urlResource.exists()).thenReturn(false);
        when(urlResource.isReadable()).thenReturn(false);

        assertThrows(DownloadFailedException.class, () -> {
            fileStorageService.download("testFile.txt");
        });
    }
}
