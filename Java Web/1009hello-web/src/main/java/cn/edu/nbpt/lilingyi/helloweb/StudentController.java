package cn.edu.nbpt.lilingyi.helloweb;

import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/students")
public class StudentController {
    @GetMapping("/{className}/{studentName}")
    public Student getStudent(@PathVariable String className, @PathVariable String studentName){
        Student stu = new Student(studentName, className,18,
                List.of(new String[]{"原神", "英雄联盟", "王者荣耀"}),
                new Address("浙江省","宁波市"));
        return stu;
    }
}
