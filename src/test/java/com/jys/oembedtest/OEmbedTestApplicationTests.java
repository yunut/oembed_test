package com.jys.oembedtest;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.jys.oembedtest.oembed.OembedRequest;
import com.jys.oembedtest.oembed.OembedResponse;
import com.jys.oembedtest.oembed.OembedService;
import com.jys.oembedtest.oembed.provider.dto.Provider;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.reactive.AutoConfigureWebTestClient;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.junit.jupiter.api.Assertions;
import org.springframework.http.*;
import org.springframework.test.web.reactive.server.WebTestClient;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.RestTemplate;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@SpringBootTest
class OEmbedTestApplicationTests {

	@Autowired
	OembedService oembedService;

	// 페이스북 API 요청 시 별도의 인증 토큰이 필요
	@Test
	void OEmbed_API_인스타그램_실패_테스트() throws JsonProcessingException{
		String json = "{ \"url\": \"https://www.instagram.com/p/BUawPlPF_Rx/\"}";
		ObjectMapper mapper = new ObjectMapper();
		OembedRequest oembedRequest = mapper.readValue(json, OembedRequest.class );


		Assertions.assertThrows(HttpClientErrorException.class, () -> {
			oembedService.changeUrlOmbedData(oembedRequest);
		});
	}

	@Test
	void OEmbed_API_유튜브_테스트() throws JsonProcessingException {
		//given
		String json = "{ \"url\": \"https://www.youtube.com/watch?v=dBD54EZIrZo\"}";
		ObjectMapper mapper = new ObjectMapper();
		OembedRequest oembedRequest = mapper.readValue(json, OembedRequest.class );

		Assertions.assertTrue(oembedService.changeUrlOmbedData(oembedRequest) instanceof OembedResponse);
	}

	@Test
	void OEmbed_API_트위터_테스트() throws JsonProcessingException {
		//given
		String json = "{ \"url\": \"https://twitter.com/hellopolicy/status/867177144815804416\"}";
		ObjectMapper mapper = new ObjectMapper();
		OembedRequest oembedRequest = mapper.readValue(json, OembedRequest.class );

		Assertions.assertTrue(oembedService.changeUrlOmbedData(oembedRequest) instanceof OembedResponse);
	}

	@Test
	void OEmbed_API_viemo_테스트() throws JsonProcessingException {
		//given
		String json = "{ \"url\": \"https://vimeo.com/20097015\"}";
		ObjectMapper mapper = new ObjectMapper();
		OembedRequest oembedRequest = mapper.readValue(json, OembedRequest.class );

		Assertions.assertTrue(oembedService.changeUrlOmbedData(oembedRequest) instanceof OembedResponse);
	}


}
