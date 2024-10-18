package cn.nbpt.lilingyi.mavenhutool.Pojo;

import lombok.Data;

import java.util.List;

@Data
public class Student {
    private String name;
    private int age;
    private List<String> hobby;

    public Student(String name, int age, List<String> hobby) {
        this.name = name;
        this.age = age;
        this.hobby = hobby;
    }
}
