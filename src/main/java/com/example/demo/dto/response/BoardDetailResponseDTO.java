package com.example.demo.dto.response;

import com.example.demo.domain.Board;
import lombok.Data;

import java.time.LocalDateTime;

@Data
public class BoardDetailResponseDTO {
    private Long id;
    private String title;
    private String content;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;

    public BoardDetailResponseDTO(Board board){
        this.id= board.getId();
        this.title= board.getTitle();
        this.content= board.getContent();
        this.createdAt= board.getCreated_at();
        this.updatedAt= board.getUpdated_at();
    }
}
