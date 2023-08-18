package com.example.demo.repository.custom.impl;

import com.example.demo.domain.QBoard;
import com.example.demo.domain.QReply;
import com.example.demo.domain.Reply;
import com.example.demo.repository.custom.ReplyCustomRepository;
import com.querydsl.jpa.impl.JPAQueryFactory;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
@RequiredArgsConstructor
public class ReplyCustomRepositoryImpl implements ReplyCustomRepository {
    private final JPAQueryFactory queryFactory;
    @Override
    public List<Reply> findReplyList(Long boardId) {
        QReply reply = QReply.reply;
        List<Reply>list = queryFactory.selectDistinct(reply)
                .from(reply)
                .where(reply.board.id.eq(boardId).and(reply.board.deleted.eq(false)))
                .fetch();
        return list;
    }

    @Override
    public Optional<Reply> findReply(Long replyId) {
        QReply qReply = QReply.reply;
        Reply reply = queryFactory.selectDistinct(qReply)
                .from(qReply)
                .where(qReply.id.eq(replyId).and(qReply.board.deleted.eq(false)))
                .fetchOne();
        return Optional.ofNullable(reply);
    }
}
