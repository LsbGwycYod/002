package cn.edu.nbpt.lilingyi.helloweb;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.List;


@Data
@AllArgsConstructor
public class Student {
    private String name;
    private String className;
    private int age;
    private List<String> hobbies;
    private Address address;
}
