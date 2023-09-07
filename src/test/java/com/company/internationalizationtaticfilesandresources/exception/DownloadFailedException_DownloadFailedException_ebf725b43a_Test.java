package com.company.internationalizationtaticfilesandresources.exception;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class DownloadFailedException_DownloadFailedException_ebf725b43a_Test {

    private DownloadFailedException downloadFailedException;

    @BeforeEach
    public void setUp() {
        downloadFailedException = new DownloadFailedException();
    }

    @Test
    public void testDownloadFailedExceptionMessage() {
        assertEquals(ExceptionEnum.DOWNLOAD_FAILED.name(), downloadFailedException.getMessage());
    }

    @Test
    public void testDownloadFailedExceptionType() {
        assertEquals(DownloadFailedException.class, downloadFailedException.getClass());
    }
}
