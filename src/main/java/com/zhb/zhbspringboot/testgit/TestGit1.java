package com.zhb.zhbspringboot.testgit;

public class TestGit1 {

//    暂存第一次
    private String aaa;

    private String name;

    private String age;

//    用于提交  写一半 切分支情况
    private String sex;


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAge() {
        return age;
    }

    public void setAge(String age) {
        this.age = age;
    }

    public void show(){
        System.out.println("show...");
    }
}
