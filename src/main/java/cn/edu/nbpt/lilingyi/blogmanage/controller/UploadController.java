package cn.edu.nbpt.lilingyi.blogmanage.controller;

import cn.edu.nbpt.lilingyi.blogmanage.Result;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.util.UUID;

@Slf4j
@RestController
public class UploadController {
    @PostMapping("/upload")
    public Result upload(String name, Integer age, MultipartFile image) throws Exception {
        log.info("name: {}, age: {}, image: {}", name, age, image);

        String originalFilename = image.getOriginalFilename();//获取原始名

        //构造唯一文件名
        int index = originalFilename.lastIndexOf(".");
        String suffix = originalFilename.substring(index);//获取后缀名
        String newFileName = UUID.randomUUID().toString() + suffix;
        log.info("newFileName: {}", newFileName);

        image.transferTo(new File("E:\\upload\\"+newFileName));
        return Result.success(null);
    }
}
