package com.company.internationalizationtaticfilesandresources.service.impl;

import com.company.internationalizationtaticfilesandresources.dto.ResponseMessage;
import com.company.internationalizationtaticfilesandresources.enums.ExceptionEnum;
import com.company.internationalizationtaticfilesandresources.enums.SuccessMessageEnum;
import com.company.internationalizationtaticfilesandresources.exception.DeleteFailedException;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.slf4j.Logger;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class IFileStorageService_delete_582328788e_Test {

    @InjectMocks
    private FileStorageService fileStorageService;

    @Mock
    private Logger log;

    private static final Path ROOT = Paths.get("uploads");

    @BeforeEach
    public void setUp() {
        // removed this line as we are using @InjectMocks annotation
        // fileStorageService = new FileStorageService(); 
    }

    @Test
    public void testDeleteFile_Success() throws IOException {
        String fileName = "testFile.txt";
        when(Files.deleteIfExists(ROOT.resolve(fileName))).thenReturn(true);

        ResponseMessage response = fileStorageService.delete(fileName);

        verify(log, times(1)).info(SuccessMessageEnum.DELETE_SUCCESSFULLY.name());
        assertEquals(SuccessMessageEnum.DELETE_SUCCESSFULLY.name(), response.getMessage().toString());
    }

    @Test
    public void testDeleteFile_FileDoesNotExist() throws IOException {
        String fileName = "nonExistentFile.txt";
        when(Files.deleteIfExists(ROOT.resolve(fileName))).thenReturn(false);

        try {
            fileStorageService.delete(fileName);
        } catch (DeleteFailedException e) {
            verify(log, times(1)).error(ExceptionEnum.DELETE_FAILED.name());
        }
    }

    @Test
    public void testDeleteFile_IOException() throws IOException {
        String fileName = "testFile.txt";
        when(Files.deleteIfExists(any())).thenThrow(new IOException());

        try {
            fileStorageService.delete(fileName);
        } catch (DeleteFailedException e) {
            verify(log, times(0)).info(SuccessMessageEnum.DELETE_SUCCESSFULLY.name());
            verify(log, times(0)).error(ExceptionEnum.DELETE_FAILED.name());
        }
    }
}
