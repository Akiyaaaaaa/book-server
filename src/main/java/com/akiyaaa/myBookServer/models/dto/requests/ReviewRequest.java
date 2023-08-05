package com.akiyaaa.myBookServer.models.dto.requests;

import lombok.Data;

@Data
public class ReviewRequest {
    private Long rating;
    private String content;
    private Long bookId;
    private Long userId;
}
