package com.example.todolist.repository;

import com.example.todolist.model.TodoDto;
import com.querydsl.core.QueryResults;

/**
 *  Todo 조회 관련 레포지토리
 */

public interface TodoRepositorySupport {
    
    // Todo 조회
    QueryResults<TodoDto.todoList> todoList(TodoDto.listParam listParam);
}
