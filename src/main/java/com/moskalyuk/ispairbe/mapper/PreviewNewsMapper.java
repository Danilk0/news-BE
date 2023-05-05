package com.moskalyuk.ispairbe.mapper;

import com.moskalyuk.ispairbe.dto.PreviewNews;
import com.moskalyuk.ispairbe.dto.NewsResponse;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.time.ZoneOffset;

@Component
public class PreviewNewsMapper implements Map<NewsResponse,PreviewNews> {
    @Override
    public PreviewNews map(NewsResponse obj) {
        return PreviewNews.builder()
                .id(obj.getId())
                .author(obj.getAuthor())
                .name(obj.getName())
                .rating(obj.getRating())
                .date(LocalDateTime.ofEpochSecond(obj.getUnixTime(), 0, ZoneOffset.UTC))
                .build();
    }
}
