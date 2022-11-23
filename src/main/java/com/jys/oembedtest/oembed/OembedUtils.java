package com.jys.oembedtest.oembed;

import com.jys.oembedtest.oembed.provider.dto.Provider;

import java.net.MalformedURLException;
import java.net.URL;

public class OembedUtils {

    /**
     * URL 호스트 반환
     * @param str
     * @return URL HOST
     */
    public static String hostCheck(String str) {
        String result = "";
        try {
            URL url = new URL(str);

            String[] split = url.getHost().split("\\.");

            // split 데이터가 2개일 경우
            if (split.length == 2) {
                result = split[0];
            } else if (split.length == 3) {
                result = split[1];
            }

        } catch (MalformedURLException e) {
            e.printStackTrace();
        }
        return result;
    }

    // 프로바이더 url + 포맷 + 인코드

    /**
     * 프로바이더 URL + 포맷, 인코드 형식의 주소 반환
     * @param host
     * @param encode
     * @param providers
     * @return
     */
    public static String createOembedURL(String host, String encode, Provider[] providers) {
        String oembedUrl = "";
        // 프로바이더 url을 검색
        for (Provider provider : providers) {
            String url = provider.getEndpoints().get(0).getUrl();
            if (url.contains(host)) {
                // 프로바이더 url + ?format=json&url= + encode data
                if (url.contains("oembed.")) {
                    // {format}이 들어있으면 json 포맷으로 요청
                    if (url.contains("{format}")) {
                        url = url.replace("{format}", "json");
                    }
                    oembedUrl = url + "?url=" + encode;
                } else {
                    oembedUrl = url + "?format=json&url=" + encode;
                }
                break;
            }
        }

        return oembedUrl;
    }
}
