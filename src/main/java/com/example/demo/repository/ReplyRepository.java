package com.example.demo.repository;

import com.example.demo.domain.Reply;
import com.example.demo.repository.custom.ReplyCustomRepository;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ReplyRepository extends JpaRepository<Reply, Long>, ReplyCustomRepository {
}
