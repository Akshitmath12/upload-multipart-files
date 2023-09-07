package com.company.internationalizationtaticfilesandresources.exception;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;
import com.company.internationalizationtaticfilesandresources.enums.ExceptionEnum;

public class NotFoundException_NotFoundException_328ce0c88a_Test {

    private NotFoundException notFoundException;
    private String message = ExceptionEnum.NOT_FOUND_FILE.name();
    private Throwable cause = null;

    @BeforeEach
    public void setUp() {
        notFoundException = new NotFoundException(message, cause);
    }

    @Test
    public void testNotFoundExceptionMessage() {
        assertEquals(message, notFoundException.getMessage());
    }

    @Test
    public void testNotFoundExceptionCause() {
        assertEquals(cause, notFoundException.getCause());
    }
}
