package com.moskalyuk.ispairbe.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;


@Getter
public class NewsResponse {

    @JsonProperty("id")
    Integer id;

    @JsonProperty("title")
    String name;

    @JsonProperty("score")
    Double rating;

    @JsonProperty("by")
    String author;

    @JsonProperty("time")
    Long unixTime;

    @JsonProperty("descendants")
    Integer commentsCount;

//    @JsonProperty("kids")
//    long[] comments;

    @JsonProperty("url")
    String link;
}
