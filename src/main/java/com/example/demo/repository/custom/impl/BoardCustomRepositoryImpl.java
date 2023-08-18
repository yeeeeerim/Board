package com.example.demo.repository.custom.impl;

import com.example.demo.domain.Board;
import com.example.demo.domain.QBoard;
import com.example.demo.domain.QReply;
import com.example.demo.repository.custom.BoardCustomRepository;
import com.querydsl.jpa.impl.JPAQuery;
import com.querydsl.jpa.impl.JPAQueryFactory;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.support.PageableExecutionUtils;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@RequiredArgsConstructor
@Repository
public class BoardCustomRepositoryImpl implements BoardCustomRepository {
    private final JPAQueryFactory queryFactory;


    @Override
    public Page<Board> findBoardList(Pageable pageable) {
        QBoard board = QBoard.board;
        List<Board> list = queryFactory
                .selectDistinct(board)
                .from(board)
                .where(board.deleted.eq(false))
                .offset(pageable.getOffset())
                .limit(pageable.getPageSize())
                .fetch();

        JPAQuery<Long> count = queryFactory
                .selectDistinct(board.count())
                .from(board)
                .where(board.deleted.eq(false));


        return PageableExecutionUtils.getPage(list, pageable, count::fetchOne);
    }

    @Override
    public Optional<Board> findByIdBoard(Long id) {
        QBoard board = QBoard.board;
        Board select = queryFactory
                .select(board)
                .from(board)
                .where(board.deleted.eq(false).and(board.id.eq(id)))
                .fetchOne();

        return Optional.ofNullable(select);
    }
    @Override
    public Optional<Board> findByBoardIdReply(Long id) {
        QBoard board = QBoard.board;
        QReply reply = QReply.reply;
        Board select = queryFactory
                .select(board)
                .from(board)
                .leftJoin(board.replyList,reply)
                .fetchJoin()
                .where(board.deleted.eq(false).and(board.id.eq(id)))
                .fetchOne();

        return Optional.ofNullable(select);
    }
}
