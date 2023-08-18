package com.example.demo.domain;

import com.example.demo.dto.request.BoardUpdateRequestDTO;
import lombok.*;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Builder
@Entity
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class Board extends BaseTimeEntity{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String title;

    @Column(columnDefinition = "TEXT")
    private String content;

    @OneToMany(mappedBy = "board" , cascade = CascadeType.ALL)
    @Builder.Default
    private List<Reply> replyList = new ArrayList<>();

    private boolean deleted;

    public void setDeleted (){
        this.deleted=true;
    }

    public void updateBoard(BoardUpdateRequestDTO updateDTO){
        this.title=updateDTO.getTitle();
        this.content=updateDTO.getContent();
    }


}
