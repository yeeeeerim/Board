package com.example.demo.dto.request;

import com.example.demo.domain.Board;
import lombok.Data;

import javax.validation.constraints.NotEmpty;

@Data
public class BoardRequestDTO {
    @NotEmpty
    private String title;
    @NotEmpty
    private String content;

    public Board toEntity(){
        return Board.builder()
                .title(title)
                .content(content)
                .deleted(false)
                .build();
    }
}
