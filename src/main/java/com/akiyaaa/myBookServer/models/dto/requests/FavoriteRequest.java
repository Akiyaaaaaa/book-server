package com.akiyaaa.myBookServer.models.dto.requests;

import lombok.Data;

@Data
public class FavoriteRequest {
    private Long bookId;
    private Long userId;
}
