package com.example.demo.dto.response;

import com.example.demo.domain.Reply;
import lombok.Data;

@Data
public class ReplyResponseDTO {
    private Long replyId;
    private String content;

    public ReplyResponseDTO(Reply reply){
        this.replyId = reply.getId();
        this.content = reply.getContent();
    }
}
