package com.example.demo.repository.custom;

import com.example.demo.domain.Board;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface BoardCustomRepository {
    Page<Board> findBoardList(Pageable pageable);
    Optional<Board> findByIdBoard(Long id);
    Optional<Board> findByBoardIdReply(Long id);
}
