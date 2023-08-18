package com.example.demo.repository.custom;

import com.example.demo.domain.Board;
import com.example.demo.domain.Reply;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;
import java.util.Optional;

public interface ReplyCustomRepository {
    List<Reply> findReplyList(Long boardId);
    Optional<Reply> findReply(Long replyId);
}
