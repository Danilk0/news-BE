package com.moskalyuk.ispairbe.controller;

import com.moskalyuk.ispairbe.dto.News;
import com.moskalyuk.ispairbe.dto.PreviewNews;
import com.moskalyuk.ispairbe.service.NewsService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/v0/news")
@RequiredArgsConstructor
public class NewsRestController {

    private final NewsService newsService;

    @GetMapping("")
    @CrossOrigin
    public List<PreviewNews> getActualNews() {
        return newsService.getNews();
    }

    @CrossOrigin
    @GetMapping("/{id}")
    public News getNewsById(@PathVariable Long id){
        return newsService.getNewsById(id);
    }
}
