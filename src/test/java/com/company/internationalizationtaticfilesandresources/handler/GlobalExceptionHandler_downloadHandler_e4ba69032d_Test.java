package com.company.internationalizationtaticfilesandresources.handler;

import com.company.internationalizationtaticfilesandresources.dto.ResponseMessage;
import com.company.internationalizationtaticfilesandresources.enums.ExceptionEnum;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.mock.web.MockHttpServletRequest;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import static org.assertj.core.api.Assertions.assertThat;

public class GlobalExceptionHandler_downloadHandler_e4ba69032d_Test {

    private GlobalExceptionHandler globalExceptionHandler;

    @BeforeEach
    public void setup() {
        MockHttpServletRequest request = new MockHttpServletRequest();
        RequestContextHolder.setRequestAttributes(new ServletRequestAttributes(request));
        globalExceptionHandler = new GlobalExceptionHandler();
    }

    @Test
    public void testDownloadHandler() {
        ResponseEntity<ResponseMessage> responseEntity = globalExceptionHandler.downloadHandler();

        assertThat(responseEntity.getStatusCode()).isEqualTo(HttpStatus.INTERNAL_SERVER_ERROR);
        assertThat(responseEntity.getBody().getMessage().toString()).isEqualTo(ExceptionEnum.DOWNLOAD_FAILED.name());
    }

    @Test
    public void testDownloadHandlerWithDifferentException() {
        // TODO: Change the ExceptionEnum to a different value
        ResponseEntity<ResponseMessage> responseEntity = globalExceptionHandler.downloadHandler();

        assertThat(responseEntity.getStatusCode()).isNotEqualTo(HttpStatus.OK);
        // Assuming that 'DOWNLOAD_SUCCESS' represents a successful status in ExceptionEnum
        assertThat(responseEntity.getBody().getMessage().toString()).isNotEqualTo(ExceptionEnum.DOWNLOAD_SUCCESS.name());
    }
}
