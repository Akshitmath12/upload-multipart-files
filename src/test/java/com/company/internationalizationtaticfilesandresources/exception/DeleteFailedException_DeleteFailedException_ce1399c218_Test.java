package com.company.internationalizationtaticfilesandresources.exception;

import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class DeleteFailedException_DeleteFailedException_ce1399c218_Test {

    private DeleteFailedException deleteFailedException;

    @BeforeEach
    public void setUp() {
        deleteFailedException = new DeleteFailedException();
    }

    @Test
    public void testDeleteFailedException() {
        String expectedMessage = ExceptionEnum.DELETE_FAILED.name();
        String actualMessage = deleteFailedException.getMessage();

        assertEquals(expectedMessage, actualMessage, "Expected message to be 'DELETE_FAILED'");
    }

    @Test
    public void testDeleteFailedExceptionWithDifferentException() {
        String expectedMessage = ExceptionEnum.DELETE_FAILED.name();
        deleteFailedException = new DeleteFailedException(ExceptionEnum.OTHER_ERROR.name());
        String actualMessage = deleteFailedException.getMessage();

        assertEquals(expectedMessage, actualMessage, "Expected message to be 'DELETE_FAILED' but was different");
    }
}
