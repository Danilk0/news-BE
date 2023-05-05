package com.moskalyuk.ispairbe.service;

import com.moskalyuk.ispairbe.dto.News;
import com.moskalyuk.ispairbe.dto.NewsResponse;
import com.moskalyuk.ispairbe.dto.PreviewNews;
import com.moskalyuk.ispairbe.mapper.NewsMapper;
import com.moskalyuk.ispairbe.mapper.PreviewNewsMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.http.RequestEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;


import java.net.URI;
import java.time.LocalDateTime;
import java.util.*;

@Service
@RequiredArgsConstructor
public class NewsService {

    private final RestTemplate restTemplate;

    private final PreviewNewsMapper previewNewsMapper;

    private final NewsMapper newsMapper;

    public List<PreviewNews> getNews(){

        RequestEntity<Void> requestEntity= RequestEntity.get(URI.create("https://hacker-news.firebaseio.com/v0/newstories.json"))
                .build();
        long[] body = restTemplate.exchange(requestEntity, long[].class).getBody();
        return Optional.ofNullable(body).stream()
                .flatMapToLong(Arrays::stream)
                .limit(100)
                .mapToObj(this::sendRequest)
                .map(previewNewsMapper::map)
                .sorted(Comparator.comparing(PreviewNews::getDate, LocalDateTime::compareTo).reversed())
                .toList();
    }

    public News getNewsById(Long id) {
        return Optional.ofNullable(sendRequest(id))
                .map(newsMapper::map)
                .orElseThrow();
    }
    private NewsResponse sendRequest(Long id){
        RequestEntity<Void> requestEntity= RequestEntity.get(URI.create(String.format("https://hacker-news.firebaseio.com/v0/item/%s.json",id)))
                .build();
        return restTemplate.exchange(requestEntity, NewsResponse.class).getBody();

    }


}
