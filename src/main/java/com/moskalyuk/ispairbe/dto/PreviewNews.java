package com.moskalyuk.ispairbe.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Builder;
import lombok.Getter;
import lombok.ToString;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDateTime;


@Getter
@Builder
@ToString
public class PreviewNews {

    Long id;

    String name;

    Double rating;

    String author;

    @DateTimeFormat(pattern = "dd-MM-yyyy, HH:mm")
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd-MM-yyyy, HH:mm")
    LocalDateTime date;

}
