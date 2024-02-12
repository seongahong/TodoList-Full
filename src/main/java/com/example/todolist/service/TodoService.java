package com.example.todolist.service;

import com.example.todolist.model.TodoDto;
import com.querydsl.core.QueryResults;

/**
 * todo관련 서비스
 * interface로 구현함으로써 implements하는 class에서 구현해야하는 부분을 강제하도록 함
 */

public interface TodoService {

    /**
     * Todo 리스트 조회
     * @param listParam
     * @return
     */
    QueryResults<TodoDto.todoList> todoList(TodoDto.listParam listParam);


    /**
     *  Todo 작성
     * @param createParam
     * @return
     */
    // 1) void
    // - 데이터를 생성한 뒤, 반환하지 않는 경우 사용.
    // - 성공과 실패에 대한 반환은 예외처리를 통해 처리.
    // void create(TodoDto.createParam createParam);

    // 2) TodoDto.create
    // - 데이터를 생성한 뒤, 생선된 Todo 객채를 반환함.
    // - 생성 후, 클라이언트에게 생성된 Todo에 대한 정보를 제공하는 데 유용할 수 있음.
    TodoDto.create create(TodoDto.createParam createParam);



    /**
     * Todo 수정
     * @param modifyParam
     * @return
     */
    TodoDto.modify modify(TodoDto.modifyParam modifyParam);

    /**
     * Todo 삭제
     * @param removeParam
     * @return
     */
    TodoDto.remove remove(TodoDto.removeParam removeParam);
    
}
