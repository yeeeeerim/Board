package com.example.demo.dto.response;

import com.example.demo.domain.Board;
import com.example.demo.dto.request.BoardRequestDTO;
import lombok.Builder;
import lombok.Data;

import java.time.LocalDateTime;

@Data
public class BoardListResponseDTO {
    private Long id;
    private String title;
    private LocalDateTime createAt;
    public BoardListResponseDTO (Board board) {
        this.id= board.getId();
        this.title = board.getTitle();
        this.createAt = board.getCreated_at();
    }
}
