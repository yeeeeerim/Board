package com.example.demo.dto.request;

import lombok.Data;

@Data
public class ReplyUpdateRequestDTO {
    private Long replyId;
    private String content;
}
