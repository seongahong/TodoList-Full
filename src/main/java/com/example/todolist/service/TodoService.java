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
    // TodoDto.remove remove(TodoDto.removeParam removeParam);
    
}
