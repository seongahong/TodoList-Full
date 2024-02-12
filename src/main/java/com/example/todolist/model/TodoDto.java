package com.example.todolist.model;

import java.time.LocalDateTime;

import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.format.annotation.DateTimeFormat.ISO;

import jakarta.validation.constraints.NotEmpty;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * Todo entity 요청파라미터/반환객체 Dto
 * Dto는 data를 담아 계층 간 전달하는 용도로 쓰이는 객체.
 * 데이터만 담고 있기때문에 Getter, Setter를 제외한 다른 로직은 가지고 있지 않음.
 */

public class TodoDto {
    
    @Getter
    @Setter
    @NoArgsConstructor
    // Todo 목록 반환 객체
    public static class todoList {

        // Todo 비즈니스키
        private Long id;

        // Todo 내용
        private String todoContent;

        // Todo 작성일
        private LocalDateTime createDateTime;

        // Todo 완료여부
        private Character completeYn;

        // Todo 완료여부
        private Character todoCompleteYn;

        // 생성자
        // public todoList(Long id, String todoContent, LocalDateTime createDateTime,
        //         Character completeYn, Character todoCompleteYn) {
        //     this.id = id;
        //     this.todoContent = todoContent;
        //     this.createDateTime = createDateTime;
        //     this.todoCompleteYn = todoCompleteYn;
        //     this.todoCompleteYn = todoCompleteYn;
        // }

    }

    // Todo 목록 파라미터 -> 검색조건 
    @Getter
    @Setter
    @NoArgsConstructor
    public static class listParam {

        // todo 내용
        private String todoContent;

        // todo 날짜 from
        @DateTimeFormat(iso = ISO.DATE)
        private LocalDateTime createDateTimeFrom;

        // todo 날짜 to
        @DateTimeFormat(iso = ISO.DATE)
        private LocalDateTime createDateTimeTo;

    }



    // Todo 작성 반환객체
    @Getter
    @Setter
    @NoArgsConstructor
    public static class create {

        // Todo 비즈니스키
        private Long id;

        // public create(Long id) {
        //     this.id = id;
        // }
    }

    // Todo 작성 파라미터
    @Getter
    @Setter
    @NoArgsConstructor
    public static class createParam {

        // Todo 내용
        @NotEmpty
        private String todoContent;

        // Todo 날짜 
        // @NotEmpty
        // private LocalDateTime createDateTime;
        
    }


    // Todo 수정 반환객체
    @Getter
    @Setter
    @NoArgsConstructor
    public static class modify {

        // Todo 비즈니스키
        private Long id;


        // public modify(Long id) {
        //     this.id = id;
        // }
        
    }


    // Todo 수정 파라미터
    @Getter
    @Setter
    @NoArgsConstructor
    public static class modifyParam {

        // todo id
        @NotEmpty
        private Long id;


        // todo 내용
        @NotEmpty
        private String todoContent;

        // todo 완료여부
        private Character CompleteYn;

        // todo 작성일
        // @NotEmpty
        // private LocalDateTime createDateTime;


    }

    // Todo 삭제 반환객체
    @Getter
    @Setter
    @NoArgsConstructor
    public static class remove {

        /// todo id
        @NotEmpty
        private Long id;

        // 삭제여부
        private Character delYn;

        // 생성자
        // public remove(Todo todo) {
        //     this.id = todo.getId();
        //     this.delYn = todo.getDelYn();
        // }
    }

    // Todo 삭제 파라미터 
    @Getter
    @Setter
    @NoArgsConstructor
    public static class removeParam {

        // todo id
        @NotEmpty
        private Long id;
    }
}
