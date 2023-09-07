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

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class IFileStorageService_delete_3a46b9842f_Test {

    @InjectMocks
    private FileStorageService fileStorageService;

    private Path root;
    private final String fileName = "test.txt";

    @BeforeEach
    public void setup() {
        root = Paths.get("/tmp");
    }

    @Test
    public void testDeleteFileSuccess() throws IOException {
        Path file = root.resolve(fileName);
        Files.createFile(file);

        ResponseMessage responseMessage = fileStorageService.delete(fileName);

        assertEquals(SuccessMessageEnum.DELETE_SUCCESSFULLY.name(), responseMessage.getMessage().toString());
        assertFalse(Files.exists(file));
    }

    @Test
    public void testDeleteFileFailure() throws IOException {
        Path file = root.resolve(fileName);

        assertThrows(DeleteFailedException.class, () -> {
            fileStorageService.delete(fileName);
        });
    }
}
