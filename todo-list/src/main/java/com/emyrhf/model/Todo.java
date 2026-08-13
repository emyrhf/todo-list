package com.emyrhf.model;

public class Todo{
    private int id;
    private String title;
    private String desc;
    private boolean check;

    public Todo(int id, String title, String desc){
        this.id = id;
        this.title = title;
        this.desc = desc;
        this.check = false;
    }

    public int getId(){
        return id;
    }

    // public void setId(int id){
    //     this.id = id;
    // }

    public String getTitle(){
        return title;
    }

    public void setTitle(String title){
        this.title = title;
    }

    public String getDesc(){
        return desc;
    }

    public void setDesc(String desc){
        this.desc = desc;
    }

    public boolean getCheck(){
        return check;
    }

    public void setCheck(boolean check){
        this.check = check;
    }


    @Override public String toString(){
        return id + " " + title + " " + " " + desc + " " + check;
    }
}