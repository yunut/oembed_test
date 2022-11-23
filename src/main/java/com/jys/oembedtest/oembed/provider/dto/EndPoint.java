package com.jys.oembedtest.oembed.provider.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.ArrayList;

@NoArgsConstructor
@Getter
public class EndPoint {
    private ArrayList<String> schemes;
    private String url;
    private boolean discovery;
    private ArrayList<String> formats;
}
