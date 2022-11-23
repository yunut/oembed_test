package com.jys.oembedtest.oembed;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.jys.oembedtest.oembed.provider.dto.Provider;
import lombok.RequiredArgsConstructor;
import org.springframework.http.*;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
@RequiredArgsConstructor
public class OembedService {

    public OembedResponse changeUrlOmbedData(OembedRequest oembedRequest) throws JsonProcessingException {

        // Provider 정보
        // Provider 정보는 application/json 타입으로 얻어올 수 없어 변환이 필요
        String providerResponse = ExternalRestAPIRequest("https://oembed.com/providers.json",HttpMethod.GET, String.class);
        ObjectMapper mapper = new ObjectMapper();
        Provider[] providers = mapper.readValue(providerResponse, Provider[].class );

        // host 변환
        String host = OembedUtils.hostCheck(oembedRequest.getUrl());

        // oembedUrl 변환
        String oembedUrl = OembedUtils.createOembedURL(host, oembedRequest.getUrl(), providers);

        // oembed 요청
        OembedResponse oembedResponse = ExternalRestAPIRequest(oembedUrl, HttpMethod.GET, OembedResponse.class);


        return oembedResponse;
    }

    private <T> T ExternalRestAPIRequest(String url, HttpMethod method, Class<T> tClass) {
        RestTemplate restTemplate = new RestTemplate();
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        HttpEntity request = new HttpEntity(headers);

        ResponseEntity<T> response = restTemplate.exchange(
                url,
                method,
                request,
                tClass
        );

        return response.getBody();
    }
}
