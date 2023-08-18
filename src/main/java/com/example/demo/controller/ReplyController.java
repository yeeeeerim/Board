package com.example.demo.controller;

import com.example.demo.common.CodeEnum;
import com.example.demo.common.CommonResponse;
import com.example.demo.dto.request.ReplyRequestDTO;
import com.example.demo.dto.request.ReplyUpdateRequestDTO;
import com.example.demo.service.ReplyService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/reply")
public class ReplyController {
    private final ReplyService replyService;

    @PostMapping
    public ResponseEntity<CommonResponse> saveReply (@RequestBody ReplyRequestDTO dto){

        CommonResponse<?> commonResponse = CommonResponse.builder()
                .codeEnum(CodeEnum.SUCCESS)
                .data(replyService.saveReply(dto))
                .build();
        return ResponseEntity.status(commonResponse.getStatus()).body(commonResponse);
    }

    @GetMapping("/list/{boardId}")
    public ResponseEntity<CommonResponse> listReply (@PathVariable Long boardId){

        CommonResponse<?> commonResponse = CommonResponse.builder()
                .codeEnum(CodeEnum.SUCCESS)
                .data(replyService.listReply(boardId))
                .build();
        return ResponseEntity.status(commonResponse.getStatus()).body(commonResponse);
    }

    @PutMapping
    public ResponseEntity<CommonResponse> updateReply (@RequestBody ReplyUpdateRequestDTO dto){

        CommonResponse<?> commonResponse = CommonResponse.builder()
                .codeEnum(CodeEnum.SUCCESS)
                .data(replyService.updateReply(dto))
                .build();
        return ResponseEntity.status(commonResponse.getStatus()).body(commonResponse);
    }

    @DeleteMapping("/{replyId}")
    public ResponseEntity<CommonResponse> deleteReply (@PathVariable Long replyId){

        CommonResponse<?> commonResponse = CommonResponse.builder()
                .codeEnum(CodeEnum.SUCCESS)
                .data(replyService.deleteReply(replyId))
                .build();
        return ResponseEntity.status(commonResponse.getStatus()).body(commonResponse);
    }
}
