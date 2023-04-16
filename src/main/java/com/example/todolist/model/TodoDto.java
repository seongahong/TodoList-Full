package com.example.todolist.model;

import java.time.LocalDateTime;

import org.hibernate.validator.constraints.Length;

import com.example.todolist.domain.todo;

import jakarta.annotation.Nonnull;
import jakarta.validation.constraints.NotEmpty;
import lombok.Getter;
import lombok.Setter;

/**
 * Todo entity 요청파라미터/반환객체 Dto
 * Dto는 data를 담아 계층 간 전달하는 용도로 쓰이는 객체.
 * 데이터만 담고 있기때문에 Getter, Setter를 제외한 다른 로직은 가지고 있지 않음.
 */

public class TodoDto {
    
    @Getter
    @Setter
    // Todo 목록 반환 객체
    public static class todoList {

        // Todo 비즈니스키
        private String todoBusinessKey;

        // Todo 내용
        private String todoContent;

        // Todo 작성일
        private LocalDateTime createDateTime;

        // Todo 완료여부
        private Character todoCompleteYn;

        // 생성자
        public todoList(String todoBusinessKey, String todoContent, LocalDateTime createDateTime,
                Character todoCompleteYn) {
            this.todoBusinessKey = todoBusinessKey;
            this.todoContent = todoContent;
            this.createDateTime = createDateTime;
            this.todoCompleteYn = todoCompleteYn;
        }

    }

    // Todo 목록 파라미터 -> 검색조건이 없는 상태에서 의미가 있을까?
    @Getter
    @Setter
    public static class listParam {

    }



    // Todo 작성 반환객체
    @Getter
    @Setter
    public static class create {

        // Todo 비즈니스키
        private String todoBusinessKey;

        public create(String todoBusinessKey) {
            this.todoBusinessKey = todoBusinessKey;
        }
    }

    // Todo 작성 파라미터
    @Getter
    @Setter
    public static class createParam {

        // Todo 내용
        @NotEmpty
        private String todoContent;

        // Todo 날짜 
        @NotEmpty
        private LocalDateTime todoDateTime;
        
    }


    // Todo 수정 반환객체


    // Todo 수정 파라미터

    // Todo 삭제 반환객체

    // Todo 삭제 파라미터 
}
