package com.example.todolist.service;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.todolist.model.TodoDto;
import com.example.todolist.repository.TodoRepositoryManager;
import com.example.todolist.repository.TodoRepositorySupport;
import com.querydsl.core.QueryResults;

import jakarta.validation.constraints.NotNull;
import lombok.RequiredArgsConstructor;

/**
 * service interface 오버라이딩해야함.
 */
       
@Service
@Transactional
@RequiredArgsConstructor
public class TodoServiceImpl implements TodoService {

    // 1) @Autowired
    // TodoRepositoryManager 의존성주입.
    // 객체 간의 결합도를 낮추고 코드를 보다 유연하게 함.
    // 2) final
    // 2-1) 변수 앞에 final 키워드를 사용했을 때, 해당 변수에 대한 재할당을 금지.
    // 한번 초기화되면 값을 변경할 수 없음.
    // 2-2) 메서드에 final 키워드를 사용했을 때, 하위 클래스에서 오바라이딩 할 수 없음.
    // @Autowired
    @NotNull
    private final TodoRepositoryManager TodoRepositoryManager;

    @NotNull
    private final TodoRepositorySupport TodoRepositorySupport;

    @Override
    public QueryResults<TodoDto.todoList> todoList(TodoDto.listParam listParam) {
        // return TodoRepositorySupport.todoList(listParam);
        return null;
    }

    @Override
    public TodoDto.create create(TodoDto.createParam createParam) {
        return TodoRepositoryManager.create(createParam);
    }

    @Override
    public TodoDto.modify modify(TodoDto.modifyParam modifyParam) {
        return TodoRepositoryManager.modify(modifyParam);
    }

    @Override
    public TodoDto.remove remove(TodoDto.removeParam removeParam) {
        return TodoRepositoryManager.remove(removeParam);
    }





    
   

    
}
