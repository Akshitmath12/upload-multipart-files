// Test generated by RoostGPT for test test2 using AI Type Open AI and AI Model gpt-4

package com.company.internationalizationtaticfilesandresources.exception;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.MockitoAnnotations;

import com.company.internationalizationtaticfilesandresources.enums.ExceptionEnum;

public class DeleteFailedException_DeleteFailedException_ce1399c218_Test {

    @InjectMocks
    private DeleteFailedException deleteFailedException = new DeleteFailedException(ExceptionEnum.DELETE_FAILED);

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    public void testDeleteFailedException() {
        try {
            throw deleteFailedException;
        } catch (DeleteFailedException e) {
            assertEquals(ExceptionEnum.DELETE_FAILED.name(), e.getMessage());
        }
    }

    @Test
    public void testDeleteFailedExceptionWithDifferentException() {
        try {
            throw new DeleteFailedException(ExceptionEnum.DELETE_FAILED);
        } catch (DeleteFailedException e) {
            assertEquals(ExceptionEnum.DELETE_FAILED.name(), e.getMessage());
        }
    }
}
