package com.jys.oembedtest.oembed;

import lombok.Getter;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@Getter
public class OembedResponse {
    private String title;
    private String author_name;
    private String author_url;
    private String type;
    private int height;
    private int width;
    private String version;
    private String provider_name;
    private String provider_url;
    private int thumbnail_height;
    private int thumbnail_width;
    private String thumbnail_url;
    private String html;
}
