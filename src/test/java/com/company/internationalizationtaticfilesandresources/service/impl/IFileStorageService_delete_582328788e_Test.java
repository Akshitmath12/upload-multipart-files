package com.company.internationalizationtaticfilesandresources.service.impl;

import com.company.internationalizationtaticfilesandresources.dto.ResponseMessage;
import com.company.internationalizationtaticfilesandresources.exception.DeleteFailedException;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class IFileStorageService_delete_582328788e_Test {

    @Mock
    private Path ROOT;

    @InjectMocks
    private FileStorageService fileStorageService;

    @BeforeEach
    void setUp() {
        ROOT = Paths.get("src/test/resources");
    }

    @Test
    public void testDeleteSuccess() throws Exception {
        String fileName = "test.txt";

        when(Files.deleteIfExists(ROOT.resolve(fileName))).thenReturn(true);

        ResponseMessage responseMessage = fileStorageService.delete(fileName);

        assertEquals("DELETE_SUCCESSFULLY", responseMessage.getMessage().toString());
        verify(Files.deleteIfExists(ROOT.resolve(fileName)), times(1));
    }

    @Test
    public void testDeleteFailure() throws Exception {
        String fileName = "test.txt";

        when(Files.deleteIfExists(ROOT.resolve(fileName))).thenReturn(false);

        assertThrows(DeleteFailedException.class, () -> fileStorageService.delete(fileName));
        verify(Files.deleteIfExists(ROOT.resolve(fileName)), times(1));
    }

    @Test
    public void testDeleteIOException() throws Exception {
        String fileName = "test.txt";

        when(Files.deleteIfExists(ROOT.resolve(fileName))).thenThrow(IOException.class);

        assertThrows(DeleteFailedException.class, () -> fileStorageService.delete(fileName));
        verify(Files.deleteIfExists(ROOT.resolve(fileName)), times(1));
    }
}
