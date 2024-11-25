package com.collabhub.majd.controller;

import com.collabhub.majd.service.ExternalApiService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/v1/posts")
@RequiredArgsConstructor
public class ExternalApiController {

    private final ExternalApiService externalApiService;

    @GetMapping("/fetch")
    public List<Map<String, Object>> fetchPosts() {
        // Call the service to fetch posts
        return externalApiService.fetchPosts();
    }
}
