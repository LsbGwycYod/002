package cn.nbpt.lilingyi.mavenhutool.Pojo;

import lombok.Data;

import java.util.List;

@Data
public class Employee {
    private String name;
    private int age;
    private List<String> job;

    public Employee(String name, int age, List<String> job) {
        this.name = name;
        this.age = age;
        this.job = job;
    }

    public Employee() {
    }
}
