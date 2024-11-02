package cn.edu.nbpt.demo;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.management.relation.RoleInfo;
import javax.print.DocFlavor;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@RestController
public class RequestController {

    @GetMapping("/user/{className}/{userName}")
    public Object lly(@RequestBody User user,
                    @RequestParam Integer age,
                    @RequestHeader(name="password") String password,
                    @PathVariable String className,
                    @PathVariable String userName){
        user.setAge(age);
        user.setPassword(password);
        user.setName(userName);
        user.setClazz(className);
        user.setRoleIds(user.getRoles().stream().map(item->item.getId()).collect(Collectors.toList()));
        return user;
    }
}







