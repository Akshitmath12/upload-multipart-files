package com.company.internationalizationtaticfilesandresources.exception;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class UploadFailedException_UploadFailedException_78b326900b_Test {

    private UploadFailedException uploadFailedException;

    @BeforeEach
    public void setup() {
        uploadFailedException = new UploadFailedException();
    }

    @Test
    public void testUploadFailedExceptionMessage() {
        assertEquals("UploadFailed", uploadFailedException.getMessage());
    }

    @Test
    public void testUploadFailedExceptionType() {
        assertEquals(UploadFailedException.class, uploadFailedException.getClass());
    }
}
