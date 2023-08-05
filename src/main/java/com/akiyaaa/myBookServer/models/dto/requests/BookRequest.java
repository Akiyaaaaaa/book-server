package com.akiyaaa.myBookServer.models.dto.requests;

import lombok.Data;

import java.util.Date;

@Data
public class BookRequest {
    private String title;
    private Date releaseDate;
    private Long publisherId;
    private Long authorId;
    private Long[] genres;
}
