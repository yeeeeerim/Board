package com.example.demo.service;

import com.example.demo.common.CommonException;
import com.example.demo.common.ErrorCode;
import com.example.demo.domain.Board;
import com.example.demo.dto.request.BoardRequestDTO;
import com.example.demo.dto.request.BoardUpdateRequestDTO;
import com.example.demo.dto.response.BoardDetailResponseDTO;
import com.example.demo.dto.response.BoardListResponseDTO;
import com.example.demo.repository.BoardRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.beans.Transient;

@Service
@RequiredArgsConstructor
public class BoardService {
    private final BoardRepository boardRepository;

    @Transactional
    public Long saveBoard(BoardRequestDTO boardRequestDTO){
        Board board= boardRequestDTO.toEntity();
        boardRepository.save(board);
        return board.getId();
    }

    public Page<BoardListResponseDTO> listBoard(Pageable pageable){
        Page<Board> boards = boardRepository.findBoardList(pageable);
        return boards.map(BoardListResponseDTO::new);
    }

    public BoardDetailResponseDTO detailBoard(Long boardId){
        Board board = boardRepository.findByIdBoard(boardId)
                .orElseThrow(()->new CommonException(ErrorCode.BOARD_NOT_FOUND));
        return new BoardDetailResponseDTO(board);

    }

    @Transactional
    public Long deleteBoard(Long boardId){
        Board board = boardRepository.findByIdBoard(boardId)
                .orElseThrow(()->new CommonException(ErrorCode.BOARD_NOT_FOUND));
        board.setDeleted();
        return board.getId();
    }

    @Transactional
    public Long updateBoard(BoardUpdateRequestDTO dto){
        Board board = boardRepository.findByIdBoard(dto.getId())
                .orElseThrow(()->new CommonException(ErrorCode.BOARD_NOT_FOUND));
        board.updateBoard(dto);
        return board.getId();
    }

}
