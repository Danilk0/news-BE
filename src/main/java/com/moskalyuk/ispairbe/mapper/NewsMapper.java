package com.moskalyuk.ispairbe.mapper;

import com.moskalyuk.ispairbe.dto.News;
import com.moskalyuk.ispairbe.dto.NewsResponse;
import com.moskalyuk.ispairbe.dto.PreviewNews;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.time.ZoneOffset;

@Component
public class NewsMapper implements Map<NewsResponse,News> {
    @Override
    public News map(NewsResponse obj) {
        return News.builder()
                .id(obj.getId())
                .link(obj.getLink())
                .title(obj.getName())
                .counter(obj.getCommentsCount())
                .date(LocalDateTime.ofEpochSecond(obj.getUnixTime(), 0, ZoneOffset.UTC))
                .build();
    }
}
