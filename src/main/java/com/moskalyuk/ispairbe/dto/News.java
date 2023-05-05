package com.moskalyuk.ispairbe.dto;

import lombok.Builder;
import lombok.Getter;

import java.time.LocalDateTime;
import java.util.Date;
import java.util.LinkedList;
import java.util.Map;

@Builder
@Getter
public class News {
    Integer id;
    String link;
    String title;
    LocalDateTime date;
    Integer counter;
//    Map<String, LinkedList<String>> comments;

}
