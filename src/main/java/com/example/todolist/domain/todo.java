package com.example.todolist.domain;

import java.time.LocalDateTime;

import org.hibernate.annotations.ColumnDefault;
import org.hibernate.annotations.CreationTimestamp;
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
 */

@Entity
@Getter
@Table(name ="TODO")
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Todo {

    @Id
    @GeneratedValue
    @Column(name="todoId")
    // todo 아이디 - primary key로써 쓰임
    private Long id;

    // todo 내용
    @Lob
    private String todoContent;

    // todo 최초작성일자
    @CreationTimestamp
    private LocalDateTime createDateTime;

    // todo 최종수정일자
    @UpdateTimestamp
    private LocalDateTime updateDateTime;

    // todo 완료여부
    @ColumnDefault(value = "'N'")
    private Character completeYn = 'N';

    // todo 비즈니스키 -> 필요한가?
    // private String todoBusinessKey;

    // todo 삭제여부
    @ColumnDefault(value = "'N'")
    private Character delYn = 'N';

    // todo 삭제일자
    @CreationTimestamp
    private LocalDateTime delDateTime;

    // todo 삭제키 -> 필요한가?
    // private String delBusinessKey;

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
    public Todo(Long id, String todoContent, LocalDateTime createDateTime, LocalDateTime updateDateTime,
            Character completeYn, Character delYn, LocalDateTime delDateTime) {
        this.id = id;
        this.todoContent = todoContent;
        this.createDateTime = createDateTime;
        this.updateDateTime = updateDateTime;
        this.completeYn = completeYn;
        this.delYn = delYn;
        this.delDateTime = delDateTime;
    }

    // Todo 등록을 위한 생성자 -> TodoDto의 요청 파라미터를 매개변수로 받음.
    protected Todo(TodoDto.createParam createParam, String todoBusinessKeym) {
        this.todoContent = createParam.getTodoContent();
        this.createDateTime = createParam.getCreateDateTime();
    }

    // Todo 작성을 위한 함수형 인터페이스 supplier
    public static Supplier<Todo> create(TodoDto.createParam createParam, String todoBusinessKey) {
        return () -> new Todo(createParam, todoBusinessKey);
    }

    // Todo 수정
    public void modify(TodoDto.modifyParam modifyParam) {
        this.todoContent = modifyParam.getTodoContent();
        this.completeYn = modifyParam.getCompleteYn();
        this.updateDateTime = LocalDateTime.now();
    }


    // Todo 삭제
    public void remove(TodoDto.removeParam removeParam) {
        this.id = removeParam.getId();
    }
}

