package com.example.todolist.repository;

import java.util.List;

import com.example.todolist.model.TodoDto;
import com.querydsl.core.QueryResults;

/**
 *  Todo 조회 관련 레포지토리
 *  TODO: QueryResults 타입과 List 타입의 차이.
 */

public interface TodoRepositorySupport {
    
    /**
     * Todo 리스트 조회
     * @param listParam
     * @return
     */
    List<TodoDto.todoList> todoList(TodoDto.listParam listParam);
}
