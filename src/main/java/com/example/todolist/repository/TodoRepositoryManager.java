package com.example.todolist.repository;

import com.example.todolist.model.TodoDto;

/**
 * Todo 행위 관련 레포지토리
 */
public interface TodoRepositoryManager {

    // Todo 등록
    TodoDto.create create(TodoDto.createParam createParam);

    // Todo 수정
    TodoDto.modify modify(TodoDto.modifyParam modifyParam);

    // Todo 삭제
    TodoDto.remove remove(TodoDto.removeParam removeParam);
    
}
