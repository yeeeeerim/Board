package com.example.demo.service;

import com.example.demo.common.CommonException;
import com.example.demo.common.ErrorCode;
import com.example.demo.domain.Board;
import com.example.demo.domain.Reply;
import com.example.demo.dto.request.ReplyRequestDTO;
import com.example.demo.dto.request.ReplyUpdateRequestDTO;
import com.example.demo.dto.response.ReplyResponseDTO;
import com.example.demo.repository.BoardRepository;
import com.example.demo.repository.ReplyRepository;
import lombok.RequiredArgsConstructor;
import net.bytebuddy.asm.Advice;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class ReplyService {
    private final ReplyRepository replyRepository;
    private final BoardRepository boardRepository;
    @Transactional
    public Long saveReply(ReplyRequestDTO dto){
        Board board = boardRepository.findByIdBoard(dto.getBoardId())
                .orElseThrow(() -> new CommonException(ErrorCode.BOARD_NOT_FOUND));
        Reply reply = dto.toEntity(board);
        replyRepository.save(reply);
        return reply.getId();
    }

    public List<ReplyResponseDTO> listReply(Long boardId){
        List<Reply> replyList = replyRepository.findReplyList(boardId);
        List<ReplyResponseDTO> responseDTOList = new ArrayList<>();

        if(replyList!=null && !replyList.isEmpty()){
            for(Reply reply : replyList){
                responseDTOList.add(new ReplyResponseDTO(reply));
            }
        }
        return responseDTOList;
    }

    @Transactional
    public Long updateReply(ReplyUpdateRequestDTO dto){
        Reply reply = replyRepository.findReply(dto.getReplyId())
                .orElseThrow(()-> new CommonException(ErrorCode.REPLY_NOT_FOUND));
        reply.updateReply(dto.getContent());
        return reply.getId();
    }

    public Long deleteReply(Long replyId){
        Reply reply = replyRepository.findReply(replyId)
                .orElseThrow(()-> new CommonException(ErrorCode.REPLY_NOT_FOUND));
        replyRepository.deleteById(replyId);
        return reply.getId();
    }


}
