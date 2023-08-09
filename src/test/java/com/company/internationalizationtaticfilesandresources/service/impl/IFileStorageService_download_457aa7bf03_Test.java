// Test generated by RoostGPT for test test2 using AI Type Open AI and AI Model gpt-4

package com.company.internationalizationtaticfilesandresources.service.impl;

import com.company.internationalizationtaticfilesandresources.dto.ResponseMessage;
import com.company.internationalizationtaticfilesandresources.enums.ExceptionEnum;
import com.company.internationalizationtaticfilesandresources.enums.SuccessMessageEnum;
import com.company.internationalizationtaticfilesandresources.exception.DeleteFailedException;
import com.company.internationalizationtaticfilesandresources.exception.DownloadFailedException;
import com.company.internationalizationtaticfilesandresources.exception.NotFoundException;
import com.company.internationalizationtaticfilesandresources.exception.UploadFailedException;
import com.company.internationalizationtaticfilesandresources.service.FileStorageService;
import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;
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
@Slf4j
public class IFileStorageService_download_457aa7bf03_Test {

    @InjectMocks
    private FileStorageService fileStorageService;

    @Mock
    private Path ROOT;

    @Test
    public void testDownloadSuccess() throws IOException {
        String fileName = "testFile.txt";
        Path file = Paths.get(fileName);
        Resource resource = new UrlResource(file.toUri());

        when(ROOT.resolve(fileName)).thenReturn(file);
        when(resource.exists()).thenReturn(true);
        when(resource.isReadable()).thenReturn(true);

        Resource result = fileStorageService.download(fileName);
        assertTrue(result.exists());
        assertTrue(result.isReadable());
    }

    @Test
    public void testDownloadFailure() throws IOException {
        String fileName = "testFile.txt";
        Path file = Paths.get(fileName);
        Resource resource = new UrlResource(file.toUri());

        when(ROOT.resolve(fileName)).thenReturn(file);
        when(resource.exists()).thenReturn(false);
        when(resource.isReadable()).thenReturn(false);

        assertThrows(DownloadFailedException.class, () -> {
            fileStorageService.download(fileName);
        });
    }
}
