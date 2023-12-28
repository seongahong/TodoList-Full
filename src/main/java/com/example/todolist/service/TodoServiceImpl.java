package com.example.todolist.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.todolist.repository.TodoRepositoryManager;

import lombok.RequiredArgsConstructor;

/**
 * service interface 오버라이딩해야함.
 */
       
@Service
@Transactional
@RequiredArgsConstructor
public class TodoServiceImpl implements TodoService {

    @Autowired
    private TodoRepositoryManager TodoRepositoryManager;


    
   

    
}
