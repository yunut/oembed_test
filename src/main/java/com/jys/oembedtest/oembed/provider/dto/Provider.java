package com.jys.oembedtest.oembed.provider.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.ArrayList;

@NoArgsConstructor
@Getter
public class Provider {
    private String provider_name;
    private String provider_url;
    private ArrayList<EndPoint> endpoints;
}
