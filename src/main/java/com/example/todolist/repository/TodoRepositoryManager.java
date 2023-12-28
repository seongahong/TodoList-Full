package com.example.todolist.repository;

import com.example.todolist.domain.Todo;
import com.example.todolist.model.TodoDto;
import com.querydsl.core.QueryResults;

/**
 * Todo 행위 관련 레포지토리
 */
public interface TodoRepositoryManager {

    // Todo List 조회
    QueryResults<TodoDto.todoList> todoList(TodoDto.listParam listParam);

    // Todo 등록
    TodoDto.create create(TodoDto.createParam createParam);

    // Todo 수정
    TodoDto.modify modify(TodoDto.modifyParam modifyParam, Todo todo);

    // Todo 삭제
    TodoDto.remove remove(Todo todo);
    
}
