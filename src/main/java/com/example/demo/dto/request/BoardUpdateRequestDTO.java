package com.example.demo.dto.request;

import lombok.Data;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

@Data
public class BoardUpdateRequestDTO {
    @NotNull
    private Long id;
    @NotEmpty
    private String title;
    @NotEmpty
    private String content;
}
