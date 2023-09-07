package com.company.internationalizationtaticfilesandresources.exception;

import com.company.internationalizationtaticfilesandresources.enums.ExceptionEnum;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class UploadFailedException_UploadFailedException_5e9d22b518_Test {

    private UploadFailedException uploadFailedException;

    @BeforeEach
    public void setup() {
        uploadFailedException = new UploadFailedException(ExceptionEnum.UPLOAD_FAILED.name());
    }

    @Test
    public void testUploadFailedExceptionMessage() {
        assertEquals(ExceptionEnum.UPLOAD_FAILED.name(), uploadFailedException.getMessage());
    }

    @Test
    public void testUploadFailedExceptionInstanceOfRuntimeException() {
        assertTrue(uploadFailedException instanceof RuntimeException);
    }

}
