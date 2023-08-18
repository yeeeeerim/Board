package com.example.demo.repository;

import com.example.demo.domain.Board;
import com.example.demo.repository.custom.BoardCustomRepository;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BoardRepository extends JpaRepository<Board,Long>, BoardCustomRepository {
}
