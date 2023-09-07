package com.company.internationalizationtaticfilesandresources.service.impl;

import com.company.internationalizationtaticfilesandresources.exception.DownloadFailedException;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.core.io.UrlResource;
import org.springframework.core.io.Resource;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.io.IOException;
import static org.mockito.Mockito.when;
import static org.mockito.Mockito.any;
import static org.junit.jupiter.api.Assertions.*;

class IFileStorageService_download_f4ddb4302b_Test {

    @Mock
    UrlResource urlResource;

    @InjectMocks
    FileStorageService fileStorageService;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    void testDownloadSuccess() throws IOException {
        String fileName = "testFile.txt";
        Path file = Paths.get(fileName);

        when(urlResource.exists()).thenReturn(true);
        when(urlResource.isReadable()).thenReturn(true);
        when(urlResource.getInputStream()).thenReturn(any());

        Resource result = fileStorageService.download(fileName);

        assertNotNull(result, "File should not be null");
        assertEquals(file.toUri(), result.getURI(), "File URIs should match");
    }

    @Test
    void testDownloadFailure() {
        String fileName = "invalidFile.txt";
        Path file = Paths.get(fileName);

        when(urlResource.exists()).thenReturn(false);
        when(urlResource.isReadable()).thenReturn(false);

        assertThrows(DownloadFailedException.class, () -> fileStorageService.download(fileName));
    }
}
