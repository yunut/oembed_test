package com.jys.oembedtest.oembed;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.jys.oembedtest.oembed.error.ErrorResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.HttpClientErrorException;


@RestController
public class OembedController {

    private Logger log = LoggerFactory.getLogger(getClass());

    @Autowired
    private OembedService oembedService;

    /**
     * oembed 변환 요청
     * @param oembedRequest
     * @return OembedResponse.class
     * @throws JsonProcessingException
     */
    @PostMapping("/oembed")
    @ResponseStatus(value = HttpStatus.OK)
    public OembedResponse oembed(@RequestBody OembedRequest oembedRequest) throws JsonProcessingException {
        return oembedService.changeUrlOmbedData(oembedRequest);
    }


    /**
     * Controller 외부 HTTP 요청 예외 시 공통 예외 클래스
     * @param exception
     * @return
     */
    @ExceptionHandler(HttpClientErrorException.class)
    private ResponseEntity<ErrorResponse> handleHttpClientErrorException(HttpClientErrorException exception) {
        log.error("HTTP Client Error. > Reason {}", exception.getMessage());
        return ResponseEntity.status(500)
                .contentType(MediaType.APPLICATION_JSON)
                .body(ErrorResponse.builder()
                        .message("Internal Server Error")
                        .build());
    }

    /**
     * Controller Json 파싱 예외 시 공통 처리 클래스
     * @param exception
     * @return
     */
    @ExceptionHandler(JsonProcessingException.class)
    private ResponseEntity<ErrorResponse> handleJsonProcessingException(JsonProcessingException exception) {
        log.error("JsonProcess Error", exception.getMessage());
        return ResponseEntity.status(500)
                .contentType(MediaType.APPLICATION_JSON)
                .body(ErrorResponse.builder()
                        .message("Internal Server Error")
                        .build());
    }
}
