package com.example.demo.common;

import lombok.AllArgsConstructor;
import lombok.Getter;
import org.springframework.http.HttpStatus;

@AllArgsConstructor
@Getter
public enum ErrorCode {
    BOARD_NOT_FOUND(HttpStatus.BAD_REQUEST, "해당 게시물 찾을 수 없음"),
    REPLY_NOT_FOUND(HttpStatus.BAD_REQUEST,"해당 댓글을 찾을 수 없음");


    private HttpStatus httpStatus;
    private String message;
}
