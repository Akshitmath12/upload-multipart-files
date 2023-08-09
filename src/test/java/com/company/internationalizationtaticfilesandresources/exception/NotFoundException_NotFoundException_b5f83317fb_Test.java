package com.company.internationalizationtaticfilesandresources.exception;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.MockitoAnnotations;
import com.company.internationalizationtaticfilesandresources.enums.ExceptionEnum;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

public class NotFoundException_NotFoundException_b5f83317fb_Test {

    @InjectMocks
    NotFoundException notFoundException;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void testNotFoundException() {
        NotFoundException exception = new NotFoundException();
        assertEquals(ExceptionEnum.NOT_FOUND_FILE.name(), exception.getMessage());
    }

    @Test
    public void testNotFoundExceptionWithDifferentException() {
        NotFoundException exception = new NotFoundException();
        assertNotEquals(ExceptionEnum.OTHER_EXCEPTION.name(), exception.getMessage());
    }
}
