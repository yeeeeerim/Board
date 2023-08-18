package com.example.demo.controller;

import com.example.demo.common.CodeEnum;
import com.example.demo.common.CommonResponse;
import com.example.demo.dto.request.BoardRequestDTO;
import com.example.demo.dto.request.BoardUpdateRequestDTO;
import com.example.demo.service.BoardService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/boards")
public class BoardController {
    private final BoardService boardService;
    @PostMapping
    public ResponseEntity<CommonResponse> writeBoard(@Valid @RequestBody BoardRequestDTO dto){

        CommonResponse<?> commonResponse = CommonResponse.builder()
                                            .codeEnum(CodeEnum.SUCCESS)
                                            .data(boardService.saveBoard(dto))
                                            .build();
        return ResponseEntity.status(commonResponse.getStatus()).body(commonResponse);
    }

    @GetMapping("/list")
    public ResponseEntity<CommonResponse> listBoard(@RequestParam(name = "page", defaultValue = "0") int page,
                                                    @RequestParam(name = "size", defaultValue = "8") int size){
        Pageable pageable = PageRequest.of(page, size);
        CommonResponse<?> commonResponse = CommonResponse.builder()
                .codeEnum(CodeEnum.SUCCESS)
                .data(boardService.listBoard(pageable))
                .build();
        return ResponseEntity.status(commonResponse.getStatus()).body(commonResponse);

    }

    @GetMapping("/{id}")
    public ResponseEntity<CommonResponse> detailBoard(@PathVariable Long id){
        CommonResponse<?> commonResponse = CommonResponse.builder()
                .codeEnum(CodeEnum.SUCCESS)
                .data(boardService.detailBoard(id))
                .build();
        return ResponseEntity.status(commonResponse.getStatus()).body(commonResponse);

    }

    @DeleteMapping("/{id}")
    public ResponseEntity<CommonResponse> deleteBoard(@PathVariable Long id){
        CommonResponse<?> commonResponse = CommonResponse.builder()
                .codeEnum(CodeEnum.SUCCESS)
                .data(boardService.deleteBoard(id))
                .build();
        return ResponseEntity.status(commonResponse.getStatus()).body(commonResponse);

    }

    @PutMapping("/{id}")
    public ResponseEntity<CommonResponse> updateBoard(@Valid @RequestBody BoardUpdateRequestDTO dto){
        CommonResponse<?> commonResponse = CommonResponse.builder()
                .codeEnum(CodeEnum.SUCCESS)
                .data(boardService.updateBoard(dto))
                .build();
        return ResponseEntity.status(commonResponse.getStatus()).body(commonResponse);

    }





}
