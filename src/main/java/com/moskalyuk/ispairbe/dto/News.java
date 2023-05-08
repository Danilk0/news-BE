package com.moskalyuk.ispairbe.dto;

import lombok.Builder;
import lombok.Getter;

import java.time.LocalDateTime;


@Builder
@Getter
public class News {

    Long id;

    String link;

    String title;

    LocalDateTime date;

    Integer counter;

}
