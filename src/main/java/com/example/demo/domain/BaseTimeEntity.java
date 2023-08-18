package com.example.demo.domain;

import lombok.Getter;

import javax.persistence.Column;
import javax.persistence.MappedSuperclass;
import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;
import java.time.LocalDateTime;

@Getter
@MappedSuperclass
public class BaseTimeEntity {
    @Column(updatable = false)
    private LocalDateTime created_at;
    private LocalDateTime updated_at;

    @PrePersist
    public void prePersist(){
        LocalDateTime now = LocalDateTime.now();
        created_at = now;
        updated_at = now;
    }
    @PreUpdate
    public void preUpdate() {
        updated_at = LocalDateTime.now();
    }
}
