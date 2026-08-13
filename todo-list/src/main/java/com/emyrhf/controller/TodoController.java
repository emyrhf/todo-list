package com.emyrhf.controller;

import java.util.ArrayList;
import com.emyrhf.model.Todo;

public class TodoController{
    private ArrayList<Todo> list = new ArrayList<>();
    int nextId = 1;
    
    public void addToDoList(String title, String desc){
        Todo task = new Todo(nextId, title, desc);
        list.add(task);
        nextId++;
    }

    public void listTasks(){
        for(Todo task:list){
            System.out.println(task.getId() + " - " + task.getTitle() + " - " + task.getDesc() + " - " + task.getCheck());
        }
    }

    public void checkTask(String title){
        for(Todo task:list){
            if(task.getTitle().equals(title)){
                task.setCheck(true);
                break;
            }
        }
    }

    public void deleteTask(String title){
        for(Todo task:list){
            if(task.getTitle().equals(title)){
                list.remove(task);
                break;
            }
        }
    }

    // @Override public String toString(){

    // }
}