package com.example.todolist.domain;

import java.time.LocalDateTime;

import org.hibernate.annotations.ColumnDefault;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Lob;
import jakarta.persistence.Table;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

/**
 * [Todo 엔티티]
 * 1. todo 아이디
 * 2. todo 내용
 * 3. todo 완료여부
 * 4. todo 비즈니스키
 * 5. todo 삭제여부
 * 6. todo 삭제일자
 * 7. todo 삭제키
 * 8. todo 최초작성일
 * 9. todo 최종변경일
 */

@Entity
@Getter
@Table(name ="TODO")
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class todo {

    @Id
    @GeneratedValue
    @Column(name="todoId")
    // todo 아이디 - primary key로써 쓰임
    private Long id;

    @Lob
    // todo 내용
    private String todoContent;

    @CreationTimestamp
    // todo 최초작성일자
    private LocalDateTime createDateTime;

    @UpdateTimestamp
    // todo 최종수정일자
    private LocalDateTime updateDateTime;

    @ColumnDefault(value = "'N'")
    // todo 완료여부
    private Character completeYn = 'N';

    // todo 비즈니스키
    private String todoBusinessKey;

    @ColumnDefault(value = "'N'")
    // todo 삭제여부
    private Character delYn = 'N';

    // todo 삭제일자
    private LocalDateTime delDateTime;

    // todo 삭제키
    private String delBusinessKey;



    
    
}
