package com.example.todolist.domain;

import java.time.LocalDateTime;

import org.hibernate.annotations.ColumnDefault;
import org.hibernate.annotations.Comment;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;
import org.hibernate.annotations.UpdateTimestamp;

import com.example.todolist.model.TodoDto;
import com.google.common.base.Supplier;

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
 * 
 * 
 * [Entity]
 * spring.jpa.hibernate.ddl-auto=update
 * DDL을 애플리케이션 실행 시점에 자동으로 생성해줌.
 * JPA의 구현체인 Hibernate는 Entity 코드를 스캔하여 스키마 및 테이블 자동 생성.
 * 
 * TODO: 생성자를 public과 protected로 했을 때의 차이점
 */

@Table(name ="TODO")
@Entity
@Getter
@DynamicInsert
@DynamicUpdate
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Todo {

    @Id
    @GeneratedValue
    @Comment("아이디")
    @Column(name = "todoId")
    private Long id;

    @Comment("내용")
    @Lob
    @Column(name = "todoContent")
    private String todoContent;

    @Comment("작성일")
    @CreationTimestamp
    @Column(name = "createDateTime")
    private LocalDateTime createDateTime;

    @Comment("수정일")
    @UpdateTimestamp
    @Column(name = "updateDateTime")
    private LocalDateTime updateDateTime;

    @Comment("완료여부")
    @ColumnDefault(value = "'N'")
    @Column(name = "completeYn")
    private Character completeYn = 'N';

    @Comment("삭제여부")
    @ColumnDefault(value = "'N'")
    @Column(name = "delYn")
    public Character delYn = 'N';

    @Comment("삭제일")
    @CreationTimestamp
    @Column(name = "delDateTime")
    private LocalDateTime delDateTime;

    // 생성자
    /**
     * AllArgsConsttuctor
     * @param id
     * @param todoContent
     * @param createDateTime
     * @param updateDateTime
     * @param completeYn
     * @param delYn
     * @param delDateTime
     */
    protected Todo(Long id, String todoContent, LocalDateTime createDateTime, LocalDateTime updateDateTime,
            Character completeYn, Character delYn, LocalDateTime delDateTime) {
        this.id = id;
        this.todoContent = todoContent;
        this.createDateTime = createDateTime;
        this.updateDateTime = updateDateTime;
        this.completeYn = completeYn;
        this.delYn = delYn;
        this.delDateTime = delDateTime;
    }

    /**
     * Todo 생성
     * Todo 작성을 위한 함수형 인터페이스 supplier
     * @param todoContent
     * @return
     */
    protected static Supplier<Todo> createTodo(
        TodoDto.createParam createParam
    ) {
        final Todo todo = new Todo(
            null, 
            createParam.getTodoContent(), 
            LocalDateTime.now(), 
            null, 
            'N', 
            'N', 
            null
            );

        return () -> todo;
    }

    /**
     * Todo 수정
     * @param modifyParam
     */
    public void modify(TodoDto.modifyParam modifyParam) {
        this.todoContent = modifyParam.getTodoContent();
        this.completeYn = modifyParam.getCompleteYn();
        this.updateDateTime = LocalDateTime.now();
    }


    /**
     * Todo 삭제
     * @param removeParam
     */
    public void remove(TodoDto.removeParam removeParam) {
        this.id = removeParam.getId();
    }
}

