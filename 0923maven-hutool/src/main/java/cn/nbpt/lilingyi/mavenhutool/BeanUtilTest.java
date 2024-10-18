package cn.nbpt.lilingyi.mavenhutool;

import cn.hutool.core.bean.BeanUtil;
import cn.nbpt.lilingyi.mavenhutool.Pojo.Employee;
import cn.nbpt.lilingyi.mavenhutool.Pojo.Student;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class BeanUtilTest {
    public static void main(String[] args) {
        List<Student> studentList = new ArrayList<>();
        List<Employee> employeeList = new ArrayList<>();

        studentList.add(new Student("zhangsan", 18, Arrays.asList(new String[]{"原神", "LOL"})));
        studentList.add(new Student("lisi", 19, Arrays.asList(new String[]{"原神", "LOL","王者荣耀"})));
        studentList.add(new Student("wangwu", 20, Arrays.asList(new String[]{"前端", "后端"})));
        studentList.add(new Student("zhaoliu", 21, Arrays.asList(new String[]{"前端", "后端","大数据"})));

        employeeList = studentList.stream()
                .map(student -> {
                    Employee employee = new Employee();
                    BeanUtil.copyProperties(student, employee, true);
                    return employee;
                })
                .collect(Collectors.toList());

        employeeList.get(1).setAge(25);
        employeeList.get(1).setJob(Arrays.asList(new String[]{"前端开发", "后端开发"}));

        studentList.forEach(System.out::println);
        employeeList.forEach(System.out::println);
    }
}
