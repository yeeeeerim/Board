package com.example.demo.dto.request;

import com.example.demo.domain.Board;
import com.example.demo.domain.Reply;
import lombok.Data;

@Data
public class ReplyRequestDTO {
    private Long boardId;
    private String content;
    public Reply toEntity(Board board){
        return Reply.builder()
                .board(board)
                .content(content)
                .build();
    }

}
