package com.company.internationalizationtaticfilesandresources.exception;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class NotFoundException_NotFoundException_b5f83317fb_Test {
    
    private NotFoundException notFoundException;

    @BeforeEach
    public void setUp() {
        notFoundException = new NotFoundException();
    }

    @Test
    public void testNotFoundExceptionMessage() {
        assertEquals("NOT_FOUND_FILE", notFoundException.getMessage());
    }

    @Test
    public void testNotFoundExceptionCause() {
        assertNull(notFoundException.getCause());
    }
}
