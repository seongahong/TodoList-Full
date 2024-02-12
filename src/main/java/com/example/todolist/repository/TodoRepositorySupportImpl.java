package com.example.todolist.repository;

// import static com.example.todolist.domain.QTodo.todo;
// import com.example.todolist.domain.QTodo;

import org.springframework.data.jpa.repository.support.Querydsl;
import org.springframework.data.jpa.repository.support.QuerydslRepositorySupport;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;

import com.example.todolist.domain.Todo;
import com.example.todolist.model.TodoDto;
import com.example.todolist.model.TodoDto.todoList;
import com.querydsl.core.QueryResults;
import com.querydsl.core.types.Projections;
import com.querydsl.core.types.dsl.BooleanExpression;
import com.querydsl.jpa.impl.JPAQueryFactory;

import jakarta.validation.constraints.NotNull;

import java.util.List;


@Repository
// @SuppressWarnings("deprecation")
// deprecated된 메서드를 사용하는 코드. 이 부분에서 발생하는 경고를 무시하고 컴파일 진행.
public class TodoRepositorySupportImpl extends QuerydslRepositorySupport {

    // TODO: NotNull 어노테이션 붙인 이유.
    @NotNull
    private final JPAQueryFactory jpaQueryFactory;

    public TodoRepositorySupportImpl(EntityManager entityManager) {
        super(Todo.class);
        this.jpaQueryFactory = new JPAQueryFactory(entityManager);
    }

    // private final BooleanExpression isNotDel = todo.delYn.eq("N");

    // @Override
    // public List<TodoDto.todoList> todoList(TodoDto.listParam listParam) {
    //     // return jpaQueryFactory.select(Projections.constructor(TodoDto.todoList.class, todo))
    //     return jpaQueryFactory.select(Projections.constructor(TodoDto.todoList.class,
    //                              todo.id,
    //                              todo.content,
    //                              todo.createDateTime,
    //                              todo.updateDateTime,
    //                              todo.completeYn,
    //                              todo.delDateTime,
    //                              todo.delYn
    //                              )
    //                         )
    //                         .from(todo)
    //                         .orderBy(todo.updateDateTime.asc())
    //                         .fetch();
    // }



    
}
